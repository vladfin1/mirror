package by.fin.project.domain;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @OneToOne(cascade=CascadeType.ALL)
    private UserData data;

    public User(String userName, String password, Set<Role> roles) {
        super();
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public User(String userName, String password, UserData data) {
        super();
        this.password = password;
        this.userName = userName;
        this.data = data;
    }

}

