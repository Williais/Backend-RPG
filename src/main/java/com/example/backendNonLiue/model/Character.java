package com.example.backendNonLiue.model;

import com.example.backendNonLiue.util.Archetype;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "tb_characters")
public class Character extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(nullable = false)
    private Archetype archetype;

    @Column(columnDefinition = "TEXT")
    private String lore;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "attr_forma", nullable = false)
    private Integer attrForma = 0;

    @Column(name = "attr_saber", nullable = false)
    private Integer attrSaber = 0;

    @Column(name = "attr_ser", nullable = false)
    private Integer attrSer = 0;

    @Column(name = "attr_onirico", nullable = false)
    private Integer attrOnirico = 0;
}