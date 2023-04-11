package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.modeles;

import fr.iut.montreuil.R4_S02_2023_4.BizQuiz6_questionnaire_sme.entities.bo.QuestionnaireBO;
import fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.entities.dto.StatsQuestionnaireDTO;

public interface IServiceQuestionnaire {
	
	//recuperestats doit recuperer la question avec la mieu repondue, la question la moin bien repondu, le nombre de fois ou le questionnaire à
	//ete jouer, et renvoi un objet qui contient :
	//int nbJouer
	//QuestionDto questionPlus
	//QuestionDto questionMoin
	//prend en parametre un questionnaireBO
	
	public StatsQuestionnaireDTO recupererStatsQuestionnaire(QuestionnaireBO questionnaire);
}
