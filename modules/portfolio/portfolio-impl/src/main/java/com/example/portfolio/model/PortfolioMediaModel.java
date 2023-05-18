package com.example.portfolio.model;

import com.example.utils.model.MediaModel;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "PORTFOLIO_MEDIA")
public class PortfolioMediaModel extends MediaModel {
  @ManyToOne
  @JoinColumn(name = "PORTFOLIO_ID")
  private PortfolioItemModel portfolioItemModel;
}
