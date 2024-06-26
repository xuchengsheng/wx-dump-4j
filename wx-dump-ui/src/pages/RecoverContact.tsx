import { DownloadOutlined } from '@ant-design/icons';
import type { ProColumns } from '@ant-design/pro-components';
import { ProDescriptions, ProTable } from '@ant-design/pro-components';
import { PageContainer } from '@ant-design/pro-layout';
import { Avatar, Button, Card, Divider, Flex, List, Modal, Space, Tag, Typography } from 'antd';
import React, { useState } from 'react';
import './Style/ChatRoom.less';
import {queryRecoverContact,exportRecoverContact} from "@/services/RecoverContact";

const ChatRoom: React.FC = () => {

  const [isExportRecoverContactOpen, setIsExportRecoverContactOpen] = useState(false);
  const [isExporting, setIsExporting] = useState(false);

  const handleExportContact = async () => {
    setIsExporting(true);
    try {
      const response = await exportRecoverContact();
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
    setIsExportRecoverContactOpen(false);
  };

  const columns: ProColumns<ChatRoomItem>[] = [
    {
      title: '昵称',
      dataIndex: 'nickname',
      align: 'center',
      width: '500px'
    },
    {
      dataIndex: 'remark',
      title: '备注',
      align: 'center',
      width: '500px'
    },
    {
      dataIndex: 'alias',
      title: '微信号',
      search: false,
      align: 'center',
    }
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
              return queryRecoverContact(params);
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
          headerTitle="已删除好友列表"
          toolBarRender={() => [
            <Button
              onClick={() => setIsExportRecoverContactOpen(true)}
              key="button"
              icon={<DownloadOutlined/>}
              type="primary"
            >
              导出
            </Button>,
          ]}
        />
      <Modal
        title="导出已删除好友"
        open={isExportRecoverContactOpen}
        footer={null}
        onCancel={() => setIsExportRecoverContactOpen(false)}
      >
        <p style={{padding: '15px'}}>
          即将导出已删除好友列表数据，请导出后妥善保管，以防信息泄露或丢失！
        </p>
        <Flex justify="flex-end">
          <Space>
            <Button disabled={isExporting} onClick={() => setIsExportRecoverContactOpen(false)}>
              取消导出
            </Button>
            <Button
              type="primary"
              loading={isExporting}
              disabled={isExporting}
              onClick={() => handleExportContact()}
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
