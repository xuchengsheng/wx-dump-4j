import {querySession} from '@/services/Session';
import {ProCard} from '@ant-design/pro-components';
import {Avatar, List, Typography} from 'antd';
import {useEffect, useState} from 'react';
import Chat from './Chat';
import './Style/Session.less';

const {Text} = Typography;

export default () => {
  const [isSessionLoading, setIsSessionLoading] = useState(false);
  const [sessionList, setSessionList] = useState<SessionItem[]>([]);
  const [userName, setUserName] = useState<string>();
  const [nickName, setNickName] = useState<string>();

  const getSession = async () => {
    try {
      setIsSessionLoading(true);
      const response = await querySession();
      setSessionList(response.data);
    } catch (error) {
      console.error(error);
    }
    setIsSessionLoading(false);
  };

  const handleMsg = (item: SessionItem) => {
    setUserName(item.userName);
    setNickName(item.nickName);
  };

  useEffect(() => {
    getSession();
  }, []);

  return (
    <ProCard split="vertical">
      <ProCard bordered title="聊天列表" colSpan="28%" bodyStyle={{paddingInline: '0px'}}>
        <List
          dataSource={sessionList}
          className="session-scrollbar"
          loading={isSessionLoading}
          renderItem={(item) => (
            <List.Item
              onClick={() => handleMsg(item)}
              className={`sessionItem ${item.userName === userName ? 'highlighted' : ''}`}
            >
              <List.Item.Meta
                avatar={<Avatar src={item.headImgUrl}/>}
                title={<Text ellipsis>{item.nickName}</Text>}
                description={<Text ellipsis>{item.content}</Text>}
              />
              <Text className="timeText">{item.shortTime}</Text>
            </List.Item>
          )}
        />
      </ProCard>
      <ProCard
        bordered
        title={nickName ? nickName : '~'}
        headerBordered
        bodyStyle={{paddingInline: '0px'}}
      >
        <Chat userName={userName}/>
      </ProCard>
    </ProCard>
  );
};
