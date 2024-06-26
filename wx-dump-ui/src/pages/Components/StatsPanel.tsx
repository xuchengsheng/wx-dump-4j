import { statsPanel } from '@/services/DashBoard';
import RcResizeObserver from 'rc-resize-observer';
import React, { useEffect, useState } from 'react';
import { StatisticCard } from '@ant-design/pro-components';

const Panel: React.FC = () => {
  const [responsive, setResponsive] = useState(false);
  const [data, setData] = useState<StatsPanel>();

  const imgStyle = {
    display: 'block',
    width: 42,
    height: 42,
  };

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
      <StatisticCard.Group direction={responsive ? 'column' : 'row'}>
        <StatisticCard
          statistic={{
            title: '好友数量',
            value: data?.contact,
            icon: (
              <img
                style={imgStyle}
                src="/img/icon-friend-number.png"
                alt="icon"
              />
            ),
          }}
        />
        <StatisticCard
          statistic={{
            title: '群聊数量',
            value: data?.chatRoom,
            icon: (
              <img
                style={imgStyle}
                src="/img/icon-group-chat-number.png"
                alt="icon"
              />
            ),
          }}
        />
        <StatisticCard
          statistic={{
            title: '今日发送消息数量',
            value: data?.sent,
            icon: (
              <img
                style={imgStyle}
                src="/img/icon-send-message-number.png"
                alt="icon"
              />
            ),
          }}
        />
        <StatisticCard
          statistic={{
            title: '今日接受消息数量',
            value: data?.received,
            icon: (
              <img
                style={imgStyle}
                src="/img/icon-receiver-message-number.png"
                alt="icon"
              />
            ),
          }}
        />
      </StatisticCard.Group>
    </RcResizeObserver>
  );
};

export default Panel;
