package com.order.order_system.repository;

import com.order.order_system.entity.AppUser;  
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends BaseRepository<AppUser, Long> {
}
