package pl.sdaacademy.core;

import java.util.concurrent.Callable;

public abstract class Task<T> implements Callable<T> {

    private String url;

    public Task(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public abstract int getTimeout();
}
