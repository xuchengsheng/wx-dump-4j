import { request } from 'umi';

export async function queryFeeds(params: FeedsParams, options?: { [key: string]: any }) {
  return request<Response<FeedsItem[]>>('/api/feeds/list', {
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
