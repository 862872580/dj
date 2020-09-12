package com.jeethink.project.dj.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.dj.mapper.DjMarkMapper;
import com.jeethink.project.dj.domain.DjMark;
import com.jeethink.project.dj.service.IDjMarkService;

/**
 * 单场比赛记录Service业务层处理
 * 
 * @author miao
 * @date 2020-09-12
 */
@Service
public class DjMarkServiceImpl implements IDjMarkService {
    @Autowired
    private DjMarkMapper djMarkMapper;

    /**
     * 查询单场比赛记录
     * 
     * @param markId 单场比赛记录ID
     * @return 单场比赛记录
     */
    @Override
    public DjMark selectDjMarkById(Long markId) {
        return djMarkMapper.selectDjMarkById(markId);
    }

    /**
     * 查询单场比赛记录列表
     * 
     * @param djMark 单场比赛记录
     * @return 单场比赛记录
     */
    @Override
    public List<DjMark> selectDjMarkList(DjMark djMark) {
        return djMarkMapper.selectDjMarkList(djMark);
    }

    /**
     * 新增单场比赛记录
     * 
     * @param djMark 单场比赛记录
     * @return 结果
     */
    @Override
    public int insertDjMark(DjMark djMark) {
        djMark.setCreateTime(DateUtils.getNowDate());
        return djMarkMapper.insertDjMark(djMark);
    }

    /**
     * 修改单场比赛记录
     * 
     * @param djMark 单场比赛记录
     * @return 结果
     */
    @Override
    public int updateDjMark(DjMark djMark) {
        return djMarkMapper.updateDjMark(djMark);
    }

    /**
     * 批量删除单场比赛记录
     * 
     * @param markIds 需要删除的单场比赛记录ID
     * @return 结果
     */
    @Override
    public int deleteDjMarkByIds(Long[] markIds) {
        return djMarkMapper.deleteDjMarkByIds(markIds);
    }

    /**
     * 删除单场比赛记录信息
     * 
     * @param markId 单场比赛记录ID
     * @return 结果
     */
    @Override
    public int deleteDjMarkById(Long markId) {
        return djMarkMapper.deleteDjMarkById(markId);
    }
}
