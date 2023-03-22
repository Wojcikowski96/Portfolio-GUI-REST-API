package com.example.portfolio.repository;

import com.example.blog.model.BlogEntryModel;
import com.example.portfolio.model.PortfolioItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PortfolioRepository extends JpaRepository<PortfolioItemModel, Long>,
    JpaSpecificationExecutor<PortfolioItemModel> {
}
