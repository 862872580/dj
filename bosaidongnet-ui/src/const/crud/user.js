/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */
export const tableOption = {
    border: true,
    index: true,
    indexLabel: '序号',
    stripe: true,
    menuAlign: 'center',
    searchMenuSpan: 6,
    align: 'center',
    column: [{
        fixed: true,
        label: 'id',
        prop: 'id',
        span: 24,
        hide: true,
        editDisabled: true,
        addDisplay: false
    }, {
        label: '用户名',
        prop: 'userName',
        type: 'input',
    },{
        label: '昵称',
        prop: 'nickName',
        type: 'input',
    }, {
        type: "input",
        label: '手机号',
        prop: 'phonenumber',
        overHidden: true,
        rules: [{
            required: true,
            message: '请输入手机号',
            trigger: 'blur'
        }]
    },{
        type: "input",
        label: '备注',
        prop: 'remark',
        overHidden: true,
    }, {
        width: 180,
        label: '创建时间',
        prop: 'createTime',
        type: 'datetime',
        format: 'yyyy-MM-dd HH:mm',
        valueFormat: 'yyyy-MM-dd HH:mm:ss',
        editDisabled: true,
        addDisplay: false,
        span: 24
    }]
}
