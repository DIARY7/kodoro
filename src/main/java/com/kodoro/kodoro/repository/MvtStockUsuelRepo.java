package com.kodoro.kodoro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodoro.kodoro.dto.ResultTabUsuel;
import com.kodoro.kodoro.model.MvtStockUsuel;

public interface MvtStockUsuelRepo extends JpaRepository<MvtStockUsuel,Integer> {
    @Query("SELECT new com.kodoro.kodoro.dto.ResultTabUsuel (u.designation,SUM(msu.entree - msu.sortie), " 
    +"SUM ((u.longueur*u.largeur*u.hauteur* (msu.entree - msu.sortie)/(b.longueur*b.largeur*b.hauteur)) * b.prixRevient),"
    + " SUM ((msu.entree - msu.sortie) * u.prix) )  "
    + "FROM MvtStockUsuel msu "
    + "JOIN msu.fab fab "
    +"JOIN fab.usuel u "
    +"JOIN fab.bloc b group by fab.usuel " )
    List<ResultTabUsuel> getResultTabUsuel();
}
