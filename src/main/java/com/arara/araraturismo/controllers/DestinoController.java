package com.arara.araraturismo.controllers;

import com.arara.araraturismo.exception.ResourceNotFoundException;
import com.arara.araraturismo.models.Destino;
import com.arara.araraturismo.repositories.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/mapa")
public class DestinoController {

    @Autowired
    DestinoRepository destinoRepository;

    @GetMapping("/destinos")
    public ResponseEntity<List<Destino>> listarDestinos() {
        List<Destino> destinos = new ArrayList<Destino>();

        destinoRepository.findAll().forEach(destinos::add);

        if (destinos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(destinos, HttpStatus.OK);
    }

    @GetMapping("/destinos/{id}")
    public ResponseEntity<Destino> buscarDestinoPorId(@PathVariable("id") long id) {
        Destino destino = destinoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destino não encontrado com id = " + id));
        return new ResponseEntity<>(destino, HttpStatus.OK);
    }

    @PostMapping("/destinos")
    public ResponseEntity<Destino> cadastrarDestino(@RequestBody Destino destino) {
        Destino _destino = destinoRepository.save(new Destino(destino.getCidade(),
                destino.getEstado(),
                destino.getBairro(),
                destino.getRua(),
                destino.getNumero(),
                destino.getLatitude(),
                destino.getLongitude(),
                destino.getDescricao()));
        return new ResponseEntity<>(_destino, HttpStatus.CREATED);
    }

    @DeleteMapping("/destinos/{id}")
    public ResponseEntity<HttpStatus> deletarDestino(@PathVariable("id") long id) {

        destinoRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
