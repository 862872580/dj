package com.jeethink.project.dj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 队伍关系对象 dj_teammid
 * 
 * @author miao
 * @date 2020-09-15
 */
public class DjTeammid extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 队伍关系id */
    private Long teammidId;

    /** 选手会员id */
    @Excel(name = "选手会员id")
    private String menId;

    /** 队伍id */
    @Excel(name = "队伍id")
    private Long teamId;

    /** 活动id */
    @Excel(name = "活动id")
    private Long activeId;

    public void setTeammidId(Long teammidId){
        this.teammidId = teammidId;
    }

    public Long getTeammidId(){
        return teammidId;
    }
    public void setMenId(String menId){
        this.menId = menId;
    }

    public String getMenId(){
        return menId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("teammidId", getTeammidId())
            .append("memId", getMenId())
            .append("teamId", getTeamId())
            .append("createTime", getCreateTime())
            .append("activeId", getActiveId())
            .toString();
    }
}
