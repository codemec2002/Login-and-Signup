package com.example.Rentify;

public interface UserService {
    User registerUser(User User);
    User loginUser(String userEmail, String userPassword);
}
