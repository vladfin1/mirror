package by.fin.project.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    private String fullName;
    private String phoneNumber;
    @OneToMany
    private List<Mirror> list;

    public UserData(String fullName, String phoneNumber){
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }
    
}
