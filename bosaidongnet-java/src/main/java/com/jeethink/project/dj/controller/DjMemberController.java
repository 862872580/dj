package com.jeethink.project.dj.controller;

import java.util.List;
import java.util.UUID;

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
import com.jeethink.project.dj.domain.DjMember;
import com.jeethink.project.dj.service.IDjMemberService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;

/**
 * 选手用户Controller
 * 
 * @author miao
 * @date 2020-09-14
 */
@RestController
@RequestMapping("/dj/member")
public class DjMemberController extends BaseController {
    @Autowired
    private IDjMemberService djMemberService;

    /**
     * 查询选手用户列表
     */
    @PreAuthorize("@ss.hasPermi('dj:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(DjMember djMember) {
        startPage();
        List<DjMember> list = djMemberService.selectDjMemberList(djMember);
        return getDataTable(list);
    }

    /**
     * 导出选手用户列表
     */
    @PreAuthorize("@ss.hasPermi('dj:member:export')")
    @Log(title = "选手用户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DjMember djMember) {
        List<DjMember> list = djMemberService.selectDjMemberList(djMember);
        ExcelUtil<DjMember> util = new ExcelUtil<DjMember>(DjMember.class);
        return util.exportExcel(list, "member");
    }


    /**
     * 获取选手用户详细信息
     */
    @GetMapping(value = "/{menId}")
    public AjaxResult getInfo(@PathVariable("menId") String menId) {
        return AjaxResult.success(djMemberService.selectDjMemberById(menId));
    }

    /**
     * 新增选手用户
     */
    @Log(title = "选手用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DjMember djMember) {
        return toAjax(djMemberService.insertDjMember(djMember));
    }

    /**
     * 修改选手用户
     */
    @Log(title = "选手用户", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public AjaxResult edit(DjMember djMember) {
        return toAjax(djMemberService.updateDjMember(djMember));
    }

    /**
     * 删除选手用户
     */
    @Log(title = "选手用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{menIds}")
    public AjaxResult remove(@PathVariable String[] menIds) {
        return toAjax(djMemberService.deleteDjMemberByIds(menIds));
    }

    /**
     * 判断用户信息是否填写
     */
    @GetMapping(value = "/joinauth")
    public AjaxResult getJoinAuth(String menId) {
        String gameName = djMemberService.selectDjMemberById(menId).getGameName();
        if (gameName == null || gameName.equals("")){
            return AjaxResult.success("0");
        }
        return AjaxResult.success("1");
    }
}
