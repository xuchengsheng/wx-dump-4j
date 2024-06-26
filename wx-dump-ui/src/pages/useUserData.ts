import { useState, useEffect } from 'react';
import { getAvatar, getNickname } from '@/services/User';

const useUserData = () => {
  const [avatarUrl, setAvatarUrl] = useState<string>();
  const [nickname, setNickname] = useState<string>();

  const handleAvatar = async () => {
    try {
      const response = await getAvatar();
      if (response.success) {
        setAvatarUrl(response.data);
      }
    } catch (error) {
      console.error(error);
    }
  };

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
    handleAvatar();
    handleNickname();
  }, []);

  return { avatarUrl, nickname };
};

export default useUserData;
