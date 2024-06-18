// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

export async function queryRecoverContact(params: RecoverContactParams, options?: { [key: string]: any }) {
  return request<Response<ChatRoomItem[]>>('/api/recover/contact/list', {
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

export async function exportRecoverContact(options?: { [key: string]: any }) {
  return request<Response<string>>('/api/recover/contact/export', {
    method: 'GET',
    ...(options || {}),
  });
}
