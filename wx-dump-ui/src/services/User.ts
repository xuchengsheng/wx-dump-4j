// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

export async function readWeChatConfig(options?: { [key: string]: any }) {
  return request<Response<WeChatConfig[]>>('/api/user/readWeChatConfig', {
    method: 'GET',
    ...(options || {}),
  });
}

export async function getUserInfo(options?: { [key: string]: any }) {
  return request<Response<UserInfo>>('/api/user/userInfo', {
    method: 'GET',
    ...(options || {}),
  });
}

export async function getAvatar(options?: { [key: string]: any }) {
  return request<Response<string>>('/api/user/avatar', {
    method: 'GET',
    ...(options || {}),
  });
}

export async function getNickname(options?: { [key: string]: any }) {
  return request<Response<string>>('/api/user/nickname', {
    method: 'GET',
    ...(options || {}),
  });
}

export async function getUsers(options?: { [key: string]: any }) {
  return request<Response<UserItem[]>>('/api/user/users', {
    method: 'GET',
    ...(options || {}),
  });
}

export async function switchUser(params: SwitchUserParams, options?: { [key: string]: any }) {
  return request<Response<string>>('/api/user/switchUser', {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    params: {
      ...params,
    },
    ...(options || {}),
  });
}