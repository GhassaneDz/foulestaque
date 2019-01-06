package net.secudev.fs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLIRunner implements CommandLineRunner {

	@Autowired
	Populate populate;
	
	//Cette classe permet de lancer du code Spring au démarrage de l'appli web
	//on peut donc utiliser tous les objets du conteneur spring
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {
		logger.trace("Initialisation ...." );
		//Si il n'y a pas de données de démo alors en en crée.
		if(populate.hasNoData())
		{
			logger.trace("Pas de donnée dans catégories et produits, ajout de données de démo ...." );
			populate.creerJeuDessai();
		}
		
	}

}
