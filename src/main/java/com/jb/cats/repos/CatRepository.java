package com.jb.cats.repos;

import com.jb.cats.beans.Cat;
import com.jb.cats.beans.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {

    List<Cat> findByWeightGreaterThan(double weight);

    List<Cat> findByWeightLessThan(double weight);

    List<Cat> findByColorAndWeightGreaterThan(Color color, double weight);

    List<Cat> findByColorOrWeightGreaterThan(Color color, double weight);

    List<Cat> findByNameStartingWith(String letter);

    @Query(value = "select avg(weight) from cats", nativeQuery = true)
    double avg();

    @Query(value = "select count(*) from cats where color = ?", nativeQuery = true)
    int countAllCatsByColor(String color);


}
