package com.qr.club.service;


import com.qr.club.entity.MemberEntity;
import com.qr.club.dto.MemberRequest;
import com.qr.club.dto.MemberResponse;
import com.qr.club.entity.QrCodeEntity;
import com.qr.club.exception.MemberRepositoryException;
import com.qr.club.mapper.MemberMapper;
import com.qr.club.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository repository;
    private final MemberMapper mapper;

    public MemberResponse create(MemberRequest dto) {
        MemberEntity member = mapper.toEntity(dto);
        member.setQrCode(new QrCodeEntity(member.getId(), UUID.randomUUID(), member));

        return mapper.toResponse(
                repository.save(member)
        );
    }

    public MemberResponse update(MemberRequest dto, UUID uuid) {

        MemberEntity member = repository.findOptionalByUuid(uuid)
                .orElseThrow(() -> new MemberRepositoryException("Member not found"));

        mapper.updateEntityFromRequest(member, dto);

        return mapper.toResponse(
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
        MemberEntity member = repository.findOptionalByUuid(uuid)
                .orElseThrow(() -> new MemberRepositoryException("Member not found"));

        member.getQrCode().setUuid(
                UUID.randomUUID()
        );

        return mapper.toResponse(
                repository.save(member)
        );
    }
}
