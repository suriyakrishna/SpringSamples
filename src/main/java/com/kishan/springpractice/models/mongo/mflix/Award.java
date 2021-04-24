package com.kishan.springpractice.models.mongo.mflix;

public class Award {
    private Integer wins;
    private Integer nominations;
    private String text;

    public Award() {
    }

    public Award(Integer wins, Integer nominations, String text) {
        this.wins = wins;
        this.nominations = nominations;
        this.text = text;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getNominations() {
        return nominations;
    }

    public void setNominations(Integer nominations) {
        this.nominations = nominations;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
