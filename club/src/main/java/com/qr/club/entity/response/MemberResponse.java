package com.qr.club.entity.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record MemberResponse(
        UUID uuid,
        String name,
        String surname,
        String middleName
){}
