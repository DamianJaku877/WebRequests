package pl.sdaacademy.core;

public class PingResult {

    private String url;
    private PingStatus status;
    private long time;

    public PingResult(String url, PingStatus status, long time) {
        this.url = url;
        this.status = status;
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PingStatus getStatus() {
        return status;
    }

    public void setStatus(PingStatus status) {
        this.status = status;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PingResult{" +
                "url='" + url + '\'' +
                ", status=" + status +
                ", time=" + time +
                '}';
    }
}
