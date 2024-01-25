// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

export async function msgTypeDistribution(options?: { [key: string]: any }) {
  return request<Response<MsgTypeDistributionItem[]>>('/api/dashboard/msgTypeDistribution', {
    method: 'GET',
    ...(options || {}),
  });
}

export async function countRecentMsgs(options?: { [key: string]: any }) {
  return request<Response<CountRecentMsgItem[]>>('/api/dashboard/countRecentMsgs', {
    method: 'GET',
    ...(options || {}),
  });
}

export async function topContacts(options?: { [key: string]: any }) {
  return request<Response<TopContactsMonthlyItem[]>>('/api/dashboard/topContacts', {
    method: 'GET',
    ...(options || {}),
  });
}

export async function statsPanel(options?: { [key: string]: any }) {
  return request<Response<StatsPanel>>('/api/dashboard/statsPanel', {
    method: 'GET',
    ...(options || {}),
  });
}

export async function queryRecentUsedKeyWord(options?: { [key: string]: any }) {
  return request<Response<RecentUsedKeyWordItem[]>>('/api/dashboard/queryRecentUsedKeyWord', {
    method: 'GET',
    ...(options || {}),
  });
}
