package com.fujitsu.caac.framework.persistence.bean;

import java.math.BigDecimal;
import java.util.Date;

public class XJRiskStateBean {
    private BigDecimal id;

    private String stateName;

    private BigDecimal stateLevel;

    private BigDecimal displayIndex;

    private String creator;

    private Date creationDate;

    private String modifier;

    private Date modifyDate;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName == null ? null : stateName.trim();
    }

    public BigDecimal getStateLevel() {
        return stateLevel;
    }

    public void setStateLevel(BigDecimal stateLevel) {
        this.stateLevel = stateLevel;
    }

    public BigDecimal getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(BigDecimal displayIndex) {
        this.displayIndex = displayIndex;
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