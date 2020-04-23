package org.jeasy.rules.tutorials.insurance;

import java.math.BigDecimal;
import java.util.Date;


public class Coverage {
    private String coverageKey;
    private String planCode;
    private String prodCode;
    private int faceAmount;
    private BigDecimal adjustPremium;
    private BigDecimal coveragePremium;
    private Client client;
    private Date effectDate;

    public String getCoverageKey() {
        return coverageKey;
    }

    public void setCoverageKey(String coverageKey) {
        this.coverageKey = coverageKey;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public int getFaceAmount() {
        return faceAmount;
    }

    public void setFaceAmount(int faceAmount) {
        this.faceAmount = faceAmount;
    }

    public BigDecimal getAdjustPremium() {
        return adjustPremium;
    }

    public void setAdjustPremium(BigDecimal adjustPremium) {
        this.adjustPremium = adjustPremium;
    }

    public BigDecimal getCoveragePremium() {
        return coveragePremium;
    }

    public void setCoveragePremium(BigDecimal coveragePremium) {
        this.coveragePremium = coveragePremium;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}