package com.example.facade;

/**
 * Subsystem class that would normally talk to DB or remote API
 * to fetch FD records. Here we simulate and return a dummy FdDetails.
 */
public class FdService {

    /**
     * Return FD details corresponding to an account number.
     * In real code this would perform DB lookup; here we return
     * a sample FD for demonstration.
     */
    public FdDetails getFdServiceDetails(String accountNo) {
        // Simulated data (in rupees, months, percentage)
        double principal = 100_000.00;   // 100k principal
        double rate = 6.5;               // 6.5% annual
        int tenureMonths = 12;           // 12 months
        return new FdDetails(accountNo, principal, rate, tenureMonths);
    }
}
