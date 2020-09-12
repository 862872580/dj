package com.jeethink.project.dj.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.dj.mapper.DjActivityMapper;
import com.jeethink.project.dj.domain.DjActivity;
import com.jeethink.project.dj.service.IDjActivityService;

/**
 * 活动Service业务层处理
 * 
 * @author miao
 * @date 2020-09-12
 */
@Service
public class DjActivityServiceImpl implements IDjActivityService {
    @Autowired
    private DjActivityMapper djActivityMapper;

    /**
     * 查询活动
     * 
     * @param activeId 活动ID
     * @return 活动
     */
    @Override
    public DjActivity selectDjActivityById(Long activeId) {
        return djActivityMapper.selectDjActivityById(activeId);
    }

    /**
     * 查询活动列表
     * 
     * @param djActivity 活动
     * @return 活动
     */
    @Override
    public List<DjActivity> selectDjActivityList(DjActivity djActivity) {
        return djActivityMapper.selectDjActivityList(djActivity);
    }

    /**
     * 新增活动
     * 
     * @param djActivity 活动
     * @return 结果
     */
    @Override
    public int insertDjActivity(DjActivity djActivity) {
        djActivity.setCreateTime(DateUtils.getNowDate());
        return djActivityMapper.insertDjActivity(djActivity);
    }

    /**
     * 修改活动
     * 
     * @param djActivity 活动
     * @return 结果
     */
    @Override
    public int updateDjActivity(DjActivity djActivity) {
        djActivity.setUpdateTime(DateUtils.getNowDate());
        return djActivityMapper.updateDjActivity(djActivity);
    }

    /**
     * 批量删除活动
     * 
     * @param activeIds 需要删除的活动ID
     * @return 结果
     */
    @Override
    public int deleteDjActivityByIds(Long[] activeIds) {
        return djActivityMapper.deleteDjActivityByIds(activeIds);
    }

    /**
     * 删除活动信息
     * 
     * @param activeId 活动ID
     * @return 结果
     */
    @Override
    public int deleteDjActivityById(Long activeId) {
        return djActivityMapper.deleteDjActivityById(activeId);
    }
}
