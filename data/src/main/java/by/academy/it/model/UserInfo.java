package by.academy.it.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "user_info")
public class UserInfo implements Model {

    @Id
    @Column(name = "info_id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Setter
    private String firstname;
    @Setter
    private String lastname;
    @Setter
    private String email;
    @Setter
    private LocalDate birthday;
    @Setter
    private String gender;
    @Setter
    @OneToOne
    private User user;
    @Column(name = "change_date")
    @Setter
    private LocalDateTime date;

    public UserInfo(String firstname, String lastname, String email, LocalDate birthday, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
    }
}
