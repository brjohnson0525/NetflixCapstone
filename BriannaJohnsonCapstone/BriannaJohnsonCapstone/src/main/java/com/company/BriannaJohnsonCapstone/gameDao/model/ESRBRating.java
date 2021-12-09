package com.company.BriannaJohnsonCapstone.gameDao.model;

public class ESRBRating {
    private int gameId;
    private String title;
    private String ESRBRating;
    private String description;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getESRBRating() {
        return ESRBRating;
    }

    public void setESRBRating(String ESRBRating) {
        this.ESRBRating = ESRBRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
