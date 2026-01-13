package com.qr.club.repository;

import com.qr.club.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface QrRepository extends JpaRepository<Member, Long> {

    Optional<Member> findOptionalByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

    boolean existsByUuid(UUID uuid);
}
