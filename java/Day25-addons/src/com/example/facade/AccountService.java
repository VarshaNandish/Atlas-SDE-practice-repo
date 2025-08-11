package com.example.facade;

/**
 * Small subsystem service for account-related operations.
 */
public class AccountService {

    /**
     * In a real system we'd check the DB. Here true if non-empty.
     */
    public boolean accountExists(String accountNo) {
        return accountNo != null && !accountNo.trim().isEmpty();
    }

    /**
     * Return account holder name for display/demo purposes.
     */
    public String getAccountHolderName(String accountNo) {
        // Dummy name for demo; real app would lookup name
        return "Kavya Sharma";
    }
}
