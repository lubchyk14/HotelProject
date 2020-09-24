package com.hotel.Entity;

import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apartments")
public class Apartments {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "room_class")
    private String roomClass;

    @Column(name = "number_of_rooms")
    private int numberOfRooms;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "apartments")
    private List<Reservation> reservations;

    public void addReservation(Reservation reservation){
        if (reservation==null){
            reservations = new ArrayList<>();
        }
        reservation.setApartments(this);
        reservations.add(reservation);
    }

    public Apartments(String roomClass, int numberOfRooms) {
        this.roomClass = roomClass;
        this.numberOfRooms = numberOfRooms;
    }

    public Apartments(String roomClass, int numberOfRooms, Hotel hotel) {
        this.roomClass = roomClass;
        this.numberOfRooms = numberOfRooms;
        this.hotel = hotel;
    }

    public Apartments() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
