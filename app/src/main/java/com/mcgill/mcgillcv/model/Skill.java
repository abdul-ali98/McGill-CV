/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/
/*PLEASE DO NOT EDIT THIS CODE*/
package com.mcgill.mcgillcv.model;

import java.util.*;

// line 58 "model.ump"
// line 125 "model.ump"
public class Skill
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Skill Attributes
  private String skill;

  //Skill Associations
  private List<Course> courses;
  private List<Project> projects;
  private CV cV;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Skill(String aSkill, CV aCV)
  {
    skill = aSkill;
    courses = new ArrayList<Course>();
    projects = new ArrayList<Project>();
    boolean didAddCV = setCV(aCV);
    if (!didAddCV)
    {
      throw new RuntimeException("Unable to create skill due to cV. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSkill(String aSkill)
  {
    boolean wasSet = false;
    skill = aSkill;
    wasSet = true;
    return wasSet;
  }

  public String getSkill()
  {
    return skill;
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
  /* Code from template association_GetOne */
  public CV getCV()
  {
    return cV;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCourses()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addCourse(Course aCourse)
  {
    boolean wasAdded = false;
    if (courses.contains(aCourse)) { return false; }
    courses.add(aCourse);
    if (aCourse.indexOfSkill(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCourse.addSkill(this);
      if (!wasAdded)
      {
        courses.remove(aCourse);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeCourse(Course aCourse)
  {
    boolean wasRemoved = false;
    if (!courses.contains(aCourse))
    {
      return wasRemoved;
    }

    int oldIndex = courses.indexOf(aCourse);
    courses.remove(oldIndex);
    if (aCourse.indexOfSkill(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCourse.removeSkill(this);
      if (!wasRemoved)
      {
        courses.add(oldIndex,aCourse);
      }
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
  /* Code from template association_AddManyToManyMethod */
  public boolean addProject(Project aProject)
  {
    boolean wasAdded = false;
    if (projects.contains(aProject)) { return false; }
    projects.add(aProject);
    if (aProject.indexOfSkill(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aProject.addSkill(this);
      if (!wasAdded)
      {
        projects.remove(aProject);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeProject(Project aProject)
  {
    boolean wasRemoved = false;
    if (!projects.contains(aProject))
    {
      return wasRemoved;
    }

    int oldIndex = projects.indexOf(aProject);
    projects.remove(oldIndex);
    if (aProject.indexOfSkill(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aProject.removeSkill(this);
      if (!wasRemoved)
      {
        projects.add(oldIndex,aProject);
      }
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
      existingCV.removeSkill(this);
    }
    cV.addSkill(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Course> copyOfCourses = new ArrayList<Course>(courses);
    courses.clear();
    for(Course aCourse : copyOfCourses)
    {
      aCourse.removeSkill(this);
    }
    ArrayList<Project> copyOfProjects = new ArrayList<Project>(projects);
    projects.clear();
    for(Project aProject : copyOfProjects)
    {
      aProject.removeSkill(this);
    }
    CV placeholderCV = cV;
    this.cV = null;
    if(placeholderCV != null)
    {
      placeholderCV.removeSkill(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "skill" + ":" + getSkill()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cV = "+(getCV()!=null?Integer.toHexString(System.identityHashCode(getCV())):"null");
  }
}