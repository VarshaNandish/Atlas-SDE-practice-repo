package com.example.facade;

/**
 * Simple model object that holds FD (fixed deposit) details
 * and can compute the maturity amount using monthly compounding.
 */
public class FdDetails {
    private final String accountNo;
    private final double principal;
    private final double annualInterestRate; // as percentage, e.g., 6.5
    private final int tenureMonths; // tenure in months

    public FdDetails(String accountNo, double principal, double annualInterestRate, int tenureMonths) {
        this.accountNo = accountNo;
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.tenureMonths = tenureMonths;
    }

    public String getAccountNo() { return accountNo; }
    public double getPrincipal() { return principal; }
    public double getAnnualInterestRate() { return annualInterestRate; }
    public int getTenureMonths() { return tenureMonths; }

    /**
     * Compute maturity amount using monthly compounding:
     * A = P * (1 + r/12)^(tenureMonths)
     * where r = annualInterestRate / 100
     */
    public double maturityAmount() {
        double r = annualInterestRate / 100.0;
        return principal * Math.pow(1 + r / 12.0, tenureMonths);
    }

    @Override
    public String toString() {
        return String.format("FdDetails[acct=%s, principal=%.2f, rate=%.2f%%, tenure=%d months, maturity=%.2f]",
                accountNo, principal, annualInterestRate, tenureMonths, maturityAmount());
    }
}
