import { queryFeeds } from '@/services/Wechat/Feeds';
import { LikeOutlined, MessageOutlined, StarOutlined } from '@ant-design/icons';
import { PageContainer, ProList } from '@ant-design/pro-components';
import { Avatar, Col, Flex, Image, Row, Typography } from 'antd';
import React from 'react';
import './Style/Feeds.less';

const IconText = ({ icon, text }: { icon: any; text: string }) => (
  <span>
    {React.createElement(icon, { style: { marginInlineEnd: 8 } })}
    {text}
  </span>
);

const { Text, Link } = Typography;

const Feeds: React.FC = () => {
  return (
    <PageContainer>
      <ProList<FeedsItem>
        request={async (params) => {
          try {
            return queryFeeds(params);
          } catch (error) {
            console.error(error);
            return [];
          }
        }}
        bordered
        itemLayout="vertical"
        pagination={{
          pageSize: 5,
          showSizeChanger: false
        }}
        metas={{
          title: {
            dataIndex: 'nickName',
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
