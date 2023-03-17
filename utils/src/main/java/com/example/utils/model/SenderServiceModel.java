package com.example.utils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SENDER_SERVICE")
@Data
public class SenderServiceModel extends BaseModel {

  @Column(name = "EMAIL")
  private String email;

  @Column(name= "PASSWORD")
  private String password;
}
