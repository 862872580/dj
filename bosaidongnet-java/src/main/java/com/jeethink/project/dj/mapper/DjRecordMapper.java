package com.jeethink.project.dj.mapper;

import java.util.List;
import com.jeethink.project.dj.domain.DjRecord;
import org.apache.ibatis.annotations.Select;

/**
 * 比赛记录Mapper接口
 * 
 * @author miao
 * @date 2020-09-12
 */
public interface DjRecordMapper {
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
     * 删除比赛记录
     * 
     * @param recordId 比赛记录ID
     * @return 结果
     */
    public int deleteDjRecordById(Long recordId);

    /**
     * 批量删除比赛记录
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDjRecordByIds(Long[] recordIds);

    List<DjRecord> selectDjRecordRank(long matchId);
}
