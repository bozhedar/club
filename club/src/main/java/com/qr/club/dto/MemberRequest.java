package com.qr.club.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MemberRequest(
        @NotBlank(message = "Имя обязательно")
        @Size(max = 32, message = "Имя не должно превышать 32 символа")
        String name,

        @NotBlank(message = "Фамилия обязательна")
        @Size(max = 32, message = "Фамилия не должна превышать 32 символа")
        String surname,

        @Size(max = 32, message = "Отчество не должно превышать 32 символа")
        String middleName
) {

}
