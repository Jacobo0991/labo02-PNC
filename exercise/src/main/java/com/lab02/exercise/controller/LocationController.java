package com.lab02.exercise.controller;

import com.lab02.exercise.entities.Location;
import com.lab02.exercise.repository.LocationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) { this.locationRepository = locationRepository; }

    // Obtener todas las ubicaciones
    @GetMapping
    public List<Location> getAllLocations() { return locationRepository.findAll(); }

    // Obtener ubicaciones por piso (/location/search/by-floor?floor=2)
    @GetMapping("/search/by-floor")
    public ResponseEntity<List<Location>> findByFloor(@RequestParam("floor") int floor) {
        List<Location> locations = locationRepository.findByFloor(floor);
        if (locations.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(locations);
        }
    }

    // Obtener ubicaciones por estantería (/location/search/by-shelf?floor=2&shelf=1
    @GetMapping("/search/by-shelf")
    public ResponseEntity<List<Location>> findByShelf(@RequestParam("floor") int floor, @RequestParam("shelf") int shelf) {
        List<Location> locations = locationRepository.findByLevelShelf(floor, shelf);
        if (locations.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(locations);
        }
    }

}
