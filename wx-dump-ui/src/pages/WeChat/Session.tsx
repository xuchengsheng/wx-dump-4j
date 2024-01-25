import { exportMsg } from '@/services/Wechat/Msg';
import { querySession } from '@/services/Wechat/Session';
import { ProCard } from '@ant-design/pro-components';
import { Avatar, Button, Flex, List, Modal, Space, Typography } from 'antd';
import { useEffect, useState } from 'react';
import Chat from './Chat';
import './Style/Session.less';

const { Text } = Typography;

export default () => {
  const [isSessionLoading, setIsSessionLoading] = useState(false);
  const [isExportChatOpen, setIsExportChatOpen] = useState(false);
  const [isExporting, setIsExporting] = useState(false);
  const [sessionList, setSessionList] = useState<SessionItem[]>([]);
  const [userName, setUserName] = useState<string>();
  const [nickName, setNickName] = useState<string>();

  const handleExportChat = async () => {
    setIsExporting(true);
    try {
      const response = await exportMsg({ talker: userName });
      if (response.success) {
        const link = document.createElement('a');
        link.href = '/api/export/download?path=' + encodeURIComponent(response.data);
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
      }
    } catch (error) {
      console.error(error);
    }
    setIsExporting(false);
    setIsExportChatOpen(false);
  };

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
      <ProCard bordered title="聊天列表" colSpan="28%" bodyStyle={{ paddingInline: '0px' }}>
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
                avatar={<Avatar src={item.headImgUrl} />}
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
        bodyStyle={{ paddingInline: '0px' }}
        extra={
          userName && (
            <Button type="link" onClick={() => setIsExportChatOpen(true)}>
              导出聊天记录
            </Button>
          )
        }
      >
        <Chat userName={userName} />
      </ProCard>
      <Modal
        title="导出聊天记录"
        open={isExportChatOpen}
        footer={null}
        onCancel={() => setIsExportChatOpen(false)}
      >
        <p style={{ padding: '15px' }}>
          即将导出的微信聊天记录数据，请导出后妥善保管，以防信息泄露或丢失！
        </p>
        <Flex justify="flex-end">
          <Space>
            <Button disabled={isExporting} onClick={() => setIsExportChatOpen(false)}>
              取消导出
            </Button>
            <Button
              type="primary"
              loading={isExporting}
              disabled={isExporting}
              onClick={() => handleExportChat()}
            >
              开始导出
            </Button>
          </Space>
        </Flex>
      </Modal>
    </ProCard>
  );
};
