package model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 24 "model.ump"
// line 98 "model.ump"
public class Experience
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum ExperienceType { Internship, DesignTeam, Work, Volunteer, Research }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Experience Attributes
  private String positionTitle;
  private String companyName;
  private String startDate;
  private String endDate;
  private String tasks;
  private ExperienceType experienceType;

  //Experience Associations
  private CV cV;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Experience(String aPositionTitle, String aCompanyName, String aStartDate, String aEndDate, String aTasks, ExperienceType aExperienceType, CV aCV)
  {
    positionTitle = aPositionTitle;
    companyName = aCompanyName;
    startDate = aStartDate;
    endDate = aEndDate;
    tasks = aTasks;
    experienceType = aExperienceType;
    boolean didAddCV = setCV(aCV);
    if (!didAddCV)
    {
      throw new RuntimeException("Unable to create experience due to cV. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPositionTitle(String aPositionTitle)
  {
    boolean wasSet = false;
    positionTitle = aPositionTitle;
    wasSet = true;
    return wasSet;
  }

  public boolean setCompanyName(String aCompanyName)
  {
    boolean wasSet = false;
    companyName = aCompanyName;
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

  public boolean setTasks(String aTasks)
  {
    boolean wasSet = false;
    tasks = aTasks;
    wasSet = true;
    return wasSet;
  }

  public boolean setExperienceType(ExperienceType aExperienceType)
  {
    boolean wasSet = false;
    experienceType = aExperienceType;
    wasSet = true;
    return wasSet;
  }

  public String getPositionTitle()
  {
    return positionTitle;
  }

  public String getCompanyName()
  {
    return companyName;
  }

  public String getStartDate()
  {
    return startDate;
  }

  public String getEndDate()
  {
    return endDate;
  }

  public String getTasks()
  {
    return tasks;
  }

  public ExperienceType getExperienceType()
  {
    return experienceType;
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
      existingCV.removeExperience(this);
    }
    cV.addExperience(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    CV placeholderCV = cV;
    this.cV = null;
    if(placeholderCV != null)
    {
      placeholderCV.removeExperience(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "positionTitle" + ":" + getPositionTitle()+ "," +
            "companyName" + ":" + getCompanyName()+ "," +
            "startDate" + ":" + getStartDate()+ "," +
            "endDate" + ":" + getEndDate()+ "," +
            "tasks" + ":" + getTasks()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "experienceType" + "=" + (getExperienceType() != null ? !getExperienceType().equals(this)  ? getExperienceType().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "cV = "+(getCV()!=null?Integer.toHexString(System.identityHashCode(getCV())):"null");
  }
}