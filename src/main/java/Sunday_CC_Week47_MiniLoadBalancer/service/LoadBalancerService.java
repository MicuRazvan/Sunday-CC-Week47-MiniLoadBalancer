package Sunday_CC_Week47_MiniLoadBalancer.service;

import Sunday_CC_Week47_MiniLoadBalancer.config.DatabaseContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LoadBalancerService {
    private final AtomicInteger counter = new AtomicInteger(0);

    public DatabaseContext getNextDatabase() {
        int roll = ThreadLocalRandom.current().nextInt(10);

        // 10% chance to write in DB3
        if (roll == 0) {
            return DatabaseContext.DB3;
        }

        // 90% chance to write in DB1/2
        else {
            DatabaseContext[] baselineDbs = { DatabaseContext.DB1, DatabaseContext.DB2 };
            int index = Math.abs(counter.getAndIncrement() % baselineDbs.length);
            return baselineDbs[index];
        }
    }
}