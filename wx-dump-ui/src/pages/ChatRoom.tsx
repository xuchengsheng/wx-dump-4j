import {
  exportChatRoomDetail,
  queryChatRoom,
  queryChatRoomDetail,
} from '@/services/ChatRoom';
import { DownloadOutlined } from '@ant-design/icons';
import type { ProColumns } from '@ant-design/pro-components';
import { ProDescriptions, ProTable } from '@ant-design/pro-components';
import { PageContainer } from '@ant-design/pro-layout';
import { Avatar, Button, Card, Divider, Flex, List, Modal, Space, Tag, Typography } from 'antd';
import React, { useState } from 'react';
import Chat from './Chat';
import './Style/ChatRoom.less';
import {exportMsg} from "@/services/Msg";

const ChatRoom: React.FC = () => {
  const [isChatRoomDetailOpen, setIsChatRoomDetailOpen] = useState(false);
  const [isChatDetailOpen, setIsChatDetailOpen] = useState(false);
  const [isChatRoomExportOpen, setIsChatRoomExportOpen] = useState(false);
  const [isExporting, setIsExporting] = useState(false);
  const [isLoadingChatRoomDetail, setIsLoadingChatRoomDetail] = useState(false);
  const [chatRoomDetail, setChatRoomDetail] = useState<ChatRoomDetail>();
  const [userName, setUserName] = useState<string>();
  const [nickName, setNickName] = useState<string>();
  const [isExportChatOpen, setIsExportChatOpen] = useState(false);

  const { Text } = Typography;

  const handleChatDetail = (record: ChatRoomItem) => {
    setUserName(record.chatRoomName);
    setNickName(record.chatRoomTitle);
    setIsChatDetailOpen(true);
  };

  const handleDetail = async (record: ChatRoomItem) => {
    try {
      setIsLoadingChatRoomDetail(true);
      setIsChatRoomDetailOpen(true);
      const response = await queryChatRoomDetail({ chatRoomName: record.chatRoomName });
      setChatRoomDetail(response.data);
      setIsLoadingChatRoomDetail(false);
    } catch (error) {
      console.error(error);
    }
  };

  const handleExportChatRoom = async () => {
    setIsExporting(true);
    try {
      const response = await exportChatRoomDetail();
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
    setIsChatRoomExportOpen(false);
  };

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

  const handleExportChatOpen = async (record: ChatRoomItem) =>{
    setIsExportChatOpen(true);
    setUserName(record.chatRoomName);
  }

  const columns: ProColumns<ChatRoomItem>[] = [
    {
      title: '群头像',
      dataIndex: 'headImgUrl',
      align: 'center',
      search: false,
      render: (_, record) => <Avatar src={record.headImgUrl} shape="circle" size="large" />,
    },
    {
      dataIndex: 'chatRoomName',
      title: '群号',
      search: false,
      align: 'center',
    },
    {
      dataIndex: 'chatRoomTitle',
      title: '群聊名称',
      align: 'center',
    },
    {
      dataIndex: 'createBy',
      title: '创建人',
      align: 'center',
    },
    {
      dataIndex: 'memberCount',
      title: '群聊人数',
      align: 'center',
    },
    {
      dataIndex: 'selfDisplayName',
      title: '备注',
      align: 'center',
    },
    {
      dataIndex: 'enterprise',
      title: '群聊类型',
      search: false,
      align: 'center',
      render: (enterprise) => (
        <Tag color={enterprise ? 'orange' : 'green'}>
          {enterprise ? '企业微信群聊' : '普通群聊'}
        </Tag>
      ),
    },
    {
      dataIndex: 'dissolution',
      title: '是否解散',
      align: 'center',
      search: false,
      render: (dissolution) => (
        <Tag color={dissolution ? 'red' : 'blue'}>{dissolution ? '已解散' : '未解散'}</Tag>
      ),
    },
    {
      title: '操作',
      valueType: 'option',
      align: 'center',
      key: 'option',
      render: (text, record) => (
        <Flex justify="center">
          <a onClick={() => handleExportChatOpen(record)}>导出记录</a>
          <Divider type="vertical"/>
          <a key="detail" onClick={() => handleDetail(record)}>群聊详情</a>
          <Divider type="vertical"/>
          <a key="chat" onClick={() => handleChatDetail(record)}>聊天记录</a>
        </Flex>
      ),
    },
  ];

  return (
    <PageContainer>
    <ProTable<ChatRoomItem>
        columns={columns}
        cardBordered={{
          search: true,
          table: true,
        }}
        request={async (params) => {
          try {
            return queryChatRoom(params);
          } catch (error) {
            console.error(error);
            return [];
          }
        }}
        revalidateOnFocus={false}
        rowKey="chatRoomName"
        search={{
          labelWidth: 'auto',
        }}
        options={false}
        pagination={{
          pageSize: 10,
          showSizeChanger: false
        }}
        headerTitle="群聊列表"
        toolBarRender={() => [
          <Button
            key="button"
            icon={<DownloadOutlined />}
            type="primary"
            onClick={() => setIsChatRoomExportOpen(true)}
          >
            导出
          </Button>,
        ]}
      />
      <Modal
        width={850}
        open={isChatRoomDetailOpen}
        footer={null}
        onCancel={() => setIsChatRoomDetailOpen(false)}
      >
        <ProDescriptions
          title="群聊详细信息"
          loading={isLoadingChatRoomDetail}
          dataSource={chatRoomDetail}
        >
          <ProDescriptions.Item dataIndex="chatRoomName" label="群号" />
          <ProDescriptions.Item dataIndex="chatRoomTitle" label="群名称" />
          <ProDescriptions.Item dataIndex="selfDisplayName" label="群备注" />
          <ProDescriptions.Item dataIndex="createBy" label="创建人" />
          <ProDescriptions.Item
            dataIndex={['chatRoomInfo', 'announcementPublisher']}
            label="公告发布人"
          />
          <ProDescriptions.Item
            dataIndex={['chatRoomInfo', 'strAnnouncementPublishTime']}
            label="公告发布时间"
          />
          <ProDescriptions.Item dataIndex={['chatRoomInfo', 'announcement']} label="群公告内容" />
        </ProDescriptions>

        <Card title="群成员列表">
          <List
            grid={{ gutter: 16, column: 10 }}
            dataSource={chatRoomDetail?.members}
            renderItem={(item) => (
              <List.Item key={item.wxId}>
                <Flex vertical align="center" justify="center">
                  <Flex>
                    <Avatar src={item.headImgUrl} />
                  </Flex>
                  <Flex className="remark-top-margin" justify="center">
                    <Text ellipsis={{ tooltip: item.remark }}>{item.remark}</Text>
                  </Flex>
                </Flex>
              </List.Item>
            )}
          />
        </Card>
      </Modal>
      <Modal
        width={800}
        title={nickName}
        footer={null}
        open={isChatDetailOpen}
        onCancel={() => setIsChatDetailOpen(false)}
      >
        <Chat userName={userName} />
      </Modal>
      <Modal
        title="导出群聊"
        open={isChatRoomExportOpen}
        footer={null}
        onCancel={() => setIsChatRoomExportOpen(false)}
      >
        <p style={{ padding: '15px' }}>
          即将导出的微信群聊列表数据，请导出后妥善保管，以防信息泄露或丢失！
        </p>
        <Flex justify="flex-end">
          <Space>
            <Button disabled={isExporting} onClick={() => setIsChatRoomExportOpen(false)}>
              取消导出
            </Button>
            <Button
              type="primary"
              loading={isExporting}
              disabled={isExporting}
              onClick={() => handleExportChatRoom()}
            >
              开始导出
            </Button>
          </Space>
        </Flex>
      </Modal>
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
    </PageContainer>
  );
};

export default ChatRoom;
