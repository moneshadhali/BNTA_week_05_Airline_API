package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public DataLoader(){

    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Passenger p1 = new Passenger("Hanna", "hanna@gmail.com");
        Passenger p2 = new Passenger("Leila", "leila@gmail.com");
        Passenger p3 = new Passenger("Birindar", "birindar@gmail.com");
        Passenger p4 = new Passenger("Kajanan", "kajanan@gmail.com");
        Passenger p5 = new Passenger("Colin", "colin@gmail.com");
        passengerRepository.save(p1);
        passengerRepository.save(p2);
        passengerRepository.save(p3);
        passengerRepository.save(p4);
        passengerRepository.save(p5);

        Flight f1 = new Flight("Rome", 30,"10/01/2025","5pm");
        Flight f2 = new Flight("Paris", 50,"20/01/2025","6pm");
        Flight f3 = new Flight("Japan", 45,"30/01/2025","12pm");
        f1.addPassenger(p1);
        f1.addPassenger(p2);
        f1.addPassenger(p3);
        f1.addPassenger(p4);
        f1.addPassenger(p5);

        f2.addPassenger(p1);
        f2.addPassenger(p4);
        f2.addPassenger(p5);

        f3.addPassenger(p5);
        flightRepository.save(f1);
        flightRepository.save(f2);
        flightRepository.save(f3);

    }
}
