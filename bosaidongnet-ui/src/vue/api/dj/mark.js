import request from '@/utils/request'

// 查询单场比赛记录列表
export function listMark(query) {
  return request({
    url: '/dj/mark/list',
    method: 'get',
    params: query
  })
}

// 查询单场比赛记录详细
export function getMark(markId) {
  return request({
    url: '/dj/mark/' + markId,
    method: 'get'
  })
}

// 新增单场比赛记录
export function addMark(data) {
  return request({
    url: '/dj/mark',
    method: 'post',
    data: data
  })
}

// 修改单场比赛记录
export function updateMark(data) {
  return request({
    url: '/dj/mark',
    method: 'put',
    data: data
  })
}

// 删除单场比赛记录
export function delMark(markId) {
  return request({
    url: '/dj/mark/' + markId,
    method: 'delete'
  })
}

// 导出单场比赛记录
export function exportMark(query) {
  return request({
    url: '/dj/mark/export',
    method: 'get',
    params: query
  })
}