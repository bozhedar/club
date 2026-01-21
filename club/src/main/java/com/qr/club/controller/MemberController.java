package com.qr.club.controller;

import com.qr.club.dto.MemberRequest;
import com.qr.club.dto.MemberResponse;
import com.qr.club.service.MemberService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/club")
@AllArgsConstructor
public class MemberController {

    private final MemberService service;

    @PostMapping("/new")
    public MemberResponse create(@RequestBody @Valid MemberRequest dto) {
        return service.create(dto);
    }

    @PutMapping("/change")
    public MemberResponse update(@RequestBody MemberRequest dto, @RequestParam UUID uuid) {
        return service.update(dto, uuid);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam UUID uuid) {
        service.deleteByUuid(uuid);
    }
}
