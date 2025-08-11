package com.example.facade;

/**
 * Another subsystem service for loan-related queries.
 */
public class LoanService {

    /**
     * Example: return outstanding loan amount (simulated)
     */
    public double getOutstandingLoanAmount(String accountNo) {
        // Simulated outstanding amount
        return 50_000.00;
    }

    /**
     * Example eligibility check (always true in demo).
     */
    public boolean isEligibleForLoan(String accountNo) {
        return true;
    }
}
