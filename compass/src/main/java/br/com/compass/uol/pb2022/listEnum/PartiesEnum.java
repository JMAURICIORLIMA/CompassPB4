package br.com.compass.uol.pb2022.listEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PartiesEnum {
    RIGHT("Direita"),
    LEFT("Esqueda"),
    CENTER("Centro");

    private String description;

}
