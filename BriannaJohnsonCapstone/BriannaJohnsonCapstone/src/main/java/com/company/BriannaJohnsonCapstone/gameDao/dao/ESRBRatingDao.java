package com.company.BriannaJohnsonCapstone.gameDao.dao;

public interface ESRBRatingDao {
    ESRBRating addESRBRating(ESRBRating esrbRating);
    ESRBRating getESRBRating(int id);
    List<ESRBRating> getAllESRBRatings();
    void updateESRBRating(ESRBRating esrbRating);
    void deleteESRBRating(int id);
}
