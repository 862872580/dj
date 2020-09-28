package com.jeethink.project.dj.mapper;

import java.util.List;
import com.jeethink.project.dj.domain.DjTeam;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    public DjTeam insertDjTeam(DjTeam djTeam);

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

    /**
     * 跟新队伍信息
     * @param djTeam 队伍信息
     * @return 结果
     */
    @Update("update dj_team set full_time = #{fullTime}, status = #{status} where team_id = #{teamId}")
    int updateFullTime(DjTeam djTeam);

    /**
     * 根据名称查询队伍信息
     * @param teamName 队伍名称
     * @return 结果
     */
    DjTeam selectDjTeamByName(String teamName);

    List<DjTeam> selectDjTeamListByActiveId(Long activeId,Long teamTotal);
}
