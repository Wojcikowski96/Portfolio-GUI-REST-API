package com.example.portfolio.model;

import com.example.utils.model.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Data;

@Entity
@Table(name = "PORTFOLIO_ENTRY")
@Data
public class PortfolioItemModel extends BaseModel {
  @Column(name = "TITTLE")
  private String tittle;

  @Column(name = "WOJEWODZTWO")
  private String wojewodztwo;

  @Column(name = "POWIAT")
  private String powiat;

  @Column(name = "PROJECT_TYPE")
  private String projectType;

  @Column(name = "COAT_OF_ARMS_URL")
  private String url;

  @Column(name= "ABOUT_LOCATION", columnDefinition = "varchar(1000)")
  private String aboutLocation;

  @Column(name= "COAT_OF_ARMS_DESCRIPTION", columnDefinition = "varchar(1000)")
  private String coatOfArmsDescription;

  @Column(name = "SYMBOLS_DESCRIPTION" , columnDefinition = "varchar(1000)")
  private String symbolsDescription;

  @Column(name = "HISTORY_DESCRIPTION" , columnDefinition = "varchar(1000)")
  private String history;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "portfolioItemModel")
  private Set<PortfolioMediaModel> portfolioImage;



}
