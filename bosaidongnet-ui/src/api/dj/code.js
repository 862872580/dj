import request from '@/utils/request'

// 查询兑换码列表
export function listCode(query) {
  return request({
    url: '/dj/code/list',
    method: 'get',
    params: query
  })
}

// 查询兑换码详细
export function getCode(codeId) {
  return request({
    url: '/dj/code/' + codeId,
    method: 'get'
  })
}

// 新增兑换码
export function addCode(data) {
  return request({
    url: '/dj/code',
    method: 'post',
    data: data
  })
}

// 修改兑换码
export function updateCode(data) {
  return request({
    url: '/dj/code',
    method: 'put',
    data: data
  })
}

// 删除兑换码
export function delCode(codeId) {
  return request({
    url: '/dj/code/' + codeId,
    method: 'delete'
  })
}

// 导出兑换码
export function exportCode(query) {
  return request({
    url: '/dj/code/export',
    method: 'get',
    params: query
  })
}