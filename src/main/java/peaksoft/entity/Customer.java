package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.Enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    public Customer(String name, String surName, Gender gender, String phoneNumber, String email) {
        this.name = name;
        this.surName = surName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Id
    @GeneratedValue(generator = "customers_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customers_gen", sequenceName = "customers_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    @Column(name = "sur_name")
    private String surName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @ManyToMany(mappedBy = "customers", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Agency> agencies;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "customer")
    private List<Booking> bookings;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
