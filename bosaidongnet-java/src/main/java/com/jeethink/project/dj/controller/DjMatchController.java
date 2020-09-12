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
     * 新增比赛场次
     */
    @PreAuthorize("@ss.hasPermi('dj:match:add')")
    @Log(title = "比赛场次", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DjMatch djMatch) {
        return toAjax(djMatchService.insertDjMatch(djMatch));
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
