package com.jb.cats.controllers;

import com.jb.cats.beans.Cat;
import com.jb.cats.beans.Color;
import com.jb.cats.exception.CatSystemException;
import com.jb.cats.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping
    public List<Cat> getAll() {
        return catService.getAllCats();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCat(@RequestBody Cat cat) throws CatSystemException {
        catService.addCat(cat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCat(@PathVariable int id) throws CatSystemException {
        catService.deleteCat(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCat(@PathVariable int id, @RequestBody Cat cat) throws CatSystemException {
        catService.updateCat(id, cat);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void getSingle(@PathVariable int id) throws CatSystemException {
        catService.getSingletCat(id);
    }

    @GetMapping("weight/avg")
    public double getAvgWeight() {
        return catService.avgWeight();
    }

    @GetMapping("color/count")
    public void countCatInColor(@RequestParam String color) {
        catService.countCatInColor(Color.valueOf(color));
    }

    @GetMapping("weight/over")
    public List<Cat> getAllCatsOverWeight(@RequestParam double weight) {
        return catService.getAllCatsOverWeight(weight);
    }

    @GetMapping("weight/under")
    public List<Cat> getAllCatsUnderWeight(@RequestParam double weight) {
        return catService.getAllCatsOverWeight(weight);
    }

    @GetMapping("by/color-and-weight-over")
    public List<Cat> getAllCatsByColorAndOverWeight(@RequestParam String color, @RequestParam double weight) throws CatSystemException {
        return catService.getAllCatsByColorAndOverWeight(Color.valueOf(color), weight);
    }

    @GetMapping("by/color-or-weight-over")
    public List<Cat> getAllCatsByColorOrOverWeight(@RequestParam String color, @RequestParam double weight) throws CatSystemException {
        return catService.getAllCatsByColorOrOverWeight(Color.valueOf(color), weight);
    }

    @GetMapping("name/starting")
    public List<Cat> getAllCatsStartWith(@RequestParam String letter) {
        return catService.getByCatsStaringWith(letter);
    }
}
