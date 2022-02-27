package com.academy.it.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chat")
public class Chat implements BaseEntity<String> {

    @Id
    @Column(name = "chat_id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "user_chat_id")
    private UserChat userChat;
    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;
    private String message;
    @Column(name = "create_time")
    private LocalDateTime createTime;
}

