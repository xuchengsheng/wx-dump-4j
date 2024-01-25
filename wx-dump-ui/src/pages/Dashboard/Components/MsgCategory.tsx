import { msgTypeDistribution } from '@/services/Wechat/DashBoard';
import { Pie } from '@ant-design/plots';
import React, { useEffect, useState } from 'react';

const MsgCategory: React.FC = () => {
  const [data, setData] = useState<MsgTypeDistributionItem[]>([]);

  const getSession = async () => {
    try {
      const response = await msgTypeDistribution();
      setData(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const config = {
    data,
    title: '消息类别',
    angleField: 'value',
    colorField: 'type',
    radius: 0.9,
    tooltip: {
      title: 'value',
    },
    legend: {
      color: {
        title: false,
        position: 'bottom',
        rowPadding: 5,
      },
    },
  };

  useEffect(() => {
    getSession();
  }, []);

  return <Pie {...config} />;
};

export default MsgCategory;
