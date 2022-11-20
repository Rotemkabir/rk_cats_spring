package com.jb.cats.service;

import com.jb.cats.beans.Cat;
import com.jb.cats.beans.Color;
import com.jb.cats.exception.CatSystemException;
import com.jb.cats.exception.ErrMsg;
import com.jb.cats.repos.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatRepository catRepository;

    @Override
    public void addCat(Cat cat) throws CatSystemException {
        int id = cat.getId();
        if (catRepository.existsById(id)) {
            throw new CatSystemException(ErrMsg.ID_ALREADY_EXIST);
        }
        catRepository.save(cat);
    }

    @Override
    public void updateCat(int id, Cat cat) throws CatSystemException {
        if (!catRepository.existsById(id)) {
            throw new CatSystemException(ErrMsg.ID_NOT_FOUND);
        }
        cat.setId(id);
        catRepository.saveAndFlush(cat);
    }

    @Override
    public void deleteCat(int id) throws CatSystemException {
        if (!catRepository.existsById(id)) {
            throw new CatSystemException(ErrMsg.ID_NOT_FOUND);
        }
        catRepository.deleteById(id);
    }

    @Override
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    @Override
    public Cat getSingletCat(int id) throws CatSystemException {
        return catRepository.findById(id)
                .orElseThrow(() -> new CatSystemException(ErrMsg.ID_NOT_FOUND));
    }

    @Override
    public int countCatInColor(Color color) {
        return catRepository.countAllCatsByColor(color.name());
    }

    @Override
    public List<Cat> getByCatsStaringWith(String letter) {
        return catRepository.findByNameStartingWith(letter);
    }

    @Override
    public double avgWeight() {
        return catRepository.avg();
    }

    @Override
    public List<Cat> getAllCatsOverWeight(double weight) {
        return catRepository.findByWeightGreaterThan(weight);
    }

    @Override
    public List<Cat> getAllCatsUnderWeight(double weight) {
        return catRepository.findByWeightLessThan(weight);
    }

    @Override
    public List<Cat> getAllCatsByColorAndOverWeight(Color color, double weight) throws CatSystemException {
        if (weight <= 0) {
            throw new CatSystemException(ErrMsg.WEIGHT_MUST_BE_GREATER_THAN_ZERO);
        }
        return catRepository.findByColorAndWeightGreaterThan(color, weight);
    }

    @Override
    public List<Cat> getAllCatsByColorOrOverWeight(Color color, double weight) throws CatSystemException {
        if (weight <= 0) {
            throw new CatSystemException(ErrMsg.WEIGHT_MUST_BE_GREATER_THAN_ZERO);
        }
        return catRepository.findByColorOrWeightGreaterThan(color, weight);
    }
}