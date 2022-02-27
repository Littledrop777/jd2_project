package com.academy.it.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "friend")
public class Friend implements BaseEntity<String>{

    @Id
    @Column(name = "friend_id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "user_one_id")
    private AppUser firstFriend;
    @ManyToOne
    @JoinColumn(name = "user_two_id")
    private AppUser secondFriend;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "create_date")
    private Instant createDate;
    @Column(name = "update_date")
    private Instant updateDate;
}
