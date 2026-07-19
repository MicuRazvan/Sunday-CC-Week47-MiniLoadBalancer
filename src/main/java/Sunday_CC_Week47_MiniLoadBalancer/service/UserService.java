package Sunday_CC_Week47_MiniLoadBalancer.service;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.*;

@Service
public class UserService {
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
    private final List<ScheduledFuture<?>> activeUsers = new CopyOnWriteArrayList<>();
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${server.port:8080}")
    private int port;

    public void createUser() {
        ScheduledFuture<?> future = executorService.scheduleAtFixedRate(() -> {
            try {
                String url = "http://localhost:" + port + "/api/entries";
                restTemplate.postForEntity(url, null, Void.class);
            } catch (Exception e) {
                System.err.println("Request execution failed: " + e.getMessage());
            }
        }, 0, 1, TimeUnit.SECONDS);
        activeUsers.add(future);
    }

    public int getActiveUserCount() {
        return activeUsers.size();
    }

    @PreDestroy
    public void shutdown() {
        executorService.shutdown();
    }
}
