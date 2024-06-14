package io.keepcoding.keeptrivial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import io.keepcoding.TriviaModel.Team;
import io.keepcoding.TriviaModel.Teams;
import io.keepcoding.TriviaModel.question;
import io.keepcoding.TriviaModel.topic_questions;

public class MainTrivial {
	public static void main(String [] args) {
		// initialize questions
		ArrayList<topic_questions> questions = getQuestions();
		//System.out.println(questions.toString());
		
		// initialize teams
		boolean teams_ini = true;
		Teams my_teams = new Teams();
		Scanner sc=new Scanner(System.in);  
		int i = 1;
		while(teams_ini) {
			System.out.print("Ingresa el nombre del team "+i+"(ingresa q para salir):");
			String team_name= sc.nextLine();
			if (team_name.equals("q")) {
				teams_ini = false;
			}
			else {
				my_teams.addTeam(team_name);
			}
			i++;
		}
		
		String ganador = "Sin ganador.";
		int topic_number = getRandomInt(questions.size());
		Scanner input = new Scanner (System.in);
		boolean exit = false;
		do {
			// Cambiar el turno para cada equipo
			for (i=0;i<my_teams.length();i++) {
				
				title("Ahora es el turno del equipo "+my_teams.getTeam(i).getName());
				// Mostrar preguntas
				
				if (questions.get(topic_number).length()==0){
					questions.remove(topic_number);
				}
				int question_number = getRandomInt((questions.get(topic_number)).length());
				System.out.println(questions.get(topic_number).getName()+"\n");
				question my_question = questions.get(topic_number).getQuestion(question_number);
				System.out.println(my_question.ShowInfo()+"\n");
				System.out.println("Introduzca su respuesta:");
				
				String answer = input.nextLine();
				
				while (!esTransformableAEntero(answer)) {
					System.out.println("Ingrese una respuesta válida:");
					answer = input.nextLine();
				}
				
				
				
				if (Integer.valueOf(answer).equals(my_question.getCorrect_answer())) {
					// Mostrar resultado
					System.out.println("\n¡Ha acertado!\nEquipo "+my_teams.getTeam(i).getName()+" obtiene un punto.");
					my_teams.getTeam(i).setPuntaje(questions.get(topic_number).getName());
					answer = "";
					questions.get(topic_number).eliminateQuestion(question_number);	
					
				}
				
				else {
					System.out.println("Respuesta incorrecta.");
				}
				
				// Comprobar si hay ganador
				if (my_teams.getTeam(i).ganador()==true) {
					ganador = my_teams.getTeam(i).getName();
					exit = true;
				
				}
				
				// Mostrar clasificación
				for (int j=0;j<my_teams.length();j++) {
					System.out.println(my_teams.getTeam(j).toStringPuntaje());
				}
				
				
				
			}

			
			topic_number ++;
			if (topic_number >= questions.size()) {
				topic_number = 0;
			}
		} while(!exit);
		System.out.println();
		title("Ha ganado: " + ganador);
		
	}
	
	public static void title(String text) {
		int length = text.length();
		printHashtagLine(length + 4); // Bordes

        System.out.println("# " + text + " #");

        printHashtagLine(length + 4);
	}
	
	public static void printHashtagLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
	
	 public static boolean esTransformableAEntero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	private static int getRandomInt(int max) {
		return new Random().nextInt(max);
	}
	
	
	private static ArrayList<topic_questions> getQuestions() {
		ArrayList<topic_questions> list = new ArrayList<>();
		
		
		
		 File folder = new File("questions");
	        if (!folder.exists()) {
	            title("Error al cargar el fichero");
	        } else {
	        	File[] filesList = folder.listFiles();

	            for (File file : filesList) {
	                if (file.isFile() && file.getName().endsWith(".txt")) {
	                    var topicName = file.getName().substring(0, file.getName().length() - 4);
	                    
	                    // TODO create topic
	                    topic_questions topic = new topic_questions(topicName);
	                    
	                    // Read the question
	                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	                        String line;
	                        List<String> block = new ArrayList<>();

	                        while ((line = br.readLine()) != null) {
                        		block.add(line);

	                            if (block.size() == 6) { // número de lineas que componen una pregunta
	                                var question = block.get(0);
	                                var answer1 = block.get(1);
	                                var answer2 = block.get(2);
	                                var answer3 = block.get(3);
	                                var answer4 = block.get(4);
	                                var rightOption = Integer.parseInt(block.get(5));
	                                
	                                // TODO create question
	                                block.clear();
	                                question pregunta = new question(question, answer1, answer2, answer3, answer4, rightOption);
	                                topic.addQuestion(pregunta);
	                                
	                                 
	                            }
	                            
	                        }
	                        // TODO Add to list
	                        list.add(topic);
	                        
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                  
	                }
	            }
	        }
	    
	        
		return list;
	}
	
}
