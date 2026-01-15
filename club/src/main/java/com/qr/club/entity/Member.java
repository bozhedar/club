package com.qr.club.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.util.UUID;

@Data
@Entity
@Table(schema = "qrclub", name = "members")
@NoArgsConstructor
@SecondaryTable(
        name = "member_uuid",
        schema = "qrclub",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "member_id")
)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(table = "member_uuid", columnDefinition = "UUID")
    private UUID uuid;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false, length = 32)
    private String surname;

    @Column(length = 32)
    private String middleName;

    public Member(String name, String surname, String middleName) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.uuid = UUID.randomUUID();
    }

}
