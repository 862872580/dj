package com.jeethink.project.dj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jeethink.common.utils.SecurityUtils;
import com.jeethink.project.dj.domain.DjTeam;
import com.jeethink.project.dj.service.IDjActivityService;
import com.jeethink.project.dj.service.IDjTeamService;
import com.jeethink.project.system.domain.SysUser;
import com.jeethink.project.system.service.ISysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jeethink.framework.aspectj.lang.annotation.Log;
import com.jeethink.framework.aspectj.lang.enums.BusinessType;
import com.jeethink.project.dj.domain.DjRecord;
import com.jeethink.project.dj.service.IDjRecordService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;

/**
 * 比赛记录Controller
 * 
 * @author miao
 * @date 2020-09-12
 */
@RestController
@RequestMapping("/dj/record")
public class DjRecordController extends BaseController {
    @Autowired
    private IDjRecordService djRecordService;

    @Autowired
    private IDjTeamService djTeamService;

    @Autowired
    private ISysUserService userService;
    /**
     * 查询比赛记录列表
     */
    @PreAuthorize("@ss.hasPermi('dj:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(DjRecord djRecord) {
        startPage();
        List<DjRecord> list = djRecordService.selectDjRecordList(djRecord);
        return getDataTable(list);
    }

    /**
     * 查询比赛排名
     */
    @PreAuthorize("@ss.hasPermi('dj:record:list')")
    @GetMapping("/getrank")
    public TableDataInfo getRank(long matchId) {
        List<DjRecord> djRecords = djRecordService.selectDjRecordRank(matchId);
        List<DjTeam> teamList = new ArrayList();
        for (int i = 0; i < djRecords.size(); i ++){
            if (i == 0){
                //冠军
                DjTeam djTeam = djTeamService.selectDjTeamById(djRecords.get(0).getWinteamId());
                teamList.add(djTeam);
            }
            //所有失败队伍
            teamList.add(djTeamService.selectDjTeamById(djRecords.get(i).getLoseteamId()));
        }
        return getDataTable(teamList);
    }

    /**
     * 获取比赛进度
     */
    @PreAuthorize("@ss.hasPermi('dj:record:query')")
    @GetMapping("/getprocess")
    public AjaxResult getProcess(long matchId) {
        DjRecord djRecord = new DjRecord();
        djRecord.setMatchId(matchId);
        List<DjRecord> list = djRecordService.selectDjRecordList(djRecord);
        int result = 0;
        for (DjRecord djRecord1 : list){
            int rank = Integer.parseInt(djRecord1.getRank());
            if (rank > result){
                result = rank;
            }
        }
        return AjaxResult.success(String.valueOf(result+1));
    }

    /**
     * 导出比赛记录列表
     */
    @PreAuthorize("@ss.hasPermi('dj:record:export')")
    @Log(title = "比赛记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DjRecord djRecord) {
        List<DjRecord> list = djRecordService.selectDjRecordList(djRecord);
        ExcelUtil<DjRecord> util = new ExcelUtil<DjRecord>(DjRecord.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 获取比赛记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('dj:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId) {
        return AjaxResult.success(djRecordService.selectDjRecordById(recordId));
    }

    /**
     * 新增比赛记录
     */
    @PreAuthorize("@ss.hasPermi('dj:record:add')")
    @Log(title = "比赛记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DjRecord djRecord, String rank) {
        djRecord.setStatus("2");
        List<DjRecord> djRecordList = djRecordService.selectDjRecordList(djRecord);

        if (djRecordList.size() == 1){
            return AjaxResult.success("比赛结束");
        }

        //随机获取两个队伍,开始比赛
        DjRecord djRecordA = null;
        DjRecord djRecordB = null;

        int l = djRecordList.size();

        //新建的比赛记录
        DjRecord newDjRecord = new DjRecord();

        Random random = new Random();
        //若果是单数队伍,随机抽出一个队伍轮空
        if (l % 2 == 1){
            int n = random.nextInt(djRecordList.size());
            djRecordA = djRecordList.get(n);
            //设置比赛记录结束
            djRecordA.setStatus("0");
            djRecordService.updateDjRecord(djRecordA);

            //新建比赛记录
            newDjRecord.setTeamaId(djRecordA.getWinteamId());
            newDjRecord.setWinteamId(djRecordA.getWinteamId());
            newDjRecord.setStatus("2");
            newDjRecord.setRank(rank);
            djRecordService.insertDjRecord(djRecord);

            djRecordList.remove(n);
        }

        l = djRecordList.size();
        for (int i = 0; i < l; i ++){
            int n = random.nextInt(djRecordList.size());
            if (i % 2 == 1) {
                //获取teamA,从第二次循环开始添加比赛记录
                djRecordA = djRecordList.get(n);

                //新建比赛记录
                newDjRecord.setTeamaId(djRecordA.getWinteamId());
                newDjRecord.setTeambId(djRecordB.getWinteamId());
                newDjRecord.setStatus("1");
                newDjRecord.setRank(rank);
                djRecordService.insertDjRecord(djRecord);
            } else {
                //获取teamB
                djRecordB = djRecordList.get(n);
            }
            //获取完毕之后删除List中改数据
            djRecordList.remove(n);
        }

        return AjaxResult.success();
    }

    /**
     * 判断是否所有比赛结束
     */
    @PreAuthorize("@ss.hasPermi('dj:record:query')")
    @Log(title = "比赛记录", businessType = BusinessType.UPDATE)
    @PutMapping("/decidematch")
    public AjaxResult decideMatch(@RequestBody DjRecord djRecord) {
        List<DjRecord> djRecords = djRecordService.selectDjRecordList(djRecord);
        for (DjRecord djRecord1 : djRecords){
            if ("1".equals(djRecord1.getStatus())){
                return AjaxResult.success("0");
            }
        }
        return AjaxResult.success("1");
    }

    /**
     * 修改比赛记录
     */
    @PreAuthorize("@ss.hasPermi('dj:record:edit')")
    @Log(title = "比赛记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DjRecord djRecord) {
        if (djRecord.getWinteamId() != null && !djRecord.getWinteamId().equals("")){
            //设置准备下场比赛
            djRecord.setStatus("2");
        }
        //获取当前登陆用户信息
        SysUser sysUser = userService.selectUserByUserName(SecurityUtils.getUsername());
        //设置裁判id
        djRecord.setUserId(sysUser.getUserId());
        return toAjax(djRecordService.updateDjRecord(djRecord));
    }

    /**
     * 删除比赛记录
     */
    @PreAuthorize("@ss.hasPermi('dj:record:remove')")
    @Log(title = "比赛记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds) {
        return toAjax(djRecordService.deleteDjRecordByIds(recordIds));
    }
}
