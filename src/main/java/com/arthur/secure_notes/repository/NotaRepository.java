package com.arthur.secure_notes.repository;

import com.arthur.secure_notes.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}