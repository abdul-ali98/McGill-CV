import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import model.CV;
import model.Club;
import model.Course;
import model.Experience;
import model.Language;
import model.Project;
import model.Skill;
import model.Sport;

public class Generate {

    private static CV cv = new CV("Bob","bob@mail.com","514","https1","https2","http3","software","mechanical","4.0","dfghjk","asd");

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
      try {
        File myObj = new File("C:\\Users\\fyren\\eclipse-workspace\\ControllerWork\\src\\com\\mcgill\\mcgillcv\\controller\\model\\template.html");
        if (myObj.createNewFile()) {
          System.out.println("File created: " + myObj.getName());
        } else {
          System.out.println("File already exists.");
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      
      String string = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n\"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n<title>$title</title>\n</head>\n<body>$body\n</body>\n</html>"; 
      
      try {
        
        // Open given file in append mode by creating an
        // object of BufferedWriter class
        BufferedWriter out = new BufferedWriter(
            new FileWriter("C:\\Users\\fyren\\eclipse-workspace\\ControllerWork\\src\\com\\mcgill\\mcgillcv\\controller\\model\\template.html", true));

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
      
//      String htmlString = FileUtils.readFileToString(htmlTemplateFile);
//      String title = "New Page";
//      String body = "This is Body";
//      htmlString = htmlString.replace("$title", title);
//      htmlString = htmlString.replace("$body", body);
//      File newHtmlFile = new File("path/new.html");
//      FileUtils.writeStringToFile(newHtmlFile, htmlString);
      
      
    }
    
    

    public static void main(String[] args){

        createFakeData();

        createHTML();
    }


}







