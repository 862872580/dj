import request from '@/utils/request'

// 查询活动列表
export function listActivity(query) {
  return request({
    url: '/dj/activity/list',
    method: 'get',
    params: query
  })
}

// 查询活动详细
export function getActivity(activeId) {
  return request({
    url: '/dj/activity/' + activeId,
    method: 'get'
  })
}

// 新增活动
export function addActivity(data) {
  return request({
    url: '/dj/activity',
    method: 'post',
    data: data
  })
}

// 修改活动
export function updateActivity(data) {
  return request({
    url: '/dj/activity',
    method: 'put',
    data: data
  })
}

// 删除活动
export function delActivity(activeId) {
  return request({
    url: '/dj/activity/' + activeId,
    method: 'delete'
  })
}

// 导出活动
export function exportActivity(query) {
  return request({
    url: '/dj/activity/export',
    method: 'get',
    params: query
  })
}