package com.kodoro.kodoro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodoro.kodoro.model.Usuel;

public interface UsuelRepository extends JpaRepository<Usuel,Integer> {
    @Query( value = "Select *,(prix/(longueur*largeur*hauteur)) as rapport from usuel order By rapport DESC limit 1  ",nativeQuery = true)
    Usuel findMaxBenefice();

    // @Query(value = "SELECT ")
    // Usuel findMinPerte();
}
