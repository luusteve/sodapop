package sluu.sodapop.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SodaDto {
  
  private UUID uuid;
  private String name;
}
