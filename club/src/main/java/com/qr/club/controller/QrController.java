package com.qr.club.controller;

import com.qr.club.entity.dto.MemberResponse;
import com.qr.club.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/qr")
@AllArgsConstructor
public class QrController {
    private final MemberService service;

    @GetMapping("/enter")
    public MemberResponse enterClub(@RequestParam UUID uuid) {
        return service.enterClub(uuid);
    }

}
