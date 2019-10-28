package com.energizeglobal.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "friendship", indexes = {
        @Index(name = "friendship_id_IDX", columnList = "id", unique = true),
        @Index(name = "friendship_user_id_IDX", columnList = "user_id"),
        @Index(name = "friendship_friend_id_IDX", columnList = "friend_id"),
        @Index(name = "friendship_user_friend_id_IDX", columnList = "user_id,friend_id", unique = true)
})
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "friend_id")
    private UserEntity friend;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private FriendshipStatusEntity status;
}
