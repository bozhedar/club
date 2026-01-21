package com.qr.club.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(schema = "qrclub", name = "member_uuid")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class QrCode {
    @Id
    @Column(name = "member_id")
    private Long id;

    @Column(name = "uuid", nullable = false, unique = true)
    private UUID uuid;

    @MapsId
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
