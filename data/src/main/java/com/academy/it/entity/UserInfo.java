package com.academy.it.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@Builder
@Entity
@Table(name = "user_info")
public class UserInfo implements BaseEntity<String> {

    @Id
    @Column(name = "info_id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Column(nullable = false)
    private String firstname;
    private String lastname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate birthday;
    private String gender;
    @Column(name = "create_date", nullable = false)
    private Instant createDate;
    @Column(name = "update_date")
    private Instant updateDate;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser appUser;
}
