import { queryRecentUsedKeyWord } from '@/services/Wechat/DashBoard';
import { WordCloud } from '@ant-design/plots';
import React, { useEffect, useState } from 'react';

const RecentUsedKeyWord: React.FC = () => {
  const [data, setData] = useState<RecentUsedKeyWordItem[]>([]);

  const getRecentUsedKeyWord = async () => {
    try {
      const response = await queryRecentUsedKeyWord();
      setData(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    getRecentUsedKeyWord();
  }, []);

  const config = {
    paddingTop: 40,
    data,
    layout: { spiral: 'rectangular' },
    colorField: 'text',
  };

  return <WordCloud {...config} />;
};

export default RecentUsedKeyWord;
