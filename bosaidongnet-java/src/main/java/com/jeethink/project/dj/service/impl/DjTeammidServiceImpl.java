package com.jeethink.project.dj.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.dj.mapper.DjTeammidMapper;
import com.jeethink.project.dj.domain.DjTeammid;
import com.jeethink.project.dj.service.IDjTeammidService;

/**
 * 队伍关系Service业务层处理
 * 
 * @author miao
 * @date 2020-09-12
 */
@Service
public class DjTeammidServiceImpl implements IDjTeammidService {
    @Autowired
    private DjTeammidMapper djTeammidMapper;

    /**
     * 查询队伍关系
     * 
     * @param teammidId 队伍关系ID
     * @return 队伍关系
     */
    @Override
    public DjTeammid selectDjTeammidById(Long teammidId) {
        return djTeammidMapper.selectDjTeammidById(teammidId);
    }

    /**
     * 查询队伍关系列表
     * 
     * @param djTeammid 队伍关系
     * @return 队伍关系
     */
    @Override
    public List<DjTeammid> selectDjTeammidList(DjTeammid djTeammid) {
        return djTeammidMapper.selectDjTeammidList(djTeammid);
    }

    /**
     * 新增队伍关系
     * 
     * @param djTeammid 队伍关系
     * @return 结果
     */
    @Override
    public int insertDjTeammid(DjTeammid djTeammid) {
        djTeammid.setCreateTime(DateUtils.getNowDate());
        return djTeammidMapper.insertDjTeammid(djTeammid);
    }

    /**
     * 修改队伍关系
     * 
     * @param djTeammid 队伍关系
     * @return 结果
     */
    @Override
    public int updateDjTeammid(DjTeammid djTeammid) {
        return djTeammidMapper.updateDjTeammid(djTeammid);
    }

    /**
     * 批量删除队伍关系
     * 
     * @param teammidIds 需要删除的队伍关系ID
     * @return 结果
     */
    @Override
    public int deleteDjTeammidByIds(Long[] teammidIds) {
        return djTeammidMapper.deleteDjTeammidByIds(teammidIds);
    }

    /**
     * 删除队伍关系信息
     * 
     * @param teammidId 队伍关系ID
     * @return 结果
     */
    @Override
    public int deleteDjTeammidById(Long teammidId) {
        return djTeammidMapper.deleteDjTeammidById(teammidId);
    }
}
