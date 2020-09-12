package com.jeethink.project.dj.mapper;

import java.util.List;
import com.jeethink.project.dj.domain.DjTeam;

/**
 * 队伍Mapper接口
 * 
 * @author miao
 * @date 2020-09-12
 */
public interface DjTeamMapper {
    /**
     * 查询队伍
     * 
     * @param teamId 队伍ID
     * @return 队伍
     */
    public DjTeam selectDjTeamById(Long teamId);

    /**
     * 查询队伍列表
     * 
     * @param djTeam 队伍
     * @return 队伍集合
     */
    public List<DjTeam> selectDjTeamList(DjTeam djTeam);

    /**
     * 新增队伍
     * 
     * @param djTeam 队伍
     * @return 结果
     */
    public int insertDjTeam(DjTeam djTeam);

    /**
     * 修改队伍
     * 
     * @param djTeam 队伍
     * @return 结果
     */
    public int updateDjTeam(DjTeam djTeam);

    /**
     * 删除队伍
     * 
     * @param teamId 队伍ID
     * @return 结果
     */
    public int deleteDjTeamById(Long teamId);

    /**
     * 批量删除队伍
     * 
     * @param teamIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDjTeamByIds(Long[] teamIds);
}
