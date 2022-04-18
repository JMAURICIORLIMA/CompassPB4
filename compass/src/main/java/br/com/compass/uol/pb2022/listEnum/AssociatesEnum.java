package br.com.compass.uol.pb2022.listEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AssociatesEnum {

    ALDERMAN("Vereador"),
    MAYOR("Prefeito"),
    CONGRESSMAN("deputado federal"),
    STATE_DEPUTY("deputado estadual"),
    PRESIDENT("presidente"),
    SENADOR("senador"),
    NONE("nenhum");

    private String description;


}
