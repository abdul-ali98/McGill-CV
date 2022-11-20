import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import model.CV;
import model.Club;
import model.Course;
import model.Experience;
import model.Language;
import model.Project;
import model.Skill;
import model.Sport;

public class Generate {

    private static CV cv = new CV("Bobby","bob@mail.com","514","https1","https2","http3","software","mechanical","4.0","dfghjk","asd");

    public static void createFakeData(){

        Club club = new Club("McRun","Headrunner","Runs with people", cv);

        Experience experience = new Experience("Software Developer","Google","11/11/11","22/12/22","Coding", Experience.ExperienceType.Internship, cv);

        Language language = new Language("English", cv.getBasicInformation(), cv);

        Skill skill = new Skill("Python", cv);

        Sport sport = new Sport("Soccer", "McGill", "11/11/11","11/12/11", cv);

        Course course = new Course("ECSE321", cv);

        Project project = new Project("Portfolio","portfolio","portfolio.com");


        System.out.println(cv.getSkill(0).getSkill());
    }
    
    
    public static void createHTML() {
      
    	File myObj = new File("template.html");
    	String string ="";
    	
    	try {
	       string = FileUtils.readFileToString(myObj);
    	} catch (IOException e) {

            // Display message when exception occurs
            System.out.println("exception occurred" + e);
        }
	      
    	string = writeHeader(string);
    	
	      try {
	        
	        // Open given file in append mode by creating an
	        // object of BufferedWriter class
	        BufferedWriter out = new BufferedWriter(
	            new FileWriter("index.html", false));
	
	        // Writing on output stream
	        out.write(string);
	        // Closing the connection
	        out.close();
    }

    // Catch block to handle the exceptions
    catch (IOException e) {

        // Display message when exception occurs
        System.out.println("exception occurred" + e);
    }
	      
	      
    }
    
    public static String writeHeader(String string) {
    	string = string.replace("$name", cv.getBasicInformation().getName());
    	return string;
    }
    
    

    public static void main(String[] args){

        createFakeData();

        createHTML();
    }


}







