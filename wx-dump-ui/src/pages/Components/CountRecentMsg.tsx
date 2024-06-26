import { countRecentMsgs } from '@/services/DashBoard';
import { Line } from '@ant-design/plots';
import React, { useEffect, useState } from 'react';

const CountRecentMsg: React.FC = () => {
  const [data, setData] = useState<CountRecentMsgItem[]>([]);
  const [isLoading, setIsLoading] = useState(false);

  const getDailyMsgCount = async () => {
    setIsLoading(true);
    try {
      const response = await countRecentMsgs();
      setData(response.data);
    } catch (error) {
      console.error(error);
    }
    setIsLoading(false);
  };

  const config = {
    data,
    xField: 'type',
    yField: 'value',
    style: {
      lineWidth: 2,
    },
    colorField: 'category',
  };

  useEffect(() => {
    getDailyMsgCount();
  }, []);

  return <Line loading={isLoading} {...config} />;
};

export default CountRecentMsg;
