package net.secudev.fs.domain.model.categorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategorieRepository extends JpaRepository<Categorie, Long>{
	
	boolean existsByLibelle(String libelle);
	List<Categorie> findByLibelleIgnoreCase(String libelle);
	

}
