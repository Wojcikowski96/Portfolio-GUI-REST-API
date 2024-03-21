package com.example.portfolio.specification;

import com.example.PortfolioEntryDomain;
import com.example.portfolio.model.PortfolioItemModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Root;
import lombok.Setter;
import org.hibernate.query.sqm.tree.predicate.SqmLikePredicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@Setter
public class PortfolioSearchSpecification {
  public Specification<PortfolioItemModel> getEntries(PortfolioEntryDomain domain) {

    return (root, query, criteriaBuilder) -> {


      List<Predicate> predicates = new ArrayList<>();


      if (domain.getTittle() != null && !domain.getTittle().isEmpty()) {
        predicates.add(
            criteriaBuilder.like(criteriaBuilder.lower(root.get("tittle")),
                "%" + domain.getTittle().toLowerCase() + "%"));
      }

      return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

    };

  }
}
