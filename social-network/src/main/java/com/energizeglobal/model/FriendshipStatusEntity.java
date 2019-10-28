package com.energizeglobal.model;

import com.energizeglobal.util.FriendshipStatusEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "friendship_statuses")
public class FriendshipStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private FriendshipStatusEnum status;
}
