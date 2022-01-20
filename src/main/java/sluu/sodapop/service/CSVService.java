package sluu.sodapop.service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sluu.sodapop.entity.SodaPack;
import sluu.sodapop.helper.CSVHelper;
import sluu.sodapop.repository.SodaPackRepository;

@Service
public class CSVService {

  @Autowired
  SodaPackRepository sodaPackRepository;

  public ByteArrayInputStream load() {
    List<SodaPack> sodapacks = toList(sodaPackRepository.findAll());

    return CSVHelper.sodaPacksToCSV(sodapacks);
  }

  private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
  
}
