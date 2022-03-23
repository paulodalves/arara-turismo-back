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
        Destino _destino = destinoRepository.save(new Destino(destino.getNome(),
                destino.getTelefone(),
                destino.getEmail(),
                destino.getCidade(),
                destino.getEstado(),
                destino.getBairro(),
                destino.getRua(),
                destino.getNumero(),
                destino.getLatitude(),
                destino.getLongitude(),
                destino.getDescricao()));
        return new ResponseEntity<>(_destino, HttpStatus.CREATED);
    }

    @PutMapping("/destinos/{id}")
    public ResponseEntity<Destino> atualizarDestino(@PathVariable("id") long id, @RequestBody Destino destino) {
        Destino _destino = destinoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destino não encontrado com id = " + id));
        _destino.setNome(destino.getNome());
        _destino.setTelefone(destino.getTelefone());
        _destino.setEmail(destino.getEmail());
        _destino.setCidade(destino.getCidade());
        _destino.setEstado(destino.getEstado());
        _destino.setRua(destino.getRua());
        _destino.setNumero(destino.getNumero());
        _destino.setLatitude(destino.getLatitude());
        _destino.setLongitude(destino.getLongitude());
        _destino.setDescricao(destino.getDescricao());
        return new ResponseEntity<>(destinoRepository.save(_destino), HttpStatus.OK);
    }

    @DeleteMapping("/destinos/{id}")
    public ResponseEntity<HttpStatus> deletarDestino(@PathVariable("id") long id) {

        destinoRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
