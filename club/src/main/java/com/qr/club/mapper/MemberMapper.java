package com.qr.club.mapper;


import com.qr.club.dto.MemberRequest;
import com.qr.club.dto.MemberResponse;
import com.qr.club.entity.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(source = "qrCode.uuid", target = "uuid")
    MemberResponse toResponse(MemberEntity member);

    MemberEntity toEntity(MemberRequest request);

    default void updateEntityFromRequest(MemberEntity member, MemberRequest request){
        Optional.ofNullable(request.name())
                .ifPresent(member::setName);
        Optional.ofNullable(request.surname())
                .ifPresent(member::setSurname);
        Optional.ofNullable(request.middleName())
                .ifPresent(member::setMiddleName);
    }
}
