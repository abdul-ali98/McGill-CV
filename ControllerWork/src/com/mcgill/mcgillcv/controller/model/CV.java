/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/
package model;

import java.util.*;

// line 73 "model.ump"
// line 136 "model.ump"
public class CV
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CV Associations
  private BasicInformation basicInformation;
  private List<Language> languages;
  private List<Experience> experiences;
  private List<Club> clubs;
  private List<Skill> skills;
  private List<Sport> sports;
  private List<Course> courses;
  private List<Project> projects;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CV(BasicInformation aBasicInformation)
  {
    if (aBasicInformation == null || aBasicInformation.getCV() != null)
    {
      throw new RuntimeException("Unable to create CV due to aBasicInformation. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    basicInformation = aBasicInformation;
    languages = new ArrayList<Language>();
    experiences = new ArrayList<Experience>();
    clubs = new ArrayList<Club>();
    skills = new ArrayList<Skill>();
    sports = new ArrayList<Sport>();
    courses = new ArrayList<Course>();
    projects = new ArrayList<Project>();
  }

  public CV(String aNameForBasicInformation, String aEmailForBasicInformation, String aPhoneNumberForBasicInformation, String aPersonalWebsiteForBasicInformation, String aLinkedInLinkForBasicInformation, String aGitHubLinkForBasicInformation, String aMajorForBasicInformation, String aMinorForBasicInformation, String aGpaForBasicInformation, String aStartDateForBasicInformation, String aExpectedGraduationDateForBasicInformation)
  {
    basicInformation = new BasicInformation(aNameForBasicInformation, aEmailForBasicInformation, aPhoneNumberForBasicInformation, aPersonalWebsiteForBasicInformation, aLinkedInLinkForBasicInformation, aGitHubLinkForBasicInformation, aMajorForBasicInformation, aMinorForBasicInformation, aGpaForBasicInformation, aStartDateForBasicInformation, aExpectedGraduationDateForBasicInformation, this);
    languages = new ArrayList<Language>();
    experiences = new ArrayList<Experience>();
    clubs = new ArrayList<Club>();
    skills = new ArrayList<Skill>();
    sports = new ArrayList<Sport>();
    courses = new ArrayList<Course>();
    projects = new ArrayList<Project>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public BasicInformation getBasicInformation()
  {
    return basicInformation;
  }
  /* Code from template association_GetMany */
  public Language getLanguage(int index)
  {
    Language aLanguage = languages.get(index);
    return aLanguage;
  }

  public List<Language> getLanguages()
  {
    List<Language> newLanguages = Collections.unmodifiableList(languages);
    return newLanguages;
  }

  public int numberOfLanguages()
  {
    int number = languages.size();
    return number;
  }

  public boolean hasLanguages()
  {
    boolean has = languages.size() > 0;
    return has;
  }

  public int indexOfLanguage(Language aLanguage)
  {
    int index = languages.indexOf(aLanguage);
    return index;
  }
  /* Code from template association_GetMany */
  public Experience getExperience(int index)
  {
    Experience aExperience = experiences.get(index);
    return aExperience;
  }

  public List<Experience> getExperiences()
  {
    List<Experience> newExperiences = Collections.unmodifiableList(experiences);
    return newExperiences;
  }

  public int numberOfExperiences()
  {
    int number = experiences.size();
    return number;
  }

  public boolean hasExperiences()
  {
    boolean has = experiences.size() > 0;
    return has;
  }

  public int indexOfExperience(Experience aExperience)
  {
    int index = experiences.indexOf(aExperience);
    return index;
  }
  /* Code from template association_GetMany */
  public Club getClub(int index)
  {
    Club aClub = clubs.get(index);
    return aClub;
  }

  public List<Club> getClubs()
  {
    List<Club> newClubs = Collections.unmodifiableList(clubs);
    return newClubs;
  }

  public int numberOfClubs()
  {
    int number = clubs.size();
    return number;
  }

  public boolean hasClubs()
  {
    boolean has = clubs.size() > 0;
    return has;
  }

  public int indexOfClub(Club aClub)
  {
    int index = clubs.indexOf(aClub);
    return index;
  }
  /* Code from template association_GetMany */
  public Skill getSkill(int index)
  {
    Skill aSkill = skills.get(index);
    return aSkill;
  }

  public List<Skill> getSkills()
  {
    List<Skill> newSkills = Collections.unmodifiableList(skills);
    return newSkills;
  }

  public int numberOfSkills()
  {
    int number = skills.size();
    return number;
  }

  public boolean hasSkills()
  {
    boolean has = skills.size() > 0;
    return has;
  }

  public int indexOfSkill(Skill aSkill)
  {
    int index = skills.indexOf(aSkill);
    return index;
  }
  /* Code from template association_GetMany */
  public Sport getSport(int index)
  {
    Sport aSport = sports.get(index);
    return aSport;
  }

  public List<Sport> getSports()
  {
    List<Sport> newSports = Collections.unmodifiableList(sports);
    return newSports;
  }

  public int numberOfSports()
  {
    int number = sports.size();
    return number;
  }

  public boolean hasSports()
  {
    boolean has = sports.size() > 0;
    return has;
  }

  public int indexOfSport(Sport aSport)
  {
    int index = sports.indexOf(aSport);
    return index;
  }
  /* Code from template association_GetMany */
  public Course getCourse(int index)
  {
    Course aCourse = courses.get(index);
    return aCourse;
  }

  public List<Course> getCourses()
  {
    List<Course> newCourses = Collections.unmodifiableList(courses);
    return newCourses;
  }

  public int numberOfCourses()
  {
    int number = courses.size();
    return number;
  }

  public boolean hasCourses()
  {
    boolean has = courses.size() > 0;
    return has;
  }

  public int indexOfCourse(Course aCourse)
  {
    int index = courses.indexOf(aCourse);
    return index;
  }
  /* Code from template association_GetMany */
  public Project getProject(int index)
  {
    Project aProject = projects.get(index);
    return aProject;
  }

  public List<Project> getProjects()
  {
    List<Project> newProjects = Collections.unmodifiableList(projects);
    return newProjects;
  }

  public int numberOfProjects()
  {
    int number = projects.size();
    return number;
  }

  public boolean hasProjects()
  {
    boolean has = projects.size() > 0;
    return has;
  }

  public int indexOfProject(Project aProject)
  {
    int index = projects.indexOf(aProject);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfLanguages()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Language addLanguage(String aName)
  {
    return new Language(aName, this);
  }

  public boolean addLanguage(Language aLanguage)
  {
    boolean wasAdded = false;
    if (languages.contains(aLanguage)) { return false; }
    CV existingCV = aLanguage.getCV();
    boolean isNewCV = existingCV != null && !this.equals(existingCV);
    if (isNewCV)
    {
      aLanguage.setCV(this);
    }
    else
    {
      languages.add(aLanguage);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLanguage(Language aLanguage)
  {
    boolean wasRemoved = false;
    //Unable to remove aLanguage, as it must always have a cV
    if (!this.equals(aLanguage.getCV()))
    {
      languages.remove(aLanguage);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addLanguageAt(Language aLanguage, int index)
  {  
    boolean wasAdded = false;
    if(addLanguage(aLanguage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLanguages()) { index = numberOfLanguages() - 1; }
      languages.remove(aLanguage);
      languages.add(index, aLanguage);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLanguageAt(Language aLanguage, int index)
  {
    boolean wasAdded = false;
    if(languages.contains(aLanguage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLanguages()) { index = numberOfLanguages() - 1; }
      languages.remove(aLanguage);
      languages.add(index, aLanguage);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLanguageAt(aLanguage, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfExperiences()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Experience addExperience(String aPositionTitle, String aCompanyName, String aStartDate, String aEndDate, String aTasks, Experience.ExperienceType aExperienceType)
  {
    return new Experience(aPositionTitle, aCompanyName, aStartDate, aEndDate, aTasks, aExperienceType, this);
  }

  public boolean addExperience(Experience aExperience)
  {
    boolean wasAdded = false;
    if (experiences.contains(aExperience)) { return false; }
    CV existingCV = aExperience.getCV();
    boolean isNewCV = existingCV != null && !this.equals(existingCV);
    if (isNewCV)
    {
      aExperience.setCV(this);
    }
    else
    {
      experiences.add(aExperience);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeExperience(Experience aExperience)
  {
    boolean wasRemoved = false;
    //Unable to remove aExperience, as it must always have a cV
    if (!this.equals(aExperience.getCV()))
    {
      experiences.remove(aExperience);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addExperienceAt(Experience aExperience, int index)
  {  
    boolean wasAdded = false;
    if(addExperience(aExperience))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExperiences()) { index = numberOfExperiences() - 1; }
      experiences.remove(aExperience);
      experiences.add(index, aExperience);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveExperienceAt(Experience aExperience, int index)
  {
    boolean wasAdded = false;
    if(experiences.contains(aExperience))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExperiences()) { index = numberOfExperiences() - 1; }
      experiences.remove(aExperience);
      experiences.add(index, aExperience);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addExperienceAt(aExperience, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfClubs()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Club addClub(String aName, String aTitle, String aDescription)
  {
    return new Club(aName, aTitle, aDescription, this);
  }

  public boolean addClub(Club aClub)
  {
    boolean wasAdded = false;
    if (clubs.contains(aClub)) { return false; }
    CV existingCV = aClub.getCV();
    boolean isNewCV = existingCV != null && !this.equals(existingCV);
    if (isNewCV)
    {
      aClub.setCV(this);
    }
    else
    {
      clubs.add(aClub);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeClub(Club aClub)
  {
    boolean wasRemoved = false;
    //Unable to remove aClub, as it must always have a cV
    if (!this.equals(aClub.getCV()))
    {
      clubs.remove(aClub);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addClubAt(Club aClub, int index)
  {  
    boolean wasAdded = false;
    if(addClub(aClub))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClubs()) { index = numberOfClubs() - 1; }
      clubs.remove(aClub);
      clubs.add(index, aClub);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveClubAt(Club aClub, int index)
  {
    boolean wasAdded = false;
    if(clubs.contains(aClub))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClubs()) { index = numberOfClubs() - 1; }
      clubs.remove(aClub);
      clubs.add(index, aClub);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addClubAt(aClub, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSkills()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Skill addSkill(String aSkill)
  {
    return new Skill(aSkill, this);
  }

  public boolean addSkill(Skill aSkill)
  {
    boolean wasAdded = false;
    if (skills.contains(aSkill)) { return false; }
    CV existingCV = aSkill.getCV();
    boolean isNewCV = existingCV != null && !this.equals(existingCV);
    if (isNewCV)
    {
      aSkill.setCV(this);
    }
    else
    {
      skills.add(aSkill);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSkill(Skill aSkill)
  {
    boolean wasRemoved = false;
    //Unable to remove aSkill, as it must always have a cV
    if (!this.equals(aSkill.getCV()))
    {
      skills.remove(aSkill);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSkillAt(Skill aSkill, int index)
  {  
    boolean wasAdded = false;
    if(addSkill(aSkill))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSkills()) { index = numberOfSkills() - 1; }
      skills.remove(aSkill);
      skills.add(index, aSkill);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSkillAt(Skill aSkill, int index)
  {
    boolean wasAdded = false;
    if(skills.contains(aSkill))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSkills()) { index = numberOfSkills() - 1; }
      skills.remove(aSkill);
      skills.add(index, aSkill);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSkillAt(aSkill, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSports()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Sport addSport(String aName, String aSchool, String aStartDate, String aEndDate)
  {
    return new Sport(aName, aSchool, aStartDate, aEndDate, this);
  }

  public boolean addSport(Sport aSport)
  {
    boolean wasAdded = false;
    if (sports.contains(aSport)) { return false; }
    CV existingCV = aSport.getCV();
    boolean isNewCV = existingCV != null && !this.equals(existingCV);
    if (isNewCV)
    {
      aSport.setCV(this);
    }
    else
    {
      sports.add(aSport);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSport(Sport aSport)
  {
    boolean wasRemoved = false;
    //Unable to remove aSport, as it must always have a cV
    if (!this.equals(aSport.getCV()))
    {
      sports.remove(aSport);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSportAt(Sport aSport, int index)
  {  
    boolean wasAdded = false;
    if(addSport(aSport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSports()) { index = numberOfSports() - 1; }
      sports.remove(aSport);
      sports.add(index, aSport);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSportAt(Sport aSport, int index)
  {
    boolean wasAdded = false;
    if(sports.contains(aSport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSports()) { index = numberOfSports() - 1; }
      sports.remove(aSport);
      sports.add(index, aSport);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSportAt(aSport, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCourses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Course addCourse(String aCode)
  {
    return new Course(aCode, this);
  }

  public boolean addCourse(Course aCourse)
  {
    boolean wasAdded = false;
    if (courses.contains(aCourse)) { return false; }
    CV existingCV = aCourse.getCV();
    boolean isNewCV = existingCV != null && !this.equals(existingCV);
    if (isNewCV)
    {
      aCourse.setCV(this);
    }
    else
    {
      courses.add(aCourse);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCourse(Course aCourse)
  {
    boolean wasRemoved = false;
    //Unable to remove aCourse, as it must always have a cV
    if (!this.equals(aCourse.getCV()))
    {
      courses.remove(aCourse);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCourseAt(Course aCourse, int index)
  {  
    boolean wasAdded = false;
    if(addCourse(aCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCourses()) { index = numberOfCourses() - 1; }
      courses.remove(aCourse);
      courses.add(index, aCourse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCourseAt(Course aCourse, int index)
  {
    boolean wasAdded = false;
    if(courses.contains(aCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCourses()) { index = numberOfCourses() - 1; }
      courses.remove(aCourse);
      courses.add(index, aCourse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCourseAt(aCourse, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfProjects()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Project addProject(String aName, String aDescription, String aLink)
  {
    return new Project(aName, aDescription, aLink, this);
  }

  public boolean addProject(Project aProject)
  {
    boolean wasAdded = false;
    if (projects.contains(aProject)) { return false; }
    CV existingCV = aProject.getCV();
    boolean isNewCV = existingCV != null && !this.equals(existingCV);
    if (isNewCV)
    {
      aProject.setCV(this);
    }
    else
    {
      projects.add(aProject);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProject(Project aProject)
  {
    boolean wasRemoved = false;
    //Unable to remove aProject, as it must always have a cV
    if (!this.equals(aProject.getCV()))
    {
      projects.remove(aProject);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addProjectAt(Project aProject, int index)
  {  
    boolean wasAdded = false;
    if(addProject(aProject))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProjects()) { index = numberOfProjects() - 1; }
      projects.remove(aProject);
      projects.add(index, aProject);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProjectAt(Project aProject, int index)
  {
    boolean wasAdded = false;
    if(projects.contains(aProject))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProjects()) { index = numberOfProjects() - 1; }
      projects.remove(aProject);
      projects.add(index, aProject);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProjectAt(aProject, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    BasicInformation existingBasicInformation = basicInformation;
    basicInformation = null;
    if (existingBasicInformation != null)
    {
      existingBasicInformation.delete();
    }
    while (languages.size() > 0)
    {
      Language aLanguage = languages.get(languages.size() - 1);
      aLanguage.delete();
      languages.remove(aLanguage);
    }
    
    while (experiences.size() > 0)
    {
      Experience aExperience = experiences.get(experiences.size() - 1);
      aExperience.delete();
      experiences.remove(aExperience);
    }
    
    while (clubs.size() > 0)
    {
      Club aClub = clubs.get(clubs.size() - 1);
      aClub.delete();
      clubs.remove(aClub);
    }
    
    while (skills.size() > 0)
    {
      Skill aSkill = skills.get(skills.size() - 1);
      aSkill.delete();
      skills.remove(aSkill);
    }
    
    while (sports.size() > 0)
    {
      Sport aSport = sports.get(sports.size() - 1);
      aSport.delete();
      sports.remove(aSport);
    }
    
    while (courses.size() > 0)
    {
      Course aCourse = courses.get(courses.size() - 1);
      aCourse.delete();
      courses.remove(aCourse);
    }
    
    while (projects.size() > 0)
    {
      Project aProject = projects.get(projects.size() - 1);
      aProject.delete();
      projects.remove(aProject);
    }
    
  }

}