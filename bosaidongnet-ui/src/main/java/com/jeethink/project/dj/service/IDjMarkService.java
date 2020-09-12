package com.jeethink.project.dj.service;

import java.util.List;
import com.jeethink.project.dj.domain.DjMark;

/**
 * 单场比赛记录Service接口
 * 
 * @author miao
 * @date 2020-09-12
 */
public interface IDjMarkService {
    /**
     * 查询单场比赛记录
     * 
     * @param markId 单场比赛记录ID
     * @return 单场比赛记录
     */
    public DjMark selectDjMarkById(Long markId);

    /**
     * 查询单场比赛记录列表
     * 
     * @param djMark 单场比赛记录
     * @return 单场比赛记录集合
     */
    public List<DjMark> selectDjMarkList(DjMark djMark);

    /**
     * 新增单场比赛记录
     * 
     * @param djMark 单场比赛记录
     * @return 结果
     */
    public int insertDjMark(DjMark djMark);

    /**
     * 修改单场比赛记录
     * 
     * @param djMark 单场比赛记录
     * @return 结果
     */
    public int updateDjMark(DjMark djMark);

    /**
     * 批量删除单场比赛记录
     * 
     * @param markIds 需要删除的单场比赛记录ID
     * @return 结果
     */
    public int deleteDjMarkByIds(Long[] markIds);

    /**
     * 删除单场比赛记录信息
     * 
     * @param markId 单场比赛记录ID
     * @return 结果
     */
    public int deleteDjMarkById(Long markId);
}
