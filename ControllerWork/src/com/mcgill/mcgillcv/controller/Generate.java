import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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

    private static CV cv = new CV("Bobby","bob@mail.com","514-999-9999","https1","https2","http3","software","mechanical","4.0","01/09/2019","01/05/2024");

    public static void createFakeData(){
      
        
        Experience experience = new Experience("Software Developer","Google","11/11/11","22/12/22","Coding", Experience.ExperienceType.Internship, cv);
        Experience experience2 = new Experience("Frontend Developer","Microsoft","11/11/11","22/12/22","fake coding", Experience.ExperienceType.Internship, cv);
        Experience experience3 = new Experience("Machine Learning","Google","11/11/11","22/12/22","research", Experience.ExperienceType.Internship, cv);

        Club club = new Club("McRun","Headrunner","Runs with people", cv);
        Club club2 = new Club("Coffee McGill","Barista","Makes coffee", cv);
        
        Language language = new Language("English",  cv);
        Language language2 = new Language("French",  cv);

        Skill skill = new Skill("Python", cv);
        Skill skill1 = new Skill("Java", cv);
        Skill skill2 = new Skill("C++", cv);
        Skill skill3 = new Skill("Umple", cv);
        Skill skill4 = new Skill("Springboot", cv);
        Skill skill5 = new Skill("Heroku", cv);
        Skill skill6 = new Skill("Windows", cv);
        Skill skill7 = new Skill("HTML/CSS", cv);
        Skill skill8 = new Skill("Javascript", cv);
        Skill skill9 = new Skill("Archery", cv);
        Skill skill10 = new Skill("Piano", cv);

        Sport sport = new Sport("Soccer", "McGill Varsity", "11/11/11","11/12/11", cv);
        Sport sport2 = new Sport("Hockey", "McGill Intramural", "11/11/11","11/12/11", cv);

        Course course = new Course("ECSE321", cv);
        Course course2 = new Course("ECSE223", cv);
        Course course3 = new Course("ECSE202", cv);
        Course course4 = new Course("COMP250", cv);
        Course course5 = new Course("ECSE429", cv);

        Project project = new Project("Portfolio","portfolio","portfolio.com", cv);
        Project project2 = new Project("Storiko","grocery store application","storiko.com", cv);


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
    	string = writeContact(string);
    	string = writeEducation(string);
    	string = writeExperience(string);
    	string = writeClubs(string);
    	string = writeSkills(string);
    	string = writeSports(string);
    	string = writeLanguages(string);
    	string = writeProjects(string);
    	
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
    	string = string.replace("$name", cv.getBasicInformation().getName().toUpperCase());
    	return string;
    }
    
    
    public static String writeContact(String string) {
      string = string.replace("$email", cv.getBasicInformation().getEmail());
      string = string.replace("$website", cv.getBasicInformation().getPersonalWebsite());
      string = string.replace("$phone", cv.getBasicInformation().getPhoneNumber());
      return string;
    }
    
    public static String writeEducation(String string) {
      string = string.replace("$major", cv.getBasicInformation().getMajor());
      string = string.replace("$minor", cv.getBasicInformation().getMinor());
      string = string.replace("$eduDate", cv.getBasicInformation().getStartDate() + " - " +  cv.getBasicInformation().getExpectedGraduationDate());
      string = string.replace("$school", "McGill");
      return string;
    }
    
    public static String writeExperience(String cv_text) {
      
      String xp = "";
      
      List<Experience> experiences = cv.getExperiences();
      
      for (Experience e : experiences) {
      
        xp += "<h4>"+e.getCompanyName()+"</h4>\n";
        xp += "<li>"+e.getPositionTitle()+"</li>\n";
        xp += "<li>"+e.getStartDate()+"</li>\n";
        xp += "<li>"+e.getEndDate()+"</li>\n";
        
      }
      
      cv_text = cv_text.replace("$experience",xp);
      
      return cv_text;
      
    }
    
    
    public static String writeClubs(String cv_text) {
      
      String clubs_text = "";
      
      List<Club> clubs = cv.getClubs();
      
      for (Club c : clubs) {
        
        clubs_text += "<h4>"+c.getName()+"</h4>\n";
        clubs_text += "<li>"+c.getTitle()+"</li>\n";
        clubs_text += "<li>"+c.getDescription()+"</li>\n";
        
      }
      
      cv_text = cv_text.replace("$club",clubs_text);
      
      return cv_text;
      
    }
    
    public static String writeSkills(String cv_text) {
      
      String skills_text = "";
      
      List<Skill> skills = cv.getSkills();
      
      for (Skill s : skills) {
        
    
        skills_text += "<h4>"+s.getSkill()+"</h4>\n";
        
      }
      
      cv_text = cv_text.replace("$skill",skills_text);
      
      return cv_text;
      
    }
    
    public static String writeLanguages(String cv_text) {
      
      String languages_text = "";
      
      List<Language> languages = cv.getLanguages();
      
      for (Language l : languages) {
        
        
        languages_text += "<h4>"+l.getName()+"</h4>\n";
        
      }
      
      cv_text = cv_text.replace("$language",languages_text);
      
      return cv_text;
      
    }
    
    
    public static String writeSports(String cv_text) {
      
      String sports_text = "";
      
      List<Sport> sports = cv.getSports();
      
      for (Sport s : sports) {
        
        
        sports_text += "<h4>"+s.getName()+"</h4>\n";
        sports_text += "<li>"+s.getSchool()+"</li>\n";
        sports_text += "<li>"+s.getStartDate()+"</li>\n";
        sports_text += "<li>"+s.getEndDate()+"</li>\n";
        
      }
      
      cv_text = cv_text.replace("$sport",sports_text);
      
      return cv_text;
      
    }
    
    
    public static String writeProjects(String cv_text) {
      
      String projects_text = "";
      
      List<Project> projects = cv.getProjects();
      
      for (Project p : projects) {
        
        
        projects_text += "<h4>"+p.getName()+"</h4>\n";
        projects_text += "<li>"+p.getLink()+"</li>\n";
        projects_text += "<li>"+p.getDescription()+"</li>\n";
        
      }
      
      cv_text = cv_text.replace("$project",projects_text);
      
      return cv_text;
      
    }

    public static void main(String[] args){

        createFakeData();

        createHTML();
    }


}







