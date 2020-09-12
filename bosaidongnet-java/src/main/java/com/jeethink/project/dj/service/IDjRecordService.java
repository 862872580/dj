package com.jeethink.project.dj.service;

import java.util.List;
import com.jeethink.project.dj.domain.DjRecord;

/**
 * 比赛记录Service接口
 * 
 * @author miao
 * @date 2020-09-12
 */
public interface IDjRecordService {
    /**
     * 查询比赛记录
     * 
     * @param recordId 比赛记录ID
     * @return 比赛记录
     */
    public DjRecord selectDjRecordById(Long recordId);

    /**
     * 查询比赛记录列表
     * 
     * @param djRecord 比赛记录
     * @return 比赛记录集合
     */
    public List<DjRecord> selectDjRecordList(DjRecord djRecord);

    /**
     * 新增比赛记录
     * 
     * @param djRecord 比赛记录
     * @return 结果
     */
    public int insertDjRecord(DjRecord djRecord);

    /**
     * 修改比赛记录
     * 
     * @param djRecord 比赛记录
     * @return 结果
     */
    public int updateDjRecord(DjRecord djRecord);

    /**
     * 批量删除比赛记录
     * 
     * @param recordIds 需要删除的比赛记录ID
     * @return 结果
     */
    public int deleteDjRecordByIds(Long[] recordIds);

    /**
     * 删除比赛记录信息
     * 
     * @param recordId 比赛记录ID
     * @return 结果
     */
    public int deleteDjRecordById(Long recordId);
}
