package com.jeethink.project.dj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 选手用户对象 dj_member
 * 
 * @author miao
 * @date 2020-09-14
 */
public class DjMember extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 选手用户id
 */
    private String menId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String memName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idnumber;

    /** 游戏昵称 */
    @Excel(name = "游戏昵称")
    private String gameName;

    /** 电话 */
    @Excel(name = "电话")
    private String phonenumber;

    /** 积分 */
    @Excel(name = "积分")
    private Long score;

    /** 帐号状态（0正常 1停用） */
    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** openid */
    @Excel(name = "openid")
    private String openId;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nikename;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String handimage;

    public void setMenId(String menId){
        this.menId = menId;
    }

    public String getMenId(){
        return menId;
    }
    public void setMemName(String memName){
        this.memName = memName;
    }

    public String getMemName(){
        return memName;
    }
    public void setIdnumber(String idnumber){
        this.idnumber = idnumber;
    }

    public String getIdnumber(){
        return idnumber;
    }
    public void setGameName(String gameName){
        this.gameName = gameName;
    }

    public String getGameName(){
        return gameName;
    }
    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber(){
        return phonenumber;
    }
    public void setScore(Long score){
        this.score = score;
    }

    public Long getScore(){
        return score;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
    public void setOpenId(String openId){
        this.openId = openId;
    }

    public String getOpenId(){
        return openId;
    }
    public void setNikename(String nikename){
        this.nikename = nikename;
    }

    public String getNikename(){
        return nikename;
    }
    public void setHandimage(String handimage){
        this.handimage = handimage;
    }

    public String getHandimage(){
        return handimage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("menId", getMenId())
            .append("memName", getMemName())
            .append("idnumber", getIdnumber())
            .append("gameName", getGameName())
            .append("phonenumber", getPhonenumber())
            .append("score", getScore())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .append("openId", getOpenId())
            .append("nikename", getNikename())
            .append("handimage", getHandimage())
            .toString();
    }
}
