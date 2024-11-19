package com.auradecristal.aura_de_cristal.repository;

import com.auradecristal.aura_de_cristal.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findByNombre(String nombre);
    @Query(value = "SELECT * FROM producto ORDER BY RAND() LIMIT 10", nativeQuery = true)
    List<Producto> findRandomProducts();

}
