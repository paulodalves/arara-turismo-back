package com.arara.araraturismo.repositories;

import com.arara.araraturismo.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByDestinoId(Long postId);
}
