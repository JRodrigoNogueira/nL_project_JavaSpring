package com.newlife.Newlife.repository;

import com.newlife.Newlife.entity.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante,Long>, JpaSpecificationExecutor<Visitante> {

    @Query("SELECT a FROM Visitante a WHERE a.visitante = :visitante")
    Optional<Visitante> findByVisitante(String visitante);

}
