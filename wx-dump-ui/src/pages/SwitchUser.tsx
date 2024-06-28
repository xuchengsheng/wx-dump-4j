import { InfoCircleOutlined, UserSwitchOutlined } from '@ant-design/icons';
import { Dropdown, Avatar, message, Modal, Descriptions,Typography } from 'antd';
import type { MenuProps } from 'antd';
import React, { useState, useEffect } from 'react';
import { getUsers, switchUser,getUserInfo } from "@/services/User";

export type SwitchUserProps = {
  children?: React.ReactNode;
};

const SwitchUser: React.FC<SwitchUserProps> = ({ children }) => {
  const [users, setUsers] = useState<UserItem[]>([]);
  const [userInfo, setUserInfo] = useState<UserInfo>();
  const [selectedKeys, setSelectedKeys] = useState<string[]>([]);
  const [isModalOpen, setIsModalOpen] = useState(false);

  const { Text } = Typography;

  const handleUserInfoOk = () => {
    setIsModalOpen(false);
  };

  const handleUserInfoCancel = () => {
    setIsModalOpen(false);
  };

  const handleUsers = async () => {
    try {
      const response = await getUsers();
      if (response.success) {
        setUsers(response.data);
        const currentUser = response.data.find((user: UserItem) => user.current);
        if (currentUser) {
          setSelectedKeys([currentUser.wxId]);
        }
      }
    } catch (error) {
      console.error(error);
    }
  };

  const handleUserInfo = async () => {
    try {
      const response = await getUserInfo();
      if (response.success) {
        setUserInfo(response.data);
      }
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    handleUsers();
  }, []);

  const onClick: MenuProps['onClick'] = async ({ key }) => {
    const selectKey = `${key}`;

    if (selectKey == 'switch') {
      return;
    }

    if (selectKey == 'userInfo') {
      setIsModalOpen(true);
      handleUserInfo();
      return;
    }

    try {
      const response = await switchUser({ wxId: selectKey });
      if (response.success) {
        window.location.reload();
      }
    } catch (error) {
      console.error(error);
      message.error('切换用户失败，请稍后重试。');
    }
  };

  const userMenuItems = users.map((user) => ({
    key: user.wxId,
    label: user.nickname,
    icon: <Avatar shape="square" size={20} src={user.avatar} />,
  }));

  const menuItems = [
    {
      key: 'switch',
      icon: <UserSwitchOutlined />,
      label: '切换账号',
      children: [
        ...userMenuItems,
      ],
    },
    {
      type: 'divider' as const,
    },
    {
      key: 'userInfo',
      icon: <InfoCircleOutlined />,
      label: '账号信息',
    },
  ];

  return (
    <>
      <Dropdown menu={{ selectedKeys, items: menuItems, onClick }}>
        {children}
      </Dropdown>

      <Modal open={isModalOpen} onOk={handleUserInfoOk} onCancel={handleUserInfoCancel} width={1000}>
        <Descriptions title="账号信息">
          <Descriptions.Item label="微信Id">{userInfo?.wxId}</Descriptions.Item>
          <Descriptions.Item label="版本号">{userInfo?.version}</Descriptions.Item>
          <Descriptions.Item label="文件目录"><Text ellipsis style={{width:200}}>{userInfo?.basePath}</Text></Descriptions.Item>
          <Descriptions.Item label="昵称">{userInfo?.nickname}</Descriptions.Item>
          <Descriptions.Item label="账号">{userInfo?.account}</Descriptions.Item>
          <Descriptions.Item label="手机号">{userInfo?.mobile}</Descriptions.Item>
        </Descriptions>
      </Modal>
    </>
  );
};

export default SwitchUser;
