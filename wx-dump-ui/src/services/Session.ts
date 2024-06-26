// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

export async function querySession(options?: { [key: string]: any }) {
  return request<Response<SessionItem[]>>('/api/session/list', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
    ...(options || {}),
  });
}
