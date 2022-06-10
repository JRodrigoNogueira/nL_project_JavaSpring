package com.newlife.Newlife.repository;

import com.newlife.Newlife.entity.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoradorRepository extends JpaRepository<Morador,Long>, JpaSpecificationExecutor<Morador> {

    @Query("SELECT a FROM Morador a WHERE a.morador = :morador")
    Optional<Morador> findByMorador(String morador);

}
