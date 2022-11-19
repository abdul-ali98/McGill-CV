package model;

/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/
import java.util.*;


// line 51 "model.ump"
// line 118 "model.ump"
public class Course
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Course Attributes
  private String code;

  //Course Associations
  private List<Skill> skills;
  private List<Project> projects;
  private CV cV;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Course(String aCode, CV aCV)
  {
    code = aCode;
    skills = new ArrayList<Skill>();
    projects = new ArrayList<Project>();
    boolean didAddCV = setCV(aCV);
    if (!didAddCV)
    {
      throw new RuntimeException("Unable to create course due to cV. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public String getCode()
  {
    return code;
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
  /* Code from template association_GetOne */
  public CV getCV()
  {
    return cV;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSkills()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addSkill(Skill aSkill)
  {
    boolean wasAdded = false;
    if (skills.contains(aSkill)) { return false; }
    skills.add(aSkill);
    if (aSkill.indexOfCourse(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSkill.addCourse(this);
      if (!wasAdded)
      {
        skills.remove(aSkill);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeSkill(Skill aSkill)
  {
    boolean wasRemoved = false;
    if (!skills.contains(aSkill))
    {
      return wasRemoved;
    }

    int oldIndex = skills.indexOf(aSkill);
    skills.remove(oldIndex);
    if (aSkill.indexOfCourse(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSkill.removeCourse(this);
      if (!wasRemoved)
      {
        skills.add(oldIndex,aSkill);
      }
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
  public static int minimumNumberOfProjects()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addProject(Project aProject)
  {
    boolean wasAdded = false;
    if (projects.contains(aProject)) { return false; }
    Course existingCourse = aProject.getCourse();
    if (existingCourse == null)
    {
      aProject.setCourse(this);
    }
    else if (!this.equals(existingCourse))
    {
      existingCourse.removeProject(aProject);
      addProject(aProject);
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
    if (projects.contains(aProject))
    {
      projects.remove(aProject);
      aProject.setCourse(null);
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
  /* Code from template association_SetOneToMany */
  public boolean setCV(CV aCV)
  {
    boolean wasSet = false;
    if (aCV == null)
    {
      return wasSet;
    }

    CV existingCV = cV;
    cV = aCV;
    if (existingCV != null && !existingCV.equals(aCV))
    {
      existingCV.removeCourse(this);
    }
    cV.addCourse(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Skill> copyOfSkills = new ArrayList<Skill>(skills);
    skills.clear();
    for(Skill aSkill : copyOfSkills)
    {
      aSkill.removeCourse(this);
    }
    while( !projects.isEmpty() )
    {
      projects.get(0).setCourse(null);
    }
    CV placeholderCV = cV;
    this.cV = null;
    if(placeholderCV != null)
    {
      placeholderCV.removeCourse(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "code" + ":" + getCode()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cV = "+(getCV()!=null?Integer.toHexString(System.identityHashCode(getCV())):"null");
  }
}