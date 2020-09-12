package com.jeethink.project.dj.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.dj.mapper.DjCodeMapper;
import com.jeethink.project.dj.domain.DjCode;
import com.jeethink.project.dj.service.IDjCodeService;

/**
 * 兑换码Service业务层处理
 * 
 * @author miao
 * @date 2020-09-12
 */
@Service
public class DjCodeServiceImpl implements IDjCodeService {
    @Autowired
    private DjCodeMapper djCodeMapper;

    /**
     * 查询兑换码
     * 
     * @param codeId 兑换码ID
     * @return 兑换码
     */
    @Override
    public DjCode selectDjCodeById(Long codeId) {
        return djCodeMapper.selectDjCodeById(codeId);
    }

    /**
     * 查询兑换码列表
     * 
     * @param djCode 兑换码
     * @return 兑换码
     */
    @Override
    public List<DjCode> selectDjCodeList(DjCode djCode) {
        return djCodeMapper.selectDjCodeList(djCode);
    }

    /**
     * 新增兑换码
     * 
     * @param djCode 兑换码
     * @return 结果
     */
    @Override
    public int insertDjCode(DjCode djCode) {
        djCode.setCreateTime(DateUtils.getNowDate());
        return djCodeMapper.insertDjCode(djCode);
    }

    /**
     * 修改兑换码
     * 
     * @param djCode 兑换码
     * @return 结果
     */
    @Override
    public int updateDjCode(DjCode djCode) {
        return djCodeMapper.updateDjCode(djCode);
    }

    /**
     * 批量删除兑换码
     * 
     * @param codeIds 需要删除的兑换码ID
     * @return 结果
     */
    @Override
    public int deleteDjCodeByIds(Long[] codeIds) {
        return djCodeMapper.deleteDjCodeByIds(codeIds);
    }

    /**
     * 删除兑换码信息
     * 
     * @param codeId 兑换码ID
     * @return 结果
     */
    @Override
    public int deleteDjCodeById(Long codeId) {
        return djCodeMapper.deleteDjCodeById(codeId);
    }
}
