package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.Enums.HouseType;

@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor
public class House {

    public House(HouseType houseType, String address, int price, String room, String country, String description, String isBooked, String image) {
        this.houseType = houseType;
        this.address = address;
        this.price = price;
        this.room = room;
        this.country = country;
        this.description = description;
        this.isBooked = isBooked;
        this.image = image;
    }

    @Id
    @GeneratedValue(generator = "houses_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "houses_gen", sequenceName = "houses_seq",
            allocationSize = 1)
    private Long id;
    private HouseType houseType;
    private String address;
    private int price;
    private String room;
    private String country;
    private String description;
    private String isBooked;
    private String image;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Agency agency;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH } , mappedBy = "house")
    private Booking booking;

    @Override
    public String toString() {
        return "House{" +
                "houseType=" + houseType +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", room='" + room + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", isBooked='" + isBooked + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
