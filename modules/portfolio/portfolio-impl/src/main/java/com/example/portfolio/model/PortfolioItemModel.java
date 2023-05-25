package com.example.portfolio.model;

import com.example.utils.model.BaseModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;
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

  @Column(name = "CREATED_AT")
  private LocalDateTime createdAt;

  @Column(name = "CITY_LONGITUDE")
  private Double longitude;

  @Column(name = "CITY_LATITUDE")
  private Double latitude;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "portfolioItemModel")
  private Set<PortfolioMediaModel> mediaModels;



}
