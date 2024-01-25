// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

export async function decrypt(options?: { [key: string]: any }) {
  return request<Response<Boolean>>('/api/database/decrypt', {
    method: 'GET',
    ...(options || {}),
  });
}

export async function queryWeChat(options?: { [key: string]: any }) {
  return request<Response<WeChat>>('/api/database/queryWeChat', {
    method: 'GET',
    ...(options || {}),
  });
}
