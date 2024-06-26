import { queryRecentUsedKeyWord } from '@/services/DashBoard';
import { WordCloud } from '@ant-design/plots';
import React, { useEffect, useState } from 'react';

const RecentUsedKeyWord: React.FC = () => {
  const [data, setData] = useState<RecentUsedKeyWordItem[]>([]);
  const [isLoading, setIsLoading] = useState(false);

  const getRecentUsedKeyWord = async () => {
    setIsLoading(true);
    try {
      const response = await queryRecentUsedKeyWord();
      setData(response.data);
    } catch (error) {
      console.error(error);
    }
    setIsLoading(false);
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

  return <WordCloud loading={isLoading} {...config} />;
};

export default RecentUsedKeyWord;
