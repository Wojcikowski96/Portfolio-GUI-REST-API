package com.example.portfolio.model;

import com.example.utils.model.BaseModel;
import com.example.utils.model.ImageModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Data;

@Entity
@Table(name = "PORTFOLIO_ENTRY_DETAILS")
@Data
public class PortfolioItemModelDetails extends BaseModel {

  @Column(name= "ABOUT_LOCATION", columnDefinition = "text")
  String aboutLocation;

  @Column(name= "COAT_OF_ARMS_DESCRIPTION", columnDefinition = "text")
  String coatOfArmsDescription;

  @Column(name = "SYMBOLS_DESCRIPTION", columnDefinition = "text")
  String symbolsDescription;

  @Column(name = "HISTORY_DESCRIPTION", columnDefinition = "text")
  String history;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "ENTRY_ID")
  private Set<ImageModel> image;

}
