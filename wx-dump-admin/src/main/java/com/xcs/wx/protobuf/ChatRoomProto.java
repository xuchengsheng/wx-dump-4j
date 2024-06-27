package com.xcs.wx.protobuf;

/**
 * 群聊Protobuf
 *
 * @author xcs
 * @date 2024年6月27日14:55:41
 */
@SuppressWarnings("all")
public final class ChatRoomProto {
    private ChatRoomProto() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    public interface ChatRoomOrBuilder extends
            // @@protoc_insertion_point(interface_extends:ChatRoom)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>repeated .Member members = 1;</code>
         */
        java.util.List<Member>
        getMembersList();

        /**
         * <code>repeated .Member members = 1;</code>
         */
        Member getMembers(int index);

        /**
         * <code>repeated .Member members = 1;</code>
         */
        int getMembersCount();

        /**
         * <code>repeated .Member members = 1;</code>
         */
        java.util.List<? extends MemberOrBuilder>
        getMembersOrBuilderList();

        /**
         * <code>repeated .Member members = 1;</code>
         */
        MemberOrBuilder getMembersOrBuilder(
                int index);

        /**
         * <code>int32 field2 = 2;</code>
         *
         * @return The field2.
         */
        int getField2();

        /**
         * <code>int32 field3 = 3;</code>
         *
         * @return The field3.
         */
        int getField3();

        /**
         * <code>int32 field4 = 4;</code>
         *
         * @return The field4.
         */
        int getField4();

        /**
         * <code>int32 roomCapacity = 5;</code>
         *
         * @return The roomCapacity.
         */
        int getRoomCapacity();

        /**
         * <code>int32 field6 = 6;</code>
         *
         * @return The field6.
         */
        int getField6();

        /**
         * <code>int64 field7 = 7;</code>
         *
         * @return The field7.
         */
        long getField7();

        /**
         * <code>int64 field8 = 8;</code>
         *
         * @return The field8.
         */
        long getField8();
    }

    /**
     * Protobuf type {@code ChatRoom}
     */
    public static final class ChatRoom extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:ChatRoom)
            ChatRoomOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use ChatRoom.newBuilder() to construct.
        private ChatRoom(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private ChatRoom() {
            members_ = java.util.Collections.emptyList();
        }

        @Override
        @SuppressWarnings({"unused"})
        protected Object newInstance(
                UnusedPrivateParameter unused) {
            return new ChatRoom();
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return ChatRoomProto.internal_static_ChatRoom_descriptor;
        }

        @Override
        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return ChatRoomProto.internal_static_ChatRoom_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            ChatRoom.class, Builder.class);
        }

        public static final int MEMBERS_FIELD_NUMBER = 1;
        @SuppressWarnings("serial")
        private java.util.List<Member> members_;

        /**
         * <code>repeated .Member members = 1;</code>
         */
        @Override
        public java.util.List<Member> getMembersList() {
            return members_;
        }

        /**
         * <code>repeated .Member members = 1;</code>
         */
        @Override
        public java.util.List<? extends MemberOrBuilder>
        getMembersOrBuilderList() {
            return members_;
        }

        /**
         * <code>repeated .Member members = 1;</code>
         */
        @Override
        public int getMembersCount() {
            return members_.size();
        }

        /**
         * <code>repeated .Member members = 1;</code>
         */
        @Override
        public Member getMembers(int index) {
            return members_.get(index);
        }

        /**
         * <code>repeated .Member members = 1;</code>
         */
        @Override
        public MemberOrBuilder getMembersOrBuilder(
                int index) {
            return members_.get(index);
        }

        public static final int FIELD2_FIELD_NUMBER = 2;
        private int field2_ = 0;

        /**
         * <code>int32 field2 = 2;</code>
         *
         * @return The field2.
         */
        @Override
        public int getField2() {
            return field2_;
        }

        public static final int FIELD3_FIELD_NUMBER = 3;
        private int field3_ = 0;

        /**
         * <code>int32 field3 = 3;</code>
         *
         * @return The field3.
         */
        @Override
        public int getField3() {
            return field3_;
        }

        public static final int FIELD4_FIELD_NUMBER = 4;
        private int field4_ = 0;

        /**
         * <code>int32 field4 = 4;</code>
         *
         * @return The field4.
         */
        @Override
        public int getField4() {
            return field4_;
        }

        public static final int ROOMCAPACITY_FIELD_NUMBER = 5;
        private int roomCapacity_ = 0;

        /**
         * <code>int32 roomCapacity = 5;</code>
         *
         * @return The roomCapacity.
         */
        @Override
        public int getRoomCapacity() {
            return roomCapacity_;
        }

        public static final int FIELD6_FIELD_NUMBER = 6;
        private int field6_ = 0;

        /**
         * <code>int32 field6 = 6;</code>
         *
         * @return The field6.
         */
        @Override
        public int getField6() {
            return field6_;
        }

        public static final int FIELD7_FIELD_NUMBER = 7;
        private long field7_ = 0L;

        /**
         * <code>int64 field7 = 7;</code>
         *
         * @return The field7.
         */
        @Override
        public long getField7() {
            return field7_;
        }

        public static final int FIELD8_FIELD_NUMBER = 8;
        private long field8_ = 0L;

        /**
         * <code>int64 field8 = 8;</code>
         *
         * @return The field8.
         */
        @Override
        public long getField8() {
            return field8_;
        }

        private byte memoizedIsInitialized = -1;

        @Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            for (int i = 0; i < members_.size(); i++) {
                output.writeMessage(1, members_.get(i));
            }
            if (field2_ != 0) {
                output.writeInt32(2, field2_);
            }
            if (field3_ != 0) {
                output.writeInt32(3, field3_);
            }
            if (field4_ != 0) {
                output.writeInt32(4, field4_);
            }
            if (roomCapacity_ != 0) {
                output.writeInt32(5, roomCapacity_);
            }
            if (field6_ != 0) {
                output.writeInt32(6, field6_);
            }
            if (field7_ != 0L) {
                output.writeInt64(7, field7_);
            }
            if (field8_ != 0L) {
                output.writeInt64(8, field8_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            for (int i = 0; i < members_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(1, members_.get(i));
            }
            if (field2_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(2, field2_);
            }
            if (field3_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(3, field3_);
            }
            if (field4_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(4, field4_);
            }
            if (roomCapacity_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(5, roomCapacity_);
            }
            if (field6_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(6, field6_);
            }
            if (field7_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(7, field7_);
            }
            if (field8_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(8, field8_);
            }
            size += getUnknownFields().getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ChatRoom)) {
                return super.equals(obj);
            }
            ChatRoom other = (ChatRoom) obj;

            if (!getMembersList()
                    .equals(other.getMembersList())) return false;
            if (getField2()
                    != other.getField2()) return false;
            if (getField3()
                    != other.getField3()) return false;
            if (getField4()
                    != other.getField4()) return false;
            if (getRoomCapacity()
                    != other.getRoomCapacity()) return false;
            if (getField6()
                    != other.getField6()) return false;
            if (getField7()
                    != other.getField7()) return false;
            if (getField8()
                    != other.getField8()) return false;
            if (!getUnknownFields().equals(other.getUnknownFields())) return false;
            return true;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (getMembersCount() > 0) {
                hash = (37 * hash) + MEMBERS_FIELD_NUMBER;
                hash = (53 * hash) + getMembersList().hashCode();
            }
            hash = (37 * hash) + FIELD2_FIELD_NUMBER;
            hash = (53 * hash) + getField2();
            hash = (37 * hash) + FIELD3_FIELD_NUMBER;
            hash = (53 * hash) + getField3();
            hash = (37 * hash) + FIELD4_FIELD_NUMBER;
            hash = (53 * hash) + getField4();
            hash = (37 * hash) + ROOMCAPACITY_FIELD_NUMBER;
            hash = (53 * hash) + getRoomCapacity();
            hash = (37 * hash) + FIELD6_FIELD_NUMBER;
            hash = (53 * hash) + getField6();
            hash = (37 * hash) + FIELD7_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getField7());
            hash = (37 * hash) + FIELD8_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getField8());
            hash = (29 * hash) + getUnknownFields().hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static ChatRoom parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChatRoom parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChatRoom parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChatRoom parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChatRoom parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChatRoom parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChatRoom parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static ChatRoom parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChatRoom parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static ChatRoom parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChatRoom parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static ChatRoom parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChatRoom prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(
                BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * Protobuf type {@code ChatRoom}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:ChatRoom)
                ChatRoomOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return ChatRoomProto.internal_static_ChatRoom_descriptor;
            }

            @Override
            protected FieldAccessorTable
            internalGetFieldAccessorTable() {
                return ChatRoomProto.internal_static_ChatRoom_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                ChatRoom.class, Builder.class);
            }

            // Construct using ChatRoomProto.ChatRoom.newBuilder()
            private Builder() {

            }

            private Builder(
                    BuilderParent parent) {
                super(parent);

            }

            @Override
            public Builder clear() {
                super.clear();
                bitField0_ = 0;
                if (membersBuilder_ == null) {
                    members_ = java.util.Collections.emptyList();
                } else {
                    members_ = null;
                    membersBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000001);
                field2_ = 0;
                field3_ = 0;
                field4_ = 0;
                roomCapacity_ = 0;
                field6_ = 0;
                field7_ = 0L;
                field8_ = 0L;
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return ChatRoomProto.internal_static_ChatRoom_descriptor;
            }

            @Override
            public ChatRoom getDefaultInstanceForType() {
                return ChatRoom.getDefaultInstance();
            }

            @Override
            public ChatRoom build() {
                ChatRoom result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public ChatRoom buildPartial() {
                ChatRoom result = new ChatRoom(this);
                buildPartialRepeatedFields(result);
                if (bitField0_ != 0) {
                    buildPartial0(result);
                }
                onBuilt();
                return result;
            }

            private void buildPartialRepeatedFields(ChatRoom result) {
                if (membersBuilder_ == null) {
                    if (((bitField0_ & 0x00000001) != 0)) {
                        members_ = java.util.Collections.unmodifiableList(members_);
                        bitField0_ = (bitField0_ & ~0x00000001);
                    }
                    result.members_ = members_;
                } else {
                    result.members_ = membersBuilder_.build();
                }
            }

            private void buildPartial0(ChatRoom result) {
                int from_bitField0_ = bitField0_;
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    result.field2_ = field2_;
                }
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    result.field3_ = field3_;
                }
                if (((from_bitField0_ & 0x00000008) != 0)) {
                    result.field4_ = field4_;
                }
                if (((from_bitField0_ & 0x00000010) != 0)) {
                    result.roomCapacity_ = roomCapacity_;
                }
                if (((from_bitField0_ & 0x00000020) != 0)) {
                    result.field6_ = field6_;
                }
                if (((from_bitField0_ & 0x00000040) != 0)) {
                    result.field7_ = field7_;
                }
                if (((from_bitField0_ & 0x00000080) != 0)) {
                    result.field8_ = field8_;
                }
            }

            @Override
            public Builder clone() {
                return super.clone();
            }

            @Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return super.setField(field, value);
            }

            @Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return super.addRepeatedField(field, value);
            }

            @Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof ChatRoom) {
                    return mergeFrom((ChatRoom) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(ChatRoom other) {
                if (other == ChatRoom.getDefaultInstance()) return this;
                if (membersBuilder_ == null) {
                    if (!other.members_.isEmpty()) {
                        if (members_.isEmpty()) {
                            members_ = other.members_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                        } else {
                            ensureMembersIsMutable();
                            members_.addAll(other.members_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.members_.isEmpty()) {
                        if (membersBuilder_.isEmpty()) {
                            membersBuilder_.dispose();
                            membersBuilder_ = null;
                            members_ = other.members_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                            membersBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                            getMembersFieldBuilder() : null;
                        } else {
                            membersBuilder_.addAllMessages(other.members_);
                        }
                    }
                }
                if (other.getField2() != 0) {
                    setField2(other.getField2());
                }
                if (other.getField3() != 0) {
                    setField3(other.getField3());
                }
                if (other.getField4() != 0) {
                    setField4(other.getField4());
                }
                if (other.getRoomCapacity() != 0) {
                    setRoomCapacity(other.getRoomCapacity());
                }
                if (other.getField6() != 0) {
                    setField6(other.getField6());
                }
                if (other.getField7() != 0L) {
                    setField7(other.getField7());
                }
                if (other.getField8() != 0L) {
                    setField8(other.getField8());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                if (extensionRegistry == null) {
                    throw new NullPointerException();
                }
                try {
                    boolean done = false;
                    while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 10: {
                                Member m =
                                        input.readMessage(
                                                Member.parser(),
                                                extensionRegistry);
                                if (membersBuilder_ == null) {
                                    ensureMembersIsMutable();
                                    members_.add(m);
                                } else {
                                    membersBuilder_.addMessage(m);
                                }
                                break;
                            } // case 10
                            case 16: {
                                field2_ = input.readInt32();
                                bitField0_ |= 0x00000002;
                                break;
                            } // case 16
                            case 24: {
                                field3_ = input.readInt32();
                                bitField0_ |= 0x00000004;
                                break;
                            } // case 24
                            case 32: {
                                field4_ = input.readInt32();
                                bitField0_ |= 0x00000008;
                                break;
                            } // case 32
                            case 40: {
                                roomCapacity_ = input.readInt32();
                                bitField0_ |= 0x00000010;
                                break;
                            } // case 40
                            case 48: {
                                field6_ = input.readInt32();
                                bitField0_ |= 0x00000020;
                                break;
                            } // case 48
                            case 56: {
                                field7_ = input.readInt64();
                                bitField0_ |= 0x00000040;
                                break;
                            } // case 56
                            case 64: {
                                field8_ = input.readInt64();
                                bitField0_ |= 0x00000080;
                                break;
                            } // case 64
                            default: {
                                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                    done = true; // was an endgroup tag
                                }
                                break;
                            } // default:
                        } // switch (tag)
                    } // while (!done)
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.unwrapIOException();
                } finally {
                    onChanged();
                } // finally
                return this;
            }

            private int bitField0_;

            private java.util.List<Member> members_ =
                    java.util.Collections.emptyList();

            private void ensureMembersIsMutable() {
                if (!((bitField0_ & 0x00000001) != 0)) {
                    members_ = new java.util.ArrayList<Member>(members_);
                    bitField0_ |= 0x00000001;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    Member, Member.Builder, MemberOrBuilder> membersBuilder_;

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public java.util.List<Member> getMembersList() {
                if (membersBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(members_);
                } else {
                    return membersBuilder_.getMessageList();
                }
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public int getMembersCount() {
                if (membersBuilder_ == null) {
                    return members_.size();
                } else {
                    return membersBuilder_.getCount();
                }
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Member getMembers(int index) {
                if (membersBuilder_ == null) {
                    return members_.get(index);
                } else {
                    return membersBuilder_.getMessage(index);
                }
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Builder setMembers(
                    int index, Member value) {
                if (membersBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMembersIsMutable();
                    members_.set(index, value);
                    onChanged();
                } else {
                    membersBuilder_.setMessage(index, value);
                }
                return this;
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Builder setMembers(
                    int index, Member.Builder builderForValue) {
                if (membersBuilder_ == null) {
                    ensureMembersIsMutable();
                    members_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    membersBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Builder addMembers(Member value) {
                if (membersBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMembersIsMutable();
                    members_.add(value);
                    onChanged();
                } else {
                    membersBuilder_.addMessage(value);
                }
                return this;
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Builder addMembers(
                    int index, Member value) {
                if (membersBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMembersIsMutable();
                    members_.add(index, value);
                    onChanged();
                } else {
                    membersBuilder_.addMessage(index, value);
                }
                return this;
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Builder addMembers(
                    Member.Builder builderForValue) {
                if (membersBuilder_ == null) {
                    ensureMembersIsMutable();
                    members_.add(builderForValue.build());
                    onChanged();
                } else {
                    membersBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Builder addMembers(
                    int index, Member.Builder builderForValue) {
                if (membersBuilder_ == null) {
                    ensureMembersIsMutable();
                    members_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    membersBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Builder addAllMembers(
                    Iterable<? extends Member> values) {
                if (membersBuilder_ == null) {
                    ensureMembersIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                            values, members_);
                    onChanged();
                } else {
                    membersBuilder_.addAllMessages(values);
                }
                return this;
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Builder clearMembers() {
                if (membersBuilder_ == null) {
                    members_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                    onChanged();
                } else {
                    membersBuilder_.clear();
                }
                return this;
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Builder removeMembers(int index) {
                if (membersBuilder_ == null) {
                    ensureMembersIsMutable();
                    members_.remove(index);
                    onChanged();
                } else {
                    membersBuilder_.remove(index);
                }
                return this;
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Member.Builder getMembersBuilder(
                    int index) {
                return getMembersFieldBuilder().getBuilder(index);
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public MemberOrBuilder getMembersOrBuilder(
                    int index) {
                if (membersBuilder_ == null) {
                    return members_.get(index);
                } else {
                    return membersBuilder_.getMessageOrBuilder(index);
                }
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public java.util.List<? extends MemberOrBuilder>
            getMembersOrBuilderList() {
                if (membersBuilder_ != null) {
                    return membersBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(members_);
                }
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Member.Builder addMembersBuilder() {
                return getMembersFieldBuilder().addBuilder(
                        Member.getDefaultInstance());
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public Member.Builder addMembersBuilder(
                    int index) {
                return getMembersFieldBuilder().addBuilder(
                        index, Member.getDefaultInstance());
            }

            /**
             * <code>repeated .Member members = 1;</code>
             */
            public java.util.List<Member.Builder>
            getMembersBuilderList() {
                return getMembersFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    Member, Member.Builder, MemberOrBuilder>
            getMembersFieldBuilder() {
                if (membersBuilder_ == null) {
                    membersBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            Member, Member.Builder, MemberOrBuilder>(
                            members_,
                            ((bitField0_ & 0x00000001) != 0),
                            getParentForChildren(),
                            isClean());
                    members_ = null;
                }
                return membersBuilder_;
            }

            private int field2_;

            /**
             * <code>int32 field2 = 2;</code>
             *
             * @return The field2.
             */
            @Override
            public int getField2() {
                return field2_;
            }

            /**
             * <code>int32 field2 = 2;</code>
             *
             * @param value The field2 to set.
             * @return This builder for chaining.
             */
            public Builder setField2(int value) {

                field2_ = value;
                bitField0_ |= 0x00000002;
                onChanged();
                return this;
            }

            /**
             * <code>int32 field2 = 2;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearField2() {
                bitField0_ = (bitField0_ & ~0x00000002);
                field2_ = 0;
                onChanged();
                return this;
            }

            private int field3_;

            /**
             * <code>int32 field3 = 3;</code>
             *
             * @return The field3.
             */
            @Override
            public int getField3() {
                return field3_;
            }

            /**
             * <code>int32 field3 = 3;</code>
             *
             * @param value The field3 to set.
             * @return This builder for chaining.
             */
            public Builder setField3(int value) {

                field3_ = value;
                bitField0_ |= 0x00000004;
                onChanged();
                return this;
            }

            /**
             * <code>int32 field3 = 3;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearField3() {
                bitField0_ = (bitField0_ & ~0x00000004);
                field3_ = 0;
                onChanged();
                return this;
            }

            private int field4_;

            /**
             * <code>int32 field4 = 4;</code>
             *
             * @return The field4.
             */
            @Override
            public int getField4() {
                return field4_;
            }

            /**
             * <code>int32 field4 = 4;</code>
             *
             * @param value The field4 to set.
             * @return This builder for chaining.
             */
            public Builder setField4(int value) {

                field4_ = value;
                bitField0_ |= 0x00000008;
                onChanged();
                return this;
            }

            /**
             * <code>int32 field4 = 4;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearField4() {
                bitField0_ = (bitField0_ & ~0x00000008);
                field4_ = 0;
                onChanged();
                return this;
            }

            private int roomCapacity_;

            /**
             * <code>int32 roomCapacity = 5;</code>
             *
             * @return The roomCapacity.
             */
            @Override
            public int getRoomCapacity() {
                return roomCapacity_;
            }

            /**
             * <code>int32 roomCapacity = 5;</code>
             *
             * @param value The roomCapacity to set.
             * @return This builder for chaining.
             */
            public Builder setRoomCapacity(int value) {

                roomCapacity_ = value;
                bitField0_ |= 0x00000010;
                onChanged();
                return this;
            }

            /**
             * <code>int32 roomCapacity = 5;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearRoomCapacity() {
                bitField0_ = (bitField0_ & ~0x00000010);
                roomCapacity_ = 0;
                onChanged();
                return this;
            }

            private int field6_;

            /**
             * <code>int32 field6 = 6;</code>
             *
             * @return The field6.
             */
            @Override
            public int getField6() {
                return field6_;
            }

            /**
             * <code>int32 field6 = 6;</code>
             *
             * @param value The field6 to set.
             * @return This builder for chaining.
             */
            public Builder setField6(int value) {

                field6_ = value;
                bitField0_ |= 0x00000020;
                onChanged();
                return this;
            }

            /**
             * <code>int32 field6 = 6;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearField6() {
                bitField0_ = (bitField0_ & ~0x00000020);
                field6_ = 0;
                onChanged();
                return this;
            }

            private long field7_;

            /**
             * <code>int64 field7 = 7;</code>
             *
             * @return The field7.
             */
            @Override
            public long getField7() {
                return field7_;
            }

            /**
             * <code>int64 field7 = 7;</code>
             *
             * @param value The field7 to set.
             * @return This builder for chaining.
             */
            public Builder setField7(long value) {

                field7_ = value;
                bitField0_ |= 0x00000040;
                onChanged();
                return this;
            }

            /**
             * <code>int64 field7 = 7;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearField7() {
                bitField0_ = (bitField0_ & ~0x00000040);
                field7_ = 0L;
                onChanged();
                return this;
            }

            private long field8_;

            /**
             * <code>int64 field8 = 8;</code>
             *
             * @return The field8.
             */
            @Override
            public long getField8() {
                return field8_;
            }

            /**
             * <code>int64 field8 = 8;</code>
             *
             * @param value The field8 to set.
             * @return This builder for chaining.
             */
            public Builder setField8(long value) {

                field8_ = value;
                bitField0_ |= 0x00000080;
                onChanged();
                return this;
            }

            /**
             * <code>int64 field8 = 8;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearField8() {
                bitField0_ = (bitField0_ & ~0x00000080);
                field8_ = 0L;
                onChanged();
                return this;
            }

            @Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:ChatRoom)
        }

        // @@protoc_insertion_point(class_scope:ChatRoom)
        private static final ChatRoom DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new ChatRoom();
        }

        public static ChatRoom getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<ChatRoom>
                PARSER = new com.google.protobuf.AbstractParser<ChatRoom>() {
            @Override
            public ChatRoom parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                Builder builder = newBuilder();
                try {
                    builder.mergeFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(builder.buildPartial());
                } catch (com.google.protobuf.UninitializedMessageException e) {
                    throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
                } catch (java.io.IOException e) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(e)
                            .setUnfinishedMessage(builder.buildPartial());
                }
                return builder.buildPartial();
            }
        };

        public static com.google.protobuf.Parser<ChatRoom> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<ChatRoom> getParserForType() {
            return PARSER;
        }

        @Override
        public ChatRoom getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface MemberOrBuilder extends
            // @@protoc_insertion_point(interface_extends:Member)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string wxId = 1;</code>
         *
         * @return The wxId.
         */
        String getWxId();

        /**
         * <code>string wxId = 1;</code>
         *
         * @return The bytes for wxId.
         */
        com.google.protobuf.ByteString
        getWxIdBytes();

        /**
         * <code>string remark = 2;</code>
         *
         * @return The remark.
         */
        String getRemark();

        /**
         * <code>string remark = 2;</code>
         *
         * @return The bytes for remark.
         */
        com.google.protobuf.ByteString
        getRemarkBytes();

        /**
         * <code>int32 state = 3;</code>
         *
         * @return The state.
         */
        int getState();
    }

    /**
     * Protobuf type {@code Member}
     */
    public static final class Member extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:Member)
            MemberOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use Member.newBuilder() to construct.
        private Member(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private Member() {
            wxId_ = "";
            remark_ = "";
        }

        @Override
        @SuppressWarnings({"unused"})
        protected Object newInstance(
                UnusedPrivateParameter unused) {
            return new Member();
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return ChatRoomProto.internal_static_Member_descriptor;
        }

        @Override
        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return ChatRoomProto.internal_static_Member_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            Member.class, Builder.class);
        }

        public static final int WXID_FIELD_NUMBER = 1;
        @SuppressWarnings("serial")
        private volatile Object wxId_ = "";

        /**
         * <code>string wxId = 1;</code>
         *
         * @return The wxId.
         */
        @Override
        public String getWxId() {
            Object ref = wxId_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                wxId_ = s;
                return s;
            }
        }

        /**
         * <code>string wxId = 1;</code>
         *
         * @return The bytes for wxId.
         */
        @Override
        public com.google.protobuf.ByteString
        getWxIdBytes() {
            Object ref = wxId_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                wxId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int REMARK_FIELD_NUMBER = 2;
        @SuppressWarnings("serial")
        private volatile Object remark_ = "";

        /**
         * <code>string remark = 2;</code>
         *
         * @return The remark.
         */
        @Override
        public String getRemark() {
            Object ref = remark_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                remark_ = s;
                return s;
            }
        }

        /**
         * <code>string remark = 2;</code>
         *
         * @return The bytes for remark.
         */
        @Override
        public com.google.protobuf.ByteString
        getRemarkBytes() {
            Object ref = remark_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                remark_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int STATE_FIELD_NUMBER = 3;
        private int state_ = 0;

        /**
         * <code>int32 state = 3;</code>
         *
         * @return The state.
         */
        @Override
        public int getState() {
            return state_;
        }

        private byte memoizedIsInitialized = -1;

        @Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(wxId_)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, wxId_);
            }
            if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(remark_)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, remark_);
            }
            if (state_ != 0) {
                output.writeInt32(3, state_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(wxId_)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, wxId_);
            }
            if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(remark_)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, remark_);
            }
            if (state_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(3, state_);
            }
            size += getUnknownFields().getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Member)) {
                return super.equals(obj);
            }
            Member other = (Member) obj;

            if (!getWxId()
                    .equals(other.getWxId())) return false;
            if (!getRemark()
                    .equals(other.getRemark())) return false;
            if (getState()
                    != other.getState()) return false;
            if (!getUnknownFields().equals(other.getUnknownFields())) return false;
            return true;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + WXID_FIELD_NUMBER;
            hash = (53 * hash) + getWxId().hashCode();
            hash = (37 * hash) + REMARK_FIELD_NUMBER;
            hash = (53 * hash) + getRemark().hashCode();
            hash = (37 * hash) + STATE_FIELD_NUMBER;
            hash = (53 * hash) + getState();
            hash = (29 * hash) + getUnknownFields().hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static Member parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Member parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Member parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Member parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Member parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Member parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Member parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static Member parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Member parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static Member parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Member parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static Member parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Member prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(
                BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * Protobuf type {@code Member}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:Member)
                MemberOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return ChatRoomProto.internal_static_Member_descriptor;
            }

            @Override
            protected FieldAccessorTable
            internalGetFieldAccessorTable() {
                return ChatRoomProto.internal_static_Member_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                Member.class, Builder.class);
            }

            // Construct using ChatRoomProto.Member.newBuilder()
            private Builder() {

            }

            private Builder(
                    BuilderParent parent) {
                super(parent);

            }

            @Override
            public Builder clear() {
                super.clear();
                bitField0_ = 0;
                wxId_ = "";
                remark_ = "";
                state_ = 0;
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return ChatRoomProto.internal_static_Member_descriptor;
            }

            @Override
            public Member getDefaultInstanceForType() {
                return Member.getDefaultInstance();
            }

            @Override
            public Member build() {
                Member result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public Member buildPartial() {
                Member result = new Member(this);
                if (bitField0_ != 0) {
                    buildPartial0(result);
                }
                onBuilt();
                return result;
            }

            private void buildPartial0(Member result) {
                int from_bitField0_ = bitField0_;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    result.wxId_ = wxId_;
                }
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    result.remark_ = remark_;
                }
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    result.state_ = state_;
                }
            }

            @Override
            public Builder clone() {
                return super.clone();
            }

            @Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return super.setField(field, value);
            }

            @Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return super.addRepeatedField(field, value);
            }

            @Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Member) {
                    return mergeFrom((Member) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(Member other) {
                if (other == Member.getDefaultInstance()) return this;
                if (!other.getWxId().isEmpty()) {
                    wxId_ = other.wxId_;
                    bitField0_ |= 0x00000001;
                    onChanged();
                }
                if (!other.getRemark().isEmpty()) {
                    remark_ = other.remark_;
                    bitField0_ |= 0x00000002;
                    onChanged();
                }
                if (other.getState() != 0) {
                    setState(other.getState());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                if (extensionRegistry == null) {
                    throw new NullPointerException();
                }
                try {
                    boolean done = false;
                    while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 10: {
                                wxId_ = input.readStringRequireUtf8();
                                bitField0_ |= 0x00000001;
                                break;
                            } // case 10
                            case 18: {
                                remark_ = input.readStringRequireUtf8();
                                bitField0_ |= 0x00000002;
                                break;
                            } // case 18
                            case 24: {
                                state_ = input.readInt32();
                                bitField0_ |= 0x00000004;
                                break;
                            } // case 24
                            default: {
                                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                    done = true; // was an endgroup tag
                                }
                                break;
                            } // default:
                        } // switch (tag)
                    } // while (!done)
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.unwrapIOException();
                } finally {
                    onChanged();
                } // finally
                return this;
            }

            private int bitField0_;

            private Object wxId_ = "";

            /**
             * <code>string wxId = 1;</code>
             *
             * @return The wxId.
             */
            public String getWxId() {
                Object ref = wxId_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    wxId_ = s;
                    return s;
                } else {
                    return (String) ref;
                }
            }

            /**
             * <code>string wxId = 1;</code>
             *
             * @return The bytes for wxId.
             */
            public com.google.protobuf.ByteString
            getWxIdBytes() {
                Object ref = wxId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    wxId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>string wxId = 1;</code>
             *
             * @param value The wxId to set.
             * @return This builder for chaining.
             */
            public Builder setWxId(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                wxId_ = value;
                bitField0_ |= 0x00000001;
                onChanged();
                return this;
            }

            /**
             * <code>string wxId = 1;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearWxId() {
                wxId_ = getDefaultInstance().getWxId();
                bitField0_ = (bitField0_ & ~0x00000001);
                onChanged();
                return this;
            }

            /**
             * <code>string wxId = 1;</code>
             *
             * @param value The bytes for wxId to set.
             * @return This builder for chaining.
             */
            public Builder setWxIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);
                wxId_ = value;
                bitField0_ |= 0x00000001;
                onChanged();
                return this;
            }

            private Object remark_ = "";

            /**
             * <code>string remark = 2;</code>
             *
             * @return The remark.
             */
            public String getRemark() {
                Object ref = remark_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    remark_ = s;
                    return s;
                } else {
                    return (String) ref;
                }
            }

            /**
             * <code>string remark = 2;</code>
             *
             * @return The bytes for remark.
             */
            public com.google.protobuf.ByteString
            getRemarkBytes() {
                Object ref = remark_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    remark_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>string remark = 2;</code>
             *
             * @param value The remark to set.
             * @return This builder for chaining.
             */
            public Builder setRemark(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                remark_ = value;
                bitField0_ |= 0x00000002;
                onChanged();
                return this;
            }

            /**
             * <code>string remark = 2;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearRemark() {
                remark_ = getDefaultInstance().getRemark();
                bitField0_ = (bitField0_ & ~0x00000002);
                onChanged();
                return this;
            }

            /**
             * <code>string remark = 2;</code>
             *
             * @param value The bytes for remark to set.
             * @return This builder for chaining.
             */
            public Builder setRemarkBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);
                remark_ = value;
                bitField0_ |= 0x00000002;
                onChanged();
                return this;
            }

            private int state_;

            /**
             * <code>int32 state = 3;</code>
             *
             * @return The state.
             */
            @Override
            public int getState() {
                return state_;
            }

            /**
             * <code>int32 state = 3;</code>
             *
             * @param value The state to set.
             * @return This builder for chaining.
             */
            public Builder setState(int value) {

                state_ = value;
                bitField0_ |= 0x00000004;
                onChanged();
                return this;
            }

            /**
             * <code>int32 state = 3;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearState() {
                bitField0_ = (bitField0_ & ~0x00000004);
                state_ = 0;
                onChanged();
                return this;
            }

            @Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:Member)
        }

        // @@protoc_insertion_point(class_scope:Member)
        private static final Member DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new Member();
        }

        public static Member getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<Member>
                PARSER = new com.google.protobuf.AbstractParser<Member>() {
            @Override
            public Member parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                Builder builder = newBuilder();
                try {
                    builder.mergeFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(builder.buildPartial());
                } catch (com.google.protobuf.UninitializedMessageException e) {
                    throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
                } catch (java.io.IOException e) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(e)
                            .setUnfinishedMessage(builder.buildPartial());
                }
                return builder.buildPartial();
            }
        };

        public static com.google.protobuf.Parser<Member> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<Member> getParserForType() {
            return PARSER;
        }

        @Override
        public Member getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_ChatRoom_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_ChatRoom_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_Member_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_Member_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        String[] descriptorData = {
                "\n\016RoomData.proto\"\232\001\n\010ChatRoom\022\030\n\007members" +
                        "\030\001 \003(\0132\007.Member\022\016\n\006field2\030\002 \001(\005\022\016\n\006field" +
                        "3\030\003 \001(\005\022\016\n\006field4\030\004 \001(\005\022\024\n\014roomCapacity\030" +
                        "\005 \001(\005\022\016\n\006field6\030\006 \001(\005\022\016\n\006field7\030\007 \001(\003\022\016\n" +
                        "\006field8\030\010 \001(\003\"5\n\006Member\022\014\n\004wxId\030\001 \001(\t\022\016\n" +
                        "\006remark\030\002 \001(\t\022\r\n\005state\030\003 \001(\005B\017B\rChatRoom" +
                        "Protob\006proto3"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        });
        internal_static_ChatRoom_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_ChatRoom_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_ChatRoom_descriptor,
                new String[]{"Members", "Field2", "Field3", "Field4", "RoomCapacity", "Field6", "Field7", "Field8",});
        internal_static_Member_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_Member_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_Member_descriptor,
                new String[]{"WxId", "Remark", "State",});
    }

    // @@protoc_insertion_point(outer_class_scope)
}
