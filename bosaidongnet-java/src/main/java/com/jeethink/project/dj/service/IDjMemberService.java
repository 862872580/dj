package com.jeethink.project.dj.service;

import java.util.List;
import com.jeethink.project.dj.domain.DjMember;

/**
 * 选手用户Service接口
 * 
 * @author miao
 * @date 2020-09-12
 */
public interface IDjMemberService {
    /**
     * 查询选手用户
     * 
     * @param menId 选手用户ID
     * @return 选手用户
     */
    public DjMember selectDjMemberById(String menId);

    /**
     * 查询选手用户列表
     * 
     * @param djMember 选手用户
     * @return 选手用户集合
     */
    public List<DjMember> selectDjMemberList(DjMember djMember);

    /**
     * 新增选手用户
     * 
     * @param djMember 选手用户
     * @return 结果
     */
    public int insertDjMember(DjMember djMember);

    /**
     * 修改选手用户
     * 
     * @param djMember 选手用户
     * @return 结果
     */
    public int updateDjMember(DjMember djMember);

    /**
     * 批量删除选手用户
     * 
     * @param menIds 需要删除的选手用户ID
     * @return 结果
     */
    public int deleteDjMemberByIds(String[] menIds);

    /**
     * 删除选手用户信息
     * 
     * @param menId 选手用户ID
     * @return 结果
     */
    public int deleteDjMemberById(String menId);
}
