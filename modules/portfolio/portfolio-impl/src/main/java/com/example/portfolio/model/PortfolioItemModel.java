package com.example.portfolio.model;

import com.example.utils.model.BaseModel;
import com.example.utils.model.ImageModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Data;

@Entity
@Table(name = "PORTFOLIO_ENTRY")
@Data
public class PortfolioItemModel extends BaseModel {
  @Column(name = "TITTLE")
  private String tittle;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "PORTFOLIO_ID")
  private PortfolioItemModelDetails portfolioItemModelDetails;

  @Column(name = "WOJEWODZTWO")
  private String wojewodztwo;

  @Column(name = "POWIAT")
  private String powiat;

  @Column(name = "PROJECT_TYPE")
  private String projectType;



}
