package com.jeethink.project.dj.service;

import java.util.List;
import com.jeethink.project.dj.domain.DjActivity;

/**
 * 活动Service接口
 * 
 * @author miao
 * @date 2020-09-12
 */
public interface IDjActivityService {
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
     * 批量删除活动
     * 
     * @param activeIds 需要删除的活动ID
     * @return 结果
     */
    public int deleteDjActivityByIds(Long[] activeIds);

    /**
     * 删除活动信息
     * 
     * @param activeId 活动ID
     * @return 结果
     */
    public int deleteDjActivityById(Long activeId);
}
