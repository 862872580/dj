package com.jeethink.project.dj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 单场比赛记录对象 dj_mark
 * 
 * @author miao
 * @date 2020-09-12
 */
public class DjMark extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 单场记录id */
    private Long markId;

    /** 胜利队伍id */
    @Excel(name = "胜利队伍id")
    private Long winteamId;

    /** 失败队伍id */
    @Excel(name = "失败队伍id")
    private Long loseteamId;

    /** 比赛记录id */
    @Excel(name = "比赛记录id")
    private Long recordId;

    /** 比赛照片位置 */
    @Excel(name = "比赛照片位置")
    private String photo;

    public void setMarkId(Long markId){
        this.markId = markId;
    }

    public Long getMarkId(){
        return markId;
    }
    public void setWinteamId(Long winteamId){
        this.winteamId = winteamId;
    }

    public Long getWinteamId(){
        return winteamId;
    }
    public void setLoseteamId(Long loseteamId){
        this.loseteamId = loseteamId;
    }

    public Long getLoseteamId(){
        return loseteamId;
    }
    public void setRecordId(Long recordId){
        this.recordId = recordId;
    }

    public Long getRecordId(){
        return recordId;
    }
    public void setPhoto(String photo){
        this.photo = photo;
    }

    public String getPhoto(){
        return photo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("markId", getMarkId())
            .append("winteamId", getWinteamId())
            .append("loseteamId", getLoseteamId())
            .append("recordId", getRecordId())
            .append("photo", getPhoto())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
