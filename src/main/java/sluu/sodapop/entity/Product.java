package sluu.sodapop.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.NaturalId;

import lombok.Data;
import lombok.NonNull;

@Data
@MappedSuperclass
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NaturalId
  @NonNull
  @Column(unique = true)
  private UUID uuid;

  @NonNull
  private String name;

  @NonNull
  private BigDecimal weight;

  private boolean isFragile;
  
}
