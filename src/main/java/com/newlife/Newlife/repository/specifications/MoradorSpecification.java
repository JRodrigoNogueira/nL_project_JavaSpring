package com.newlife.Newlife.repository.specifications;

import com.newlife.Newlife.entity.Morador;
import com.newlife.Newlife.entity.Morador_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class MoradorSpecification {

    public static Specification<Morador> visitanteLike(String info){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Morador_.morador),"%"+info+"%");
    }

    public static Specification<Morador> rgLike(String info){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Morador_.rg),"%"+info+"%");
    }

    public static Specification<Morador> cpfLike(String info){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Morador_.cpf),"%"+info+"%");
    }

    public static Specification<Morador> telefone1(String info){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Morador_.telefone1),"%"+info+"%");
    }

    public static Specification<Morador> likeGenericQuery(String queryString) {
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
