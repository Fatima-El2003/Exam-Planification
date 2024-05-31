package com.ensah.examplan.service;

import com.ensah.examplan.model.UserInfo;
import com.ensah.examplan.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService{
        @Autowired
    UserInfoRepository userInfoRepository;
        @Autowired
     private PasswordEncoder passwordEncoder;
    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
    }
}
