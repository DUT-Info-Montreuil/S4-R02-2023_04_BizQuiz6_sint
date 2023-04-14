package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.entities.dto;

import java.util.Iterator;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.StatistiqueDTO;

public class StatistiqueJoueurDTO {
	JoueurDto joueur;

	public StatistiqueJoueurDTO(JoueurDto joueur) {
		super();
		this.joueur = joueur;
	}
	
	
	
	
	
	public String fournirStratString() {
		int nbBonnesReps=0;
		
		for(StatistiqueDTO stat : joueur.getStats()) {
			nbBonnesReps+=stat.getNbBonnesReponses();
		}
		
		String stats="Statistiques de "+joueur.getNom()+" :\n\n\t"
		+joueur.getNbPartiesJouer()+" parties jouées\n"
		+"\t"+nbBonnesReps+" bonnes réponses sur "+joueur.getNbPartiesJouer()+"\n"
		+"\tMoyennes générale : "+joueur.getMoyennePoints()+"/10 \n"
		+"\tDurée moyenne : "+joueur.getMoyenneChrono()+"\n"
		+"\n\n\t5 dernieres parties jouées : ";
		
		if (joueur.getStats().size() >= 5) {
		    for (int i = joueur.getStats().size() - 1; i >= joueur.getStats().size() - 5; i--) {
		        stats = stats + "\n\t\t" + joueur.getStats().get(i).getNbBonnesReponses() + "/10 en " + joueur.getStats().get(i).getChrono();
		    }
		} else {
		    for (int i = joueur.getStats().size() - 1; i >= 0; i--) {
		        stats = stats + "\n\t\t" + joueur.getStats().get(i).getNbBonnesReponses() + "/10 en " + joueur.getStats().get(i).getChrono().getDureeTxt();
		    }
		}	
		return stats;
			
	}





	public JoueurDto getJoueur() {
		return this.joueur;
	}

}
