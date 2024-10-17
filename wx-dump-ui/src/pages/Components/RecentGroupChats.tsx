// RecentGroupChats.tsx
import { Avatar, Card, List, Skeleton } from 'antd';
import React, { useEffect, useState } from 'react';
import { getRecentGroupChats } from '@/services/DashBoard'; // 假设你已经定义了这个API调用
import styles from '../Style/RecentGroupChats.less'; // 自定义样式文件

const RecentGroupChats: React.FC = () => {
  const [data, setData] = useState<TopGroupChatsItem[]>([]);
  const [isLoading, setIsLoading] = useState(false);

  const fetchRecentGroupChats = async () => {
    setIsLoading(true);
    try {
      const response = await getRecentGroupChats(); // 调用API
      setData(response.data);
    } catch (error) {
      console.error(error);
    }
    setIsLoading(false);
  };

  useEffect(() => {
    fetchRecentGroupChats();
  }, []);

  return (
    <Card title="最近使用的群聊" loading={isLoading}>
      <List
        itemLayout="horizontal"
        dataSource={data}
        renderItem={(item) => (
          <List.Item>
            <List.Item.Meta
              avatar={<Avatar>{item.name.charAt(0)}</Avatar>}
              title={<a href={`/group/${item.name}`}>{item.name}</a>}
              description={`消息数: ${item.messageCount}`}
            />
          </List.Item>
        )}
      />
    </Card>
  );
};

export default RecentGroupChats;
