package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.modeles;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.StatistiqueDTO;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.entities.dto.StatistiqueJoueurDTO;

import java.util.ArrayList;

public interface IServiceQuizJoueur {


    
    public  ArrayList<StatistiqueJoueurDTO> recupererLesStats();

}