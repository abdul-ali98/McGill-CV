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
  
    
    private static int SKILL_MAX = 5;
    private static int PROJECT_MAX = 3;
    private static int EXPERIENCE_MAX = 3;
    private static int SPORTS_MAX = 2;
    private static int LANGUAGES_MAX = 2;
    private static int PROJECTS_MAX = 2;
    private static int CLUBS_MAX = 2;
    
    private static CV cv = new CV("Bobby","bob@mail.com","514-999-9999","https1","https2","http3","software","mechanical","4.0","01/09/2019","01/05/2024");
    
    public static void optimize() {

      int numExperience = cv.getExperiences().size();
      int numClubs = cv.getClubs().size();
      int numSkills = cv.getSkills().size();
      int numSports = cv.getSports().size();
      int numLanguages = cv.getLanguages().size();
      int numProjects = cv.getProjects().size();
      
      //removeExcess(cv.getSkills(),SKILL_MAX);
      
      // Remove excess skills
      if (numSkills > SKILL_MAX) {
        List<Skill> skills = cv.getSkills();
        for (int i = 0; i < skills.size(); i++) {
          System.out.println(i);
          if (i+1 > SKILL_MAX){
              skills.get(i).delete();
              i--;
          }
        }
      }
       
      // Remove excess experience
      if (numExperience > EXPERIENCE_MAX) {
        List<Experience> experience = cv.getExperiences();
        for (int i = 0; i < experience.size(); i++) {
          System.out.println(i);
          if (i+1 > EXPERIENCE_MAX){
            experience.get(i).delete();
            i--;
          }
        }
      }
      
      // Remove excess sports
      if (numSports > SPORTS_MAX) {
        List<Sport> sports = cv.getSports();
        for (int i = 0; i < sports.size(); i++) {
          System.out.println(i);
          if (i+1 > SPORTS_MAX){
            sports.get(i).delete();
            i--;
          }
        }
      }
      
      // Remove excess projects
      if (numProjects > PROJECTS_MAX) {
        List<Project> projects = cv.getProjects();
        for (int i = 0; i < projects.size(); i++) {
          System.out.println(i);
          if (i+1 > PROJECT_MAX){
            projects.get(i).delete();
            i--;
          }
        }
      }
      
      // Remove excess languages
      if (numLanguages > LANGUAGES_MAX) {
        List<Language> languages = cv.getLanguages();
        for (int i = 0; i < languages.size(); i++) {
          System.out.println(i);
          if (i+1 > LANGUAGES_MAX){
            languages.get(i).delete();
            i--;
          }
        }
      }
      
      // Remove excess clubs
      if (numClubs > CLUBS_MAX) {
        List<Club> clubs = cv.getClubs();
        for (int i = 0; i < clubs.size(); i++) {
          System.out.println(i);
          if (i+1 > CLUBS_MAX){
            clubs.get(i).delete();
            i--;
          }
        }
      }
      
      
      
      
      
    }
    
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
    }
    
    public static boolean checkNotInSkills(String skillName) {
    /**
     * HELPER METHOD
     */
      for (Skill s : cv.getSkills()) {
        if (s.getSkill().toLowerCase().contains(skillName.toLowerCase())) {
          return false;
        }
      }
      return true;
    }
    
    public static boolean checkNotInProjects(String projectName) {
      /**
       * HELPER METHOD
       */
      for (Project p : cv.getProjects()) {
        if (p.getName().toLowerCase().contains(projectName.toLowerCase())) {
          return false;
        }
      }
      return true;
    }
   
  
    public static void addSkillsAndProjectsFromCourses() {
        
      for (Course c : cv.getCourses()) {
        
        if (c.getCode() == "ECSE321") {
          if (checkNotInSkills("Agile")) {
             cv.addSkill("Agile");
          }
          if (checkNotInSkills("GitHub")) {
            cv.addSkill("GitHub");
          }
          cv.addProject("Spring-Boot Project", "Full-stack web application based in Java", "");
        }
        
        if (c.getCode() == "ECSE223") {
          if (checkNotInSkills("Umple")) {
            cv.addSkill("Umple code generation");
          }
          if (checkNotInSkills("Gherkin")) {
            cv.addSkill("Gherkin");
          }
          if (checkNotInSkills("Cucumber")) {
            cv.addSkill("Cucumber");
          }
          cv.addProject("Code Generation Project", "Full-stack web application based in Java", "");
        }
        
        
        if (c.getCode() == "COMP250") {
          if (checkNotInSkills("Java")) {
            cv.addSkill("Java");
          }
        }
        
        if (c.getCode() == "COMP202") {
          if (checkNotInSkills("Java")) {
            cv.addSkill("Java");
          }
        }
        
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
    
    
    public static void createHTML() {
      
      File myObj = new File("template.html");
      String string ="";
      
      try {
         string = FileUtils.readFileToString(myObj);
      } catch (IOException e) {

          // Display message when exception occurs
          System.out.println("exception occurred" + e);
      }
      
      
      addSkillsAndProjectsFromCourses();
      optimize();
      string = writeHeader(string);
      string = writeContact(string);
      string = writeEducation(string);
      string = writeExperience(string);
      string = writeClubs(string);
      string = writeSkills(string);
      string = writeSports(string);
      string = writeLanguages(string);
      string = writeProjects(string);
      
      
      System.out.println("CV Successfully Generated.");
      
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

}







