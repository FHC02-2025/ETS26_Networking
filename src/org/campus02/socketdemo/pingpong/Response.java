package org.campus02.socketdemo.pingpong;

import java.io.Serializable;

public class Response implements Serializable {

    // Server antwortet mit Response(200, "PING | PONG")
    // Server antwortet mit Response(500, "ERROR")

    private int status;
    private String message;

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
