package sluu.sodapop.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import sluu.sodapop.entity.SodaPack;

public interface SodaPackRepository extends CrudRepository<SodaPack, UUID> {
  
  SodaPack findSodaPackByUuid(UUID uuid);

  List<SodaPack> findByName(String name);
}
