package com.academy.it.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "email")
@ToString(exclude = "appUser")
@Builder
@Entity
@Table(name = "user_info")
public class UserInfo implements BaseEntity<String> {

    @Id
    @Column(name = "info_id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate birthday;
    private String gender;
    @Column(name = "update_date")
    private Instant updateDate;
    @OneToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;
}
