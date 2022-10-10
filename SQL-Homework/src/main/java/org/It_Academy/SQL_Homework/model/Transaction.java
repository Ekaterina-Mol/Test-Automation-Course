package org.It_Academy.SQL_Homework.model;

public class Transaction {
    private int transactionId;

    private int accountId;

    private int amount;

    public int getTransactionId() {
        return transactionId;
    }

    public int getAccountId(){
        return accountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
