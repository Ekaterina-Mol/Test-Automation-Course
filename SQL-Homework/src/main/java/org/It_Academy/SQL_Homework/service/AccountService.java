package org.It_Academy.SQL_Homework.service;

import org.It_Academy.SQL_Homework.model.Account;
import org.It_Academy.SQL_Homework.model.User;
import org.It_Academy.SQL_Homework.query_executor.AccountQueryExecutor;
import org.It_Academy.SQL_Homework.query_executor.UserQueryExecutor;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountService {
    private UserQueryExecutor userQueryExecutor;
    private AccountQueryExecutor accountQueryExecutor;

    public AccountService() {
        this.userQueryExecutor = new UserQueryExecutor();
        this.accountQueryExecutor = new AccountQueryExecutor();
    }

    public void insertAccount() throws SQLException {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user id: ");
        account.setUserId(scanner.nextInt());
        User user = userQueryExecutor.getUser(account.getUserId());
        if (user != null) {
            System.out.println("Enter account id: ");
            account.setAccountId(scanner.nextInt());
            scanner.nextLine();

            boolean isCurrencyAvailable = false;
            do {
                System.out.println("Enter account currency: ");
                account.setCurrency(scanner.nextLine());
                isCurrencyAvailable = this.checkCurrencyAvailability(account.getUserId(), account.getCurrency());

                if (!isCurrencyAvailable) {
                    System.out.println("Account with this currency already created for current user. \n Please try another currency");
                }
            } while (!isCurrencyAvailable);

            this.accountQueryExecutor.addAccount(account);

            System.out.println("Account added successfully");
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkCurrencyAvailability(int userId, String currency) throws SQLException {
        var existingAccounts = this.accountQueryExecutor.getAccountsForUser(userId);
        boolean result = true;

        for (var existingAccount :
                existingAccounts) {
            if (existingAccount.getCurrency().equals(currency)){
                result = false;
                break;
            }
        }

        return result;
    }
}
