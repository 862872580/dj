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

    /**
     * 查询队伍关系列表
     */
    @PreAuthorize("@ss.hasPermi('dj:teammid:list')")
    @GetMapping("/list")
    public TableDataInfo list(DjTeammid djTeammid) {
        startPage();
        List<DjTeammid> list = djTeammidService.selectDjTeammidList(djTeammid);
        return getDataTable(list);
    }

    /**
     * 导出队伍关系列表
     */
    @PreAuthorize("@ss.hasPermi('dj:teammid:export')")
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
    @PreAuthorize("@ss.hasPermi('dj:teammid:query')")
    @GetMapping(value = "/{teammidId}")
    public AjaxResult getInfo(@PathVariable("teammidId") Long teammidId) {
        return AjaxResult.success(djTeammidService.selectDjTeammidById(teammidId));
    }

    /**
     * 新增队伍关系
     */
    @PreAuthorize("@ss.hasPermi('dj:teammid:add')")
    @Log(title = "队伍关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DjTeammid djTeammid) {
        return toAjax(djTeammidService.insertDjTeammid(djTeammid));
    }

    /**
     * 修改队伍关系
     */
    @PreAuthorize("@ss.hasPermi('dj:teammid:edit')")
    @Log(title = "队伍关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DjTeammid djTeammid) {
        return toAjax(djTeammidService.updateDjTeammid(djTeammid));
    }

    /**
     * 删除队伍关系
     */
    @PreAuthorize("@ss.hasPermi('dj:teammid:remove')")
    @Log(title = "队伍关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teammidIds}")
    public AjaxResult remove(@PathVariable Long[] teammidIds) {
        return toAjax(djTeammidService.deleteDjTeammidByIds(teammidIds));
    }
}
