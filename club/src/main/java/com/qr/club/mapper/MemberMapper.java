package com.qr.club.mapper;

import com.qr.club.entity.Member;
import com.qr.club.entity.dto.MemberDto;
import com.qr.club.entity.response.MemberResponse;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public MemberDto toMemberDto(Member m) {
        return new MemberDto(
                m.getName(),
                m.getSurname(),
                m.getMiddleName()
        );
    }

    public Member toMember(MemberDto m) {
        return new Member(
                m.name(),
                m.surname(),
                m.middleName()
        );
    }

    public MemberResponse toMemberResponse(Member m) {
        return new MemberResponse(
                m.getUuid(),
                m.getName(),
                m.getSurname(),
                m.getMiddleName()
        );
    }
}
