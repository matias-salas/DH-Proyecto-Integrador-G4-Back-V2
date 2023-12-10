package com.grupo4.digitalcars.controller;

import com.grupo4.digitalcars.model.Transmission;
import com.grupo4.digitalcars.services.TransmissionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags="Cities")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cities")
public class TransmissionController {

    @Autowired
    private TransmissionService transmissionService;

    @GetMapping
    public ResponseEntity<List<Transmission>> listarCiudades() {
        return ResponseEntity.ok(transmissionService.getAllCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transmission> buscarCiudad(@PathVariable Integer id) {
        Optional<Transmission> ciudadBuscada = transmissionService.getTransmissionById(id);
        if (ciudadBuscada.isPresent()) {
            return ResponseEntity.ok(ciudadBuscada.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Transmission> crearCiudad(@RequestBody Transmission transmission) {
        return ResponseEntity.ok(transmissionService.saveTransmission(transmission));
    }

    @PutMapping("/update")
    public ResponseEntity<?> editarCiudad(@RequestBody Transmission transmission) throws Exception {
        Optional<Transmission> ciudadBuscada = transmissionService.getTransmissionById(transmission.getId());
        if (ciudadBuscada.isPresent()) {
            return ResponseEntity.ok(transmissionService.updateTransmission(transmission));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La ciudad con ID: " + transmission.getId() + " no se encuentra ");
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarCiudad(@PathVariable Integer id) {
        if (transmissionService.getTransmissionById(id).isPresent()) {
            transmissionService.deleteTransmissionById(id);
            return ResponseEntity.ok("Se eliminó con éxito la ciudad con ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la ciudad coon ID: " + id);
    }
}