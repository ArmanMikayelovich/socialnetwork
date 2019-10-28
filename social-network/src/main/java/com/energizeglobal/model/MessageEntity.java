package com.energizeglobal.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "messages", indexes = {
        @Index(name = "messages_id_IDX", columnList = "id"),
        @Index(name = "messages_from_to_IDX", columnList = "message_from, message_to"),
        @Index(name = "messages_to_from_IDX", columnList = "message_to, message_from"),
        @Index(name = "messages_from_IDX", columnList = "message_from"),
        @Index(name = "messages_to_IDX", columnList = "message_to"),
})
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "message_from")
    private UserEntity from;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "message_to")
    private UserEntity to;


    @Column(name = "message", nullable = false, length = 1000)
    private String message;

    @CreationTimestamp
    private Date time;
}
