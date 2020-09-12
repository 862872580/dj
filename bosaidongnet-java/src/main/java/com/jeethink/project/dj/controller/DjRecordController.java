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
    public AjaxResult add(@RequestBody DjRecord djRecord) {
        return toAjax(djRecordService.insertDjRecord(djRecord));
    }

    /**
     * 修改比赛记录
     */
    @PreAuthorize("@ss.hasPermi('dj:record:edit')")
    @Log(title = "比赛记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DjRecord djRecord) {
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
