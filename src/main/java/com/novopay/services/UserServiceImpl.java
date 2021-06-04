package com.novopay.services;

@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService{

    @org.springframework.beans.factory.annotation.Autowired
    private com.novopay.repositories.UserRespository userRespository;

    @Override
    public void addUser(com.novopay.domain.User user) {
            userRespository.save(user);
    }
}
