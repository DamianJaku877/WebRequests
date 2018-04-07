package pl.sdaacademy;

import pl.sdaacademy.core.Ping;
import pl.sdaacademy.core.PingResult;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    //http://www.javapractices.com/topic/TopicAction.do?Id=247
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<PingResult>> results = executor.invokeAll(Arrays.asList(
                new Ping("http://www.wzieu.pl/"),
                new Ping("https://www.onet.pl/"),
                new Ping("http://cdn.wonderfulengineering.com/wp-content/uploads/2014/03/high-resolution-wallpapers-1.jpg"),
                new Ping("http://www.star-wars.pl/"),
                new Ping("https://www.wp.pl/")
        ));
        for (Future<PingResult> task : results) {
            System.out.println(task.get());
        }
        executor.shutdown();
    }
}
