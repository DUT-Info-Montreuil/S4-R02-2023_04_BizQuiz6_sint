package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.impl;

import java.util.ArrayList;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.StatistiqueDTO;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.impl.ServiceJoueurImpl;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.entities.dto.StatistiqueJoueurDTO;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.modeles.IServiceQuizJoueur;

public class ServiceQuizJoueurImpl implements IServiceQuizJoueur{

	private ServiceJoueurImpl service ;
	
	public ServiceQuizJoueurImpl(ServiceJoueurImpl service) {
		super();
		this.service = service;
	}
	
	public ArrayList<StatistiqueJoueurDTO> recupererLesStats() {
		ArrayList<StatistiqueJoueurDTO> stat=new ArrayList<StatistiqueJoueurDTO>();
		
		for(JoueurDto joueur:service.getListeJoueur()) {
			stat.add(new StatistiqueJoueurDTO(joueur));
		}
		return stat;
	}

	public ServiceJoueurImpl getService() {
		return service;
	}

}
