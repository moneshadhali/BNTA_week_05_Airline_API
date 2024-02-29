package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id){
        return flightRepository.findById(id);
    }

    public Flight addNewFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight addPassengerToFlight(FlightDTO flightDTO, Long id) {
        Flight flight = flightRepository.findById(id).get();
        for (Long pID : flightDTO.getPassengerID()){
            Passenger passenger = passengerRepository.findById(pID).get();
            flight.addPassenger(passenger);
        }
        flightRepository.save(flight);
        return flight;
    }

    public void cancelFlight(Long id) {
        Flight flight = flightRepository.findById(id).get();
        for (Passenger passenger : flight.getPassengers()){
            flight.removePassenger(passenger);
            passengerRepository.save(passenger);
        }
        flightRepository.delete(flight);
    }
}
