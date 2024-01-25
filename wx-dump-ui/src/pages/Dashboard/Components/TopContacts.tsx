import { topContacts } from '@/services/Wechat/DashBoard';
import { Avatar } from 'antd';
import React, { useEffect, useState } from 'react';
import styles from '../Style/TopContacts.less';

const TopContacts: React.FC = () => {
  const [data, setData] = useState<TopContactsMonthlyItem[]>([]);

  const getTop10ContactsMonthly = async () => {
    try {
      const response = await topContacts();
      setData(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    getTop10ContactsMonthly();
  }, []);

  return (
    <div>
      <h4>最近一个月内微信互动最频繁的前10位联系人</h4>
      <ul className={styles.topContactList}>
        {data.map((item, i) => (
          <li key={item.nickName}>
            <span className={`${styles.topContactItemNumber} ${i < 3 ? styles.active : ''}`}>
              {i + 1}
            </span>
            <Avatar size="small" src={item.headImgUrl} />
            <span className={styles.topContactItemTitle} title={item.nickName}>
              {item.nickName}
            </span>
            <span>{item.total}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TopContacts;
