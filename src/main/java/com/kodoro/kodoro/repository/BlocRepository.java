package com.kodoro.kodoro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kodoro.kodoro.dto.VolumeReste;
import com.kodoro.kodoro.model.Bloc;

public interface BlocRepository extends JpaRepository<Bloc,Integer> {
    @Query(value="SELECT * FROM Bloc WHere id NOT IN (SELECT DISTINCT id_bloc FROM Fabrication)",nativeQuery = true)
    List<Bloc> findBlocsNotInFabrication();
    
    @Query("SELECT new com.kodoro.kodoro.dto.VolumeReste(sum(b.longueur*b.largeur*b.hauteur) , sum(b.prixRevient) )  "
    + " FROM Bloc b Where b.id NOT IN (SELECT DISTINCT f.bloc.id FROM Fabrication f ) group by b.hauteur")
    List<VolumeReste> findVolumeReste();
    //Raha ohatra ka hipasser valeur
    // @Query(value="SELECT * FROM Bloc WHere id = :blocId",nativeQuery = true)
    // List<Bloc> findBlocsNotInFabrication(@Param("blocId") Long blocId);
    @Query(value="SELECT * FROM Bloc b Where b.id_origine = : blocId ",nativeQuery = true)
    List<Bloc> getFilles(@Param("blocId") int blocId );

}
