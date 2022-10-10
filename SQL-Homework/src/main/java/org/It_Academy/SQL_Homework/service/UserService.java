package org.It_Academy.SQL_Homework.service;

import org.It_Academy.SQL_Homework.model.User;
import org.It_Academy.SQL_Homework.query_executor.UserQueryExecutor;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
    private UserQueryExecutor userQueryExecutor;

    public UserService() {
        this.userQueryExecutor = new UserQueryExecutor();
    }

    public void insertUser() throws SQLException {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user id: ");
        user.setUserId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter user name: ");
        user.setName(scanner.nextLine());
        System.out.println("Enter user address: ");
        user.setAddress(scanner.nextLine());

        this.userQueryExecutor.addUser(user);

        System.out.println("User added successfully");
    }
}
