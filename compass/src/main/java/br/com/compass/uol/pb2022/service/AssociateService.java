package br.com.compass.uol.pb2022.service;

import br.com.compass.uol.pb2022.dto.AssociateDTO;
import br.com.compass.uol.pb2022.dto.PartyDTO;
import br.com.compass.uol.pb2022.model.Associate;
import br.com.compass.uol.pb2022.model.Party;
import br.com.compass.uol.pb2022.repository.AssociateRepository;
import br.com.compass.uol.pb2022.util.ChecksNullValue;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssociateService {

    @Autowired
    AssociateRepository associateRepository;

    public String saveAssociate(AssociateDTO associateDTO) {
        String resultNullValue = ChecksNullValue.checkNullValueMethod(associateDTO);

        if (resultNullValue.isEmpty()) {
            Associate associate = new Associate();
            BeanUtils.copyProperties(associateDTO, associate);
            associateRepository.save(associate);
            return "Saved successfully.";
        }
        return "required field: " + resultNullValue;
    }

    public List<AssociateDTO> searchAssociate() {
        List<Associate> associateList = associateRepository.findAll();

        return associateList.stream().map(obj -> new AssociateDTO(obj.getName(),
                        obj.getPoliticalPosition(),
                        obj.getSex(),
                        obj.getBrithDate()))
                .collect(Collectors.toList());
    }

    public AssociateDTO searchById(Long id) {
        Optional<Associate> associate = associateRepository.findById(id);
        return associate.map(AssociateDTO::associateToAssociateDTD).orElse(null);
    }

    public String deleteAssociate(Long id) {
        associateRepository.deleteById(id);
        return "deletado com sucesso!";
    }

    public ResponseEntity<?> deleteAssociatedByParty(Long id, Long partyId) {
        Optional<Associate> associate = associateRepository.findById(id);
        if (associate.isPresent()) {
            associate.get().setParties(null);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
