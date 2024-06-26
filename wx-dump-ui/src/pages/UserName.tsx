import { Typography } from 'antd';
import React from 'react';
import useUserData from './useUserData';

const { Text } = Typography;

const UserName: React.FC = () => {
  const { nickname } = useUserData();

  return <Text>{nickname}</Text>;
};

export default UserName;
