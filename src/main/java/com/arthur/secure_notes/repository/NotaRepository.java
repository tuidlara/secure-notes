package com.arthur.secure_notes.repository;

import com.arthur.secure_notes.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    List<Nota> findByUsuarioEmail(String email);

    Optional<Nota> findByIdAndUsuarioEmail(Long id, String email);

}