package com.jeethink.project.dj.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.project.dj.mapper.DjTeamMapper;
import com.jeethink.project.dj.domain.DjTeam;
import com.jeethink.project.dj.service.IDjTeamService;

/**
 * 队伍Service业务层处理
 * 
 * @author miao
 * @date 2020-09-12
 */
@Service
public class DjTeamServiceImpl implements IDjTeamService {
    @Autowired
    private DjTeamMapper djTeamMapper;

    /**
     * 查询队伍
     * 
     * @param teamId 队伍ID
     * @return 队伍
     */
    @Override
    public DjTeam selectDjTeamById(Long teamId) {
        return djTeamMapper.selectDjTeamById(teamId);
    }

    /**
     * 查询队伍列表
     * 
     * @param djTeam 队伍
     * @return 队伍
     */
    @Override
    public List<DjTeam> selectDjTeamList(DjTeam djTeam) {
        return djTeamMapper.selectDjTeamList(djTeam);
    }

    /**
     * 新增队伍
     * 
     * @param djTeam 队伍
     * @return 结果
     */
    @Override
    public DjTeam insertDjTeam(DjTeam djTeam) {
        djTeam.setStatus("1");
        djTeam.setCreateTime(DateUtils.getNowDate());
        djTeamMapper.insertDjTeam(djTeam);
        return djTeam;
    }

    /**
     * 修改队伍
     * 
     * @param djTeam 队伍
     * @return 结果
     */
    @Override
    public int updateDjTeam(DjTeam djTeam) {
        djTeam.setUpdateTime(DateUtils.getNowDate());
        return djTeamMapper.updateDjTeam(djTeam);
    }

    /**
     * 批量删除队伍
     * 
     * @param teamIds 需要删除的队伍ID
     * @return 结果
     */
    @Override
    public int deleteDjTeamByIds(Long[] teamIds) {
        return djTeamMapper.deleteDjTeamByIds(teamIds);
    }

    /**
     * 删除队伍信息
     * 
     * @param teamId 队伍ID
     * @return 结果
     */
    @Override
    public int deleteDjTeamById(Long teamId) {
        return djTeamMapper.deleteDjTeamById(teamId);
    }

    /**
     * 设置队伍满人状态
     * @param djTeam 队伍信息
     * @return 结果
     */
    @Override
    public int updateFullTime(DjTeam djTeam) {
        return djTeamMapper.updateFullTime(djTeam);
    }

    /**
     * 判断队伍名称是否重复
     * @param teamName 队伍名称
     * @return 结果
     */
    @Override
    public DjTeam selectDjTeamByName(String teamName) {
        teamName = teamName.trim();
        return djTeamMapper.selectDjTeamByName(teamName);
    }
}
