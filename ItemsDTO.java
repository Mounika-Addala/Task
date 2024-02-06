package com.task.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public class ItemsDTO {
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message="code is required")
    private Integer code;
    @NotBlank(message = "uom is required")
    private String uom;
    @NotNull(message = "AvailableCount is required")
    private Integer availableCount;
    private String viewedBy;
    private int alertCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvilableCount(Integer availableCount) {
        this.availableCount = availableCount;
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
