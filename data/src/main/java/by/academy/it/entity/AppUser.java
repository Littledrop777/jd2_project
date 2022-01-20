package by.academy.it.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
<<<<<<< HEAD:data/src/main/java/by/academy/it/entity/AppUser.java
import java.time.Instant;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614:data/src/main/java/by/academy/it/model/User.java

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "login")
<<<<<<< HEAD:data/src/main/java/by/academy/it/entity/AppUser.java
=======
@ToString(exclude = "usersInfo")
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614:data/src/main/java/by/academy/it/model/User.java
@Entity
@Table(name = "user")
public class AppUser implements BaseEntity<String> {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Column(name = "u_login", nullable = false, unique = true)
    private String login;
    @Column(name = "u_pass", nullable = false)
    private String password;
<<<<<<< HEAD:data/src/main/java/by/academy/it/entity/AppUser.java
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "update_date")
    private Instant updateDate;
    @OneToOne(mappedBy = "appUser", cascade = CascadeType.ALL)
    private UserInfo userInfo;

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        this.userInfo.setAppUser(this);
    }
=======
    //@Column(name = "u_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<AppUserInfo> usersInfo = new ArrayList<>();

>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614:data/src/main/java/by/academy/it/model/User.java
}
