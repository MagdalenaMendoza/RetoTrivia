package io.keepcoding.TriviaModel;


import java.util.HashMap;
import java.util.Map;

public class Team {
	String name;
	Map<String,Boolean> puntaje;
	
	public Team(String name) {
		this.name = name;
		this.puntaje = new HashMap() {{
			put("Historia",false);
			put("Historia de Keep Coding",false);
			put("Inteligencia Artificial",false);
			put("Redes",false);
			put("Tecnología",false);
			
			
		}};

	}
	
	public void setPuntaje(String topic) {
		puntaje.replace(topic, true);
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public boolean ganador(){
		boolean result = true;
		for (var key: puntaje.entrySet()) {
			if (key.getValue()==false) {
				result = false;
			};
		}
		return result;
	}


	public String toStringPuntaje() {
		String result = "\nPuntaje equipo "+ name + ".\n";
		for (var key: puntaje.entrySet()) {
			result += key.getKey() + " : "+ key.getValue()+"\n";
		}
		return result;
	}
	
}

