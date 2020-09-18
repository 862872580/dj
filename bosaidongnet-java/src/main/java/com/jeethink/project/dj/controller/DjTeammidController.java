package com.jeethink.project.dj.controller;

import java.util.ArrayList;
import java.util.List;

import com.jeethink.common.utils.DateUtils;
import com.jeethink.project.dj.domain.DjMember;
import com.jeethink.project.dj.domain.DjTeam;
import com.jeethink.project.dj.service.IDjMemberService;
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
import com.jeethink.project.dj.domain.DjTeammid;
import com.jeethink.project.dj.service.IDjTeammidService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;

/**
 * 队伍关系Controller
 * 
 * @author miao
 * @date 2020-09-12
 */
@RestController
@RequestMapping("/dj/teammid")
public class DjTeammidController extends BaseController {
    @Autowired
    private IDjTeammidService djTeammidService;

    @Autowired
    private IDjTeamService djTeamService;

    @Autowired
    private IDjMemberService djMemberService;

    /**
     * 查询队伍成员
     */
    @GetMapping("/list")
    public TableDataInfo list(DjTeammid djTeammid) {
        //查询队伍id
        List<DjTeammid> djTeammids = djTeammidService.selectDjTeammidList(djTeammid);
        long teamId = djTeammids.get(0).getTeamId();

        //查询所有队伍成员id
        DjTeammid djTeammid1 = new DjTeammid();
        djTeammid1.setTeamId(teamId);
        List<DjTeammid> list = djTeammidService.selectDjTeammidList(djTeammid1);

        //查询每个成员的信息,放入list
        List<Object> memList = new ArrayList<>();
        for (int i = 0; i < list.size(); i ++){
            String menId = list.get(i).getMenId();
            DjMember djMember = djMemberService.selectDjMemberById(menId);
            memList.add(djMember);
        }
        memList.add(teamId);

        return getDataTable(memList);
    }

    /**
     * 查询队伍成员
     */
    @GetMapping("/getteam")
    public TableDataInfo list(long teamId) {
        //查询所有队伍成员id
        DjTeammid djTeammid1 = new DjTeammid();
        djTeammid1.setTeamId(teamId);
        List<DjTeammid> list = djTeammidService.selectDjTeammidList(djTeammid1);

        //查询每个成员的信息,放入list
        List<Object> memList = new ArrayList<>();
        for (int i = 0; i < list.size(); i ++){
            String menId = list.get(i).getMenId();
            DjMember djMember = djMemberService.selectDjMemberById(menId);
            memList.add(djMember);
        }
        memList.add(teamId);

        return getDataTable(memList);
    }

    /**
     * 导出队伍关系列表
     */
    @Log(title = "队伍关系", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DjTeammid djTeammid) {
        List<DjTeammid> list = djTeammidService.selectDjTeammidList(djTeammid);
        ExcelUtil<DjTeammid> util = new ExcelUtil<DjTeammid>(DjTeammid.class);
        return util.exportExcel(list, "teammid");
    }

    /**
     * 获取队伍关系详细信息
     */
    @GetMapping(value = "/{teammidId}")
    public AjaxResult getInfo(@PathVariable("teammidId")Long teammidId) {
        return AjaxResult.success(djTeammidService.selectDjTeammidById(teammidId));
    }

    /**
     * 新增队伍关系
     */
    @Log(title = "队伍关系", businessType = BusinessType.INSERT)
    @PostMapping("/insert")
    public AjaxResult add(DjTeammid djTeammid, int isCap) {

        if (djTeammidService.selectDjTeammidByMenId(djTeammid) != null){
            return AjaxResult.error("已经加入队伍");
        }

        //获取队伍id
        long teamId = djTeammid.getTeamId();
        //查询队员人数
        int count = djTeammidService.countDjTeammid(teamId);
        if (count <= 4) {
            djTeammidService.insertDjTeammid(djTeammid);
            //添加成员是队长
            if (isCap == 1){
                DjTeam djTeam = new DjTeam();
                djTeam.setTeamId(teamId);
                djTeam.setMenId(djTeammid.getMenId());
                djTeamService.updateDjTeam(djTeam);
            }
            //如果已经有四个人,再添加一个满人了,跟新队伍信息
            if (count == 4){

                DjTeam djTeam = new DjTeam();
                djTeam.setTeamId(teamId);

                //判断是否有队长
                String menId = djTeamService.selectDjTeamById(teamId).getMenId();
                if (menId == null || menId.equals("")){
                    djTeam.setMenId(djTeammid.getMenId());
                }

                djTeam.setFullTime(DateUtils.getNowDate());
                djTeam.setStatus("2");
                djTeamService.updateDjTeam(djTeam);
            }
            return AjaxResult.success("加入成功");
        }
        return AjaxResult.error("加入失败");
    }

    /**
     * 修改队伍关系
     */
    @Log(title = "队伍关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DjTeammid djTeammid) {
        return toAjax(djTeammidService.updateDjTeammid(djTeammid));
    }

    /**
     * 删除队伍关系
     */
	@GetMapping("/remove")
    public AjaxResult remove(long teamId, String menId) {
        DjTeam djTeam = djTeamService.selectDjTeamById(teamId);
        //如果退出队伍的是队长
        if (menId.equals(djTeam.getMenId())){
            djTeam.setMenId(null);
        }

        //跟新队伍信息
        djTeam.setTeamId(teamId);
        djTeam.setFullTime(null);
        djTeam.setStatus("1");
        djTeamService.updateFullTime(djTeam);

        djTeammidService.deleteDjTeammidByMenId(menId, teamId);
        return AjaxResult.success("退出成功");
    }

    /**
     * 解散队伍
     */
    @GetMapping("/cancel")
    public AjaxResult cancelTeam(long teamId) {
        djTeamService.deleteDjTeamById(teamId);
        djTeammidService.deleteDjTeammidByTeamId(teamId);
        return AjaxResult.success("退出成功");
    }
}
