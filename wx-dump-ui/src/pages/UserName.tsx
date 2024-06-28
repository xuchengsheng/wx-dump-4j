import { Typography } from 'antd';
import React from 'react';
import { getNickname } from '@/services/User';
import { useState, useEffect } from 'react';

const { Text } = Typography;

const UserName: React.FC = () => {
  const [nickname, setNickname] = useState<string>();

  const handleNickname = async () => {
    try {
      const response = await getNickname();
      if (response.success) {
        setNickname(response.data);
      }
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    handleNickname();
  }, []);

  return <Text>{nickname}</Text>;
};

export default UserName;
