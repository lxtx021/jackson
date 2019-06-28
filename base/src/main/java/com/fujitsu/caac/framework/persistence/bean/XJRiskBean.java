package com.fujitsu.caac.framework.persistence.bean;

import java.math.BigDecimal;
import java.util.Date;

public class XJRiskBean {
    private String id;

    private String title;

    private String sourceType;

    private String sourceTopic;

    private String riskType;

    private String postType;

    private String workFlow;

    private String reasonAnalysis;

    private String manageType;

    private String gradingStandard;

    private String treatmentMeasure;

    private String respUnit;

    private String resourceRequirements;

    private String rectificationPeriod;

    private String implementationMeasures;

    private BigDecimal status;

    private String creator;

    private Date creationDate;

    private String modifier;

    private Date modifyDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getSourceTopic() {
        return sourceTopic;
    }

    public void setSourceTopic(String sourceTopic) {
        this.sourceTopic = sourceTopic == null ? null : sourceTopic.trim();
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType == null ? null : riskType.trim();
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType == null ? null : postType.trim();
    }

    public String getWorkFlow() {
        return workFlow;
    }

    public void setWorkFlow(String workFlow) {
        this.workFlow = workFlow == null ? null : workFlow.trim();
    }

    public String getReasonAnalysis() {
        return reasonAnalysis;
    }

    public void setReasonAnalysis(String reasonAnalysis) {
        this.reasonAnalysis = reasonAnalysis == null ? null : reasonAnalysis.trim();
    }

    public String getManageType() {
        return manageType;
    }

    public void setManageType(String manageType) {
        this.manageType = manageType == null ? null : manageType.trim();
    }

    public String getGradingStandard() {
        return gradingStandard;
    }

    public void setGradingStandard(String gradingStandard) {
        this.gradingStandard = gradingStandard == null ? null : gradingStandard.trim();
    }

    public String getTreatmentMeasure() {
        return treatmentMeasure;
    }

    public void setTreatmentMeasure(String treatmentMeasure) {
        this.treatmentMeasure = treatmentMeasure == null ? null : treatmentMeasure.trim();
    }

    public String getRespUnit() {
        return respUnit;
    }

    public void setRespUnit(String respUnit) {
        this.respUnit = respUnit == null ? null : respUnit.trim();
    }

    public String getResourceRequirements() {
        return resourceRequirements;
    }

    public void setResourceRequirements(String resourceRequirements) {
        this.resourceRequirements = resourceRequirements == null ? null : resourceRequirements.trim();
    }

    public String getRectificationPeriod() {
        return rectificationPeriod;
    }

    public void setRectificationPeriod(String rectificationPeriod) {
        this.rectificationPeriod = rectificationPeriod == null ? null : rectificationPeriod.trim();
    }

    public String getImplementationMeasures() {
        return implementationMeasures;
    }

    public void setImplementationMeasures(String implementationMeasures) {
        this.implementationMeasures = implementationMeasures == null ? null : implementationMeasures.trim();
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
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