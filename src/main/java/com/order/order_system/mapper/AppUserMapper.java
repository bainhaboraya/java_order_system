package com.order.order_system.mapper;

import com.order.order_system.dto.AppUserDto;
import com.order.order_system.entity.AppUser;

import java.util.List;

import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface AppUserMapper {
    AppUserDto toDTO(AppUser appUser);
    List<AppUserDto> toDTO(List<AppUser> appUsers);
}
