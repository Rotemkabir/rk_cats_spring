package com.jb.cats.repos;

import com.jb.cats.beans.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Integer> {
}