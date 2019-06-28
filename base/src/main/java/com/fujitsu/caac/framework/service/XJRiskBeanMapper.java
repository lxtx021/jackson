package com.fujitsu.caac.framework.service;

import com.fujitsu.caac.framework.persistence.bean.XJRiskBean;

public interface XJRiskBeanMapper {
    int deleteByPrimaryKey(String id);

    int insert(XJRiskBean record);

    int insertSelective(XJRiskBean record);

    XJRiskBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(XJRiskBean record);

    int updateByPrimaryKey(XJRiskBean record);
}