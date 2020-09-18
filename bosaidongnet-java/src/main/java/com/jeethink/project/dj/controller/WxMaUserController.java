package com.jeethink.project.dj.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.project.dj.config.WxMaConfiguration;
import com.jeethink.project.dj.domain.DjMember;
import com.jeethink.project.dj.service.IDjMemberService;
import com.jeethink.project.dj.utils.JsonUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信小程序用户接口
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@RestController
@RequestMapping("/wx/user/{appid}")
public class WxMaUserController {

    @Autowired
    private IDjMemberService djMemberService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 登陆接口
     */
    @RequestMapping("/login")
    public AjaxResult login(@PathVariable String appid, String code) {
        if (StringUtils.isBlank(code)) {
//            return "empty jscode";
            return AjaxResult.error("empty jscode");
        }

        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            this.logger.info(session.getSessionKey());
            this.logger.info(session.getOpenid());

            //查询用户是否存在
            DjMember djMember1 = djMemberService.selectDjMemberByOpenId(session.getOpenid());
            if (djMember1 == null){
                DjMember djMember = new DjMember();
                djMember.setOpenId(session.getOpenid());
                djMemberService.insertDjMember(djMember);
                djMember1 = djMemberService.selectDjMemberByOpenId(session.getOpenid());
            }


            //TODO 可以增加自己的逻辑，关联业务相关数据
//            return JsonUtils.toJson(session);
            return AjaxResult.success("成功",JsonUtils.toJson(djMember1));
        } catch (WxErrorException e) {
            this.logger.error(e.getMessage(), e);
            return AjaxResult.error(e.toString());
        }
    }

    /**
     * <pre>
     * 获取用户信息接口
     * </pre>
     */
    @GetMapping("/info")
    public String info(@PathVariable String appid, String sessionKey,
                       String signature, String rawData, String encryptedData, String iv) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return "user check failed";
        }

        // 解密用户信息
        WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);

        return JsonUtils.toJson(userInfo);
    }

    /**
     * <pre>
     * 获取用户绑定手机号信息
     * </pre>
     */
    @GetMapping("/phone")
    public String phone(@PathVariable String appid, String sessionKey, String signature,
                        String rawData, String encryptedData, String iv) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return "user check failed";
        }

        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = wxService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);

        return JsonUtils.toJson(phoneNoInfo);
    }

}
