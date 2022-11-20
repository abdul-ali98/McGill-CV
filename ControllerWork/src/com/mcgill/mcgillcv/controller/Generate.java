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

    private static CV cv = new CV("Bobby","bob@mail.com","514-999-9999",null,null,"http3","software","mechanical","4.0","01/09/2019","01/05/2024");

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
        Skill skill11 = new Skill("Python", cv);
        Skill skill12 = new Skill("Java", cv);
        Skill skill13 = new Skill("C++", cv);
        Skill skill14 = new Skill("Umple", cv);
        Skill skill15 = new Skill("Springboot", cv);
        Skill skill16 = new Skill("Heroku", cv);
        Skill skill17 = new Skill("Windows", cv);
        Skill skill18 = new Skill("HTML/CSS", cv);
        Skill skill19 = new Skill("Javascript", cv);
        Skill skill20 = new Skill("Archery", cv);

        Sport sport = new Sport("Soccer", "McGill Varsity", "11/11/11","11/12/11", cv);
        Sport sport2 = new Sport("Hockey", "McGill Intramural", "11/11/11","11/12/11", cv);

        Course course = new Course("ECSE321", cv);
        Course course2 = new Course("ECSE223", cv);
        Course course3 = new Course("ECSE202", cv);
        Course course4 = new Course("COMP250", cv);
        Course course5 = new Course("ECSE429", cv);

        Project project = new Project("Portfolio","portfolio","portfolio.com", cv);
        Project project2 = new Project("Storiko","grocery store application","storiko.com", cv);
        Project project3 = new Project("Storiko","grocery store application","storiko.com", cv);


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
      
      if(!(cv.getBasicInformation().getPersonalWebsite()==null)) {
          string = string.replace("$website", cv.getBasicInformation().getPersonalWebsite());
      }
      else {
    	  string = string.replace("$website", "");
      }
      
      if(!(cv.getBasicInformation().getLinkedInLink()==null)) {
    	  string = string.replace("$linkedIn", cv.getBasicInformation().getLinkedInLink());
      }
      else {
    	  string = string.replace("$linkedIn", "");
      }
      
      if(!(cv.getBasicInformation().getGitHubLink()==null)) {
    	  string = string.replace("$gitHub", cv.getBasicInformation().getGitHubLink());
      }
      else {
    	  string = string.replace("$gitHub", "");
      }
      
      string = string.replace("$phone", cv.getBasicInformation().getPhoneNumber());
      return string;
    }
    
    public static String writeEducation(String string) {
      string = string.replace("$major", cv.getBasicInformation().getMajor());
      string = string.replace("$minor", cv.getBasicInformation().getMinor());
      string = string.replace("$eduDate", cv.getBasicInformation().getStartDate() + " - " +  cv.getBasicInformation().getExpectedGraduationDate());
      string = string.replace("$school", "McGill University");
      return string;
    }
    
    public static String writeExperience(String cv_text) {
      
      String xp = "";
      
      List<Experience> experiences = cv.getExperiences();
      
      for (Experience e : experiences) {
      
    	xp += "<div class=\"bottom-space\">\n";
    	xp += "<div>\n";
        xp += "<div class=\"title\">"+e.getCompanyName()+"</div>\n";
        xp += "<div class=\"date\">"+e.getStartDate()+" - ";
        xp += e.getEndDate()+"</div>\n";
        xp += "</div>\n";
        xp += "<div class=\"job-title\">"+e.getPositionTitle()+"</div>\n";
        xp += "<p>"+e.getTasks()+"</p>\n";
        xp += "</div>\n";
        
        
      }
      
      cv_text = cv_text.replace("$experience",xp);
      
      return cv_text;
      
    }
    
    
    public static String writeClubs(String cv_text) {
      
      String clubs_text = "";
      
      List<Club> clubs = cv.getClubs();
      
      for (Club c : clubs) {
    	  
    	  if (clubs.indexOf(c) != 0) {
  	        clubs_text += "<div class=\"col\">\n";
  	        clubs_text += "</div>\n";
    		clubs_text += "<div>\n";
	        clubs_text += "<div class=\"title\">"+c.getName()+"</div>\n";
	        clubs_text += "<li>"+c.getTitle()+"</li>\n";
	        clubs_text += "<li>"+c.getDescription()+"</li>\n";
	        clubs_text += "</div>\n";
    	  } else {
    		clubs_text += "<div>\n";
  	        clubs_text += "<div class=\"title\">"+c.getName()+"</div>\n";
  	        clubs_text += "<li>"+c.getTitle()+"</li>\n";
  	        clubs_text += "<li>"+c.getDescription()+"</li>\n";
  	        clubs_text += "</div>\n";
    	  }
    	  
    		  
      }
      
      cv_text = cv_text.replace("$club",clubs_text);
      
      return cv_text;
      
    }
    
    public static String writeSkills(String cv_text) {
      
      String skills_text = "";
      
      List<Skill> skills = cv.getSkills();
      
      for (Skill s : skills) {
        
    	  if (skills.indexOf(s) < skills.size() - 1) {
    		  skills_text += "<div class=\"skill\">"+s.getSkill()+", </div>\n";
    	  } else
    	  {
    		  skills_text += "<div class=\"skill\">"+s.getSkill()+"</div>\n";  
    	  }
        
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
    	  
    	sports_text += "<div class=\"bottom-space\">\n";
    	sports_text += "<div>\n";
        sports_text += "<div class=\"title\">"+s.getName()+"</div>\n";
        sports_text += "<div class=\"date\">"+s.getStartDate()+" - ";
        sports_text += s.getEndDate()+"</div>\n";
        sports_text += "</div>\n";
        sports_text += "<li>"+s.getSchool()+"</li>\n";
        sports_text += "</div>";
        
        
      }
      
      cv_text = cv_text.replace("$sport",sports_text);
      
      return cv_text;
      
    }
    
    
    public static String writeProjects(String cv_text) {
      
      String projects_text = "";
      
      List<Project> projects = cv.getProjects();
      
      for (Project p : projects) {
    	  if (projects.indexOf(p) != 0) {
	        projects_text += "<div class=\"col\">\n";
	        projects_text += "</div>\n";
	        projects_text += "<div>\n";
	        projects_text += "<div class=\"title\">"+p.getName()+"</div>\n";
	        projects_text += "<li>"+p.getLink()+"</li>\n";
	        projects_text += "<li>"+p.getDescription()+"</li>\n";
	        projects_text += "</div>\n";
    	  } else {
		    projects_text += "<div>\n";
  	        projects_text += "<div class=\"title\">"+p.getName()+"</div>\n";
  	        projects_text += "<li>"+p.getLink()+"</li>\n";
  	        projects_text += "<li>"+p.getDescription()+"</li>\n";
  	        projects_text += "</div>\n";
    	  }
      }
      
      cv_text = cv_text.replace("$project",projects_text);
      
      return cv_text;
      
    }

    public static void main(String[] args){

        createFakeData();

        createHTML();
    }
    

}







