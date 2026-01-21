package com.qr.club.entity.dto;

import java.util.UUID;

public record MemberResponse(
        UUID uuid,
        String name,
        String surname,
        String middleName
){}
