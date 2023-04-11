package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.impl;

import java.util.NoSuchElementException;

import fr.iut.montreuil.R4_S02_2023_4.BizQuiz6_questionnaire_sme.entities.bo.QuestionnaireBO;

import fr.iut.montreuil.R4_S02_2023_4.BizQuiz6_questionnaire_sme.entities.dto.QuestionDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.entities.dto.StatsQuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.modeles.IServiceQuestionnaire;

public class ServiceQuestionnaireImpl implements IServiceQuestionnaire{

	@Override
	public StatsQuestionnaireDTO recupererStatsQuestionnaire(QuestionnaireBO questionnaire) throws NoSuchElementException{
		if(questionnaire.getListeDeQuestion().isEmpty())
			throw new NoSuchElementException() ;
		else {
		
			QuestionDto questionPlus = questionnaire.getListeDeQuestion().get(0);
			double ratioPlus = questionPlus.getStatsQuestionDTO().getNbCorrecte() / questionPlus.getStatsQuestionDTO().getNbJouerQuestion();
			QuestionDto questionMoin = questionnaire.getListeDeQuestion().get(0);
			double ratioMoin = questionMoin.getStatsQuestionDTO().getNbCorrecte() / questionMoin.getStatsQuestionDTO().getNbJouerQuestion();
			
			for (QuestionDto q : questionnaire.getListeDeQuestion()) {
				double ratio = q.getStatsQuestionDTO().getNbCorrecte() / q.getStatsQuestionDTO().getNbJouerQuestion();
				
				if(ratio > ratioPlus) 
					questionPlus = q;
				else if (ratio == ratioPlus) {
					if(q.getDifficulte() > questionPlus.getDifficulte()) 
						questionPlus = q;
					else if(q.getDifficulte() == questionPlus.getDifficulte() && q.getStatsQuestionDTO().getNbJouerQuestion() > questionPlus.getStatsQuestionDTO().getNbJouerQuestion()) 
						questionPlus = q;				
				}
				if(ratio < ratioMoin) 
					questionMoin = q;
				else if (ratio == ratioMoin) {	
					if(q.getDifficulte() < questionMoin.getDifficulte()) 
						questionMoin = q;
					else if(q.getDifficulte() == questionMoin.getDifficulte() && q.getStatsQuestionDTO().getNbJouerQuestion() > questionPlus.getStatsQuestionDTO().getNbJouerQuestion()) 
						questionPlus = q;
				}
			}
			StatsQuestionnaireDTO stats= new StatsQuestionnaireDTO(questionnaire.getNbJouerQuestionnaire(), questionPlus, questionMoin, questionnaire.getIdQuestionnaire());
			
			return stats;
		}
	}
	
	
	
}
