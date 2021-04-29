package org.spring.plane.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    //    private long departure; // odlot
//    private String departureDate;
    @DateTimeFormat(pattern = "MM-dd-yyyy HH:mm")
    private Date departure;

    //    private long arrival; // przylot
//    private String arrivalDate;
    @DateTimeFormat(pattern = "MM-dd-yyyy HH:mm")
    private Date arrival;

    private String source;
    private String destination;

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

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
