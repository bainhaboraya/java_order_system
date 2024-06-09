package com.order.order_system.mapper;

import com.order.order_system.dto.RoleDto;
import com.order.order_system.entity.Role;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface RoleMapper {
    RoleDto toDTO(Role role);
    List<RoleDto> toDTO(List<Role> roles);
}

