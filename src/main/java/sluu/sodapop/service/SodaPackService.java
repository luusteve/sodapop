package sluu.sodapop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sluu.sodapop.entity.SodaPack;
import sluu.sodapop.repository.SodaPackRepository;

@Service
public class SodaPackService {
  
  @Autowired
  SodaPackRepository sodaPackRepository;

  @Transactional
  public SodaPack create(SodaPack sodaPack) {
    sodaPack.setUuid(UUID.randomUUID());
    return sodaPackRepository.save(sodaPack);
  }

  @Transactional
  public SodaPack update(SodaPack sodaPack) {
    return sodaPackRepository.save(sodaPack);
  }

  @Transactional
  public void delete(UUID uuid) {
    SodaPack foundSodaPack = sodaPackRepository.findSodaPackByUuid(uuid);
    sodaPackRepository.delete(foundSodaPack);
  }

  @Transactional
  public SodaPack getSodaPack(UUID uuid) {
    return sodaPackRepository.findSodaPackByUuid(uuid);
  }

  @Transactional
  public List<SodaPack> getAllSodaPacks() {
    return toList(sodaPackRepository.findAll());
  }

  @Transactional
  public void deleteSodaPack(UUID uuid) {
    SodaPack sodaPack = sodaPackRepository.findSodaPackByUuid(uuid);
    if (sodaPack == null) {
      throw new NullPointerException("No SodaPack by this UUID.");
    }
    sodaPackRepository.delete(sodaPack);
  }

  private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}
