package com.jeethink.project.dj.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 队伍对象 dj_team
 * 
 * @author miao
 * @date 2020-09-12
 */
public class DjTeam extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 队伍id */
    private Long teamId;

    /** 队伍名称 */
    @Excel(name = "队伍名称")
    private String teamName;

    /** 队长id */
    @Excel(name = "队长id")
    private String memId;

    /** 比赛场次 */
    @Excel(name = "比赛场次")
    private Long matchId;

    /** 活动id */
    @Excel(name = "活动id")
    private Long activeId;

    /** 队伍状态(0:解散, 1:使用中 2: 满人) */
    @Excel(name = "队伍状态(0:解散, 1:使用中 2: 满人)")
    private String status;

    /** 满人时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "满人时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fullTime;

    /** 签到时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签到时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signTime;

    public void setTeamId(Long teamId){
        this.teamId = teamId;
    }

    public Long getTeamId(){
        return teamId;
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public String getTeamName(){
        return teamName;
    }
    public void setMemId(String memId){
        this.memId = memId;
    }

    public String getMemId(){
        return memId;
    }
    public void setMatchId(Long matchId){
        this.matchId = matchId;
    }

    public Long getMatchId(){
        return matchId;
    }
    public void setActiveId(Long activeId){
        this.activeId = activeId;
    }

    public Long getActiveId(){
        return activeId;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
    public void setFullTime(Date fullTime){
        this.fullTime = fullTime;
    }

    public Date getFullTime(){
        return fullTime;
    }
    public void setSignTime(Date signTime){
        this.signTime = signTime;
    }

    public Date getSignTime(){
        return signTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("teamId", getTeamId())
            .append("teamName", getTeamName())
            .append("memId", getMemId())
            .append("createBy", getCreateBy())
            .append("matchId", getMatchId())
            .append("activeId", getActiveId())
            .append("status", getStatus())
            .append("fullTime", getFullTime())
            .append("signTime", getSignTime())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
