import { statsPanel } from '@/services/Wechat/DashBoard';
import { ProCard } from '@ant-design/pro-components';
import { Divider, Statistic } from 'antd';
import RcResizeObserver from 'rc-resize-observer';
import React, { useEffect, useState } from 'react';

const Panel: React.FC = () => {
  const [responsive, setResponsive] = useState(false);

  const [data, setData] = useState<StatsPanel>();

  const getStatsPanel = async () => {
    try {
      const response = await statsPanel();
      setData(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    getStatsPanel();
  }, []);

  return (
    <RcResizeObserver
      key="resize-observer"
      onResize={(offset) => {
        setResponsive(offset.width < 596);
      }}
    >
      <ProCard.Group title="微信指标" direction={responsive ? 'column' : 'row'}>
        <ProCard>
          <Statistic title="好友数量" value={data?.contact} />
        </ProCard>
        <Divider type={responsive ? 'horizontal' : 'vertical'} />
        <ProCard>
          <Statistic title="群聊数量" value={data?.chatRoom} />
        </ProCard>
        <Divider type={responsive ? 'horizontal' : 'vertical'} />
        <ProCard>
          <Statistic title="今日发送消息数量" value={data?.sent} />
        </ProCard>
        <Divider type={responsive ? 'horizontal' : 'vertical'} />
        <ProCard>
          <Statistic title="今日接受消息数量" value={data?.received} />
        </ProCard>
      </ProCard.Group>
    </RcResizeObserver>
  );
};

export default Panel;
