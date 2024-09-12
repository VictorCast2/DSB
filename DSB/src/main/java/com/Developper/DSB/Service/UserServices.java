package com.Developper.DSB.Service;

import com.Developper.DSB.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

}