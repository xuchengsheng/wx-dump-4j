// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

export async function decrypt(params: DecryptParams,options?: { [key: string]: any }) {
  return request<Response<Boolean>>('/api/database/decrypt', {
    method: 'GET',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}

export async function queryWeChat(options?: { [key: string]: any }) {
  return request<Response<WeChat>>('/api/database/queryWeChat', {
    method: 'GET',
    ...(options || {}),
  });
}
