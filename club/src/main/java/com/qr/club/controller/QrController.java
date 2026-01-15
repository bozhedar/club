package com.qr.club.controller;

import com.qr.club.entity.dto.MemberDto;
import com.qr.club.entity.response.MemberResponse;
import com.qr.club.service.QrService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/qr")
@AllArgsConstructor
public class QrController {
    private final QrService service;

    @GetMapping("/enter")
    public MemberResponse enterClub(@RequestParam UUID uuid) {
        return service.enterClub(uuid);
    }

    @PostMapping("/new")
    public MemberResponse create(@RequestBody MemberDto dto) {
       return service.create(dto);
    }

    @PutMapping("/change")
    public MemberResponse update(@RequestBody MemberDto dto, @RequestParam UUID uuid) {
        return service.update(dto, uuid);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam UUID uuid) {
        service.deleteByUuid(uuid);
    }

}
