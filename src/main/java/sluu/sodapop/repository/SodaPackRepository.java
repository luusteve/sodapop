package sluu.sodapop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sluu.sodapop.entity.SodaPack;

public interface SodaPackRepository extends CrudRepository<SodaPack, String> {
  
  SodaPack findSodaPackByUuid(String uuid);

  List<SodaPack> findByName(String name);
}
