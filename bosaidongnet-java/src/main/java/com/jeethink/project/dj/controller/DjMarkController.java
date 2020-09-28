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
import com.jeethink.project.dj.domain.DjMark;
import com.jeethink.project.dj.service.IDjMarkService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 单场比赛记录Controller
 * 
 * @author miao
 * @date 2020-09-12
 */
@RestController
@RequestMapping("/dj/mark")
public class DjMarkController extends BaseController {
    @Autowired
    private IDjMarkService djMarkService;

    /**
     * 查询单场比赛记录列表
     */
    @PreAuthorize("@ss.hasPermi('dj:mark:list')")
    @GetMapping("/list")
    public TableDataInfo list(DjMark djMark) {
        startPage();
        List<DjMark> list = djMarkService.selectDjMarkList(djMark);
        return getDataTable(list);
    }

    /**
     * 导出单场比赛记录列表
     */
    @PreAuthorize("@ss.hasPermi('dj:mark:export')")
    @Log(title = "单场比赛记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DjMark djMark) {
        List<DjMark> list = djMarkService.selectDjMarkList(djMark);
        ExcelUtil<DjMark> util = new ExcelUtil<DjMark>(DjMark.class);
        return util.exportExcel(list, "mark");
    }

    /**
     * 获取单场比赛记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('dj:mark:query')")
    @GetMapping(value = "/{markId}")
    public AjaxResult getInfo(@PathVariable("markId") Long markId) {
        return AjaxResult.success(djMarkService.selectDjMarkById(markId));
    }

    /**
     * 新增单场比赛记录
     */
    @PreAuthorize("@ss.hasPermi('dj:mark:add')")
    @Log(title = "单场比赛记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DjMark djMark) {
        return toAjax(djMarkService.insertDjMark(djMark));
    }

    /**
     * 修改单场比赛记录
     */
    @PreAuthorize("@ss.hasPermi('dj:mark:edit')")
    @Log(title = "单场比赛记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DjMark djMark) {
        return toAjax(djMarkService.updateDjMark(djMark));
    }

    /**
     * 删除单场比赛记录
     */
    @PreAuthorize("@ss.hasPermi('dj:mark:remove')")
    @Log(title = "单场比赛记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{markIds}")
    public AjaxResult remove(@PathVariable Long[] markIds) {
        return toAjax(djMarkService.deleteDjMarkByIds(markIds));
    }

    /**
     * 单场比赛图片上传
     */
    @Log(title = "单场比赛图片", businessType = BusinessType.UPDATE)
    @PostMapping("/photo")
    public AjaxResult photo(@RequestParam("photofile") MultipartFile file) throws IOException
    {
        if (!file.isEmpty())
        {
            String photo = FileUploadUtils.upload(JeeThinkConfig.getMatchPhotoPath(), file);
            AjaxResult ajax = AjaxResult.success();
            ajax.put("imgUrl", photo);
            return ajax;
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }
}
