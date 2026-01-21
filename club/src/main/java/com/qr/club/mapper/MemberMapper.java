package com.qr.club.mapper;

import com.qr.club.entity.Member;
import com.qr.club.entity.dto.MemberRequest;
import com.qr.club.entity.dto.MemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(source = "qrCode.uuid", target = "uuid")
    MemberResponse toResponse(Member member);

    Member toEntity(MemberRequest request);

    default void updateEntityFromRequest(Member member, MemberRequest request){
        Optional.ofNullable(request.name())
                .ifPresent(member::setName);
        Optional.ofNullable(request.surname())
                .ifPresent(member::setSurname);
        Optional.ofNullable(request.middleName())
                .ifPresent(member::setMiddleName);
    }
}
