package com.example.proxy;

/**
 * The real subject: performs the actual "database" actions.
 * In a real app this would connect to DB and execute queries.
 */
public class DB {
    public DB() {
        // Constructor - could open DB connection in a real implementation
    }

    /**
     * Simulated execution of a query by a given user.
     */
    public void runIt(String queryType, String userId) {
        System.out.println("Executing '" + queryType + "' for user: " + userId);
        // simulate some DB work...
    }
}
