package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.impl;

import fr.iut.montreuil.R4_S02_2023_4.BizQuiz6_questionnaire_sme.entities.bo.QuestionnaireBO;
import fr.iut.montreuil.R4_S02_2023_4.BizQuiz6_questionnaire_sme.entities.dto.QuestionDto;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.entities.dto.StatsQuestionnaireDTO;

public class oui {

	public static void main(String[] args) {
		System.out.println("nfisodnfdsnf");
		QuestionDto q1 = new QuestionDto(1, 1, "fr", "qui es tu ?", "moi", 1, "tu es toi", "moi");
		QuestionDto q2 = new QuestionDto(1, 2, "fr", "d'ou vient tu ?", "cher moi", 1, "tu es toi", "moi");
		QuestionnaireBO questionnaire = new QuestionnaireBO();
		questionnaire.implementsNbJouerQuestionnaire();
		for(int i=0 ; i<5 ; i++) {
			questionnaire.implementsNbJouerQuestionnaire();
			q1.getStatsQuestionDTO().incrementerNbJouer();
			q1.getStatsQuestionDTO().incrementerNbCorrecte();
			q2.getStatsQuestionDTO().incrementerNbJouer();
		}
		questionnaire.addQuestion(q1);
		questionnaire.addQuestion(q2);
		
		System.out.println(recupererStatsQuestionnaire(questionnaire).toString());
	}
	
	
	public static StatsQuestionnaireDTO recupererStatsQuestionnaire(QuestionnaireBO questionnaire) {
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
