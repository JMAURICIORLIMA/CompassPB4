package br.com.compass.uol.pb2022.dto;

import br.com.compass.uol.pb2022.model.Party;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

@Data
public class PartyDTO {
    @NotNull(message = "Party name required.")
    public String nameParty;

    @NotNull(message = "Party acronym required.")
    public String acronym;

    @NotNull(message = "Necessary party ideology.")
    public String ideology;

    @NotNull(message = "Party creation date required.")
    public LocalDate foundingDate;

    public PartyDTO() {}

    public PartyDTO(String nameParty, String acronym, String ideology, LocalDate foundingDate) {
        this.nameParty = nameParty;
        this.acronym = acronym;
        this.ideology = ideology;
        this.foundingDate = foundingDate;
    }

    public static PartyDTO partyToPartyDTD(Party party){
        return new PartyDTO(party.getNameParty(), party.getAcronym(), party.getIdeology(), party.getFoundingDate());
    }
}
