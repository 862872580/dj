package com.jeethink.project.dj.controller;

import java.util.List;


import com.jeethink.project.dj.domain.DjTeammid;
import com.jeethink.project.dj.service.IDjTeammidService;
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
import com.jeethink.project.dj.domain.DjTeam;
import com.jeethink.project.dj.service.IDjTeamService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;

/**
 * 队伍Controller
 * 
 * @author miao
 * @date 2020-09-12
 */
@RestController
@RequestMapping("/dj/team")
public class DjTeamController extends BaseController {
    @Autowired
    private IDjTeamService djTeamService;

    @Autowired
    private IDjTeammidService djTeammidService;

    /**
     * 查询队伍列表
     */
    @GetMapping("/list")
    public TableDataInfo list(DjTeam djTeam) {
        startPage();
        List<DjTeam> list = djTeamService.selectDjTeamList(djTeam);
        return getDataTable(list);
    }

    /**
     * 查询满人队伍列表
     */
    @GetMapping("/fullteam")
    public TableDataInfo fullTeamList(DjTeam djTeam) {
        djTeam.setStatus("2");
        List<DjTeam> list = djTeamService.selectDjTeamList(djTeam);
        return getDataTable(list);
    }

    /**
     * 导出队伍列表
     */
    @Log(title = "队伍", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DjTeam djTeam) {
        List<DjTeam> list = djTeamService.selectDjTeamList(djTeam);
        ExcelUtil<DjTeam> util = new ExcelUtil<DjTeam>(DjTeam.class);
        return util.exportExcel(list, "team");
    }

    /**
     * 获取队伍详细信息
     */
    @GetMapping(value = "/{teamId}")
    public AjaxResult getInfo(@PathVariable("teamId") Long teamId) {
        return AjaxResult.success(djTeamService.selectDjTeamById(teamId));
    }

    /**
     * 判断是否可以创建队伍
     */
    @GetMapping("/decide")
    public AjaxResult decide(DjTeammid djTeammid) {
        List<DjTeammid> djTeammids = djTeammidService.selectDjTeammidList(djTeammid);
        if (djTeammids == null || djTeammids.size() == 0){
            return AjaxResult.success("1");
        }
        return AjaxResult.success("0");
    }

    /**
     * 判断是否是队长
     */
    @GetMapping("/captain")
    public AjaxResult iscaptain(DjTeam djTeam) {
        if (djTeamService.selectDjTeamList(djTeam) != null){
            return AjaxResult.success("1");
        }
        return AjaxResult.success("0");
    }

    /**
     * 判断是否有队长
     */
    @GetMapping("/havecap")
    public AjaxResult haveCap(long teamId) {
        String menId = djTeamService.selectDjTeamById(teamId).getMenId();
        if (menId == null || menId.equals("")){
            return AjaxResult.success("0");
        }
        return AjaxResult.success("1");
    }

    /**
     * 新增队伍
     */
    @Log(title = "队伍", businessType = BusinessType.INSERT)
    @PostMapping("/insert")
    public AjaxResult add(DjTeam djTeam,int isCap) {

        String teamName = djTeam.getTeamName();
        if(djTeamService.selectDjTeamByName(teamName) != null){
            return AjaxResult.error("队伍名称重复");
        }

        //添加队伍,添加队伍关系
        DjTeammid djTeammid = new DjTeammid();
        djTeammid.setMenId(djTeam.getMenId());
        djTeammid.setCreateBy(djTeam.getMenId());

        //如果不是队长,设置队长信息为空
        if (isCap == 0){
            djTeam.setMenId(null);
        }
        djTeammid.setTeamId(djTeamService.insertDjTeam(djTeam).getTeamId());
        djTeammid.setActiveId(djTeam.getActiveId());
        if (djTeammidService.insertDjTeammid(djTeammid) > 0) {
            return AjaxResult.success();
        }

        return AjaxResult.error("添加失败");
    }

    /**
     * 修改队伍
     */
    @Log(title = "队伍", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public AjaxResult edit(@RequestBody DjTeam djTeam) {
        return toAjax(djTeamService.updateDjTeam(djTeam));
    }

    /**
     * 删除队伍
     */
    @Log(title = "队伍", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teamIds}")
    public AjaxResult remove(@PathVariable Long[] teamIds) {
        return toAjax(djTeamService.deleteDjTeamByIds(teamIds));
    }
}
