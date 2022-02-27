package com.academy.it.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_chat")
public class UserChat implements BaseEntity<String>{

    @Id
    @Column(name = "user_chat_id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "one_user_id")
    private AppUser firstUser;
    @ManyToOne
    @JoinColumn(name = "two_user_id")
    private AppUser secondUser;
    @OneToMany(mappedBy = "userChat", cascade = CascadeType.ALL)
    private List<Chat> chats;
    @Column(name = "create_date")
    private Instant createDate;
}
