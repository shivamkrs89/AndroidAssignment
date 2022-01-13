package com.example.fun_with_flags;

public class Country {
    String name;
    String region;
    String capital;
    String image;
    String subregion;
    String languages;
    String borders;
    String population;

    public Country(String name, String region, String capital, String image, String subregion, String languages, String borders, String population) {
        this.name = name;
        this.region = region;
        this.capital = capital;
        this.image = image;
        this.subregion = subregion;
        this.languages = languages;
        this.borders = borders;
        this.population = population;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public String getLanguages() {
        return languages;
    }

    public String getBorders() {
        return borders;
    }

    public String getName() {
        return name;
    }


    public String getCapital() {
        return capital;
    }

    public String getImage() {
        return image;
    }
    public  String getPopulation(){return population;}
}
