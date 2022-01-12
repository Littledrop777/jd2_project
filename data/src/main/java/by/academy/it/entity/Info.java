package by.academy.it.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "email")
@ToString(exclude = "usersInfo")
@Builder
@Entity
@Table(name = "info")
public class Info implements BaseEntity<String> {

    @Id
    @Column(name = "info_id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Setter
    @Column(nullable = false)
    private String firstname;
    @Setter
    private String lastname;
    @Setter
    @Column(nullable = false, unique = true)
    private String email;
    @Setter
    @Column(nullable = false)
    private LocalDate birthday;
    @Setter
    private String gender;
   /* @Column(name = "change_date")
    @Setter
    private LocalDateTime date;*/
    @OneToMany(mappedBy = "info")
    private List<AppUserInfo> usersInfo;

}
