package com.fujitsu.caac.framework.service;

import com.fujitsu.caac.framework.persistence.bean.XJTraceAttachmentsBean;
import com.fujitsu.caac.framework.persistence.bean.XJTraceAttachmentsBeanKey;

public interface XJTraceAttachmentsBeanMapper {
    int deleteByPrimaryKey(XJTraceAttachmentsBeanKey key);

    int insert(XJTraceAttachmentsBean record);

    int insertSelective(XJTraceAttachmentsBean record);

    XJTraceAttachmentsBean selectByPrimaryKey(XJTraceAttachmentsBeanKey key);

    int updateByPrimaryKeySelective(XJTraceAttachmentsBean record);

    int updateByPrimaryKey(XJTraceAttachmentsBean record);
}