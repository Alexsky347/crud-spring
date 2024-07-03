package com.example.cruddemo.repository;

import com.example.cruddemo.models.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
    List<Beer> findAllByNameContains(String name);
    void deleteById(@NonNull Long id);
}
