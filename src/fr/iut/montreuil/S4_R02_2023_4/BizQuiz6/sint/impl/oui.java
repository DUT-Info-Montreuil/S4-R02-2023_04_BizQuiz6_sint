package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.impl;

import fr.iut.montreuil.R4_S02_2023_4.BizQuiz6_questionnaire_sme.entities.bo.QuestionnaireBO;
import fr.iut.montreuil.R4_S02_2023_4.BizQuiz6_questionnaire_sme.entities.dto.QuestionDto;

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
	}

}
