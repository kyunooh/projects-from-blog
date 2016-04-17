package hello;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application implements CommandLineRunner {

    @Autowired
    GitHubLookupService gitHubLookupService;

    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");

        // Wait until they are all done
        //while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
          //  Thread.sleep(10); //10-millisecond pause between each check
        //}

        //wait until all they are completed.
        CompletableFuture.allOf(page1,page2,page3);
        //I could join as well if interested.

        // Print results, including elapsed time
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start) +" ms");
        System.out.println(page1.get());
        System.out.println(page2.get());
        System.out.println(page3.get());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
