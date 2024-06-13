package io.keepcoding.TriviaModel;

public class question {
	
	String name_question;
	String answer1;
	String answer2;
	String answer3;
	String answer4;
	Integer correct_answer;
	
	
	public String ShowInfo() {
		return name_question + "\n 1. " + answer1 + "\n 2. " + answer2
				+ "\n 3. " + answer3 + "\n 4. " + answer4 + "\n";
	}

	public question(String name_question, String answer1, String answer2, String answer3, String answer4, Integer correct_answer) {
		this.name_question = name_question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.correct_answer = correct_answer;
		
	}

	protected String getName_question() {
		return name_question;
	}

	protected void setName_question(String name_question) {
		this.name_question = name_question;
	}

	protected String getAnswer1() {
		return answer1;
	}

	protected void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	protected String getAnswer2() {
		return answer2;
	}

	protected void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	protected String getAnswer3() {
		return answer3;
	}

	protected void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	protected String getAnswer4() {
		return answer4;
	}

	protected void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public Integer getCorrect_answer() {
		return correct_answer;
	}

	protected void setCorrect_answer(Integer correct_answer) {
		this.correct_answer = correct_answer;
	}
	

}
