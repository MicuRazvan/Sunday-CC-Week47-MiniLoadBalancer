package Sunday_CC_Week47_MiniLoadBalancer.service;

import Sunday_CC_Week47_MiniLoadBalancer.config.DatabaseContext;
import Sunday_CC_Week47_MiniLoadBalancer.config.DbContextHolder;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
    private final TransactionalDatabaseService transactionalDbService;
    private final LoadBalancerService loadBalancer;

    public EntryService(TransactionalDatabaseService transactionalDbService, LoadBalancerService loadBalancer) {
        this.transactionalDbService = transactionalDbService;
        this.loadBalancer = loadBalancer;
    }

    public void addEntry() {
        DatabaseContext targetDb = loadBalancer.getNextDatabase();
        DbContextHolder.setCurrentDb(targetDb);
        try {
            transactionalDbService.save();
        } finally {
            DbContextHolder.clear();
        }
    }

    public long getCount(DatabaseContext db) {
        DbContextHolder.setCurrentDb(db);
        try {
            return transactionalDbService.count();
        } finally {
            DbContextHolder.clear();
        }
    }
}
