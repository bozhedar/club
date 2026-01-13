package com.qr.club.service;

import com.qr.club.entity.Member;
import com.qr.club.entity.dto.MemberDto;
import com.qr.club.exception.MemberRepositoryException;
import com.qr.club.mapper.MemberMapper;
import com.qr.club.repository.QrRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class QrService {

    private final QrRepository repository;
    private final MemberMapper mapper;

    public Member create(MemberDto dto) {
        return repository.save(
                mapper.toMember(dto)
        );

    }

    public MemberDto update(MemberDto dto, UUID uuid) {

        Member member = repository.findOptionalByUuid(uuid)
                .orElseThrow(() -> new MemberRepositoryException("Member not found"));

        Optional.ofNullable(dto.name())
                .ifPresent(member::setName);
        Optional.ofNullable(dto.surname())
                .ifPresent(member::setSurname);
        Optional.ofNullable(dto.middleName())
                .ifPresent(member::setMiddleName);

        repository.save(member);

        return mapper.toMemberDto(member);
    }

    public void deleteByUuid(UUID uuid) {
        repository.deleteByUuid(uuid);
    }

    public MemberDto enterClub(UUID uuid) {
       Member member = repository.findOptionalByUuid(uuid)
               .orElseThrow(() -> new MemberRepositoryException("Member not found"));
       member.setUuid(UUID.randomUUID());
       repository.save(member);

       return mapper.toMemberDto(member);
    }
}
