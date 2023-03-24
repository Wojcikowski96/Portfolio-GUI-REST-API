package com.example.portfolio.model;

import com.example.utils.model.ImageModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "PORTFOLIO_IMAGES")
public class PortfolioImageModel extends ImageModel {
  @ManyToOne
  @JoinColumn(name = "PORTFOLIO_DETAILS_ID")
  private PortfolioItemModelDetails portfolioItemModelDetails;
}
