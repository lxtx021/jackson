package com.fujitsu.caac.framework.service;

import com.fujitsu.caac.framework.persistence.bean.XJTraceAttachmentsBean;


public interface XJTraceAttachmentsBeanMapper {

    int insert(XJTraceAttachmentsBean record);

    int insertSelective(XJTraceAttachmentsBean record);


    int updateByPrimaryKeySelective(XJTraceAttachmentsBean record);

    int updateByPrimaryKey(XJTraceAttachmentsBean record);
}