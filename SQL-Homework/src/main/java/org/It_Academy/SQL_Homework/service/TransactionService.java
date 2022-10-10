package org.It_Academy.SQL_Homework.service;

import org.It_Academy.SQL_Homework.model.Account;
import org.It_Academy.SQL_Homework.model.Transaction;
import org.It_Academy.SQL_Homework.query_executor.AccountQueryExecutor;
import org.It_Academy.SQL_Homework.query_executor.TransactionQueryExecutor;

import java.sql.SQLException;
import java.util.Scanner;

public class TransactionService {
    private TransactionQueryExecutor transactionQueryExecutor;
    private AccountQueryExecutor accountQueryExecutor;
    private final int TRANSACTION_AMOUNT_LIMIT = 100000000;
    private final int ACCOUNT_BALANCE_LIMIT = 2000000000;

    public TransactionService() {
        this.transactionQueryExecutor = new TransactionQueryExecutor();
        this.accountQueryExecutor = new AccountQueryExecutor();
    }

    public void insertTopUpTransaction() throws SQLException {
        Transaction transaction = new Transaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account id: ");
        transaction.setAccountId(scanner.nextInt());
        Account account = accountQueryExecutor.getAccount(transaction.getAccountId());
        if (account != null) {
            System.out.println("Enter transaction id: ");
            transaction.setTransactionId(scanner.nextInt());

            boolean isAmountLessThanLimit = false;
            boolean isBalanceCorrect = true;
            do {
                System.out.println("Enter amount: ");
                transaction.setAmount(scanner.nextInt());
                isAmountLessThanLimit = this.checkTransactionAmountLimit(transaction.getAmount());

                if (!isAmountLessThanLimit) {
                    System.out.println("Amount cannot exceed 100,000,000\nPlease try again");
                    continue;
                }

                isBalanceCorrect = this.checkAccountBalanceCorrectness(account.getBalance(), transaction.getAmount());
                if (!isAmountLessThanLimit) {
                    System.out.println("Balance cannot be negative or exceed 2,000,000,000\nPlease try again");
                }
            } while (!isAmountLessThanLimit || !isBalanceCorrect);

            account.setBalance(account.getBalance() + transaction.getAmount());
            this.transactionQueryExecutor.addTransaction(transaction);
            this.accountQueryExecutor.updateAccount(account);

            System.out.println("Transaction added successfully");
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void insertWithdrawTransaction() throws SQLException {
        Transaction transaction = new Transaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account id: ");
        transaction.setAccountId(scanner.nextInt());
        Account account = accountQueryExecutor.getAccount(transaction.getAccountId());
        if (account != null) {
            System.out.println("Enter transaction id: ");
            transaction.setTransactionId(scanner.nextInt());
            boolean isAmountLessThanLimit = false;
            boolean isBalanceCorrect = true;
            do {
                System.out.println("Enter amount: ");
                transaction.setAmount(0 - scanner.nextInt());
                isAmountLessThanLimit = this.checkTransactionAmountLimit(Math.abs(transaction.getAmount()));

                if (!isAmountLessThanLimit) {
                    System.out.println("Amount cannot exceed 100,000,000\nPlease try again");
                    continue;
                }

                isBalanceCorrect = this.checkAccountBalanceCorrectness(account.getBalance(), transaction.getAmount());
                if (!isAmountLessThanLimit) {
                    System.out.println("Balance cannot be negative or exceed 2,000,000,000\nPlease try again");
                }
            } while (!isAmountLessThanLimit || !isBalanceCorrect);

            account.setBalance(account.getBalance() + transaction.getAmount());
            this.transactionQueryExecutor.addTransaction(transaction);
            this.accountQueryExecutor.updateAccount(account);

            System.out.println("Transaction added successfully");
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkTransactionAmountLimit(int amount){
        var checkResult = true;
        if (amount > TRANSACTION_AMOUNT_LIMIT) {
            checkResult = false;
        }

        return checkResult;
    }

    private boolean checkAccountBalanceCorrectness(int currentBalance, int amount) {
        var checkResult = true;
        var newBalance = currentBalance + amount;

        if (newBalance > ACCOUNT_BALANCE_LIMIT || newBalance < 0){
            checkResult = false;
        }

        return checkResult;
    }

    private void handleAmount(Transaction transaction) {

    }
}
