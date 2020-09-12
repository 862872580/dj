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
import com.jeethink.project.dj.domain.DjCode;
import com.jeethink.project.dj.service.IDjCodeService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;

/**
 * 兑换码Controller
 * 
 * @author miao
 * @date 2020-09-12
 */
@RestController
@RequestMapping("/dj/code")
public class DjCodeController extends BaseController {
    @Autowired
    private IDjCodeService djCodeService;

    /**
     * 查询兑换码列表
     */
    @PreAuthorize("@ss.hasPermi('dj:code:list')")
    @GetMapping("/list")
    public TableDataInfo list(DjCode djCode) {
        startPage();
        List<DjCode> list = djCodeService.selectDjCodeList(djCode);
        return getDataTable(list);
    }

    /**
     * 导出兑换码列表
     */
    @PreAuthorize("@ss.hasPermi('dj:code:export')")
    @Log(title = "兑换码", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DjCode djCode) {
        List<DjCode> list = djCodeService.selectDjCodeList(djCode);
        ExcelUtil<DjCode> util = new ExcelUtil<DjCode>(DjCode.class);
        return util.exportExcel(list, "code");
    }

    /**
     * 获取兑换码详细信息
     */
    @PreAuthorize("@ss.hasPermi('dj:code:query')")
    @GetMapping(value = "/{codeId}")
    public AjaxResult getInfo(@PathVariable("codeId") Long codeId) {
        return AjaxResult.success(djCodeService.selectDjCodeById(codeId));
    }

    /**
     * 新增兑换码
     */
    @PreAuthorize("@ss.hasPermi('dj:code:add')")
    @Log(title = "兑换码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DjCode djCode) {
        return toAjax(djCodeService.insertDjCode(djCode));
    }

    /**
     * 修改兑换码
     */
    @PreAuthorize("@ss.hasPermi('dj:code:edit')")
    @Log(title = "兑换码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DjCode djCode) {
        return toAjax(djCodeService.updateDjCode(djCode));
    }

    /**
     * 删除兑换码
     */
    @PreAuthorize("@ss.hasPermi('dj:code:remove')")
    @Log(title = "兑换码", businessType = BusinessType.DELETE)
	@DeleteMapping("/{codeIds}")
    public AjaxResult remove(@PathVariable Long[] codeIds) {
        return toAjax(djCodeService.deleteDjCodeByIds(codeIds));
    }
}
