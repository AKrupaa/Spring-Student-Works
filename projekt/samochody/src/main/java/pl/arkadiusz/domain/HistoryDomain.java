package pl.arkadiusz.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HistoryDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    private CarDomain carDomain;

    //    @Temporal(TemporalType.TIMESTAMP)
//    private java.util.Date rentalStartDateAndTime;
    private Long rentalStartDateAndTime;
    private String rentalStartDateAndTimeString;
    //    @Temporal(TemporalType.TIMESTAMP)
//    private java.util.Date rentalEndDateAndTime;
    private Long rentalEndDateAndTime;
    private String rentalEndDateAndTimeString;
    private Long costsOfRental;
    private boolean completed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CarDomain getCarDomain() {
        return carDomain;
    }

    public void setCarDomain(CarDomain carDomain) {
        this.carDomain = carDomain;
    }

    public Long getRentalStartDateAndTime() {
        return rentalStartDateAndTime;
    }

    public void setRentalStartDateAndTime(Long rentalStartDateAndTime) {
        this.rentalStartDateAndTime = rentalStartDateAndTime;
    }

    public String getRentalStartDateAndTimeString() {
        return rentalStartDateAndTimeString;
    }

    public void setRentalStartDateAndTimeString(String rentalStartDateAndTimeString) {
        this.rentalStartDateAndTimeString = rentalStartDateAndTimeString;
    }

    public Long getRentalEndDateAndTime() {
        return rentalEndDateAndTime;
    }

    public void setRentalEndDateAndTime(Long rentalEndDateAndTime) {
        this.rentalEndDateAndTime = rentalEndDateAndTime;
    }

    public String getRentalEndDateAndTimeString() {
        return rentalEndDateAndTimeString;
    }

    public void setRentalEndDateAndTimeString(String rentalEndDateAndTimeString) {
        this.rentalEndDateAndTimeString = rentalEndDateAndTimeString;
    }

    public Long getCostsOfRental() {
        return costsOfRental;
    }

    public void setCostsOfRental(Long costsOfRental) {
        this.costsOfRental = costsOfRental;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
