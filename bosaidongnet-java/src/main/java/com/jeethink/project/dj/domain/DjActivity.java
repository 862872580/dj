package com.jeethink.project.dj.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 活动对象 dj_activity
 *
 * @author miao
 * @date 2020-09-17
 */
public class DjActivity extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 活动id */
    private Long activeId;

    /** 活动名称 */
    @Excel(name = "活动名称")
    private String activeName;

    /** 活动图片位置 */
    private String photo;

    /** 活动地址 */
    @Excel(name = "活动地址")
    private String activeAddress;

    /** 是否显示 */
    @Excel(name = "是否显示")
    private String display;

    /** 活动内容 */
    @Excel(name = "活动内容")
    private String activeContent;

    /** 允许参加队伍个数 */
    @Excel(name = "允许参加队伍个数")
    private Long teamtotal;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 活动状态(0:关闭, 1:开启) */
    @Excel(name = "活动状态(0:关闭, 1:开启)")
    private String status;

    public void setActiveId(Long activeId){
        this.activeId = activeId;
    }

    public Long getActiveId(){
        return activeId;
    }
    public void setActiveName(String activeName){
        this.activeName = activeName;
    }

    public String getActiveName(){
        return activeName;
    }
    public void setPhoto(String photo){
        this.photo = photo;
    }

    public String getPhoto(){
        return photo;
    }
    public void setActiveAddress(String activeAddress){
        this.activeAddress = activeAddress;
    }

    public String getActiveAddress(){
        return activeAddress;
    }
    public void setDisplay(String display){
        this.display = display;
    }

    public String getDisplay(){
        return display;
    }
    public void setActiveContent(String activeContent){
        this.activeContent = activeContent;
    }

    public String getActiveContent(){
        return activeContent;
    }
    public void setTeamtotal(Long teamtotal){
        this.teamtotal = teamtotal;
    }

    public Long getTeamtotal(){
        return teamtotal;
    }
    public void setStartTime(Date startTime){
        this.startTime = startTime;
    }

    public Date getStartTime(){
        return startTime;
    }
    public void setEndTime(Date endTime){
        this.endTime = endTime;
    }

    public Date getEndTime(){
        return endTime;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("activeId", getActiveId())
                .append("activeName", getActiveName())
                .append("photo", getPhoto())
                .append("activeAddress", getActiveAddress())
                .append("display", getDisplay())
                .append("activeContent", getActiveContent())
                .append("teamtotal", getTeamtotal())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("remark", getRemark())
                .toString();
    }
}