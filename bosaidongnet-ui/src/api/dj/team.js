import request from '@/utils/request'

// 查询队伍列表
export function listTeam(query) {
  return request({
    url: '/dj/team/list',
    method: 'get',
    params: query
  })
}

// 查询队伍详细
export function getTeam(teamId) {
  return request({
    url: '/dj/team/' + teamId,
    method: 'get'
  })
}

// 新增队伍
export function addTeam(data) {
  return request({
    url: '/dj/team',
    method: 'post',
    data: data
  })
}

// 修改队伍
export function updateTeam(data) {
  return request({
    url: '/dj/team',
    method: 'put',
    data: data
  })
}

// 删除队伍
export function delTeam(teamId) {
  return request({
    url: '/dj/team/' + teamId,
    method: 'delete'
  })
}

// 导出队伍
export function exportTeam(query) {
  return request({
    url: '/dj/team/export',
    method: 'get',
    params: query
  })
}