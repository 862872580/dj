import request from '@/utils/request'

// 查询选手用户列表
export function listMember(query) {
  return request({
    url: '/dj/member/list',
    method: 'get',
    params: query
  })
}

// 查询选手用户详细
export function getMember(menId) {
  return request({
    url: '/dj/member/' + menId,
    method: 'get'
  })
}

// 新增选手用户
export function addMember(data) {
  return request({
    url: '/dj/member',
    method: 'post',
    data: data
  })
}

// 修改选手用户
export function updateMember(data) {
  return request({
    url: '/dj/member',
    method: 'put',
    data: data
  })
}

// 删除选手用户
export function delMember(menId) {
  return request({
    url: '/dj/member/' + menId,
    method: 'delete'
  })
}

// 导出选手用户
export function exportMember(query) {
  return request({
    url: '/dj/member/export',
    method: 'get',
    params: query
  })
}