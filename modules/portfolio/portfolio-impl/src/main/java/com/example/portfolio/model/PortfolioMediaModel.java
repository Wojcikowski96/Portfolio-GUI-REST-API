package com.example.portfolio.model;

import com.example.utils.model.MediaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "PORTFOLIO_MEDIA")
public class PortfolioMediaModel extends MediaModel {
  @ManyToOne
  @JoinColumn(name = "PORTFOLIO_DETAILS_ID")
  private PortfolioItemModelDetails portfolioItemModelDetails;
}
