package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "agencies")
@Getter
@Setter
@NoArgsConstructor
public class Agency {
    public Agency(String name, String country, String phoneNumber, String email) {
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    @Id
    @GeneratedValue(generator = "agencies_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "agencies_gen", sequenceName = "agencies_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String country;
    private String image;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Customer> customers;
    @OneToMany(mappedBy = "agency",cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<House> houses;

    @Override
    public String toString() {
        return "Agency{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", image='" + image + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
