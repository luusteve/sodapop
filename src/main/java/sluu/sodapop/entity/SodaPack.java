package sluu.sodapop.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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
  @Enumerated(EnumType.STRING)
  private BottlingType bottlingType;

  @Min(1)
  private int unitsPerPack;

  @Min(1)
  private int volumePerUnit;
    
}
