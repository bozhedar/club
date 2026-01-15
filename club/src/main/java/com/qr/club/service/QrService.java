package com.qr.club.service;

import com.qr.club.entity.Member;
import com.qr.club.entity.dto.MemberDto;
import com.qr.club.entity.response.MemberResponse;
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

    public MemberResponse create(MemberDto dto) {
        Member member = repository.save(
                mapper.toMember(dto)
        );
        return mapper.toMemberResponse(member);
    }

    public MemberResponse update(MemberDto dto, UUID uuid) {

        Member member = repository.findOptionalByUuid(uuid)
                .orElseThrow(() -> new MemberRepositoryException("Member not found"));

        Optional.ofNullable(dto.name())
                .ifPresent(member::setName);
        Optional.ofNullable(dto.surname())
                .ifPresent(member::setSurname);
        Optional.ofNullable(dto.middleName())
                .ifPresent(member::setMiddleName);

        return mapper.toMemberResponse(
                repository.save(member)
        );
    }

    public void deleteByUuid(UUID uuid) {
        if (repository.existsByUuid(uuid)) {
            repository.deleteByUuid(uuid);
        } else {
            throw new MemberRepositoryException("Member not found");
        }
    }

    public MemberResponse enterClub(UUID uuid) {
       Member member = repository.findOptionalByUuid(uuid)
               .orElseThrow(() -> new MemberRepositoryException("Member not found"));
       member.setUuid(UUID.randomUUID());

       return mapper.toMemberResponse(
               repository.save(member)
       );
    }
}
