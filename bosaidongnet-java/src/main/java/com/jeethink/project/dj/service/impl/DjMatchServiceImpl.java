package com.jeethink.project.dj.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.dj.mapper.DjMatchMapper;
import com.jeethink.project.dj.domain.DjMatch;
import com.jeethink.project.dj.service.IDjMatchService;

/**
 * 比赛场次Service业务层处理
 * 
 * @author miao
 * @date 2020-09-12
 */
@Service
public class DjMatchServiceImpl implements IDjMatchService {
    @Autowired
    private DjMatchMapper djMatchMapper;

    /**
     * 查询比赛场次
     * 
     * @param matchId 比赛场次ID
     * @return 比赛场次
     */
    @Override
    public DjMatch selectDjMatchById(Long matchId) {
        return djMatchMapper.selectDjMatchById(matchId);
    }

    /**
     * 查询比赛场次列表
     * 
     * @param djMatch 比赛场次
     * @return 比赛场次
     */
    @Override
    public List<DjMatch> selectDjMatchList(DjMatch djMatch) {
        return djMatchMapper.selectDjMatchList(djMatch);
    }

    /**
     * 新增比赛场次
     * 
     * @param djMatch 比赛场次
     * @return 结果
     */
    @Override
    public int insertDjMatch(DjMatch djMatch) {
        djMatch.setCreateTime(DateUtils.getNowDate());
        return djMatchMapper.insertDjMatch(djMatch);
    }

    /**
     * 修改比赛场次
     * 
     * @param djMatch 比赛场次
     * @return 结果
     */
    @Override
    public int updateDjMatch(DjMatch djMatch) {
        return djMatchMapper.updateDjMatch(djMatch);
    }

    /**
     * 批量删除比赛场次
     * 
     * @param matchIds 需要删除的比赛场次ID
     * @return 结果
     */
    @Override
    public int deleteDjMatchByIds(Long[] matchIds) {
        return djMatchMapper.deleteDjMatchByIds(matchIds);
    }

    /**
     * 删除比赛场次信息
     * 
     * @param matchId 比赛场次ID
     * @return 结果
     */
    @Override
    public int deleteDjMatchById(Long matchId) {
        return djMatchMapper.deleteDjMatchById(matchId);
    }
}
