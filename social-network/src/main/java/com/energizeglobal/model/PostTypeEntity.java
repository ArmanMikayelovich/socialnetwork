package com.energizeglobal.model;

import com.energizeglobal.util.PostType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "post_types")
public class PostTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private PostType type;

}
