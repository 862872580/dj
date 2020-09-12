package com.jeethink.project.dj.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 比赛场次对象 dj_match
 * 
 * @author miao
 * @date 2020-09-12
 */
public class DjMatch extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 比赛场次 */
    private Long matchId;

    /** 胜利队伍 */
    @Excel(name = "胜利队伍")
    private Long teamId;

    /** 活动id */
    @Excel(name = "活动id")
    private Long activeId;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 比赛状态(0:未开始, 1:进行中, 2:结束) */
    @Excel(name = "比赛状态(0:未开始, 1:进行中, 2:结束)")
    private String status;

    public void setMatchId(Long matchId){
        this.matchId = matchId;
    }

    public Long getMatchId(){
        return matchId;
    }
    public void setTeamId(Long teamId){
        this.teamId = teamId;
    }

    public Long getTeamId(){
        return teamId;
    }
    public void setActiveId(Long activeId){
        this.activeId = activeId;
    }

    public Long getActiveId(){
        return activeId;
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
            .append("matchId", getMatchId())
            .append("teamId", getTeamId())
            .append("activeId", getActiveId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
