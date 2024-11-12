package com.auradecristal.aura_de_cristal.repository;

import com.auradecristal.aura_de_cristal.entity.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Long> {
}
