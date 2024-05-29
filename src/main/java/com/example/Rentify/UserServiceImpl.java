package com.example.Rentify;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String userEmail, String userPassword) {
        User user =  userRepository.findByEmail(userEmail);
        if (user != null && userPassword.equals(user.getUserPassword())) {
            return user;
        }
        return null;
    }
}
