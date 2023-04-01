package com.example.portfolio.model;

import com.example.utils.model.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Data;

@Entity
@Table(name = "PORTFOLIO_ENTRY_DETAILS")
@Data
public class PortfolioItemModelDetails extends BaseModel {

  @Column(name= "ABOUT_LOCATION", columnDefinition = "text")
  private String aboutLocation;

  @Column(name= "COAT_OF_ARMS_DESCRIPTION", columnDefinition = "text")
  private String coatOfArmsDescription;

  @Column(name = "SYMBOLS_DESCRIPTION", columnDefinition = "text")
  private String symbolsDescription;

  @Column(name = "HISTORY_DESCRIPTION", columnDefinition = "text")
  private String history;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "portfolioItemModelDetails")
  private Set<PortfolioMediaModel> portfolioImage;

}
