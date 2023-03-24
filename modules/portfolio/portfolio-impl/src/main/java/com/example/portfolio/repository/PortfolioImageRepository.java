package com.example.portfolio.repository;

import com.example.portfolio.model.PortfolioImageModel;
import com.example.utils.repository.ImagesRepository;
import java.util.List;
import java.util.Optional;

public interface PortfolioImageRepository extends ImagesRepository<PortfolioImageModel> {
 Optional<List<PortfolioImageModel>> findByPortfolioItemModelDetailsId(Long id);
}
