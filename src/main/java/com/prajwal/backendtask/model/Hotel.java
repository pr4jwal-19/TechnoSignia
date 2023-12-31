package com.prajwal.backendtask.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hotelID;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_address")
    private String hotelAddress;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "no_of_rooms")
    private int noOfRooms;

    @Column(name = "amenities")
    private String amenities;

    @Column(name = "ratings")
    private float rating;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Rating> ratings;

}
