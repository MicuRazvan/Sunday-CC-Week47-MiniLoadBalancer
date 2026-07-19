package Sunday_CC_Week47_MiniLoadBalancer.repository;

import Sunday_CC_Week47_MiniLoadBalancer.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
}
