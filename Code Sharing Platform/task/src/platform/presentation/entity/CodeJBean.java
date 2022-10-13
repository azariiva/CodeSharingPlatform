package platform.presentation.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CodeJBean implements Serializable {

    private String code;
    private String date;
    private long time;
    private int views;

    @JsonProperty
    public String getCode() {
        return code;
    }

    @JsonProperty
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty
    public String getDate() {
        return date;
    }

    @JsonIgnore
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty(defaultValue = "0")
    public long getTime() {
        return time;
    }

    @JsonProperty
    public void setTime(long time) {
        this.time = time;
    }

    @JsonProperty(defaultValue = "0")
    public int getViews() {
        return views;
    }

    @JsonProperty
    public void setViews(int views) {
        this.views = views;
    }
}
