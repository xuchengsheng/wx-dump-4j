import { InfoCircleOutlined, UserSwitchOutlined } from '@ant-design/icons';
import { Dropdown, Avatar, message } from 'antd';
import type { MenuProps } from 'antd';
import React, { useState, useEffect } from 'react';
import { getAllUser, switchUser } from "@/services/User";

export type SwitchUserProps = {
  children?: React.ReactNode;
};

const SwitchUser: React.FC<SwitchUserProps> = ({ children }) => {
  const [users, setUsers] = useState<UserItem[]>([]);
  const [selectedKeys, setSelectedKeys] = useState<string[]>([]);

  const handleAllUser = async () => {
    try {
      const response = await getAllUser();
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

  useEffect(() => {
    handleAllUser();
  }, []);

  const onClick: MenuProps['onClick'] = async ({ key }) => {
    const selectKey = `${key}`;
    const selectLabel = getLabelByKey(selectKey, menuItems);

    if (selectKey == 'switch' || selectKey == 'userinfo') {
      return;
    }
    try {
      const response = await switchUser({ wxId: selectKey });
      if (response.success) {
        message.success(`成功切换至用户 ${selectLabel}。`);
        window.location.reload();
      }
    } catch (error) {
      console.error(error);
      message.error(`切换用户 ${selectLabel} 失败，请稍后重试。`);
    }
  };

  const getLabelByKey = (key: string, items: any[]): string | null => {
    for (const item of items) {
      if (item.key === key) {
        return item.label;
      }
      if (item.children) {
        const found = getLabelByKey(key, item.children);
        if (found) {
          return found;
        }
      }
    }
    return null;
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
      key: 'userinfo',
      icon: <InfoCircleOutlined />,
      label: '个人信息',
    },
  ];

  return (
    <Dropdown menu={{ selectedKeys, items: menuItems, onClick }}>
      {children}
    </Dropdown>
  );
};

export default SwitchUser;
