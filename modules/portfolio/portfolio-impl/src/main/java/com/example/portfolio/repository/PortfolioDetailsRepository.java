package com.example.portfolio.repository;

import com.example.portfolio.model.PortfolioItemModelDetails;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioDetailsRepository extends JpaRepository<PortfolioItemModelDetails, Long> {

}
