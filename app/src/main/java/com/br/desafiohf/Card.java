package com.br.desafiohf;

import java.util.Map;

public class Card {

    private final String NOT_FOUND = "Não informado";

    private String name;
    private String image;
    private String species;
    private String house;
    private Map<String, String> wand;

    public String getName() {
        if(!name.isEmpty()) {
            return name;
        }
        return NOT_FOUND;
    }

    public String getImageURL() {
        if(!image.isEmpty()) {
            return image;
        }
        return "";
    }

    public String getSpecies() {
        if(!species.isEmpty()){
            return species;
        }
        return NOT_FOUND;
    }

    public String getHouse() {
        if(!house.isEmpty()) {
            return house;
        }
        return NOT_FOUND;
    }

    public Map<String, String> getWand() {
        return wand;
    }
}
