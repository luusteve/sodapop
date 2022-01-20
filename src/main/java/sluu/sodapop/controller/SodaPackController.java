package sluu.sodapop.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import sluu.sodapop.service.CSVService;
import sluu.sodapop.service.SodaPackService;

@RestController
@RequestMapping("/sodaPacks")
@CrossOrigin
public class SodaPackController {
  
  @Autowired
  private SodaPackService sodaPackService;

  @Autowired
  private CSVService csvService;

  @PostMapping(value = {"", "/"})
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

  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<SodaPack>> getAllSodaPacks() {
    return ResponseEntity.ok(sodaPackService.getAllSodaPacks());
  }

  @PutMapping(value = {"/{uuid}", "/{uuid}/"})
  public ResponseEntity<SodaPack> update(@RequestBody SodaPack sodaPack, @PathVariable String uuid) {
    SodaPack foundSodaPack = sodaPackService.getSodaPack(UUID.fromString(uuid));
    if (foundSodaPack == null) {
      return ResponseEntity.notFound().build();
    } else {
      sodaPack.setId(foundSodaPack.getId());
      sodaPack.setUuid(UUID.fromString(uuid));
      BeanUtils.copyProperties(sodaPack, foundSodaPack);
      SodaPack updatedSodaPack = sodaPackService.update(foundSodaPack);
      return ResponseEntity.ok(updatedSodaPack);
    }
  }

  @DeleteMapping(value = {"/{uuid}", "/{uuid}/"})
  public ResponseEntity<SodaPack> delete(@PathVariable String uuid) {
    sodaPackService.delete(UUID.fromString(uuid));
    return ResponseEntity.noContent().build();
  }

  @GetMapping(value = {"/download", "/download/"})
  public ResponseEntity<Resource> getFile() {
    String filename = "sodaPacks.csv";
    InputStreamResource file = new InputStreamResource(csvService.load());

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
        .contentType(MediaType.parseMediaType("application/csv"))
        .body(file);
  }
}
