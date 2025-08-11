package com.example.proxy;

/**
 * Common interface for both the real DB executor and its proxy.
 */
public interface DBExecutor {
    /**
     * Run a simple query type (e.g., READ, UPDATE, DELETE).
     * The proxy and the real DB class implement this method.
     */
    void runQuery(String queryType);
}
