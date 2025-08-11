package com.example.facade;

/**
 * The Facade: simplifies access to the bank subsystem.
 * Clients use this class instead of calling multiple services.
 */
public class BankFacade {

    // list of services that the facade coordinates
    private final AccountService accountService;
    private final FdService fdService;
    private final LoanService loanService;

    // constructor wires the subsystem components
    public BankFacade() {
        this.accountService = new AccountService();
        this.fdService = new FdService();
        this.loanService = new LoanService();
    }

    /**
     * Facade method: get raw FD details for an account.
     * This hides the need for the client to know about FdService.
     */
    public FdDetails getFdServiceDetails(String accountNo) {
        if (!accountService.accountExists(accountNo)) {
            throw new IllegalArgumentException("Account not found: " + accountNo);
        }
        return fdService.getFdServiceDetails(accountNo);
    }

    /**
     * Higher-level convenience method: human-readable FD summary.
     * This shows how Facade can combine results from multiple services.
     */
    public String getFdSummary(String accountNo) {
        FdDetails fd = getFdServiceDetails(accountNo);
        String holder = accountService.getAccountHolderName(accountNo);
        double outstandingLoan = loanService.getOutstandingLoanAmount(accountNo);
        return String.format("FD Summary for %s (acct=%s): principal=%.2f, rate=%.2f%%, tenure=%d months, maturity=%.2f, outstandingLoan=%.2f",
                holder, fd.getAccountNo(), fd.getPrincipal(), fd.getAnnualInterestRate(), fd.getTenureMonths(), fd.maturityAmount(), outstandingLoan);
    }
}
