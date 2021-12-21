package by.academy.it.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "user")
public class User implements Model{

    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Column(name = "u_login", nullable = false, unique = true)
    private String login;
    @Column(name = "u_pass", nullable = false)
    private String password;
    @Column(name = "u_role")
    private Role role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserInfo userInfo;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
