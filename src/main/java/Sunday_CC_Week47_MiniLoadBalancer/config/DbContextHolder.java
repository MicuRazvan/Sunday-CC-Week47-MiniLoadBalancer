package Sunday_CC_Week47_MiniLoadBalancer.config;

public class DbContextHolder {
    private static final ThreadLocal<DatabaseContext> CONTEXT = new ThreadLocal<>();

    public static void setCurrentDb(DatabaseContext db) {
        CONTEXT.set(db);
    }

    public static DatabaseContext getCurrentDb() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}