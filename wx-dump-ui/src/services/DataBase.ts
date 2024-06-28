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

export async function getDatabase(params: DatabaseParams,options?: { [key: string]: any }) {
  return request<Response<DatabaseItem[]>>('/api/database/getDatabase', {
    method: 'GET',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}