package pl.sdaacademy.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ping extends Task<PingResult> {

    public Ping(String url) {
        super(url);
    }

    @Override
    public PingResult call() throws Exception {
        return pingWebsite();
    }

    private PingResult pingWebsite() {

        PingStatus status;
        long time = 0;
        try {
            URL url = new URL(getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(getTimeout());
            connection.setRequestMethod("GET");
            long start = System.currentTimeMillis();
            status = connection.getResponseCode() == 200 ? PingStatus.SUCCESS : PingStatus.FAILED;
            long end = System.currentTimeMillis();
            time = end - start;
            connection.disconnect();
        }
        catch(IOException ex){
            status = PingStatus.FAILED;
        }
        return new PingResult(getUrl(), status, time);
    }

    @Override
    public int getTimeout() {
        return 10000;
    }
}
