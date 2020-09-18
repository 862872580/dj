package com.jeethink.project.dj.mapper;

import java.util.List;
import com.jeethink.project.dj.domain.DjTeammid;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

/**
 * 队伍关系Mapper接口
 * 
 * @author miao
 * @date 2020-09-12
 */
public interface DjTeammidMapper {
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
     * 删除队伍关系
     * 
     * @param teammidId 队伍关系ID
     * @return 结果
     */
    public int deleteDjTeammidById(Long teammidId);

    /**
     * 批量删除队伍关系
     * 
     * @param teammidIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDjTeammidByIds(Long[] teammidIds);

    /**
     * 查询队伍人数
     * @param teamId 队伍ID
     * @return 结果
     */
    @Select("select count(team_id) from dj_teammid where team_id = #{teamId};")
    public int countDjTeammid(long teamId);

    DjTeammid selectDjTeammidByMenId(DjTeammid djTeammid);

    @Delete("delete from dj_teammid where men_id = #{menId} and team_id = #{teamId}")
    int deleteDjTeammidByMenId(String menId, long teamId);

    @Delete("delete from dj_teammid where team_id = #{teamId}")
    int deleteDjTeammidByTeamId(long teamId);
}
