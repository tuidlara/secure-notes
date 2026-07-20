package com.arthur.secure_notes.repository;

import com.arthur.secure_notes.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
