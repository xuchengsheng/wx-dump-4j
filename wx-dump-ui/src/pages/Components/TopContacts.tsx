import { topContacts } from '@/services/DashBoard';
import { Avatar } from 'antd';
import React, { useEffect, useState } from 'react';
import styles from '../Style/TopContacts.less';
import { Skeleton } from 'antd';

const TopContacts: React.FC = () => {
  const [data, setData] = useState<TopContactsMonthlyItem[]>([]);
  const [isLoading, setIsLoading] = useState(false);

  const getTop10ContactsMonthly = async () => {
    setIsLoading(true);
    try {
      const response = await topContacts();
      setData(response.data);
    } catch (error) {
      console.error(error);
    }
    setIsLoading(false);
  };

  useEffect(() => {
    getTop10ContactsMonthly();
  }, []);

  return (
    <Skeleton loading={isLoading} paragraph={{ rows: 13 }} active round>
      <div>
        <h4>最近一个月内微信互动最频繁的前10位联系人</h4>
        <ul className={styles.topContactList}>
          {data.map((item, i) => (
            <li key={item.nickName}>
              <span className={`${styles.topContactItemNumber} ${i < 3 ? styles.active : ''}`}>
                {i + 1}
              </span>
              <Avatar size={30} src={item.headImgUrl} />
              <span className={styles.topContactItemTitle} title={item.nickName}>
                {item.nickName}
              </span>
              <span>{item.total}</span>
            </li>
          ))}
        </ul>
      </div>
    </Skeleton>
  );
};

export default TopContacts;
