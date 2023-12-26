package com.task.api.dto;

import org.springframework.validation.annotation.Validated;

@Validated
public class StationaryItemRequest  {


    private String name;
    private int code;

    private String uom;
    private String viewedBy;
    private int alertCount;

    public StationaryItemRequest() {
        this.name = name;
        this.code = code;
        this.uom = uom;
        this.viewedBy = viewedBy;
        this.alertCount = alertCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getViewedBy() {
        return viewedBy;
    }

    public void setViewedBy(String viewedBy) {
        this.viewedBy = viewedBy;
    }

    public int getAlertCount() {
        return alertCount;
    }

    public void setAlertCount(int alertCount) {
        this.alertCount = alertCount;
    }
}
