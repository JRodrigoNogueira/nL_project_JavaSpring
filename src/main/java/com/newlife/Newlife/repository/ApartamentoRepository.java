package com.newlife.Newlife.repository;

import com.newlife.Newlife.entity.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento,Long>, JpaSpecificationExecutor<Apartamento> {

    @Query("SELECT a FROM Apartamento a WHERE a.id = :id")
    Optional<Apartamento> findById(Long id);

}
