package br.com.compass.uol.pb2022.controller;

import br.com.compass.uol.pb2022.dto.AssociateDTO;
import br.com.compass.uol.pb2022.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/associates")
public class AssociateController {

    @Autowired
    AssociateService associateService;

    @PostMapping
    public ResponseEntity<String> saveAssosiate(@Valid @RequestBody AssociateDTO associateDTO) {
        return new ResponseEntity<>(associateService.saveAssociate(associateDTO),HttpStatus.CREATED);
    }

    @GetMapping("/searchAssociate")
    public ResponseEntity<List<AssociateDTO>> searchAssociate() {
        return new ResponseEntity<>(associateService.searchAssociate(), HttpStatus.OK);
    }

    @GetMapping("/associate/{id}")
    public ResponseEntity<AssociateDTO> searchById(@PathVariable Long id) {
        return new ResponseEntity<AssociateDTO>(associateService.searchById(id), HttpStatus.OK);
    }

    @DeleteMapping("/associate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteAssociate(@PathVariable Long id) {
        return associateService.deleteAssociate(id);
    }

    @DeleteMapping(path = "/{id}/party/{partyId}")
    @Transactional
    public ResponseEntity<?> deleteAssociatedByParty(@PathVariable Long id, @PathVariable Long partyId) {
        return associateService.deleteAssociatedByParty(id, partyId);

    }
}