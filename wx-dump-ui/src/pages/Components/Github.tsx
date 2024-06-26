import React, { useState, useEffect } from 'react';
import { GithubOutlined } from '@ant-design/icons';

const Github: React.FC = () => {
  return (
    <div
      style={{
        display: 'flex',
        height: 26,
      }}
      onClick={() => {
        window.open('https://github.com/xuchengsheng/wx-dump-4j');
      }}
    >
      <GithubOutlined />
    </div>
  );
};

export default Github;
