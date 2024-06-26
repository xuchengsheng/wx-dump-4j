// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

export async function queryMsg(params: MsgParams, options?: { [key: string]: any }) {
  return request<Response<MsgItem[]>>('/api/msg/list', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
    params: {
      ...params,
    },
    ...(options || {}),
  });
}

export async function exportMsg(params: ExportMsgParams, options?: { [key: string]: any }) {
  return request<Response<string>>('/api/msg/export', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
    params: {
      ...params,
    },
    ...(options || {}),
  });
}
