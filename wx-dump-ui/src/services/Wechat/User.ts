// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

export async function getAvatar(options?: { [key: string]: any }) {
  return request<Response<string>>('/api/user/avatar', {
    method: 'GET',
    ...(options || {}),
  });
}
