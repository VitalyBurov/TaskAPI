package by.it.academy.MK_JD2_90_22.taskAPI.core.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private LocalDateTime dateAndTime;
    private String fromWhom;
    private String toWhom;
    private String content;


    public Message(String fromWhom, String toWhom, String content) {
        this.dateAndTime = LocalDateTime.now();
        this.fromWhom = fromWhom;
        this.toWhom = toWhom;
        this.content = content;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getFromWhom() {
        return fromWhom;
    }

    public void setFromWhom(String fromWhom) {
        this.fromWhom = fromWhom;
    }

    public String getToWhom() {
        return toWhom;
    }

    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = dateAndTime.format(format);
        return  formatDateTime + " - From " + fromWhom + "\n"
                +"Message: " + content;
    }
}