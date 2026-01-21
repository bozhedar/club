package com.qr.club.dto;

import java.util.UUID;

public record MemberResponse(
        UUID uuid,
        String name,
        String surname,
        String middleName
){}
