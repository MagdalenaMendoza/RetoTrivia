package io.keepcoding.TriviaModel;

import java.util.ArrayList;

public class topic_questions {
	ArrayList<question> topic;
	String name;
	
	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public topic_questions(String name) {
		this.name = name;
		this.topic = new ArrayList<question>();
	}
	
	
	public String toString() {
		String list =  "\n"+name;
		for (var pregunta: topic) {
			list += "\n"+pregunta.ShowInfo();
		}
		list += "\n";
		return list;
	}

	public void addQuestion(question pregunta) {
		topic.add(pregunta);
	}
	
	public void eliminateQuestion(int number) {
		topic.remove(number);
	}
	

	
	public String getQuestionString(int number) {
		return topic.get(number).ShowInfo();
	}

	public question getQuestion(int number) {
		return topic.get(number);
	}
	
	public Integer length(){
		return topic.size();
	}

	protected ArrayList<question> getTopic() {
		return topic;
	}

	protected void setTopic(ArrayList<question> topic) {
		this.topic = topic;
	}
	
	
}
