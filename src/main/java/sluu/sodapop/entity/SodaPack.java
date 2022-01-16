package sluu.sodapop.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@SuperBuilder
@Setter
@Getter
@TypeDef(
    name = "pgsql_enum",
    typeClass = PostgreSQLEnumType.class
)
public class SodaPack extends Product {

  public enum BottlingType {
    CAN,
    PLASTIC,
    GLASS
  }

  @Type(type = "pgsql_enum")
  private BottlingType bottlingType;

  private Integer unitsPerPack;

  private Integer volumePerUnit;

  private LocalDate expirationDate;
    
}
