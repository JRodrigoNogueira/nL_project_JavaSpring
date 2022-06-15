package com.newlife.Newlife.repository.specifications;

import com.newlife.Newlife.entity.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioSpecification {

    public static Specification<Funcionario> funcionarioLike(String info){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Funcionario_.funcionario),"%"+info+"%");
    }

    public static Specification<Funcionario> rgLike(String info){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Funcionario_.rg),"%"+info+"%");
    }

    public static Specification<Funcionario> cpfLike(String info){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Funcionario_.cpf),"%"+info+"%");
    }

    public static Specification<Funcionario> telefone1(String info){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Funcionario_.telefone1),"%"+info+"%");
    }

    public static Specification<Funcionario> likeGenericQuery(String queryString) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>(4);
            predicates.add(funcionarioLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(rgLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(cpfLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(telefone1(queryString).toPredicate(root, query, criteriaBuilder));
            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }
}
