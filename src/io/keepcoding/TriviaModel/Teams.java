package io.keepcoding.TriviaModel;

import java.util.ArrayList;

public class Teams {
	
	ArrayList<Team> my_teams;
	
	public Teams() {
		this.my_teams = new ArrayList<Team>();
	}
	
	public Team getTeam(int team_number) {
		return my_teams.get(team_number);
	}
	
	public Integer length() {
		return my_teams.size();
	}

	public void addTeam(String name){
		my_teams.add(new Team(name));
	}




	public String toString() {
		String lista = "";
		for (Team i: my_teams) {
			lista += i.toString()+"\n";
		}
		return lista;
	}
	
}
