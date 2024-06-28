import { Card, Col, Row } from 'antd';
import CountRecentMsg from './Components/CountRecentMsg';
import MsgCategory from './Components/MsgCategory';
import RecentUsedKeyWord from './Components/RecentUsedKeyWord';
import StatsPanel from './Components/StatsPanel';
import TopContacts from './Components/TopContacts';

export default () => {
  return (
    <>
      <StatsPanel />

      <Card style={{ marginTop: 25 }} title="过去15天内每日微信消息数量统计">
        <Row>
          <Col xl={18} lg={12} md={12} sm={24} xs={24}>
            <CountRecentMsg />
          </Col>
          <Col xl={6} lg={12} md={12} sm={24} xs={24}>
            <TopContacts />
          </Col>
        </Row>
      </Card>

      <Row
        gutter={24}
        style={{
          marginTop: 24,
        }}
      >
        <Col xl={12} lg={24} md={24} sm={24} xs={24}>
          <Card title="过去15天内消息类别占比">
            <MsgCategory />
          </Card>
        </Col>
        <Col xl={12} lg={24} md={24} sm={24} xs={24}>
          <Card title="最近使用的关键字">
            <RecentUsedKeyWord />
          </Card>
        </Col>
      </Row>
    </>
  );
};
