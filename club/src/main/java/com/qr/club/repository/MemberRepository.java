package com.qr.club.repository;

import com.qr.club.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    @Query("SELECT m FROM MemberEntity m JOIN m.qrCode qc WHERE qc.uuid = :uuid")
    Optional<MemberEntity> findOptionalByUuid(@Param("uuid") UUID uuid);


    @Query("DELETE FROM MemberEntity m WHERE m.qrCode.uuid = :uuid")
    @Modifying
    void deleteByUuid(@Param("uuid") UUID uuid);

    @Query("SELECT COUNT(m) > 0 FROM MemberEntity m JOIN m.qrCode qc WHERE qc.uuid = :uuid")
    boolean existsByUuid(@Param("uuid") UUID uuid);
}
