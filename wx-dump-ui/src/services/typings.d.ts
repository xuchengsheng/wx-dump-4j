// @ts-ignore
/* eslint-disable */

interface Response<T> {
  success: boolean;
  data: T;
  errorCode?: number;
  errorMessage?: string;
}

interface ContactLabelItem {
  labelId: string;
  labelName: string;
}

interface AllContactItem {
  userName: string;
  nickName: string;
}

type ContactParams = {
  current?: number;
  pageSize?: number;
  remark?: string;
  nickName?: string;
  labelId?: string;
};

type DecryptParams = {
  key?: string;
  basePath?: string;
  wxId?: string;
};

interface ContactItem {
  userName: string;
  alias: string;
  type: number;
  verifyFlag: number;
  remark: string;
  nickName: string;
  labelNameList: string;
  headImgUrl: string;
  py: string;
  labelIdList: string;
  labels: string[];
}

type ChatRoomParams = {
  current?: number;
  pageSize?: number;
  chatRoomTitle?: string;
  selfDisplayName?: string;
  createBy?: string;
};

type ChatRoomItem = {
  chatRoomName?: string;
  chatRoomTitle?: string;
  isShowName?: number;
  selfDisplayName?: string;
  createBy?: string;
  headImgUrl?: string;
  dissolution?: boolean;
  enterprise?: boolean;
};

interface ChatRoomDetail {
  chatRoomName: string;
  chatRoomTitle: string;
  selfDisplayName: string;
  createBy: string;
  headImgUrl: string;
  chatRoomInfo: ChatRoomInfo;
  members: ChatRoomMember[];
}

interface ChatRoomInfo {
  announcement: string;
  infoVersion: number;
  announcementEditor: string;
  announcementPublisher: string;
  announcementPublishTime: number;
  strAnnouncementPublishTime: string;
  chatRoomStatus: number;
}

interface ChatRoomMember {
  wxId: string;
  remark: string;
  state: number;
  headImgUrl: string;
}

type FeedsParams = {
  current?: number;
  pageSize?: number;
};

interface FeedsItem {
  feedId: number;
  strCreateTime: string;
  faultId: number;
  type: number;
  userName: string;
  nickName: string;
  status: number;
  extFlag: number;
  privFlag: number;
  stringId: string;
  contentDesc: string;
  medias: Media[];
  location: Location;
  headImgUrl: string;
}

interface Media {
  url: string;
  thumb: string;
}

interface Location {
  poiClassifyId: string;
  poiName: string;
  poiAddress: string;
  poiClassifyType: number;
  city: string;
}

interface SessionItem {
  userName: string;
  alias: string;
  nickName: string;
  status: number;
  content: string;
  msgType: number;
  msgStatus: number;
  time: number;
  strTime: string;
  shortTime: string;
  headImgUrl: string;
}

type MsgParams = {
  talker?: string;
  nextSequence?: number;
};

type ExportMsgParams = {
  talker?: string;
};

interface MsgItem {
  msgSvrId: string;
  localId: number;
  type: number;
  subType: number;
  isSender: number;
  createTime: number;
  sequence: number;
  strCreateTime: string;
  imgMd5: string;
  image: string;
  thumb: string;
  emojiUrl: string;
  strContent: string;
  avatar: string;
  referMsgContent: string;
  weAppInfo: WeAppInfo;
  cardLink: CardLink;
}

interface WeAppInfo {
  title: string;
  sourceDisplayName: string;
  weAppIconUrl: string;
  weAppPageThumbRawUrl: string;
}

interface CardLink {
  title: string;
  sourceDisplayName: string;
  des: string;
  url: string;
}

interface WeChatConfig {
  pid: number;
  baseAddress: number;
  version: string;
  nickname: string;
  account: string;
  mobile: string;
  key: string;
  basePath: string;
  wxId: string;
}

interface Decrypt {
  fileName: string;
  fileSize: string;
  currentProgress: number;
  total: number;
}

interface MsgTypeDistributionItem {
  type: string;
  value: number;
}
interface CountRecentMsgItem {
  type: string;
  value: number;
  category: string;
}

interface TopContactsMonthlyItem {
  userName: string;
  nickName: string;
  headImgUrl: string;
  total: number;
}

interface StatsPanel {
  contact: number;
  chatRoom: number;
  sent: number;
  received: number;
}

interface RecentUsedKeyWordItem {
  text: string;
}

type RecoverContactParams = {
  current?: number;
  pageSize?: number;
  nickname?: string;
  remark?: string;
};

interface UserItem {
  wxId: string;
  nickname: string;
  avatar: string;
  current: boolean;
}

type SwitchUserParams = {
  wxId?: string;
};

type DatabaseParams = {
  wxId?: string;
};

interface DatabaseItem {
  filePath: string;
  fileSize: string;
}

interface UserInfo {
  basePath: string;
  wxId: string;
  nickname: string;
  version: string;
  account: string;
  mobile: string;
}
