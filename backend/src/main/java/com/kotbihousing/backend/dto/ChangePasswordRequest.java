package com.kotbihousing.backend.dto;

public class ChangePasswordRequest {
    private String currentPassword;
    private String newPassword;

    public String getCurrentPassword() { return currentPassword; }
    public void setCurrentPassword(String c) { this.currentPassword = c; }
    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String n) { this.newPassword = n; }
}