package com.qr.club.mapper;

import com.qr.club.entity.Member;
import com.qr.club.entity.dto.MemberDto;
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
}
