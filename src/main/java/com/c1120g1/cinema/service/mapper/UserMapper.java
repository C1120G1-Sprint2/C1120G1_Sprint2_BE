package com.c1120g1.cinema.service.mapper;

import com.c1120g1.cinema.dto.UserEditDTO;
import com.c1120g1.cinema.dto.UserPreviewDTO;
import com.c1120g1.cinema.entity.User;

import java.util.List;

public interface UserMapper {
    UserPreviewDTO toDto(User entity);

    List<UserPreviewDTO> toDto(List<User> lstEntity);

    UserEditDTO toEditDto(User entity);

    List<UserPreviewDTO> toSearchDto(List<User> entity);
}
