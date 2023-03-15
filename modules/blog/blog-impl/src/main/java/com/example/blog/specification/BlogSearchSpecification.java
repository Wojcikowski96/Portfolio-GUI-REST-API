package com.example.blog.specification;

import com.example.BlogEntryDomain;
import com.example.blog.model.BlogEntryModel;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@Setter
public class BlogSearchSpecification {

  public Specification<BlogEntryModel> getEntries(BlogEntryDomain domain) {

    return (root, query, criteriaBuilder) -> {

      List<Predicate> predicates = new ArrayList<>();

      if (domain.getContent() != null &&
          !domain.getContent().isEmpty()) {
        predicates.add(
            criteriaBuilder.like(criteriaBuilder.lower(root.get("contentdsa")),
                "%" + domain.getContent().toLowerCase() + "%"));
      }

      if (domain.getTittle() != null && !domain.getTittle().isEmpty()) {
        predicates.add(
            criteriaBuilder.like(criteriaBuilder.lower(root.get("tittle")),
                "%" + domain.getTittle().toLowerCase() + "%"));
      }

      return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

    };

  }

}
