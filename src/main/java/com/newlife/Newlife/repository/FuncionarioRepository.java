package com.newlife.Newlife.repository;

import com.newlife.Newlife.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>, JpaSpecificationExecutor<Funcionario> {

    @Query("SELECT a FROM Funcionario a WHERE a.funcionario = :funcionario")
    Optional<Funcionario> findByFuncionario(String funcionario);

}
