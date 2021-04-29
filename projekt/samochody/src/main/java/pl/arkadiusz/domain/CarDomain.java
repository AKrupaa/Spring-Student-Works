package pl.arkadiusz.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CarDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    //    doesnt work
    @NotNull(message = "{error.field.required}")
//    @Size(min = 3, message = "errrrrrrrrrrrrror")
    private String name;
    //    private Long carMaxCount;
//    private Long carActualCount;
    private String title;
    private String description;
    private String sourceImage;
    private boolean rented;
    private int price;

    //    fetch all data at time when called
//    every car is associated to type of car for sorting cars (buying them, printing by type, etc.)
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<CarTypeDomain> carTypes = new HashSet<>(0);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourceImage() {
        return sourceImage;
    }

    public void setSourceImage(String sourceImage) {
        this.sourceImage = sourceImage;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<CarTypeDomain> getCarTypes() {
        return carTypes;
    }

    public void setCarTypes(Set<CarTypeDomain> carTypes) {
        this.carTypes = carTypes;
    }
}
