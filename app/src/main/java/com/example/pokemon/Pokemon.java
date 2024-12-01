package com.example.pokemon;

public class Pokemon {

    private int id;  // ID del Pokémon
    private String name;
    private String height;
    private String weight;
    private Sprites sprite;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getSprite() {
        return sprite != null ? sprite.getFrontDefault() : null;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setSprite(Sprites sprite) {
        this.sprite = sprite;
    }


    public static class Sprites {
        private String front_default;  // URL del sprite

        public String getFrontDefault() {
            return front_default;
        }

        public void setFrontDefault(String front_default) {
            this.front_default = front_default;
        }
    }
}
