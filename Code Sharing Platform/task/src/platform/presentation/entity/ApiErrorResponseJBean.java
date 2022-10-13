package platform.presentation.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ApiErrorResponseJBean implements Serializable {

    private String message;
    private String date;

    @JsonProperty
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ApiErrorResponseJBean{" +
                "message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
