package br.com.compass.uol.pb2022.service;

import br.com.compass.uol.pb2022.dto.PartyDTO;
import br.com.compass.uol.pb2022.model.Party;
import br.com.compass.uol.pb2022.repository.PartyRepository;
import br.com.compass.uol.pb2022.util.ChecksNullValue;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartyService {

    @Autowired
    PartyRepository partyRepository;

    public String saveParty(PartyDTO partyDTO) {
        Optional<Boolean> checkAcronym = partyRepository.checkAcronym(partyDTO.getAcronym());
        if (checkAcronym.isPresent()) {
            return "acronym already exists";
        }
        String resultNullValue = ChecksNullValue.checkNullValueMethod(partyDTO);
        if (resultNullValue.isEmpty()) {
            Party party = new Party();
            BeanUtils.copyProperties(partyDTO, party);
            partyRepository.save(party);
            return "Saved successfully.";
        }
        return "required field: " + resultNullValue;
    }

    // GET - /partidos (Ter uma opção de filtrar partidos de acordo com sua ideologia)
    public List<PartyDTO> searchParty(String ideology) {
        List<Party> partyList = partyRepository.findByIdeology(ideology);

        return partyList.stream().map(obj -> new PartyDTO(obj.getNameParty(), obj.getAcronym(), obj.getIdeology(), obj.getFoundingDate())).collect(Collectors.toList());
    }

    public PartyDTO searchById(Long id) {
        Optional<Party> party = partyRepository.findById(id);
        return party.map(PartyDTO::partyToPartyDTD).orElse(null);
    }

    public String updateParty(Long id, PartyDTO partyDTO) {
        String resultNullValue = ChecksNullValue.checkNullValueMethod(partyDTO);
        if (verificaParty(id) && !resultNullValue.isEmpty()) {
            Party party = new Party();
            party.setId(id);
            BeanUtils.copyProperties(partyDTO, party);
            partyRepository.save(party);
            return "Update successfully.";
        }

        return "Error Update Party!";
    }

    public Boolean verificaParty(Long id) {
        Optional<Party> party = partyRepository.findById(id);
        if (party.isEmpty()) {
            return false;
        }
        return true;
    }

    public String deleteParty(Long id) {
        partyRepository.deleteById(id);
        return "deletado com sucesso!";
    }

    //TODO • GET - /partidos/{id}/associados (Listar todos os associados daquele partido)

}