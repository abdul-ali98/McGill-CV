package com.mcgill.mcgillcv.model;/*PLEASE DO NOT EDIT THIS CODE*/

/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 43 "model.ump"
// line 113 "model.ump"
public class Sport
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Sport Attributes
  private String name;
  private String school;
  private String startDate;
  private String endDate;

  //Sport Associations
  private CV cV;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Sport(String aName, String aSchool, String aStartDate, String aEndDate, CV aCV)
  {
    name = aName;
    school = aSchool;
    startDate = aStartDate;
    endDate = aEndDate;
    boolean didAddCV = setCV(aCV);
    if (!didAddCV)
    {
      throw new RuntimeException("Unable to create sport due to cV. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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

  public boolean setSchool(String aSchool)
  {
    boolean wasSet = false;
    school = aSchool;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartDate(String aStartDate)
  {
    boolean wasSet = false;
    startDate = aStartDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndDate(String aEndDate)
  {
    boolean wasSet = false;
    endDate = aEndDate;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getSchool()
  {
    return school;
  }

  public String getStartDate()
  {
    return startDate;
  }

  public String getEndDate()
  {
    return endDate;
  }
  /* Code from template association_GetOne */
  public CV getCV()
  {
    return cV;
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
      existingCV.removeSport(this);
    }
    cV.addSport(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    CV placeholderCV = cV;
    this.cV = null;
    if(placeholderCV != null)
    {
      placeholderCV.removeSport(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "school" + ":" + getSchool()+ "," +
            "startDate" + ":" + getStartDate()+ "," +
            "endDate" + ":" + getEndDate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cV = "+(getCV()!=null?Integer.toHexString(System.identityHashCode(getCV())):"null");
  }
}