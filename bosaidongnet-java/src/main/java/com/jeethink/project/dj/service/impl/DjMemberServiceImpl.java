package com.jeethink.project.dj.service.impl;

import java.util.List;
import java.util.UUID;

import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.dj.mapper.DjMemberMapper;
import com.jeethink.project.dj.domain.DjMember;
import com.jeethink.project.dj.service.IDjMemberService;

/**
 * 选手用户Service业务层处理
 * 
 * @author miao
 * @date 2020-09-14
 */
@Service
public class DjMemberServiceImpl implements IDjMemberService {
    @Autowired
    private DjMemberMapper djMemberMapper;

    /**
     * 查询选手用户
     * 
     * @param menId 选手用户ID
     * @return 选手用户
     */
    @Override
    public DjMember selectDjMemberById(String menId) {
        return djMemberMapper.selectDjMemberById(menId);
    }

    /**
     * 查询选手用户列表
     * 
     * @param djMember 选手用户
     * @return 选手用户
     */
    @Override
    public List<DjMember> selectDjMemberList(DjMember djMember) {
        return djMemberMapper.selectDjMemberList(djMember);
    }

    /**
     * 新增选手用户
     * 
     * @param djMember 选手用户
     * @return 结果
     */
    @Override
    public int insertDjMember(DjMember djMember) {
        djMember.setStatus("1");
        String uuid = UUID.randomUUID().toString();
        djMember.setMenId(uuid);
        djMember.setCreateTime(DateUtils.getNowDate());
        return djMemberMapper.insertDjMember(djMember);
    }

    /**
     * 修改选手用户
     * 
     * @param djMember 选手用户
     * @return 结果
     */
    @Override
    public int updateDjMember(DjMember djMember) {
        djMember.setUpdateTime(DateUtils.getNowDate());
        return djMemberMapper.updateDjMember(djMember);
    }

    /**
     * 批量删除选手用户
     * 
     * @param menIds 需要删除的选手用户ID
     * @return 结果
     */
    @Override
    public int deleteDjMemberByIds(String[] menIds) {
        return djMemberMapper.deleteDjMemberByIds(menIds);
    }

    /**
     * 删除选手用户信息
     * 
     * @param menId 选手用户ID
     * @return 结果
     */
    @Override
    public int deleteDjMemberById(String menId) {
        return djMemberMapper.deleteDjMemberById(menId);
    }

    /**
     * 查询选手用户信息
     * @param openid 微信id
     * @return 结果
     */
    @Override
    public DjMember selectDjMemberByOpenId(String openid) {
        return djMemberMapper.selectDjMemberByOpenId(openid);
    }
}
