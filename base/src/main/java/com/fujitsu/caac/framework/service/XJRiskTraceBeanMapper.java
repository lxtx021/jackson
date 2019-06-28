package com.fujitsu.caac.framework.service;

import com.fujitsu.caac.framework.persistence.bean.XJRiskTraceBean;

public interface XJRiskTraceBeanMapper {
    int deleteByPrimaryKey(String traceId);

    int insert(XJRiskTraceBean record);

    int insertSelective(XJRiskTraceBean record);

    XJRiskTraceBean selectByPrimaryKey(String traceId);

    int updateByPrimaryKeySelective(XJRiskTraceBean record);

    int updateByPrimaryKey(XJRiskTraceBean record);
}