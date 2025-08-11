package com.example.proxy;

import java.util.Objects;

/**
 * Protection / Virtual Proxy: controls access and lazily creates DB.
 */
public class DBProxy implements DBExecutor {
    private final String userId;
    private DB db; // real subject, created lazily

    /**
     * Construct proxy for a specific user.
     * @param userId identifier of the caller (e.g., "ADMIN", "MANAGER")
     */
    public DBProxy(String userId) {
        this.userId = userId;
    }

    /**
     * Proxy method that performs access checks and delegates to DB.
     */
    @Override
    public void runQuery(String queryType) {
        // Simple access control: only ADMIN can delete
        if ("DELETE".equalsIgnoreCase(queryType) && !"ADMIN".equalsIgnoreCase(userId)) {
            System.out.println("Access Denied: user '" + userId + "' cannot perform DELETE.");
            return;
        }

        // Lazy initialization of the real subject (virtual proxy)
        if (db == null) {
            db = new DB();
        }

        // Delegate to the real DB implementation
        db.runIt(queryType, userId);
    }
}
