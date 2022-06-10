package com.newlife.Newlife.repository;

import com.newlife.Newlife.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo,Long>, JpaSpecificationExecutor<Veiculo> {

    @Query("SELECT a FROM Veiculo a WHERE a.placa = :placa")
    Optional<Veiculo> findByPlaca(String placa);

}
