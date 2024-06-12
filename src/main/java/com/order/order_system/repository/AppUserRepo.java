package com.order.order_system.repository;


import com.order.order_system.entity.AppUser;

public interface AppUserRepo extends  BaseRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
