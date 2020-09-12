package com.jeethink.project.dj.controller;

import java.util.List;
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

    /**
     * 查询队伍列表
     */
    @PreAuthorize("@ss.hasPermi('dj:team:list')")
    @GetMapping("/list")
    public TableDataInfo list(DjTeam djTeam) {
        startPage();
        List<DjTeam> list = djTeamService.selectDjTeamList(djTeam);
        return getDataTable(list);
    }

    /**
     * 导出队伍列表
     */
    @PreAuthorize("@ss.hasPermi('dj:team:export')")
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
    @PreAuthorize("@ss.hasPermi('dj:team:query')")
    @GetMapping(value = "/{teamId}")
    public AjaxResult getInfo(@PathVariable("teamId") Long teamId) {
        return AjaxResult.success(djTeamService.selectDjTeamById(teamId));
    }

    /**
     * 新增队伍
     */
    @PreAuthorize("@ss.hasPermi('dj:team:add')")
    @Log(title = "队伍", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DjTeam djTeam) {
        return toAjax(djTeamService.insertDjTeam(djTeam));
    }

    /**
     * 修改队伍
     */
    @PreAuthorize("@ss.hasPermi('dj:team:edit')")
    @Log(title = "队伍", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DjTeam djTeam) {
        return toAjax(djTeamService.updateDjTeam(djTeam));
    }

    /**
     * 删除队伍
     */
    @PreAuthorize("@ss.hasPermi('dj:team:remove')")
    @Log(title = "队伍", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teamIds}")
    public AjaxResult remove(@PathVariable Long[] teamIds) {
        return toAjax(djTeamService.deleteDjTeamByIds(teamIds));
    }
}
