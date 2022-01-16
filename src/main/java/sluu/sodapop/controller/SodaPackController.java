package sluu.sodapop.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sluu.sodapop.entity.SodaPack;
import sluu.sodapop.service.SodaPackService;

@RestController
@RequestMapping("/sodaPacks")
public class SodaPackController {
  
  @Autowired
  private SodaPackService sodaPackService;

  @PostMapping("/")
  public ResponseEntity<SodaPack> create(@RequestBody SodaPack sodaPack) throws URISyntaxException {
    SodaPack createdSodaPack = sodaPackService.create(sodaPack);
    if (createdSodaPack == null) {
      return ResponseEntity.notFound().build();
    } else {
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{uuid}")
        .buildAndExpand(createdSodaPack.getUuid())
        .toUri();
      
      return ResponseEntity.created(uri).body(createdSodaPack);
    }
  }

  @GetMapping(value = {"/{uuid}"})
  public ResponseEntity<SodaPack> read(@PathVariable("uuid") String uuid) {
    SodaPack foundSodaPack = sodaPackService.getSodaPack(UUID.fromString(uuid));
    if (foundSodaPack == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(foundSodaPack);
    }
  }

  @PutMapping("/{uuid}")
  public ResponseEntity<SodaPack> update(@RequestBody SodaPack sodaPack, @PathVariable String uuid) {
    SodaPack foundSodaPack = sodaPackService.getSodaPack(UUID.fromString(uuid));
    if (foundSodaPack == null) {
      return ResponseEntity.notFound().build();
    } else {
      SodaPack updatedSodaPack = sodaPackService.update(sodaPack);
      return ResponseEntity.ok(updatedSodaPack);
    }
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<SodaPack> delete(@PathVariable String uuid) {
    sodaPackService.delete(UUID.fromString(uuid));
    return ResponseEntity.noContent().build();
  }
}
