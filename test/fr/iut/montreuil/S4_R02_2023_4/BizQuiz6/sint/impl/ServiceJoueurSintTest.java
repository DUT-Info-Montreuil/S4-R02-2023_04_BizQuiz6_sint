package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.impl;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;

import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Chrono;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.JoueurDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.Langue;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto.StatistiqueDTO;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.entities.dto.StatistiqueJoueurDTO;

public class ServiceJoueurSintTest {

	@Test
    public void testRecupererLesStats() {
        // Création d'un mock pour l'interface qui fournit les données
    	ServiceQuizJoueurImpl statistiqueJoueurServiceMock = mock(ServiceQuizJoueurImpl.class);

        // Création d'un joueurDTO avec des valeurs fictives
        JoueurDto joueurDto = new JoueurDto("emilio", "emsko", 2000, Langue.FRANCAIS, "Football,Basketball");
		
        joueurDto.setMoyennePoints(5);
        joueurDto.setNbPartiesJouer(2);
        joueurDto.getStats().add(new StatistiqueDTO(5, new Chrono()));
        joueurDto.getStats().add(new StatistiqueDTO(9, new Chrono()));
        // Création d'une liste de StatistiqueJoueurDTO avec un seul élément
        ArrayList<StatistiqueJoueurDTO> listeStatistiques = new ArrayList<>();
        listeStatistiques.add(new StatistiqueJoueurDTO(joueurDto));
        // Configuration du mock pour renvoyer la liste de statistiques
        when(statistiqueJoueurServiceMock.recupererLesStats()).thenReturn(listeStatistiques);        
        // Appel de la méthode à tester
        ArrayList<StatistiqueJoueurDTO> result = statistiqueJoueurServiceMock.recupererLesStats();
        // Vérification du résultat        assertEquals(7, result.get(0).getJoueur().getMoyenneChrono());
        assertEquals(1, result.size());
        assertEquals("emilio", result.get(0).getJoueur().getNom());
        assertEquals("emsko", result.get(0).getJoueur().getPseudo());
        assertEquals(2000, result.get(0).getJoueur().getAnneeDeNaissance());
        assertEquals(Langue.FRANCAIS, result.get(0).getJoueur().getLanguePreferer());
        assertEquals(2, result.get(0).getJoueur().getCentreDinteret().length);
        assertEquals("Football", result.get(0).getJoueur().getCentreDinteret()[0]);
        assertEquals("Basketball", result.get(0).getJoueur().getCentreDinteret()[1]);
        assertEquals(2, result.get(0).getJoueur().getNbPartiesJouer());
        assertEquals(5, result.get(0).getJoueur().getMoyennePoints(), 0.5);
    }
}
