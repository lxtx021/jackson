package com.fujitsu.caac.framework.service;

import com.fujitsu.caac.framework.persistence.bean.XJRiskStateBean;
import java.math.BigDecimal;

public interface XJRiskStateBeanMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(XJRiskStateBean record);

    int insertSelective(XJRiskStateBean record);

    XJRiskStateBean selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(XJRiskStateBean record);

    int updateByPrimaryKey(XJRiskStateBean record);
}