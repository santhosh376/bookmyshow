package org.example.bookmyshow.dtos;

import lombok.*;

@Data
public class RegisterUserResponseDto {
    private Long userId;

    public RegisterUserResponseDto(Long userId) {
        this.userId = userId;
    }
}
