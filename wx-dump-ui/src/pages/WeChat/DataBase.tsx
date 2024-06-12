import {decrypt, queryWeChat} from '@/services/Wechat/DataBase';
import {SyncOutlined} from '@ant-design/icons';
import {Button, Descriptions, Flex, Modal, notification, Space, Spin} from 'antd';
import React, {useState} from 'react';

const DataBase: React.FC = () => {
  const [isDecryptOpen, setIsDecryptOpen] = useState(false);
  const [isQueryWeChat, setIsQueryWeChat] = useState(false);
  const [isDecrypt, setIsDecrypt] = useState(false);
  const [wechat, setWechat] = useState<WeChat | null>(null);

  const [api, contextHolder] = notification.useNotification();

  const decryptSuccess = () => {
    api['success']({
      message: '数据同步成功',
      duration: 0,
      description: '数据同步已经完成。为确保最新信息显示，请重新加载页面。',
    });
  };

  const decryptError = () => {
    api['error']({
      message: '数据同步失败',
      duration: 0,
      description:
        '数据同步失败。如遇问题，请在我们的GitHub页面提交Issue，我会及时跟进处理。感谢您的反馈。',
    });
  };

  const hanldelWeChat = async () => {
    setIsDecryptOpen(true);
    setIsQueryWeChat(true);
    setWechat(null);
    try {
      const response = await queryWeChat();
      if (response.success) {
        setWechat(response.data);
      }
    } catch (error) {
      console.error(error);
    }
    setIsQueryWeChat(false);
  };

  const handleCancel = async () => {
    setTimeout(() => {
      setIsDecryptOpen(false);
    }, 0);
  };

  const handelDataBaseDecrypt = async () => {
    try {
      setIsDecrypt(true);
      const response = await decrypt({"key": wechat?.key, "basePath": wechat?.basePath, "wxId": wechat?.wxId});
      if (response.success) {
        decryptSuccess();
      } else {
        decryptError();
      }
    } catch (error) {
      console.error(error);
    }
    setIsDecrypt(false);
    setIsDecryptOpen(false);
  };

  return (
    <>
      {contextHolder}
      <Flex onClick={() => hanldelWeChat()}>
        <SyncOutlined spin/>
      </Flex>
      <Modal
        width={850}
        title="微信数据同步"
        open={isDecryptOpen}
        footer={null}
        onOk={handelDataBaseDecrypt}
        onCancel={handleCancel}
      >
        <Spin tip="数据加载中..." spinning={isQueryWeChat}>
          <Descriptions layout="vertical" column={4} style={{marginTop: 20}}>
            <Descriptions.Item label="进程Id">{wechat?.pid}</Descriptions.Item>
            <Descriptions.Item label="基址">{wechat?.baseAddress}</Descriptions.Item>
            <Descriptions.Item label="版本号">{wechat?.version}</Descriptions.Item>
            <Descriptions.Item label="昵称">{wechat?.nickname}</Descriptions.Item>
            <Descriptions.Item label="账号">{wechat?.account}</Descriptions.Item>
            <Descriptions.Item label="手机号">{wechat?.mobile}</Descriptions.Item>
            <Descriptions.Item label="微信Id">{wechat?.wxId}</Descriptions.Item>
            <Descriptions.Item label="文件目录">{wechat?.basePath}</Descriptions.Item>
          </Descriptions>
          <Descriptions column={1} layout="vertical">
            <Descriptions.Item label="秘钥">{wechat?.key}</Descriptions.Item>
          </Descriptions>
          <Flex justify="flex-end">
            <Space>
              <Button disabled={isDecrypt} onClick={handleCancel}>
                取消同步
              </Button>
              <Button type="primary" loading={isDecrypt} onClick={handelDataBaseDecrypt}>
                开始同步
              </Button>
            </Space>
          </Flex>
        </Spin>
      </Modal>
    </>
  );
};

export default DataBase;
