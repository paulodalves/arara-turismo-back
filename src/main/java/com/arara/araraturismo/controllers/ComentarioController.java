package com.arara.araraturismo.controllers;

import com.arara.araraturismo.exception.ResourceNotFoundException;
import com.arara.araraturismo.models.Comentario;
import com.arara.araraturismo.repositories.ComentarioRepository;
import com.arara.araraturismo.repositories.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/destino")
public class ComentarioController {
    @Autowired
    DestinoRepository destinoRepository;
    @Autowired
    ComentarioRepository comentarioRepository;

    @GetMapping("/detalhes/{destinoId}/comentarios")
    public ResponseEntity<List<Comentario>> listarTodosComentariosPorDestinoId(@PathVariable(value = "destinoId") Long destinoId) {
        if (!destinoRepository.existsById(destinoId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Comentario> comentarios = comentarioRepository.findByDestinoId(destinoId);
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }


    @PostMapping("/detalhes/{destinoId}/comentarios")
    public ResponseEntity<Comentario> criarComentario(@PathVariable(value = "destinoId") Long destinoId,
                                                 @RequestBody Comentario comentarioRequest) {
        Comentario comentario = destinoRepository.findById(destinoId).map(destino -> {
            comentarioRequest.setDestino(destino);
            return comentarioRepository.save(comentarioRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Destino não encontrado com id = " + destinoId));
        return new ResponseEntity<>(comentario, HttpStatus.CREATED);
    }

    @DeleteMapping("/comentario/{id}")
    public ResponseEntity<HttpStatus> deletarComentario(@PathVariable("id") long id) {
        comentarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
