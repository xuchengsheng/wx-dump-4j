import { request } from 'umi';

export async function queryContact(params: ContactParams, options?: { [key: string]: any }) {
  return request<Response<ContactItem[]>>('/api/contact/list', {
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

export async function queryAllContact(options?: { [key: string]: any }) {
  return request<Response<AllContactItem[]>>('/api/contact/all', {
    method: 'GET',
    ...(options || {}),
  });
}

export async function queryContactLabel(options?: { [key: string]: any }) {
  return request<Response<ContactLabelItem[]>>('/api/contact/label', {
    method: 'GET',
    ...(options || {}),
  });
}

export async function exportContact(options?: { [key: string]: any }) {
  return request<Response<string>>('/api/contact/export', {
    method: 'GET',
    ...(options || {}),
  });
}
