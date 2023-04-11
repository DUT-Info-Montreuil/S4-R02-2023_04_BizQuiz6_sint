package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.entities.dto;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Chrono;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Langue;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.StatistiqueDTO;

public class lancement {

	public static void main(String[] args) {
		JoueurDto j = new JoueurDto("emilio", "emsko", 2003, Langue.FRANCAIS, "sport,dance");
		
		j.setMoyennePoints(5);
		j.setNbPartiesJouer(5);
		j.getStats().add(new StatistiqueDTO(5, new Chrono()));
		j.getStats().add(new StatistiqueDTO(10, new Chrono()));
		StatistiqueJoueurDTO s = new StatistiqueJoueurDTO(j);
		System.out.println(s.fournirStratString());
	}

}
