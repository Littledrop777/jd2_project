package by.academy.it.entity;

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
<<<<<<< HEAD:data/src/main/java/by/academy/it/entity/UserInfo.java
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
=======
import javax.persistence.OneToMany;
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614:data/src/main/java/by/academy/it/entity/Info.java
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "email")
<<<<<<< HEAD:data/src/main/java/by/academy/it/entity/UserInfo.java
@Builder
@Entity
@Table(name = "user_info")
public class UserInfo implements BaseEntity<String> {
=======
@ToString(exclude = "usersInfo")
@Builder
@Entity
@Table(name = "info")
public class Info implements BaseEntity<String> {
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614:data/src/main/java/by/academy/it/entity/Info.java

    @Id
    @Column(name = "info_id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
<<<<<<< HEAD:data/src/main/java/by/academy/it/entity/UserInfo.java
=======
    @Setter
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614:data/src/main/java/by/academy/it/entity/Info.java
    @Column(nullable = false)
    private String firstname;
    private String lastname;
<<<<<<< HEAD:data/src/main/java/by/academy/it/entity/UserInfo.java
    @Column(nullable = false, unique = true)
    private String email;
=======
    @Setter
    @Column(nullable = false, unique = true)
    private String email;
    @Setter
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614:data/src/main/java/by/academy/it/entity/Info.java
    @Column(nullable = false)
    private LocalDate birthday;
    private String gender;
<<<<<<< HEAD:data/src/main/java/by/academy/it/entity/UserInfo.java
    @Column(name = "create_date", nullable = false)
    private Instant createDate;
    @Column(name = "update_date")
    private Instant updateDate;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser appUser;

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
        this.appUser.setUserInfo(this);
    }
=======
   /* @Column(name = "change_date")
    @Setter
    private LocalDateTime date;*/
    @OneToMany(mappedBy = "info")
    private List<AppUserInfo> usersInfo;

>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614:data/src/main/java/by/academy/it/entity/Info.java
}
