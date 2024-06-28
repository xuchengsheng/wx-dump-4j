import {exportContact, queryContact, queryContactLabel} from '@/services/Contact';
import {DownloadOutlined} from '@ant-design/icons';
import type {ProColumns, RequestOptionsType} from '@ant-design/pro-components';
import {ProTable} from '@ant-design/pro-components';
import {PageContainer} from '@ant-design/pro-layout';
import {Avatar, Button, Divider, Flex, Modal, Space, Tag} from 'antd';
import React, {useState} from 'react';
import Chat from './Chat';
import {exportMsg} from "@/services/Msg";

const Contact: React.FC = () => {
  const [isContactDetailOpen, setIsContactDetailOpen] = useState(false);
  const [isExportContactOpen, setIsExportContactOpen] = useState(false);
  const [isExporting, setIsExporting] = useState(false);
  const [userName, setUserName] = useState<string>();
  const [nickName, setNickName] = useState<string>();
  const [isExportChatOpen, setIsExportChatOpen] = useState(false);

  const handleExportContact = async () => {
    setIsExporting(true);
    try {
      const response = await exportContact();
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
    setIsExportContactOpen(false);
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

  const handleExportChatOpen = async (record: ContactItem) =>{
    setIsExportChatOpen(true);
    setUserName(record.userName);
  }

  const handelContactDetail = (record: ContactItem) => {
    setUserName(record.userName);
    setNickName(record.remark ? record.remark : record.nickName);
    setIsContactDetailOpen(true);
  };

  const columns: ProColumns<ContactItem>[] = [
    {
      title: '联系人头像',
      dataIndex: 'headImgUrl',
      align: 'center',
      width: '120px',
      search: false,
      render: (_, record) => <Avatar src={record.headImgUrl} shape="circle" size="large"/>,
    },
    {
      dataIndex: 'userName',
      title: '用户名',
      search: false,
      align: 'center',
    },
    {
      dataIndex: 'alias',
      title: '微信号',
      search: false,
      align: 'center',
    },
    {
      dataIndex: 'nickName',
      title: '昵称',
      align: 'center',
    },
    {
      dataIndex: 'remark',
      title: '备注',
      ellipsis: true,
      align: 'center',
    },
    {
      dataIndex: 'describe',
      title: '描述',
      ellipsis: true,
      align: 'center',
    },
    {
      dataIndex: 'labels',
      title: '标签',
      request: async (): Promise<RequestOptionsType[]> => {
        try {
          const response = await queryContactLabel();
          return response.data
            ? response.data.map((item) => ({
              label: item.labelName,
              value: item.labelId,
            }))
            : [];
        } catch (error) {
          console.error(error);
          return [];
        }
      },
      align: 'center',
      render: (_, record) => (
        <>
          {record.labels.map((label) => (
            <Tag style={{marginBottom: '5px'}} color="#108ee9" key={label}>
              {label}
            </Tag>
          ))}
        </>
      ),
    },
    {
      title: '操作',
      align: 'center',
      search: false,
      render: (_, record) =>
        <Flex justify="center">
          <a onClick={() => handleExportChatOpen(record)}>导出记录</a>
          <Divider type="vertical"/>
          <a onClick={() => handelContactDetail(record)}>聊天记录</a>
        </Flex>
    },
  ];

  return (
    <PageContainer>
      <ProTable<ContactItem>
        columns={columns}
        cardBordered={{
          search: true,
          table: true,
        }}
        request={async (params) => {
          try {
            return queryContact(params);
          } catch (error) {
            console.error(error);
            return [];
          }
        }}
        revalidateOnFocus={false}
        rowKey="usrName"
        search={{
          labelWidth: 'auto',
        }}
        options={false}
        pagination={{
          pageSize: 10,
          showSizeChanger: false
        }}
        headerTitle="会话列表"
        toolBarRender={() => [
          <Button
            onClick={() => setIsExportContactOpen(true)}
            key="button"
            icon={<DownloadOutlined/>}
            type="primary"
          >
            导出
          </Button>,
        ]}
      />
      <Modal
        width={800}
        title={nickName}
        footer={null}
        open={isContactDetailOpen}
        onCancel={() => setIsContactDetailOpen(false)}
      >
        <Chat userName={userName}/>
      </Modal>
      <Modal
        title="导出联系人"
        open={isExportContactOpen}
        footer={null}
        onCancel={() => setIsExportContactOpen(false)}
      >
        <p style={{padding: '15px'}}>
          即将导出的微信联系人列表数据，请导出后妥善保管，以防信息泄露或丢失！
        </p>
        <Flex justify="flex-end">
          <Space>
            <Button disabled={isExporting} onClick={() => setIsExportContactOpen(false)}>
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

export default Contact;
