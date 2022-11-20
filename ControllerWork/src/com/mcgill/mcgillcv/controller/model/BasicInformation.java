/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package model;

// line 2 "model.ump"
// line 90 "model.ump"
public class BasicInformation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BasicInformation Attributes
  private String name;
  private String email;
  private String phoneNumber;
  private String personalWebsite;
  private String linkedInLink;
  private String gitHubLink;
  private String major;
  private String minor;
  private String gpa;
  private String startDate;
  private String expectedGraduationDate;

  //BasicInformation Associations
  private CV cV;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BasicInformation(String aName, String aEmail, String aPhoneNumber, String aPersonalWebsite, String aLinkedInLink, String aGitHubLink, String aMajor, String aMinor, String aGpa, String aStartDate, String aExpectedGraduationDate, CV aCV)
  {
    name = aName;
    email = aEmail;
    phoneNumber = aPhoneNumber;
    personalWebsite = aPersonalWebsite;
    linkedInLink = aLinkedInLink;
    gitHubLink = aGitHubLink;
    major = aMajor;
    minor = aMinor;
    gpa = aGpa;
    startDate = aStartDate;
    expectedGraduationDate = aExpectedGraduationDate;
    if (aCV == null || aCV.getBasicInformation() != null)
    {
      throw new RuntimeException("Unable to create BasicInformation due to aCV. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    cV = aCV;
  }

  public BasicInformation(String aName, String aEmail, String aPhoneNumber, String aPersonalWebsite, String aLinkedInLink, String aGitHubLink, String aMajor, String aMinor, String aGpa, String aStartDate, String aExpectedGraduationDate)
  {
    name = aName;
    email = aEmail;
    phoneNumber = aPhoneNumber;
    personalWebsite = aPersonalWebsite;
    linkedInLink = aLinkedInLink;
    gitHubLink = aGitHubLink;
    major = aMajor;
    minor = aMinor;
    gpa = aGpa;
    startDate = aStartDate;
    expectedGraduationDate = aExpectedGraduationDate;
    cV = new CV(this);
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

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(String aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setPersonalWebsite(String aPersonalWebsite)
  {
    boolean wasSet = false;
    personalWebsite = aPersonalWebsite;
    wasSet = true;
    return wasSet;
  }

  public boolean setLinkedInLink(String aLinkedInLink)
  {
    boolean wasSet = false;
    linkedInLink = aLinkedInLink;
    wasSet = true;
    return wasSet;
  }

  public boolean setGitHubLink(String aGitHubLink)
  {
    boolean wasSet = false;
    gitHubLink = aGitHubLink;
    wasSet = true;
    return wasSet;
  }

  public boolean setMajor(String aMajor)
  {
    boolean wasSet = false;
    major = aMajor;
    wasSet = true;
    return wasSet;
  }

  public boolean setMinor(String aMinor)
  {
    boolean wasSet = false;
    minor = aMinor;
    wasSet = true;
    return wasSet;
  }

  public boolean setGpa(String aGpa)
  {
    boolean wasSet = false;
    gpa = aGpa;
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

  public boolean setExpectedGraduationDate(String aExpectedGraduationDate)
  {
    boolean wasSet = false;
    expectedGraduationDate = aExpectedGraduationDate;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getEmail()
  {
    return email;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public String getPersonalWebsite()
  {
    return personalWebsite;
  }

  public String getLinkedInLink()
  {
    return linkedInLink;
  }

  public String getGitHubLink()
  {
    return gitHubLink;
  }

  public String getMajor()
  {
    return major;
  }

  public String getMinor()
  {
    return minor;
  }

  public String getGpa()
  {
    return gpa;
  }

  public String getStartDate()
  {
    return startDate;
  }

  public String getExpectedGraduationDate()
  {
    return expectedGraduationDate;
  }
  /* Code from template association_GetOne */
  public CV getCV()
  {
    return cV;
  }

  public void delete()
  {
    CV existingCV = cV;
    cV = null;
    if (existingCV != null)
    {
      existingCV.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "email" + ":" + getEmail()+ "," +
            "phoneNumber" + ":" + getPhoneNumber()+ "," +
            "personalWebsite" + ":" + getPersonalWebsite()+ "," +
            "linkedInLink" + ":" + getLinkedInLink()+ "," +
            "gitHubLink" + ":" + getGitHubLink()+ "," +
            "major" + ":" + getMajor()+ "," +
            "minor" + ":" + getMinor()+ "," +
            "gpa" + ":" + getGpa()+ "," +
            "startDate" + ":" + getStartDate()+ "," +
            "expectedGraduationDate" + ":" + getExpectedGraduationDate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cV = "+(getCV()!=null?Integer.toHexString(System.identityHashCode(getCV())):"null");
  }
}