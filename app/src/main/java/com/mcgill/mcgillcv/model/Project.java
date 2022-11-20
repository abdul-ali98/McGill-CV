/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/
package com.mcgill.mcgillcv.model;/*PLEASE DO NOT EDIT THIS CODE*/

import java.util.*;

// line 63 "model.ump"
// line 130 "model.ump"
public class Project
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Project Attributes
  private String name;
  private String description;
  private String link;

  //Project Associations
  private Course course;
  private List<Skill> skills;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Project(String aName, String aDescription, String aLink)
  {
    name = aName;
    description = aDescription;
    link = aLink;
    skills = new ArrayList<Skill>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setLink(String aLink)
  {
    boolean wasSet = false;
    link = aLink;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public String getLink()
  {
    return link;
  }
  /* Code from template association_GetOne */
  public Course getCourse()
  {
    return course;
  }

  public boolean hasCourse()
  {
    boolean has = course != null;
    return has;
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
  /* Code from template association_SetOptionalOneToMany */
  public boolean setCourse(Course aCourse)
  {
    boolean wasSet = false;
    Course existingCourse = course;
    course = aCourse;
    if (existingCourse != null && !existingCourse.equals(aCourse))
    {
      existingCourse.removeProject(this);
    }
    if (aCourse != null)
    {
      aCourse.addProject(this);
    }
    wasSet = true;
    return wasSet;
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
    if (aSkill.indexOfProject(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSkill.addProject(this);
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
    if (aSkill.indexOfProject(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSkill.removeProject(this);
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

  public void delete()
  {
    if (course != null)
    {
      Course placeholderCourse = course;
      this.course = null;
      placeholderCourse.removeProject(this);
    }
    ArrayList<Skill> copyOfSkills = new ArrayList<Skill>(skills);
    skills.clear();
    for(Skill aSkill : copyOfSkills)
    {
      aSkill.removeProject(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "description" + ":" + getDescription()+ "," +
            "link" + ":" + getLink()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "course = "+(getCourse()!=null?Integer.toHexString(System.identityHashCode(getCourse())):"null");
  }
}