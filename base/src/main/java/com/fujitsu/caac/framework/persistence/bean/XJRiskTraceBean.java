package com.fujitsu.caac.framework.persistence.bean;

import java.math.BigDecimal;
import java.util.Date;

public class XJRiskTraceBean {
    private String traceId;

    private String riskId;

    private BigDecimal riskStatus;

    private String creator;

    private Date creationDate;

    private String modifier;

    private Date modifyDate;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId == null ? null : traceId.trim();
    }

    public String getRiskId() {
        return riskId;
    }

    public void setRiskId(String riskId) {
        this.riskId = riskId == null ? null : riskId.trim();
    }

    public BigDecimal getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(BigDecimal riskStatus) {
        this.riskStatus = riskStatus;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}