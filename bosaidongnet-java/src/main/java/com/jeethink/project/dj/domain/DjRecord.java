package com.jeethink.project.dj.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 比赛记录对象 dj_record
 * 
 * @author miao
 * @date 2020-09-12
 */
public class DjRecord extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 比赛记录id */
    private Long recordId;

    /** a队id */
    @Excel(name = "a队id")
    private Long teamaId;

    /** b队id */
    @Excel(name = "b队id")
    private Long teambId;

    /** 失败队伍 */
    @Excel(name = "失败队伍")
    private Long loseteamId;

    /** 胜利队伍 */
    @Excel(name = "胜利队伍")
    private Long winteamId;

    /** a队比分 */
    @Excel(name = "a队比分")
    private Integer aScore;

    /** b队比分 */
    @Excel(name = "b队比分")
    private Integer bScore;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd  HH:mm:ss")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd  HH:mm:ss")
    private Date endTime;

    /** 比赛场次id */
    @Excel(name = "比赛场次id")
    private Long matchId;

    /** 排名 */
    @Excel(name = "排名")
    private String rank;

    /** 裁判id */
    @Excel(name = "裁判id")
    private Long userId;

    /** 比赛状态(0:结束 1:未结束) */
    @Excel(name = "比赛状态(0:结束 1:未结束)")
    private String status;

    public void setRecordId(Long recordId){
        this.recordId = recordId;
    }

    public Long getRecordId(){
        return recordId;
    }
    public void setTeamaId(Long teamaId){
        this.teamaId = teamaId;
    }

    public Long getTeamaId(){
        return teamaId;
    }
    public void setTeambId(Long teambId){
        this.teambId = teambId;
    }

    public Long getTeambId(){
        return teambId;
    }
    public void setLoseteamId(Long loseteamId){
        this.loseteamId = loseteamId;
    }

    public Long getLoseteamId(){
        return loseteamId;
    }
    public void setWinteamId(Long winteamId){
        this.winteamId = winteamId;
    }

    public Long getWinteamId(){
        return winteamId;
    }
    public void setaScore(Integer aScore){
        this.aScore = aScore;
    }

    public Integer getaScore(){
        return aScore;
    }
    public void setbScore(Integer bScore){
        this.bScore = bScore;
    }

    public Integer getbScore(){
        return bScore;
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
    public void setMatchId(Long matchId){
        this.matchId = matchId;
    }

    public Long getMatchId(){
        return matchId;
    }
    public void setRank(String rank){
        this.rank = rank;
    }

    public String getRank(){
        return rank;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }

    public Long getUserId(){
        return userId;
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
            .append("recordId", getRecordId())
            .append("teamaId", getTeamaId())
            .append("teambId", getTeambId())
            .append("loseteamId", getLoseteamId())
            .append("winteamId", getWinteamId())
            .append("aScore", getaScore())
            .append("bScore", getbScore())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("matchId", getMatchId())
            .append("rank", getRank())
            .append("userId", getUserId())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
