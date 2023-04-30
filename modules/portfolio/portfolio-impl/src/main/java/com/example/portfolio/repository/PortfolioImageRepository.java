package com.example.portfolio.repository;

import com.example.portfolio.model.PortfolioMediaModel;
import com.example.utils.repository.ImagesRepository;
import java.util.List;
import java.util.Optional;

public interface PortfolioImageRepository extends ImagesRepository<PortfolioMediaModel> {
 Optional<List<PortfolioMediaModel>> findByPortfolioItemModelId(Long id);
}
