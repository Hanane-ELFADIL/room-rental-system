package com.kotbihousing.backend.dto;

import java.time.LocalDate;

public class CreateRentalRequestDTO {

    private Long roomId;

    private String studentName;
    private String studentEmail;
    private String studentPhone;

    private LocalDate moveInDate;
    private String duration;
    private String message;

    public Long getRoomId() { return roomId; }
    public void setRoomId(Long roomId) { this.roomId = roomId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getStudentEmail() { return studentEmail; }
    public void setStudentEmail(String studentEmail) { this.studentEmail = studentEmail; }

    public String getStudentPhone() { return studentPhone; }
    public void setStudentPhone(String studentPhone) { this.studentPhone = studentPhone; }

    public LocalDate getMoveInDate() { return moveInDate; }
    public void setMoveInDate(LocalDate moveInDate) { this.moveInDate = moveInDate; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}