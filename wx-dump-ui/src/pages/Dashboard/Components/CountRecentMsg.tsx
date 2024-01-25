import { countRecentMsgs } from '@/services/Wechat/DashBoard';
import { Line } from '@ant-design/plots';
import React, { useEffect, useState } from 'react';

const CountRecentMsg: React.FC = () => {
  const [data, setData] = useState<CountRecentMsgItem[]>([]);

  const getDailyMsgCount = async () => {
    try {
      const response = await countRecentMsgs();
      setData(response.data);
    } catch (error) {
      console.error(error);
    }
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

  return <Line {...config} />;
};

export default CountRecentMsg;
