package com.academy.it.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "login")
@ToString(exclude = {"images", "userInfo"})
@Entity
@Table(name = "app_user")
public class AppUser implements BaseEntity<String> {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Column(name = "u_login")
    private String login;
    @Column(name = "u_pass")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "u_role")
    private Role role;
    @Column(name = "create_date")
    private Instant createDate;
    @Column(name = "update_Date")
    private Instant updateDate;
    @OneToOne(mappedBy = "appUser", cascade = CascadeType.ALL)
    private UserInfo userInfo;
    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Image> images;

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        this.userInfo.setAppUser(this);
    }

}
