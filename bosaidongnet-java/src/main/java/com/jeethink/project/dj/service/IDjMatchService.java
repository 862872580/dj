package com.jeethink.project.dj.service;

import java.util.List;
import com.jeethink.project.dj.domain.DjMatch;

/**
 * 比赛场次Service接口
 * 
 * @author miao
 * @date 2020-09-12
 */
public interface IDjMatchService {
    /**
     * 查询比赛场次
     * 
     * @param matchId 比赛场次ID
     * @return 比赛场次
     */
    public DjMatch selectDjMatchById(Long matchId);

    /**
     * 查询比赛场次列表
     * 
     * @param djMatch 比赛场次
     * @return 比赛场次集合
     */
    public List<DjMatch> selectDjMatchList(DjMatch djMatch);

    /**
     * 新增比赛场次
     * 
     * @param djMatch 比赛场次
     * @return 结果
     */
    public DjMatch insertDjMatch(DjMatch djMatch);

    /**
     * 修改比赛场次
     * 
     * @param djMatch 比赛场次
     * @return 结果
     */
    public int updateDjMatch(DjMatch djMatch);

    /**
     * 批量删除比赛场次
     * 
     * @param matchIds 需要删除的比赛场次ID
     * @return 结果
     */
    public int deleteDjMatchByIds(Long[] matchIds);

    /**
     * 删除比赛场次信息
     * 
     * @param matchId 比赛场次ID
     * @return 结果
     */
    public int deleteDjMatchById(Long matchId);
}
