package org.It_Academy.SQL_Homework.presentation;

import org.It_Academy.SQL_Homework.model.Account;
import org.It_Academy.SQL_Homework.service.AccountService;
import org.It_Academy.SQL_Homework.service.TransactionService;
import org.It_Academy.SQL_Homework.service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();

        String action;
        do {
            printMenu();
            action = new Scanner(System.in).nextLine();
            switch (action) {
                case "1":
                    userService.insertUser();
                    break;
                case "2":
                    accountService.insertAccount();
                    break;
                case "3":
                    transactionService.insertTopUpTransaction();
                    break;
                case "4":
                    transactionService.insertWithdrawTransaction();
                    break;
                case "5":
                    System.out.println("Thanks for using the program!");
                    break;
            }
        } while (!"5".equals(action));


    }

    private static void printMenu() {
        System.out.println("1 - Add new user");
        System.out.println("2 - Add new account");
        System.out.println("3 - Top Up funds");
        System.out.println("4 - Withdraw funds");
        System.out.println("5 - Exit");
    }
}