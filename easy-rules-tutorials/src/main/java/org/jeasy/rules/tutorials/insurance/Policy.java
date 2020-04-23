package org.jeasy.rules.tutorials.insurance;

import java.util.List;


public class Policy {

    private List<Coverage> coverages;

    private String distChannelCategory;

    private String distChannelCode;

    private String paymentMode;

    public List<Coverage> getCoverages() {
        return coverages;
    }

    public void setCoverages(List<Coverage> coverages) {
        this.coverages = coverages;
    }

    public String getDistChannelCategory() {
        return distChannelCategory;
    }

    public void setDistChannelCategory(String distChannelCategory) {
        this.distChannelCategory = distChannelCategory;
    }

    public String getDistChannelCode() {
        return distChannelCode;
    }

    public void setDistChannelCode(String distChannelCode) {
        this.distChannelCode = distChannelCode;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}