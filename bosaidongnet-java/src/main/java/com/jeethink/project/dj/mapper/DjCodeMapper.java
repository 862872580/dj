package com.jeethink.project.dj.mapper;

import java.util.List;
import com.jeethink.project.dj.domain.DjCode;

/**
 * 兑换码Mapper接口
 * 
 * @author miao
 * @date 2020-09-12
 */
public interface DjCodeMapper {
    /**
     * 查询兑换码
     * 
     * @param codeId 兑换码ID
     * @return 兑换码
     */
    public DjCode selectDjCodeById(Long codeId);

    /**
     * 查询兑换码列表
     * 
     * @param djCode 兑换码
     * @return 兑换码集合
     */
    public List<DjCode> selectDjCodeList(DjCode djCode);

    /**
     * 新增兑换码
     * 
     * @param djCode 兑换码
     * @return 结果
     */
    public int insertDjCode(DjCode djCode);

    /**
     * 修改兑换码
     * 
     * @param djCode 兑换码
     * @return 结果
     */
    public int updateDjCode(DjCode djCode);

    /**
     * 删除兑换码
     * 
     * @param codeId 兑换码ID
     * @return 结果
     */
    public int deleteDjCodeById(Long codeId);

    /**
     * 批量删除兑换码
     * 
     * @param codeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDjCodeByIds(Long[] codeIds);
}
