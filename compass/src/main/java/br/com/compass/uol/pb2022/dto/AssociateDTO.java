package br.com.compass.uol.pb2022.dto;

import br.com.compass.uol.pb2022.listEnum.AssociatesEnum;
import br.com.compass.uol.pb2022.model.Associate;
import br.com.compass.uol.pb2022.model.Party;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class AssociateDTO {

    @NotNull
    @NotBlank(message = "Name")
    public String name;

    @NotNull
    @NotBlank(message = "Plitical Position")
    public String politicalPosition;

    @NotNull
    @NotBlank(message = "Sex")
    public String sex;

    @NotNull
    @NotBlank(message = "Brith Date")
    public LocalDate brithDate;

    @NotNull
    @NotBlank(message = "Party")
    public Party parties;

    public AssociateDTO(@NotNull(message = "Member name required.") String name, @NotNull(message = "Political position required.") AssociatesEnum politicalPosition, @NotNull(message = "Member gender required.") String sex, @NotNull(message = "Member's date of birth required.") LocalDate brithDate) {
    }

    public AssociateDTO(String name, String politicalPosition, String sex, LocalDate brithDate) {
        this.name = name;
        this.politicalPosition = politicalPosition;
        this.sex = sex;
        this.brithDate = brithDate;
    }

    public static AssociateDTO associateToAssociateDTD(Associate associate) {
        return new AssociateDTO(associate.getName(), associate.getPoliticalPosition(), associate.getSex(), associate.getBrithDate());
    }
}
