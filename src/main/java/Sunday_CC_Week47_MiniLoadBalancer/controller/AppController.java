package Sunday_CC_Week47_MiniLoadBalancer.controller;

import Sunday_CC_Week47_MiniLoadBalancer.service.EntryService;
import Sunday_CC_Week47_MiniLoadBalancer.service.UserService;
import Sunday_CC_Week47_MiniLoadBalancer.config.DatabaseContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AppController {
    private final EntryService entryService;
    private final UserService userService;

    public AppController(EntryService entryService, UserService userService) {
        this.entryService = entryService;
        this.userService = userService;
    }

    @PostMapping("/entries")
    public ResponseEntity<Void> addEntry() {
        entryService.addEntry();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser() {
        userService.createUser();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("db1", entryService.getCount(DatabaseContext.DB1));
        status.put("db2", entryService.getCount(DatabaseContext.DB2));
        status.put("db3", entryService.getCount(DatabaseContext.DB3));
        status.put("activeUsers", userService.getActiveUserCount());
        return ResponseEntity.ok(status);
    }
}
