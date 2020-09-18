package com.jeethink.project.dj.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.framework.aspectj.lang.annotation.Excel;
import com.jeethink.framework.web.domain.BaseEntity;

/**
 * 兑换码对象 dj_code
 * 
 * @author miao
 * @date 2020-09-12
 */
public class DjCode extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 兑换码id */
    private Long codeId;

    /** 兑换码 */
    @Excel(name = "兑换码")
    private String code;

    /** 积分 */
    @Excel(name = "积分")
    private Integer score;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd  HH:mm:ss")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd  HH:mm:ss")
    private Date endTime;

    /** 充值时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "充值时间", width = 30, dateFormat = "yyyy-MM-dd  HH:mm:ss")
    private Date useTime;

    /** 充值用户id */
    @Excel(name = "充值用户id")
    private String menId;

    /** 兑换状态(1:未兑换, 0:已兑换) */
    @Excel(name = "兑换状态(1:未兑换, 0:已兑换)")
    private String status;

    public void setCodeId(Long codeId){
        this.codeId = codeId;
    }

    public Long getCodeId(){
        return codeId;
    }
    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
    public void setScore(Integer score){
        this.score = score;
    }

    public Integer getScore(){
        return score;
    }
    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
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
    public void setUseTime(Date useTime){
        this.useTime = useTime;
    }

    public Date getUseTime(){
        return useTime;
    }
    public void setMenId(String menId){
        this.menId = menId;
    }

    public String getMenId(){
        return menId;
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
            .append("codeId", getCodeId())
            .append("code", getCode())
            .append("score", getScore())
            .append("type", getType())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("useTime", getUseTime())
            .append("menId", getMenId())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
