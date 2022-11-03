package Entities;

import javax.json.bind.annotation.JsonbProperty;

public class Request {

    @JsonbProperty("id")
    public String id;
    @JsonbProperty("dataString")
    public String dataString;

    public Request(String id, String dataString) {
        this.id = id;
        this.dataString = dataString;
    }

    public Request() {}

    @Override
    public String toString() {
        return "{Id=" + id + ", dataString=" + dataString + "}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }
}