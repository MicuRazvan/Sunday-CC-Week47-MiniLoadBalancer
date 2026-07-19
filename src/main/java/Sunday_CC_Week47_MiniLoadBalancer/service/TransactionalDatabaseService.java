package Sunday_CC_Week47_MiniLoadBalancer.service;

import Sunday_CC_Week47_MiniLoadBalancer.model.Entry;
import Sunday_CC_Week47_MiniLoadBalancer.repository.EntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalDatabaseService {
    private final EntryRepository repository;

    public TransactionalDatabaseService(EntryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void save() {
        repository.save(new Entry());
    }

    @Transactional(readOnly = true)
    public long count() {
        return repository.count();
    }
}
