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
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "login")
@ToString(exclude = "usersInfo")
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
    //@Column(name = "u_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<AppUserInfo> usersInfo = new ArrayList<>();

}
