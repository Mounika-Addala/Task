package com.task.api.dto;

public class UpdateAlertCount {
    private String _id;
    private int alertCount;

    public UpdateAlertCount(String _id, int alertCount) {
        this._id = _id;
        this.alertCount = alertCount;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getAlertCount() {
        return alertCount;
    }

    public void setAlertCount(int alertCount) {
        this.alertCount = alertCount;
    }
}
