package sluu.sodapop.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NaturalId
  @NonNull
  @Column(unique = true)
  private UUID uuid;

  @NonNull
  private String name;

  @NonNull
  @Digits(integer=5, fraction=2)
  private BigDecimal weight;

  @Min(0)
  private int count;

  private boolean isFragile;
  
}
