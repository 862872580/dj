package com.jeethink.project.dj.mapper;

import java.util.List;
import com.jeethink.project.dj.domain.DjTeammid;

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
}
