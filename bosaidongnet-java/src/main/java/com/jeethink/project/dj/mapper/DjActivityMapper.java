package com.jeethink.project.dj.mapper;

import java.util.List;
import com.jeethink.project.dj.domain.DjActivity;

/**
 * 活动Mapper接口
 * 
 * @author miao
 * @date 2020-09-12
 */
public interface DjActivityMapper {
    /**
     * 查询活动
     * 
     * @param activeId 活动ID
     * @return 活动
     */
    public DjActivity selectDjActivityById(Long activeId);

    /**
     * 查询活动列表
     * 
     * @param djActivity 活动
     * @return 活动集合
     */
    public List<DjActivity> selectDjActivityList(DjActivity djActivity);

    /**
     * 新增活动
     * 
     * @param djActivity 活动
     * @return 结果
     */
    public int insertDjActivity(DjActivity djActivity);

    /**
     * 修改活动
     * 
     * @param djActivity 活动
     * @return 结果
     */
    public int updateDjActivity(DjActivity djActivity);

    /**
     * 删除活动
     * 
     * @param activeId 活动ID
     * @return 结果
     */
    public int deleteDjActivityById(Long activeId);

    /**
     * 批量删除活动
     * 
     * @param activeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDjActivityByIds(Long[] activeIds);
}
