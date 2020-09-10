import request from '@/utils/request'

export function addObj(obj) {
    return request({
        url: '/user/saveUser',
        method: 'post',
        data: obj
    })
}

export function putObj(obj) {
    return request({
        url: '/user/updateUser',
        method: 'put',
        data: obj
    })
}


export function delObj(id) {
    return request({
        url: '/admin/applet/admin/' + id,
        method: 'delete'
    })
}

export function fetchList(query) {
    return request({
        url: '/system/user/list',
        method: 'get',
        params: query
    })
}
