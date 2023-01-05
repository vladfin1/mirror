package by.fin.project.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "mirror")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Mirror {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mirror_id")
    private int id;
    private String location;
    private boolean status;
    private String url;

    public Mirror(String location, String url){
        this.location = location;
        this.url = url;
    }
}
