package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.sint.entities.dto;

import fr.iut.montreuil.R4_S02_2023_4.BizQuiz6_questionnaire_sme.entities.dto.QuestionDto;

public class StatsQuestionnaireDTO {
	
	private int nbJouer;
	private QuestionDto questionPlus;
	private QuestionDto questionMoin;
	private int idQuestionnaire;
	
	public StatsQuestionnaireDTO(int nbJouer , QuestionDto questionPlus, QuestionDto questionMoin, int idQuestionnaire) {
		this.nbJouer = nbJouer;
		this.questionPlus = questionPlus;
		this.questionMoin = questionMoin;
		this.idQuestionnaire = idQuestionnaire;
	}

	public int getNbJouer() {
		return nbJouer;
	}

	public void setNbJouer(int nbJouer) {
		this.nbJouer = nbJouer;
	}

	public QuestionDto getQuestionPlus() {
		return questionPlus;
	}

	public void setQuestionPlus(QuestionDto questionPlus) {
		this.questionPlus = questionPlus;
	}

	public QuestionDto getQuestionMoin() {
		return questionMoin;
	}

	public void setQuestionMoin(QuestionDto questionMoin) {
		this.questionMoin = questionMoin;
	}

	public int getIdQuestionnaire() {
		return idQuestionnaire;
	}

	public void setIdQuestionnaire(int idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	@Override
	public String toString() {
		return "Statistique du questionnaire " + this.idQuestionnaire+"\n"
				+"Le questionnaire " + idQuestionnaire + " a été joué : \n"
				+nbJouer+" fois."
				+"La question avec le meilleur taux de réussite est : \n"
				+questionPlus.getLibelleQuestion() + " Avec " + questionPlus.getStatsNbCorrecte() + " bonnes réponses sur " + questionPlus.getStatsNbJouerQuestion()+"\n"
				+"La question avec le pire taux de réussite est :\n"
				+ "";
	}
	
	
	
}
