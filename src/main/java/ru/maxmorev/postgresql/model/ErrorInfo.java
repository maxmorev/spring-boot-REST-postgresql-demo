package ru.maxmorev.postgresql.model;

public class ErrorInfo {

    public final String status = "error";
    public final String url;
    public final String ex;

    public ErrorInfo(String url, Exception ex) {
        this.url = url;
        this.ex = ex.getLocalizedMessage();
    }

}
