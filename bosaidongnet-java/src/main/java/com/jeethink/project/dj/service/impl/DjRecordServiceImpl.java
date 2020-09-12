package com.jeethink.project.dj.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.dj.mapper.DjRecordMapper;
import com.jeethink.project.dj.domain.DjRecord;
import com.jeethink.project.dj.service.IDjRecordService;

/**
 * 比赛记录Service业务层处理
 * 
 * @author miao
 * @date 2020-09-12
 */
@Service
public class DjRecordServiceImpl implements IDjRecordService {
    @Autowired
    private DjRecordMapper djRecordMapper;

    /**
     * 查询比赛记录
     * 
     * @param recordId 比赛记录ID
     * @return 比赛记录
     */
    @Override
    public DjRecord selectDjRecordById(Long recordId) {
        return djRecordMapper.selectDjRecordById(recordId);
    }

    /**
     * 查询比赛记录列表
     * 
     * @param djRecord 比赛记录
     * @return 比赛记录
     */
    @Override
    public List<DjRecord> selectDjRecordList(DjRecord djRecord) {
        return djRecordMapper.selectDjRecordList(djRecord);
    }

    /**
     * 新增比赛记录
     * 
     * @param djRecord 比赛记录
     * @return 结果
     */
    @Override
    public int insertDjRecord(DjRecord djRecord) {
        djRecord.setCreateTime(DateUtils.getNowDate());
        return djRecordMapper.insertDjRecord(djRecord);
    }

    /**
     * 修改比赛记录
     * 
     * @param djRecord 比赛记录
     * @return 结果
     */
    @Override
    public int updateDjRecord(DjRecord djRecord) {
        return djRecordMapper.updateDjRecord(djRecord);
    }

    /**
     * 批量删除比赛记录
     * 
     * @param recordIds 需要删除的比赛记录ID
     * @return 结果
     */
    @Override
    public int deleteDjRecordByIds(Long[] recordIds) {
        return djRecordMapper.deleteDjRecordByIds(recordIds);
    }

    /**
     * 删除比赛记录信息
     * 
     * @param recordId 比赛记录ID
     * @return 结果
     */
    @Override
    public int deleteDjRecordById(Long recordId) {
        return djRecordMapper.deleteDjRecordById(recordId);
    }
}
