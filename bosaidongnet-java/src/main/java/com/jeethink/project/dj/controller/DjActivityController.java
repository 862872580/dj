package com.jeethink.project.dj.controller;

import java.io.IOException;
import java.util.List;

import com.jeethink.common.utils.file.FileUploadUtils;
import com.jeethink.framework.config.JeeThinkConfig;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeethink.framework.aspectj.lang.annotation.Log;
import com.jeethink.framework.aspectj.lang.enums.BusinessType;
import com.jeethink.project.dj.domain.DjActivity;
import com.jeethink.project.dj.service.IDjActivityService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 活动Controller
 * 
 * @author miao
 * @date 2020-09-12
 */
@RestController
@RequestMapping("/dj/activity")
public class DjActivityController extends BaseController {
    @Autowired
    private IDjActivityService djActivityService;

    /**
     * 查询活动列表
     */
    @PreAuthorize("@ss.hasPermi('dj:activity:list')")
    @GetMapping("/list")
    public TableDataInfo list(DjActivity djActivity) {
        startPage();
        List<DjActivity> list = djActivityService.selectDjActivityList(djActivity);
        return getDataTable(list);
    }

    /**
     * 查询活动列表
     */
    @GetMapping("/app/list")
    public TableDataInfo getlist(DjActivity djActivity) {
        startPage();
        djActivity.setDisplay("1");
        djActivity.setStatus("1");
        List<DjActivity> list = djActivityService.selectDjActivityList(djActivity);
        return getDataTable(list);
    }

    /**
     * 导出活动列表
     */
    @PreAuthorize("@ss.hasPermi('dj:activity:export')")
    @Log(title = "活动", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DjActivity djActivity) {
        List<DjActivity> list = djActivityService.selectDjActivityList(djActivity);
        ExcelUtil<DjActivity> util = new ExcelUtil<DjActivity>(DjActivity.class);
        return util.exportExcel(list, "activity");
    }

    /**
     * 获取活动详细信息
     */
    @PreAuthorize("@ss.hasPermi('dj:activity:query')")
    @GetMapping(value = "/{activeId}")
    public AjaxResult getInfo(@PathVariable("activeId") Long activeId) {
        return AjaxResult.success(djActivityService.selectDjActivityById(activeId));
    }

    /**
     * 新增活动
     */
    @PreAuthorize("@ss.hasPermi('dj:activity:add')")
    @Log(title = "活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DjActivity djActivity){
        return toAjax(djActivityService.insertDjActivity(djActivity));
    }

    /**
     * 修改活动
     */
    @PreAuthorize("@ss.hasPermi('dj:activity:edit')")
    @Log(title = "活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DjActivity djActivity) {
        return toAjax(djActivityService.updateDjActivity(djActivity));
    }

    /**
     * 删除活动
     */
    @PreAuthorize("@ss.hasPermi('dj:activity:remove')")
    @Log(title = "活动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{activeIds}")
    public AjaxResult remove(@PathVariable Long[] activeIds) {
        return toAjax(djActivityService.deleteDjActivityByIds(activeIds));
    }

    /**
     * 活动图片上传
     */
    @Log(title = "活动图片", businessType = BusinessType.UPDATE)
    @PostMapping("/photo")
    public AjaxResult photo(@RequestParam("photofile") MultipartFile file) throws IOException
    {
        if (!file.isEmpty())
        {
            String photo = FileUploadUtils.upload(JeeThinkConfig.getActivePhotoPath(), file);
            AjaxResult ajax = AjaxResult.success();
            ajax.put("imgUrl", photo);
            return ajax;
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }
}
