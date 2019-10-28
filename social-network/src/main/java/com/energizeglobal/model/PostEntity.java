package com.energizeglobal.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "posts", indexes = {
        @Index(name = "posts_id_IDX", columnList = "id"),
        @Index(name = "posts_user_id_IDX", columnList = "user_id")
})
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_type_id")
    private PostTypeEntity postType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "source", nullable = false)
    private String source;

}
