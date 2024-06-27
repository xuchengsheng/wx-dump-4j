import { queryFeeds } from '@/services/Feeds';
import { queryAllContact } from '@/services/Contact';
import { LikeOutlined, MessageOutlined, StarOutlined } from '@ant-design/icons';
import { PageContainer, ProList } from '@ant-design/pro-components';
import { Avatar, Col, Flex, Image, Row, Typography,Alert } from 'antd';
import React from 'react';
import './Style/Feeds.less';
import { useEffect, useState } from 'react';
import dayjs from 'dayjs';

const IconText = ({ icon, text }: { icon: any; text: string }) => (
  <span>
    {React.createElement(icon, { style: { marginInlineEnd: 8 } })}
    {text}
  </span>
);

const { Text, Link } = Typography;


const Feeds: React.FC = () => {
  const [allContact, setAllContact] = useState<{ [key: string]: { text: string } }>({});

  const getAllContact = async () => {
    try {
      const response = await queryAllContact();
      const result = response.data.reduce<{ [key: string]: { text: string } }>((acc, curr) => {
        acc[curr.userName] = { text: curr.nickName };
        return acc;
      }, {});
      setAllContact(result);
      console.log(result);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    getAllContact();
  }, []);

  return (
    <PageContainer>
      <Alert
        message="温馨提示"
        description="从2024年4月24日开始，微信朋友圈的图片暂时无法显示。经过我们的初步分析，猜测这可能是由于某些限制导致的。不过，请放心，2024年4月24日之前发布的图片依然可以正常显示，不受影响。"
        type="warning"
        style={{marginBottom:10}}
        showIcon
        closable
      />
      <ProList<FeedsItem>
        request={async (params) => {
          try {
            return queryFeeds(params);
          } catch (error) {
            console.error(error);
            return [];
          }
        }}
        search={{}}
        bordered
        itemLayout="vertical"
        pagination={{
          pageSize: 5,
          showSizeChanger: false
        }}
        metas={{
          title: {
            dataIndex: 'nickName',
            search: false,
          },
          userName: {
            title: '用户名',
            valueType: 'select',
            dataIndex: 'userName',
            valueEnum: allContact,
          },
          strCreateTime:{
            title: '创建时间',
            key: 'createdAtRange',
            dataIndex: 'createdAtRange',
            valueType: 'dateRange',
            search: {
              transform: (value) => {
                return {
                  startTime: dayjs(value[0]).unix(),
                  endTime: dayjs(value[1]).add(1, 'day').unix(),
                };
              },
            },
          },
          avatar: {
            dataIndex: 'headImgUrl',
            search: false,
            render: (_, record) => {
              return <Avatar src={record.headImgUrl}></Avatar>;
            },
          },
          description: {
            dataIndex: 'contentDesc',
            search: false,
          },
          actions: {
            render: () => [
              <IconText icon={StarOutlined} text="0" key="list-vertical-star-o" />,
              <IconText icon={LikeOutlined} text="0" key="list-vertical-like-o" />,
              <IconText icon={MessageOutlined} text="0" key="list-vertical-message" />,
            ],
          },
          content: {
            search: false,
            render: (_, record) => {
              return (
                <Flex vertical>
                  <Flex vertical className="nine-grid">
                    <Row gutter={[16, 8]}>
                      {record.medias.map((media, index) => (
                        <Col key={index} xs={24} sm={12} md={8} lg={8} xl={8}>
                          <Image
                            width={150}
                            height={150}
                            fallback="/img/404.png"
                            src={`/api/image/downloadImg?path=${encodeURIComponent(media.url)}`}
                            style={{ objectFit: 'cover' }}
                          />
                        </Col>
                      ))}
                    </Row>
                  </Flex>
                  <Flex>
                    <Text type="secondary">{record.strCreateTime}</Text>
                  </Flex>
                  <Link
                    href={`http://api.map.baidu.com/geocoder?address=${encodeURIComponent(
                      record.location.poiName,
                    )}&output=html`}
                    target="_blank"
                    className="location"
                  >
                    {record.location.poiName}
                  </Link>
                </Flex>
              );
            },
          },
        }}
      />
    </PageContainer>
  );
};

export default Feeds;
