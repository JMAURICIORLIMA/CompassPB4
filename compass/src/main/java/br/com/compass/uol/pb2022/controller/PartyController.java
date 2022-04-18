package br.com.compass.uol.pb2022.controller;

import br.com.compass.uol.pb2022.dto.PartyDTO;
import br.com.compass.uol.pb2022.service.PartyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Parties")
@RestController
@RequestMapping("/parties")
public class PartyController {

    @Autowired
    PartyService partyService;

    @ApiOperation(value = "Save Party")
    @PostMapping
    public ResponseEntity<String> saveParty(@RequestBody PartyDTO partyDTO) {
        return new ResponseEntity<>(partyService.saveParty(partyDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Search Party Ideology")
    @GetMapping("/searchParty")
    public ResponseEntity<List<PartyDTO>> searchPartyIdeology(@RequestParam String ideology) {
        return new ResponseEntity<>(partyService.searchParty(ideology), HttpStatus.OK);
    }

    @ApiOperation(value = "Search By Id")
    @GetMapping("/party/{id}")
    public ResponseEntity<PartyDTO> searchById(@PathVariable Long id) {
        return new ResponseEntity<PartyDTO>(partyService.searchById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Update Party")
    @PutMapping("/party/{id}")
    public ResponseEntity<String> updateParty(@PathVariable Long id, @RequestBody PartyDTO partyDTO) {
        return ResponseEntity.ok(partyService.updateParty(id, partyDTO));
    }

    @DeleteMapping("/party/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteParty(@PathVariable Long id) {
        return partyService.deleteParty(id);
    }

    // TODO • GET - /partidos/{id}/associados (Listar todos os associados daquele partido)


}
