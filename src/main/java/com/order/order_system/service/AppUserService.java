package com.order.order_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.order_system.dto.AppUserDto;
import com.order.order_system.entity.AppUser;
import com.order.order_system.repository.AppUserRepo;

@Service
public class AppUserService extends BaseService<AppUser, Long> {
    
    @Autowired
    private AppUserRepo userRepo;

    public void insert(AppUser user) {
        userRepo.save(user);
    }

    public List<AppUser> findAll() {
        return userRepo.findAll();
    }

    public AppUserDto findByEmail(String email) {
        AppUser user = userRepo.findByEmail(email);
        if (user == null) {
            return null;
        }
        AppUserDto userDto = new AppUserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto; 
    }
}
