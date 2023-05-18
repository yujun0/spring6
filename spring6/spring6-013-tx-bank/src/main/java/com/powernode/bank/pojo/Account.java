package com.powernode.bank.pojo;

/**
 * 銀行帳戶類
 **/
public class Account {
    private String actno;
    private Double balance;

    public Account() {
    }

    public Account(String actno, Double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
               "actno='" + actno + '\'' +
               ", balance=" + balance +
               '}';
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}