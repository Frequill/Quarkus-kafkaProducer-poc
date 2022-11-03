package Entities;

public class Response {

    public String id;
    public String container;
    public String message;

    public Response(String id, String container, String message) {
        this.id = id;
        this.container = container;
        this.message = message;
    }

    public Response() {}

    @Override
    public String toString() {
        return "{Id=" + id + ", container=" + container + ", message=" + message + "}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}