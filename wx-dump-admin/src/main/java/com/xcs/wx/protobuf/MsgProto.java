package com.xcs.wx.protobuf;

/**
 * 消息 Protobuf
 *
 * @author xcs
 * @date 2024年6月27日14:55:41
 */
@SuppressWarnings("all")
public final class MsgProto {
    
    private MsgProto() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    public interface SubMessage1OrBuilder extends
            // @@protoc_insertion_point(interface_extends:SubMessage1)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>int32 field1 = 1;</code>
         *
         * @return The field1.
         */
        int getField1();

        /**
         * <code>int32 field2 = 2;</code>
         *
         * @return The field2.
         */
        int getField2();
    }

    /**
     * Protobuf type {@code SubMessage1}
     */
    public static final class SubMessage1 extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:SubMessage1)
            SubMessage1OrBuilder {
        private static final long serialVersionUID = 0L;

        // Use SubMessage1.newBuilder() to construct.
        private SubMessage1(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private SubMessage1() {
        }

        @Override
        @SuppressWarnings({"unused"})
        protected Object newInstance(
                UnusedPrivateParameter unused) {
            return new SubMessage1();
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return MsgProto.internal_static_SubMessage1_descriptor;
        }

        @Override
        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return MsgProto.internal_static_SubMessage1_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            SubMessage1.class, Builder.class);
        }

        public static final int FIELD1_FIELD_NUMBER = 1;
        private int field1_ = 0;

        /**
         * <code>int32 field1 = 1;</code>
         *
         * @return The field1.
         */
        @Override
        public int getField1() {
            return field1_;
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
            if (field1_ != 0) {
                output.writeInt32(1, field1_);
            }
            if (field2_ != 0) {
                output.writeInt32(2, field2_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (field1_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(1, field1_);
            }
            if (field2_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(2, field2_);
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
            if (!(obj instanceof SubMessage1)) {
                return super.equals(obj);
            }
            SubMessage1 other = (SubMessage1) obj;

            if (getField1()
                    != other.getField1()) return false;
            if (getField2()
                    != other.getField2()) return false;
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
            hash = (37 * hash) + FIELD1_FIELD_NUMBER;
            hash = (53 * hash) + getField1();
            hash = (37 * hash) + FIELD2_FIELD_NUMBER;
            hash = (53 * hash) + getField2();
            hash = (29 * hash) + getUnknownFields().hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static SubMessage1 parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SubMessage1 parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SubMessage1 parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SubMessage1 parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SubMessage1 parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SubMessage1 parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SubMessage1 parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static SubMessage1 parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SubMessage1 parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static SubMessage1 parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SubMessage1 parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static SubMessage1 parseFrom(
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

        public static Builder newBuilder(SubMessage1 prototype) {
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
         * Protobuf type {@code SubMessage1}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:SubMessage1)
                SubMessage1OrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return MsgProto.internal_static_SubMessage1_descriptor;
            }

            @Override
            protected FieldAccessorTable
            internalGetFieldAccessorTable() {
                return MsgProto.internal_static_SubMessage1_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                SubMessage1.class, Builder.class);
            }

            // Construct using MsgProto.SubMessage1.newBuilder()
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
                field1_ = 0;
                field2_ = 0;
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return MsgProto.internal_static_SubMessage1_descriptor;
            }

            @Override
            public SubMessage1 getDefaultInstanceForType() {
                return SubMessage1.getDefaultInstance();
            }

            @Override
            public SubMessage1 build() {
                SubMessage1 result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public SubMessage1 buildPartial() {
                SubMessage1 result = new SubMessage1(this);
                if (bitField0_ != 0) {
                    buildPartial0(result);
                }
                onBuilt();
                return result;
            }

            private void buildPartial0(SubMessage1 result) {
                int from_bitField0_ = bitField0_;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    result.field1_ = field1_;
                }
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    result.field2_ = field2_;
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
                if (other instanceof SubMessage1) {
                    return mergeFrom((SubMessage1) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(SubMessage1 other) {
                if (other == SubMessage1.getDefaultInstance()) return this;
                if (other.getField1() != 0) {
                    setField1(other.getField1());
                }
                if (other.getField2() != 0) {
                    setField2(other.getField2());
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
                            case 8: {
                                field1_ = input.readInt32();
                                bitField0_ |= 0x00000001;
                                break;
                            } // case 8
                            case 16: {
                                field2_ = input.readInt32();
                                bitField0_ |= 0x00000002;
                                break;
                            } // case 16
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

            private int field1_;

            /**
             * <code>int32 field1 = 1;</code>
             *
             * @return The field1.
             */
            @Override
            public int getField1() {
                return field1_;
            }

            /**
             * <code>int32 field1 = 1;</code>
             *
             * @param value The field1 to set.
             * @return This builder for chaining.
             */
            public Builder setField1(int value) {

                field1_ = value;
                bitField0_ |= 0x00000001;
                onChanged();
                return this;
            }

            /**
             * <code>int32 field1 = 1;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearField1() {
                bitField0_ = (bitField0_ & ~0x00000001);
                field1_ = 0;
                onChanged();
                return this;
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


            // @@protoc_insertion_point(builder_scope:SubMessage1)
        }

        // @@protoc_insertion_point(class_scope:SubMessage1)
        private static final SubMessage1 DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new SubMessage1();
        }

        public static SubMessage1 getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<SubMessage1>
                PARSER = new com.google.protobuf.AbstractParser<SubMessage1>() {
            @Override
            public SubMessage1 parsePartialFrom(
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

        public static com.google.protobuf.Parser<SubMessage1> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<SubMessage1> getParserForType() {
            return PARSER;
        }

        @Override
        public SubMessage1 getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface SubMessage2OrBuilder extends
            // @@protoc_insertion_point(interface_extends:SubMessage2)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>int32 field1 = 1;</code>
         *
         * @return The field1.
         */
        int getField1();

        /**
         * <code>string field2 = 2;</code>
         *
         * @return The field2.
         */
        String getField2();

        /**
         * <code>string field2 = 2;</code>
         *
         * @return The bytes for field2.
         */
        com.google.protobuf.ByteString
        getField2Bytes();
    }

    /**
     * Protobuf type {@code SubMessage2}
     */
    public static final class SubMessage2 extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:SubMessage2)
            SubMessage2OrBuilder {
        private static final long serialVersionUID = 0L;

        // Use SubMessage2.newBuilder() to construct.
        private SubMessage2(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private SubMessage2() {
            field2_ = "";
        }

        @Override
        @SuppressWarnings({"unused"})
        protected Object newInstance(
                UnusedPrivateParameter unused) {
            return new SubMessage2();
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return MsgProto.internal_static_SubMessage2_descriptor;
        }

        @Override
        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return MsgProto.internal_static_SubMessage2_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            SubMessage2.class, Builder.class);
        }

        public static final int FIELD1_FIELD_NUMBER = 1;
        private int field1_ = 0;

        /**
         * <code>int32 field1 = 1;</code>
         *
         * @return The field1.
         */
        @Override
        public int getField1() {
            return field1_;
        }

        public static final int FIELD2_FIELD_NUMBER = 2;
        @SuppressWarnings("serial")
        private volatile Object field2_ = "";

        /**
         * <code>string field2 = 2;</code>
         *
         * @return The field2.
         */
        @Override
        public String getField2() {
            Object ref = field2_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                field2_ = s;
                return s;
            }
        }

        /**
         * <code>string field2 = 2;</code>
         *
         * @return The bytes for field2.
         */
        @Override
        public com.google.protobuf.ByteString
        getField2Bytes() {
            Object ref = field2_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                field2_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
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
            if (field1_ != 0) {
                output.writeInt32(1, field1_);
            }
            if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(field2_)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, field2_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (field1_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(1, field1_);
            }
            if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(field2_)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, field2_);
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
            if (!(obj instanceof SubMessage2)) {
                return super.equals(obj);
            }
            SubMessage2 other = (SubMessage2) obj;

            if (getField1()
                    != other.getField1()) return false;
            if (!getField2()
                    .equals(other.getField2())) return false;
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
            hash = (37 * hash) + FIELD1_FIELD_NUMBER;
            hash = (53 * hash) + getField1();
            hash = (37 * hash) + FIELD2_FIELD_NUMBER;
            hash = (53 * hash) + getField2().hashCode();
            hash = (29 * hash) + getUnknownFields().hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static SubMessage2 parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SubMessage2 parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SubMessage2 parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SubMessage2 parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SubMessage2 parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SubMessage2 parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SubMessage2 parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static SubMessage2 parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SubMessage2 parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static SubMessage2 parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SubMessage2 parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static SubMessage2 parseFrom(
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

        public static Builder newBuilder(SubMessage2 prototype) {
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
         * Protobuf type {@code SubMessage2}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:SubMessage2)
                SubMessage2OrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return MsgProto.internal_static_SubMessage2_descriptor;
            }

            @Override
            protected FieldAccessorTable
            internalGetFieldAccessorTable() {
                return MsgProto.internal_static_SubMessage2_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                SubMessage2.class, Builder.class);
            }

            // Construct using MsgProto.SubMessage2.newBuilder()
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
                field1_ = 0;
                field2_ = "";
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return MsgProto.internal_static_SubMessage2_descriptor;
            }

            @Override
            public SubMessage2 getDefaultInstanceForType() {
                return SubMessage2.getDefaultInstance();
            }

            @Override
            public SubMessage2 build() {
                SubMessage2 result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public SubMessage2 buildPartial() {
                SubMessage2 result = new SubMessage2(this);
                if (bitField0_ != 0) {
                    buildPartial0(result);
                }
                onBuilt();
                return result;
            }

            private void buildPartial0(SubMessage2 result) {
                int from_bitField0_ = bitField0_;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    result.field1_ = field1_;
                }
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    result.field2_ = field2_;
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
                if (other instanceof SubMessage2) {
                    return mergeFrom((SubMessage2) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(SubMessage2 other) {
                if (other == SubMessage2.getDefaultInstance()) return this;
                if (other.getField1() != 0) {
                    setField1(other.getField1());
                }
                if (!other.getField2().isEmpty()) {
                    field2_ = other.field2_;
                    bitField0_ |= 0x00000002;
                    onChanged();
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
                            case 8: {
                                field1_ = input.readInt32();
                                bitField0_ |= 0x00000001;
                                break;
                            } // case 8
                            case 18: {
                                field2_ = input.readStringRequireUtf8();
                                bitField0_ |= 0x00000002;
                                break;
                            } // case 18
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

            private int field1_;

            /**
             * <code>int32 field1 = 1;</code>
             *
             * @return The field1.
             */
            @Override
            public int getField1() {
                return field1_;
            }

            /**
             * <code>int32 field1 = 1;</code>
             *
             * @param value The field1 to set.
             * @return This builder for chaining.
             */
            public Builder setField1(int value) {

                field1_ = value;
                bitField0_ |= 0x00000001;
                onChanged();
                return this;
            }

            /**
             * <code>int32 field1 = 1;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearField1() {
                bitField0_ = (bitField0_ & ~0x00000001);
                field1_ = 0;
                onChanged();
                return this;
            }

            private Object field2_ = "";

            /**
             * <code>string field2 = 2;</code>
             *
             * @return The field2.
             */
            public String getField2() {
                Object ref = field2_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    field2_ = s;
                    return s;
                } else {
                    return (String) ref;
                }
            }

            /**
             * <code>string field2 = 2;</code>
             *
             * @return The bytes for field2.
             */
            public com.google.protobuf.ByteString
            getField2Bytes() {
                Object ref = field2_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    field2_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>string field2 = 2;</code>
             *
             * @param value The field2 to set.
             * @return This builder for chaining.
             */
            public Builder setField2(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                field2_ = value;
                bitField0_ |= 0x00000002;
                onChanged();
                return this;
            }

            /**
             * <code>string field2 = 2;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearField2() {
                field2_ = getDefaultInstance().getField2();
                bitField0_ = (bitField0_ & ~0x00000002);
                onChanged();
                return this;
            }

            /**
             * <code>string field2 = 2;</code>
             *
             * @param value The bytes for field2 to set.
             * @return This builder for chaining.
             */
            public Builder setField2Bytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);
                field2_ = value;
                bitField0_ |= 0x00000002;
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


            // @@protoc_insertion_point(builder_scope:SubMessage2)
        }

        // @@protoc_insertion_point(class_scope:SubMessage2)
        private static final SubMessage2 DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new SubMessage2();
        }

        public static SubMessage2 getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<SubMessage2>
                PARSER = new com.google.protobuf.AbstractParser<SubMessage2>() {
            @Override
            public SubMessage2 parsePartialFrom(
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

        public static com.google.protobuf.Parser<SubMessage2> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<SubMessage2> getParserForType() {
            return PARSER;
        }

        @Override
        public SubMessage2 getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface MessageBytesExtraOrBuilder extends
            // @@protoc_insertion_point(interface_extends:MessageBytesExtra)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>.SubMessage1 message1 = 1;</code>
         *
         * @return Whether the message1 field is set.
         */
        boolean hasMessage1();

        /**
         * <code>.SubMessage1 message1 = 1;</code>
         *
         * @return The message1.
         */
        SubMessage1 getMessage1();

        /**
         * <code>.SubMessage1 message1 = 1;</code>
         */
        SubMessage1OrBuilder getMessage1OrBuilder();

        /**
         * <code>repeated .SubMessage2 message2 = 3;</code>
         */
        java.util.List<SubMessage2>
        getMessage2List();

        /**
         * <code>repeated .SubMessage2 message2 = 3;</code>
         */
        SubMessage2 getMessage2(int index);

        /**
         * <code>repeated .SubMessage2 message2 = 3;</code>
         */
        int getMessage2Count();

        /**
         * <code>repeated .SubMessage2 message2 = 3;</code>
         */
        java.util.List<? extends SubMessage2OrBuilder>
        getMessage2OrBuilderList();

        /**
         * <code>repeated .SubMessage2 message2 = 3;</code>
         */
        SubMessage2OrBuilder getMessage2OrBuilder(
                int index);
    }

    /**
     * Protobuf type {@code MessageBytesExtra}
     */
    public static final class MessageBytesExtra extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:MessageBytesExtra)
            MessageBytesExtraOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use MessageBytesExtra.newBuilder() to construct.
        private MessageBytesExtra(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private MessageBytesExtra() {
            message2_ = java.util.Collections.emptyList();
        }

        @Override
        @SuppressWarnings({"unused"})
        protected Object newInstance(
                UnusedPrivateParameter unused) {
            return new MessageBytesExtra();
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return MsgProto.internal_static_MessageBytesExtra_descriptor;
        }

        @Override
        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return MsgProto.internal_static_MessageBytesExtra_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            MessageBytesExtra.class, Builder.class);
        }

        private int bitField0_;
        public static final int MESSAGE1_FIELD_NUMBER = 1;
        private SubMessage1 message1_;

        /**
         * <code>.SubMessage1 message1 = 1;</code>
         *
         * @return Whether the message1 field is set.
         */
        @Override
        public boolean hasMessage1() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <code>.SubMessage1 message1 = 1;</code>
         *
         * @return The message1.
         */
        @Override
        public SubMessage1 getMessage1() {
            return message1_ == null ? SubMessage1.getDefaultInstance() : message1_;
        }

        /**
         * <code>.SubMessage1 message1 = 1;</code>
         */
        @Override
        public SubMessage1OrBuilder getMessage1OrBuilder() {
            return message1_ == null ? SubMessage1.getDefaultInstance() : message1_;
        }

        public static final int MESSAGE2_FIELD_NUMBER = 3;
        @SuppressWarnings("serial")
        private java.util.List<SubMessage2> message2_;

        /**
         * <code>repeated .SubMessage2 message2 = 3;</code>
         */
        @Override
        public java.util.List<SubMessage2> getMessage2List() {
            return message2_;
        }

        /**
         * <code>repeated .SubMessage2 message2 = 3;</code>
         */
        @Override
        public java.util.List<? extends SubMessage2OrBuilder>
        getMessage2OrBuilderList() {
            return message2_;
        }

        /**
         * <code>repeated .SubMessage2 message2 = 3;</code>
         */
        @Override
        public int getMessage2Count() {
            return message2_.size();
        }

        /**
         * <code>repeated .SubMessage2 message2 = 3;</code>
         */
        @Override
        public SubMessage2 getMessage2(int index) {
            return message2_.get(index);
        }

        /**
         * <code>repeated .SubMessage2 message2 = 3;</code>
         */
        @Override
        public SubMessage2OrBuilder getMessage2OrBuilder(
                int index) {
            return message2_.get(index);
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
            if (((bitField0_ & 0x00000001) != 0)) {
                output.writeMessage(1, getMessage1());
            }
            for (int i = 0; i < message2_.size(); i++) {
                output.writeMessage(3, message2_.get(i));
            }
            getUnknownFields().writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(1, getMessage1());
            }
            for (int i = 0; i < message2_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(3, message2_.get(i));
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
            if (!(obj instanceof MessageBytesExtra)) {
                return super.equals(obj);
            }
            MessageBytesExtra other = (MessageBytesExtra) obj;

            if (hasMessage1() != other.hasMessage1()) return false;
            if (hasMessage1()) {
                if (!getMessage1()
                        .equals(other.getMessage1())) return false;
            }
            if (!getMessage2List()
                    .equals(other.getMessage2List())) return false;
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
            if (hasMessage1()) {
                hash = (37 * hash) + MESSAGE1_FIELD_NUMBER;
                hash = (53 * hash) + getMessage1().hashCode();
            }
            if (getMessage2Count() > 0) {
                hash = (37 * hash) + MESSAGE2_FIELD_NUMBER;
                hash = (53 * hash) + getMessage2List().hashCode();
            }
            hash = (29 * hash) + getUnknownFields().hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static MessageBytesExtra parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MessageBytesExtra parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageBytesExtra parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MessageBytesExtra parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageBytesExtra parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MessageBytesExtra parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageBytesExtra parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static MessageBytesExtra parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MessageBytesExtra parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static MessageBytesExtra parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MessageBytesExtra parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static MessageBytesExtra parseFrom(
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

        public static Builder newBuilder(MessageBytesExtra prototype) {
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
         * Protobuf type {@code MessageBytesExtra}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:MessageBytesExtra)
                MessageBytesExtraOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return MsgProto.internal_static_MessageBytesExtra_descriptor;
            }

            @Override
            protected FieldAccessorTable
            internalGetFieldAccessorTable() {
                return MsgProto.internal_static_MessageBytesExtra_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                MessageBytesExtra.class, Builder.class);
            }

            // Construct using MsgProto.MessageBytesExtra.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getMessage1FieldBuilder();
                    getMessage2FieldBuilder();
                }
            }

            @Override
            public Builder clear() {
                super.clear();
                bitField0_ = 0;
                message1_ = null;
                if (message1Builder_ != null) {
                    message1Builder_.dispose();
                    message1Builder_ = null;
                }
                if (message2Builder_ == null) {
                    message2_ = java.util.Collections.emptyList();
                } else {
                    message2_ = null;
                    message2Builder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return MsgProto.internal_static_MessageBytesExtra_descriptor;
            }

            @Override
            public MessageBytesExtra getDefaultInstanceForType() {
                return MessageBytesExtra.getDefaultInstance();
            }

            @Override
            public MessageBytesExtra build() {
                MessageBytesExtra result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public MessageBytesExtra buildPartial() {
                MessageBytesExtra result = new MessageBytesExtra(this);
                buildPartialRepeatedFields(result);
                if (bitField0_ != 0) {
                    buildPartial0(result);
                }
                onBuilt();
                return result;
            }

            private void buildPartialRepeatedFields(MessageBytesExtra result) {
                if (message2Builder_ == null) {
                    if (((bitField0_ & 0x00000002) != 0)) {
                        message2_ = java.util.Collections.unmodifiableList(message2_);
                        bitField0_ = (bitField0_ & ~0x00000002);
                    }
                    result.message2_ = message2_;
                } else {
                    result.message2_ = message2Builder_.build();
                }
            }

            private void buildPartial0(MessageBytesExtra result) {
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    result.message1_ = message1Builder_ == null
                            ? message1_
                            : message1Builder_.build();
                    to_bitField0_ |= 0x00000001;
                }
                result.bitField0_ |= to_bitField0_;
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
                if (other instanceof MessageBytesExtra) {
                    return mergeFrom((MessageBytesExtra) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(MessageBytesExtra other) {
                if (other == MessageBytesExtra.getDefaultInstance()) return this;
                if (other.hasMessage1()) {
                    mergeMessage1(other.getMessage1());
                }
                if (message2Builder_ == null) {
                    if (!other.message2_.isEmpty()) {
                        if (message2_.isEmpty()) {
                            message2_ = other.message2_;
                            bitField0_ = (bitField0_ & ~0x00000002);
                        } else {
                            ensureMessage2IsMutable();
                            message2_.addAll(other.message2_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.message2_.isEmpty()) {
                        if (message2Builder_.isEmpty()) {
                            message2Builder_.dispose();
                            message2Builder_ = null;
                            message2_ = other.message2_;
                            bitField0_ = (bitField0_ & ~0x00000002);
                            message2Builder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                            getMessage2FieldBuilder() : null;
                        } else {
                            message2Builder_.addAllMessages(other.message2_);
                        }
                    }
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
                                input.readMessage(
                                        getMessage1FieldBuilder().getBuilder(),
                                        extensionRegistry);
                                bitField0_ |= 0x00000001;
                                break;
                            } // case 10
                            case 26: {
                                SubMessage2 m =
                                        input.readMessage(
                                                SubMessage2.parser(),
                                                extensionRegistry);
                                if (message2Builder_ == null) {
                                    ensureMessage2IsMutable();
                                    message2_.add(m);
                                } else {
                                    message2Builder_.addMessage(m);
                                }
                                break;
                            } // case 26
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

            private SubMessage1 message1_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    SubMessage1, SubMessage1.Builder, SubMessage1OrBuilder> message1Builder_;

            /**
             * <code>.SubMessage1 message1 = 1;</code>
             *
             * @return Whether the message1 field is set.
             */
            public boolean hasMessage1() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <code>.SubMessage1 message1 = 1;</code>
             *
             * @return The message1.
             */
            public SubMessage1 getMessage1() {
                if (message1Builder_ == null) {
                    return message1_ == null ? SubMessage1.getDefaultInstance() : message1_;
                } else {
                    return message1Builder_.getMessage();
                }
            }

            /**
             * <code>.SubMessage1 message1 = 1;</code>
             */
            public Builder setMessage1(SubMessage1 value) {
                if (message1Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    message1_ = value;
                } else {
                    message1Builder_.setMessage(value);
                }
                bitField0_ |= 0x00000001;
                onChanged();
                return this;
            }

            /**
             * <code>.SubMessage1 message1 = 1;</code>
             */
            public Builder setMessage1(
                    SubMessage1.Builder builderForValue) {
                if (message1Builder_ == null) {
                    message1_ = builderForValue.build();
                } else {
                    message1Builder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000001;
                onChanged();
                return this;
            }

            /**
             * <code>.SubMessage1 message1 = 1;</code>
             */
            public Builder mergeMessage1(SubMessage1 value) {
                if (message1Builder_ == null) {
                    if (((bitField0_ & 0x00000001) != 0) &&
                            message1_ != null &&
                            message1_ != SubMessage1.getDefaultInstance()) {
                        getMessage1Builder().mergeFrom(value);
                    } else {
                        message1_ = value;
                    }
                } else {
                    message1Builder_.mergeFrom(value);
                }
                if (message1_ != null) {
                    bitField0_ |= 0x00000001;
                    onChanged();
                }
                return this;
            }

            /**
             * <code>.SubMessage1 message1 = 1;</code>
             */
            public Builder clearMessage1() {
                bitField0_ = (bitField0_ & ~0x00000001);
                message1_ = null;
                if (message1Builder_ != null) {
                    message1Builder_.dispose();
                    message1Builder_ = null;
                }
                onChanged();
                return this;
            }

            /**
             * <code>.SubMessage1 message1 = 1;</code>
             */
            public SubMessage1.Builder getMessage1Builder() {
                bitField0_ |= 0x00000001;
                onChanged();
                return getMessage1FieldBuilder().getBuilder();
            }

            /**
             * <code>.SubMessage1 message1 = 1;</code>
             */
            public SubMessage1OrBuilder getMessage1OrBuilder() {
                if (message1Builder_ != null) {
                    return message1Builder_.getMessageOrBuilder();
                } else {
                    return message1_ == null ?
                            SubMessage1.getDefaultInstance() : message1_;
                }
            }

            /**
             * <code>.SubMessage1 message1 = 1;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    SubMessage1, SubMessage1.Builder, SubMessage1OrBuilder>
            getMessage1FieldBuilder() {
                if (message1Builder_ == null) {
                    message1Builder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            SubMessage1, SubMessage1.Builder, SubMessage1OrBuilder>(
                            getMessage1(),
                            getParentForChildren(),
                            isClean());
                    message1_ = null;
                }
                return message1Builder_;
            }

            private java.util.List<SubMessage2> message2_ =
                    java.util.Collections.emptyList();

            private void ensureMessage2IsMutable() {
                if (!((bitField0_ & 0x00000002) != 0)) {
                    message2_ = new java.util.ArrayList<SubMessage2>(message2_);
                    bitField0_ |= 0x00000002;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    SubMessage2, SubMessage2.Builder, SubMessage2OrBuilder> message2Builder_;

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public java.util.List<SubMessage2> getMessage2List() {
                if (message2Builder_ == null) {
                    return java.util.Collections.unmodifiableList(message2_);
                } else {
                    return message2Builder_.getMessageList();
                }
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public int getMessage2Count() {
                if (message2Builder_ == null) {
                    return message2_.size();
                } else {
                    return message2Builder_.getCount();
                }
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public SubMessage2 getMessage2(int index) {
                if (message2Builder_ == null) {
                    return message2_.get(index);
                } else {
                    return message2Builder_.getMessage(index);
                }
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public Builder setMessage2(
                    int index, SubMessage2 value) {
                if (message2Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMessage2IsMutable();
                    message2_.set(index, value);
                    onChanged();
                } else {
                    message2Builder_.setMessage(index, value);
                }
                return this;
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public Builder setMessage2(
                    int index, SubMessage2.Builder builderForValue) {
                if (message2Builder_ == null) {
                    ensureMessage2IsMutable();
                    message2_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    message2Builder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public Builder addMessage2(SubMessage2 value) {
                if (message2Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMessage2IsMutable();
                    message2_.add(value);
                    onChanged();
                } else {
                    message2Builder_.addMessage(value);
                }
                return this;
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public Builder addMessage2(
                    int index, SubMessage2 value) {
                if (message2Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMessage2IsMutable();
                    message2_.add(index, value);
                    onChanged();
                } else {
                    message2Builder_.addMessage(index, value);
                }
                return this;
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public Builder addMessage2(
                    SubMessage2.Builder builderForValue) {
                if (message2Builder_ == null) {
                    ensureMessage2IsMutable();
                    message2_.add(builderForValue.build());
                    onChanged();
                } else {
                    message2Builder_.addMessage(builderForValue.build());
                }
                return this;
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public Builder addMessage2(
                    int index, SubMessage2.Builder builderForValue) {
                if (message2Builder_ == null) {
                    ensureMessage2IsMutable();
                    message2_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    message2Builder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public Builder addAllMessage2(
                    Iterable<? extends SubMessage2> values) {
                if (message2Builder_ == null) {
                    ensureMessage2IsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                            values, message2_);
                    onChanged();
                } else {
                    message2Builder_.addAllMessages(values);
                }
                return this;
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public Builder clearMessage2() {
                if (message2Builder_ == null) {
                    message2_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000002);
                    onChanged();
                } else {
                    message2Builder_.clear();
                }
                return this;
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public Builder removeMessage2(int index) {
                if (message2Builder_ == null) {
                    ensureMessage2IsMutable();
                    message2_.remove(index);
                    onChanged();
                } else {
                    message2Builder_.remove(index);
                }
                return this;
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public SubMessage2.Builder getMessage2Builder(
                    int index) {
                return getMessage2FieldBuilder().getBuilder(index);
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public SubMessage2OrBuilder getMessage2OrBuilder(
                    int index) {
                if (message2Builder_ == null) {
                    return message2_.get(index);
                } else {
                    return message2Builder_.getMessageOrBuilder(index);
                }
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public java.util.List<? extends SubMessage2OrBuilder>
            getMessage2OrBuilderList() {
                if (message2Builder_ != null) {
                    return message2Builder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(message2_);
                }
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public SubMessage2.Builder addMessage2Builder() {
                return getMessage2FieldBuilder().addBuilder(
                        SubMessage2.getDefaultInstance());
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public SubMessage2.Builder addMessage2Builder(
                    int index) {
                return getMessage2FieldBuilder().addBuilder(
                        index, SubMessage2.getDefaultInstance());
            }

            /**
             * <code>repeated .SubMessage2 message2 = 3;</code>
             */
            public java.util.List<SubMessage2.Builder>
            getMessage2BuilderList() {
                return getMessage2FieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    SubMessage2, SubMessage2.Builder, SubMessage2OrBuilder>
            getMessage2FieldBuilder() {
                if (message2Builder_ == null) {
                    message2Builder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            SubMessage2, SubMessage2.Builder, SubMessage2OrBuilder>(
                            message2_,
                            ((bitField0_ & 0x00000002) != 0),
                            getParentForChildren(),
                            isClean());
                    message2_ = null;
                }
                return message2Builder_;
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


            // @@protoc_insertion_point(builder_scope:MessageBytesExtra)
        }

        // @@protoc_insertion_point(class_scope:MessageBytesExtra)
        private static final MessageBytesExtra DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new MessageBytesExtra();
        }

        public static MessageBytesExtra getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<MessageBytesExtra>
                PARSER = new com.google.protobuf.AbstractParser<MessageBytesExtra>() {
            @Override
            public MessageBytesExtra parsePartialFrom(
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

        public static com.google.protobuf.Parser<MessageBytesExtra> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<MessageBytesExtra> getParserForType() {
            return PARSER;
        }

        @Override
        public MessageBytesExtra getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_SubMessage1_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_SubMessage1_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_SubMessage2_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_SubMessage2_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_MessageBytesExtra_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_MessageBytesExtra_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        String[] descriptorData = {
                "\n\tMsg.proto\"-\n\013SubMessage1\022\016\n\006field1\030\001 \001" +
                        "(\005\022\016\n\006field2\030\002 \001(\005\"-\n\013SubMessage2\022\016\n\006fie" +
                        "ld1\030\001 \001(\005\022\016\n\006field2\030\002 \001(\t\"S\n\021MessageByte" +
                        "sExtra\022\036\n\010message1\030\001 \001(\0132\014.SubMessage1\022\036" +
                        "\n\010message2\030\003 \003(\0132\014.SubMessage2B\nB\010MsgPro" +
                        "tob\006proto3"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        });
        internal_static_SubMessage1_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_SubMessage1_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_SubMessage1_descriptor,
                new String[]{"Field1", "Field2",});
        internal_static_SubMessage2_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_SubMessage2_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_SubMessage2_descriptor,
                new String[]{"Field1", "Field2",});
        internal_static_MessageBytesExtra_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_MessageBytesExtra_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_MessageBytesExtra_descriptor,
                new String[]{"Message1", "Message2",});
    }
}
