package com.jeethink.project.dj.controller;

import java.util.List;
import java.util.Random;

import com.jeethink.common.utils.DateUtils;
import com.jeethink.project.dj.domain.DjActivity;
import com.jeethink.project.dj.domain.DjRecord;
import com.jeethink.project.dj.domain.DjTeam;
import com.jeethink.project.dj.mapper.DjRecordMapper;
import com.jeethink.project.dj.service.IDjActivityService;
import com.jeethink.project.dj.service.IDjRecordService;
import com.jeethink.project.dj.service.IDjTeamService;
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
import com.jeethink.project.dj.domain.DjMatch;
import com.jeethink.project.dj.service.IDjMatchService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;

/**
 * 比赛场次Controller
 * 
 * @author miao
 * @date 2020-09-12
 */
@RestController
@RequestMapping("/dj/match")
public class DjMatchController extends BaseController {
    @Autowired
    private IDjMatchService djMatchService;

    @Autowired
    private IDjTeamService djTeamService;

    @Autowired
    private IDjRecordService djRecordService;

    @Autowired
    private IDjActivityService djActivityService;
    /**
     * 查询比赛场次列表
     */
    @PreAuthorize("@ss.hasPermi('dj:match:list')")
    @GetMapping("/list")
    public TableDataInfo list(DjMatch djMatch) {
        startPage();
        List<DjMatch> list = djMatchService.selectDjMatchList(djMatch);
        return getDataTable(list);
    }

    /**
     * 导出比赛场次列表
     */
    @PreAuthorize("@ss.hasPermi('dj:match:export')")
    @Log(title = "比赛场次", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DjMatch djMatch) {
        List<DjMatch> list = djMatchService.selectDjMatchList(djMatch);
        ExcelUtil<DjMatch> util = new ExcelUtil<DjMatch>(DjMatch.class);
        return util.exportExcel(list, "match");
    }

    /**
     * 获取比赛场次详细信息
     */
    @PreAuthorize("@ss.hasPermi('dj:match:query')")
    @GetMapping(value = "/{matchId}")
    public AjaxResult getInfo(@PathVariable("matchId") Long matchId) {
        return AjaxResult.success(djMatchService.selectDjMatchById(matchId));
    }

    /**
     * 开始比赛场次
     */
    @PreAuthorize("@ss.hasPermi('dj:match:add')")
    @Log(title = "比赛场次", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DjMatch djMatch, String rank) {

        //判断该活动是否已经开始
        DjMatch djMatch2 = new DjMatch();
        djMatch2.setActiveId(djMatch.getActiveId());

        List<DjMatch> djMatches = djMatchService.selectDjMatchList(djMatch2);
        if (djMatches != null && djMatches.size() > 0 ){
            return AjaxResult.error("比赛已经开始");
        }

        //获取参赛队伍数量
        Long teamTotal = djActivityService.selectDjActivityById(djMatch.getActiveId()).getTeamtotal();

        //添加比赛,并返回比赛id
        long matchId = djMatchService.insertDjMatch(djMatch).getMatchId();

        //获取所有参加改活动的队伍
        List<DjTeam> teamList = djTeamService.selectDjTeamListByActiveId(djMatch.getActiveId(), teamTotal);

        //随机获取两个队伍,开始比赛
        DjTeam teamA = null;
        DjTeam teamB = null;
        DjRecord djRecord = new DjRecord();
        djRecord.setMatchId(matchId);

        int l = teamList.size();

        Random random = new Random();
        //若果是单数队伍,随机抽出一个队伍轮空
        if (l % 2 == 1){
            int n = random.nextInt(teamList.size());
            teamA = teamList.get(n);

            djRecord.setTeamaId(teamA.getTeamId());
            djRecord.setStatus("2");
            djRecord.setRank(rank);

            djRecordService.insertDjRecord(djRecord);
            teamList.remove(n);
        }

        l = teamList.size();
        for (int i = 0; i < l; i ++){
            int n = random.nextInt(teamList.size());
            if (teamList.get(n).getSignTime() != null) {
                if (i % 2 == 1) {
                    //获取teamA,从第二次循环开始添加比赛记录
                    teamA = teamList.get(n);
                    djRecord.setTeamaId(teamA.getTeamId());
                    djRecord.setTeambId(teamB.getTeamId());
                    djRecord.setStatus("1");
                    djRecord.setRank(rank);

                    djRecordService.insertDjRecord(djRecord);
                } else {
                    //获取teamB
                    teamB = teamList.get(n);
                }
            }
            //获取完毕之后删除List中改数据
            teamList.remove(n);
        }

        return AjaxResult.success();
    }

    /**
     * 修改比赛场次
     */
    @PreAuthorize("@ss.hasPermi('dj:match:edit')")
    @Log(title = "比赛场次", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DjMatch djMatch) {
        return toAjax(djMatchService.updateDjMatch(djMatch));
    }

    /**
     * 删除比赛场次
     */
    @PreAuthorize("@ss.hasPermi('dj:match:remove')")
    @Log(title = "比赛场次", businessType = BusinessType.DELETE)
	@DeleteMapping("/{matchIds}")
    public AjaxResult remove(@PathVariable Long[] matchIds) {
        return toAjax(djMatchService.deleteDjMatchByIds(matchIds));
    }
}
