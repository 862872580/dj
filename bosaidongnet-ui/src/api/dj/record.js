import request from '@/utils/request'

// 查询比赛记录列表
export function listRecord(query) {
  return request({
    url: '/dj/record/list',
    method: 'get',
    params: query
  })
}

// 查询比赛记录详细
export function getRecord(recordId) {
  return request({
    url: '/dj/record/' + recordId,
    method: 'get'
  })
}

// 新增比赛记录
export function addRecord(data) {
  return request({
    url: '/dj/record',
    method: 'post',
    data: data
  })
}

// 修改比赛记录
export function updateRecord(data) {
  return request({
    url: '/dj/record',
    method: 'put',
    data: data
  })
}

// 删除比赛记录
export function delRecord(recordId) {
  return request({
    url: '/dj/record/' + recordId,
    method: 'delete'
  })
}

// 导出比赛记录
export function exportRecord(query) {
  return request({
    url: '/dj/record/export',
    method: 'get',
    params: query
  })
}