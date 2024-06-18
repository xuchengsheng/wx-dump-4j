import {Avatar} from 'antd';
import React, { useState, useEffect } from 'react';
import {getAvatar} from "@/services/Wechat/User";
import { UserOutlined } from '@ant-design/icons';

const UserAvatar: React.FC = () => {
  const [avatarUrl, setAvatarUrl] = useState<string>();

  const handleWeChat = async () => {
    try {
      const response = await getAvatar();
      if (response.success) {
        setAvatarUrl(response.data);
      }
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    handleWeChat();
  }, []);

  return (
    <>
      {avatarUrl ? (
        <Avatar src={avatarUrl}/>
      ) : (
        <Avatar style={{ color: 'white', backgroundColor: '#00a2ae' }}>U</Avatar>
      )}
    </>
  );
};

export default UserAvatar;
