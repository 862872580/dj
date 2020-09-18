package com.jeethink.project.dj.service;

import java.util.List;

import com.jeethink.project.dj.domain.DjTeammid;

/**
 * 队伍关系Service接口
 * 
 * @author miao
 * @date 2020-09-12
 */
public interface IDjTeammidService {
    /**
     * 查询队伍关系
     * 
     * @param teammidId 队伍关系ID
     * @return 队伍关系
     */
    public DjTeammid selectDjTeammidById(Long teammidId);

    /**
     * 查询队伍关系列表
     * 
     * @param djTeammid 队伍关系
     * @return 队伍关系集合
     */
    public List<DjTeammid> selectDjTeammidList(DjTeammid djTeammid);

    /**
     * 新增队伍关系
     * 
     * @param djTeammid 队伍关系
     * @return 结果
     */
    public int insertDjTeammid(DjTeammid djTeammid);

    /**
     * 修改队伍关系
     * 
     * @param djTeammid 队伍关系
     * @return 结果
     */
    public int updateDjTeammid(DjTeammid djTeammid);

    /**
     * 批量删除队伍关系
     * 
     * @param teammidIds 需要删除的队伍关系ID
     * @return 结果
     */
    public int deleteDjTeammidByIds(Long[] teammidIds);

    /**
     * 删除队伍关系信息
     * 
     * @param teammidId 队伍关系ID
     * @return 结果
     */
    public int deleteDjTeammidById(Long teammidId);

    int countDjTeammid(long teamId);

    DjTeammid selectDjTeammidByMenId(DjTeammid djTeammid);

    int deleteDjTeammidByMenId(String menId, long teamId);

    int deleteDjTeammidByTeamId(long teamId);
}
