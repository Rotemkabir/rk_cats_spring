package com.jb.cats.service;

import com.jb.cats.beans.Cat;
import com.jb.cats.beans.Color;
import com.jb.cats.exception.CatSystemException;

import java.util.List;

public interface CatService {

    void addCat(Cat cat) throws CatSystemException;
    void updateCat(int id,Cat cat) throws CatSystemException;
    void deleteCat(int id) throws CatSystemException;
    List<Cat> getAllCats();
    Cat getSingletCat(int id) throws CatSystemException;
    double avgWeight();
    int countCatInColor(Color color);
    List<Cat> getByCatsStaringWith(String letter);
    List<Cat> getAllCatsOverWeight(double weight);
    List<Cat> getAllCatsUnderWeight(double weight);
    List<Cat> getAllCatsByColorAndOverWeight(Color color,double weight) throws CatSystemException;
    List<Cat> getAllCatsByColorOrOverWeight(Color color,double weight) throws CatSystemException;
}
