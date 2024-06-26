import { msgTypeDistribution } from '@/services/DashBoard';
import { Pie } from '@ant-design/plots';
import React, { useEffect, useState } from 'react';

const MsgCategory: React.FC = () => {
  const [data, setData] = useState<MsgTypeDistributionItem[]>([]);
  const [isLoading, setIsLoading] = useState(false);

  const getMsgTypeDistribution = async () => {
    setIsLoading(true);
    try {
      const response = await msgTypeDistribution();
      setData(response.data);
    } catch (error) {
      console.error(error);
    }
    setIsLoading(false);
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
    getMsgTypeDistribution();
  }, []);

  return <Pie loading={isLoading} {...config} />;
};

export default MsgCategory;
