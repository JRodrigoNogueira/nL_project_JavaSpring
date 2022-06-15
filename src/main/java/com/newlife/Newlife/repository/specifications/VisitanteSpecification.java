package com.newlife.Newlife.repository.specifications;

import com.newlife.Newlife.entity.Visitante;
import com.newlife.Newlife.entity.Visitante_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class VisitanteSpecification {

    public static Specification<Visitante> visitanteLike(String info){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Visitante_.visitante),"%"+info+"%");
    }

    public static Specification<Visitante> rgLike(String info){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Visitante_.rg),"%"+info+"%");
    }

    public static Specification<Visitante> cpfLike(String info){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Visitante_.cpf),"%"+info+"%");
    }

    public static Specification<Visitante> telefone1(String info){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Visitante_.telefone1),"%"+info+"%");
    }

    public static Specification<Visitante> likeGenericQuery(String queryString) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>(4);
            predicates.add(visitanteLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(rgLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(cpfLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(telefone1(queryString).toPredicate(root, query, criteriaBuilder));
            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }

}
