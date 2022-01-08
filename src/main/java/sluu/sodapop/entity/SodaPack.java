package sluu.sodapop.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
public class SodaPack extends Product {

  public enum BottlingType{
    CAN,
    PLASTIC,
    GLASS
  }

  @Type(type = "pgsql_enum")
  private BottlingType bottlingType;

  private Integer units;

  private Integer volumePerUnit;

  private LocalDate expirationDate;
    
}
