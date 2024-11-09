package com.auradecristal.aura_de_cristal.repository;

import com.auradecristal.aura_de_cristal.entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long> {
}
