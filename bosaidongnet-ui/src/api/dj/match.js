import request from '@/utils/request'

// 查询比赛场次列表
export function listMatch(query) {
  return request({
    url: '/dj/match/list',
    method: 'get',
    params: query
  })
}

// 查询比赛场次详细
export function getMatch(matchId) {
  return request({
    url: '/dj/match/' + matchId,
    method: 'get'
  })
}

// 新增比赛场次
export function addMatch(data) {
  return request({
    url: '/dj/match',
    method: 'post',
    data: data
  })
}

// 修改比赛场次
export function updateMatch(data) {
  return request({
    url: '/dj/match',
    method: 'put',
    data: data
  })
}

// 删除比赛场次
export function delMatch(matchId) {
  return request({
    url: '/dj/match/' + matchId,
    method: 'delete'
  })
}

// 导出比赛场次
export function exportMatch(query) {
  return request({
    url: '/dj/match/export',
    method: 'get',
    params: query
  })
}