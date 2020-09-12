import request from '@/utils/request'

// 查询队伍关系列表
export function listTeammid(query) {
  return request({
    url: '/dj/teammid/list',
    method: 'get',
    params: query
  })
}

// 查询队伍关系详细
export function getTeammid(teammidId) {
  return request({
    url: '/dj/teammid/' + teammidId,
    method: 'get'
  })
}

// 新增队伍关系
export function addTeammid(data) {
  return request({
    url: '/dj/teammid',
    method: 'post',
    data: data
  })
}

// 修改队伍关系
export function updateTeammid(data) {
  return request({
    url: '/dj/teammid',
    method: 'put',
    data: data
  })
}

// 删除队伍关系
export function delTeammid(teammidId) {
  return request({
    url: '/dj/teammid/' + teammidId,
    method: 'delete'
  })
}

// 导出队伍关系
export function exportTeammid(query) {
  return request({
    url: '/dj/teammid/export',
    method: 'get',
    params: query
  })
}