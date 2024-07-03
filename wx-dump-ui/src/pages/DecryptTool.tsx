import { readWeChatConfig } from '@/services/User';
import { getDatabase } from '@/services/DataBase';

import type { ProColumns,ActionType } from '@ant-design/pro-components';
import { ProTable } from '@ant-design/pro-components';
import { PageContainer } from '@ant-design/pro-layout';
import { Button, Flex, Modal, Progress, Result, message, Divider } from 'antd';
import React, { useState,useRef } from 'react';

const DecryptTool: React.FC = () => {
  const [decryptProgress, setDecryptProgress] = useState<{ [key: number]: number }>({});
  const [isDecryptModalOpen, setIsDecryptModalOpen] = useState(false);
  const [decryptingIds, setDecryptingIds] = useState<{ [key: number]: boolean }>({});
  const [isDetailModalOpen, setIsDetailModalOpen] = useState(false);
  const [wxId, setWxId] = useState<string>();
  const ref = useRef<ActionType>();

  const handleDetail = (record: WeChatConfig) => {
    setIsDetailModalOpen(true);
    setWxId(record.wxId);
    ref.current?.reload();
  }

  const handleDetailOk = () => {
    setIsDetailModalOpen(false);
  };

  const handleDetailCancel = () => {
    setIsDetailModalOpen(false);
  };

  const handleDecryptOk = () => {
    setIsDecryptModalOpen(false);
  };

  const handleDecryptCancel = () => {
    setIsDecryptModalOpen(false);
  };

  const handleDecrypt = (record: WeChatConfig) => {
    setDecryptingIds((prev) => ({ ...prev, [record.pid]: true }));

    const params = new URLSearchParams({
      pid: record.pid.toString(),
      basePath: record.basePath,
      wxId: record.wxId,
      nickname: record.nickname,
      version: record.version,
      account: record.account,
      mobile: record.mobile,
    }).toString();

    const eventSource = new EventSource(`/api/database/decrypt?${params}`);

    eventSource.onmessage = function (event) {
      const data = JSON.parse(event.data);
      if (data.success) {
        setDecryptProgress((prev) => ({ ...prev, [record.pid]: data.data.currentProgress }));
        if (data.data.currentProgress === 100) {
          setIsDecryptModalOpen(true);
          setDecryptingIds((prev) => ({ ...prev, [record.pid]: false }));
        }
      } else {
        message.error(data.errorMessage);
        setDecryptingIds((prev) => ({ ...prev, [record.pid]: false }));
      }
    };

    eventSource.onerror = function () {
      eventSource.close();
      setDecryptingIds((prev) => ({ ...prev, [record.pid]: false }));
    };
  };

  const columnsDetail: ProColumns<DatabaseItem>[] = [
    {
      title: '文件地址',
      dataIndex: 'filePath',
      align: 'start',
      search: false,
    },
    {
      dataIndex: 'fileSize',
      title: '文件大小',
      search: false,
      align: 'start',
    },
  ];

  const columns: ProColumns<WeChatConfig>[] = [
    {
      title: '进程ID',
      dataIndex: 'pid',
      align: 'center',
      search: false,
    },
    {
      dataIndex: 'wxId',
      title: '微信ID',
      search: false,
      align: 'center',
    },
    {
      dataIndex: 'baseAddress',
      title: '基址',
      search: false,
      align: 'center',
    },
    {
      dataIndex: 'version',
      title: '版本号',
      search: false,
      align: 'center',
    },
    {
      dataIndex: 'basePath',
      title: '文件目录',
      search: false,
      ellipsis: true,
      align: 'center',
    },
    {
      dataIndex: 'nickname',
      title: '昵称',
      search: false,
      align: 'center',
    },
    {
      dataIndex: 'account',
      title: '账号',
      search: false,
      align: 'center',
    },
    {
      dataIndex: 'mobile',
      title: '手机号',
      search: false,
      align: 'center',
    },
    {
      dataIndex: 'basePath1',
      title: '解密进度',
      search: false,
      align: 'center',
      render: (_, record) => (
        <Progress
          type="circle"
          strokeColor={{
            '0%': '#108ee9',
            '100%': '#87d068',
          }}
          trailColor="#D3D3D3"
          percent={decryptProgress[record.pid] || 0}
          size={40}
        />
      ),
    },
    {
      title: '操作',
      align: 'center',
      search: false,
      render: (_, record) => (
        <Flex justify="center">
          <Button
            type="link"
            size="small"
            onClick={() => handleDecrypt(record)}
            disabled={decryptingIds[record.pid]}
          >
            {decryptingIds[record.pid] ? '解密中' : '解密'}
          </Button>
          <Divider type="vertical" />
          <Button size="small" type="link" onClick={() => handleDetail(record)}>
            详情
          </Button>
        </Flex>
      ),
    },
  ];

  return (
    <PageContainer>
      <ProTable<WeChatConfig>
        columns={columns}
        search={false}
        cardBordered={{
          search: true,
          table: true,
        }}
        request={async () => {
          try {
            return readWeChatConfig();
          } catch (error) {
            console.error(error);
            return [];
          }
        }}
        revalidateOnFocus={false}
        rowKey="pid"
        options={false}
        pagination={false}
        headerTitle="微信列表"
      />
      <Modal open={isDecryptModalOpen} onOk={handleDecryptOk} onCancel={handleDecryptCancel} footer={null}>
        <Result
          status="success"
          title="恭喜你，解密微信数据库成功!"
          subTitle="数据同步已经完成。为确保最新信息显示，请重新加载页面。"
          extra={[
            <Button type="primary" key="refresh" onClick={() => window.location.reload()}>
              刷新
            </Button>,
            <Button key="close" onClick={handleDecryptOk}>
              关闭
            </Button>,
          ]}
        />
      </Modal>

      <Modal open={isDetailModalOpen} onOk={handleDetailOk} onCancel={handleDetailCancel} width={1000} footer={null}>
        <ProTable<DatabaseItem>
          columns={columnsDetail}
          search={false}
          actionRef={ref}
          cardBordered={{
            search: true,
            table: true,
          }}
          request={async () => {
            try {
              return getDatabase({wxId:wxId});
            } catch (error) {
              console.error(error);
              return [];
            }
          }}
          revalidateOnFocus={false}
          rowKey="filePath"
          options={false}
          pagination={false}
          headerTitle="数据库列表"
        />
      </Modal>
    </PageContainer>
  );
};

export default DecryptTool;
