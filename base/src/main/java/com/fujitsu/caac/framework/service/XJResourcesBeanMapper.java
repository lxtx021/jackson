package com.fujitsu.caac.framework.service;

import com.fujitsu.caac.framework.persistence.bean.XJResourcesBean;

public interface XJResourcesBeanMapper {
    int deleteByPrimaryKey(String id);

    int insert(XJResourcesBean record);

    int insertSelective(XJResourcesBean record);

    XJResourcesBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(XJResourcesBean record);

    int updateByPrimaryKey(XJResourcesBean record);
}