package model;

import java.util.*;

// line 2 "model.ump"
// line 91 "model.ump"
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
  private List<Language> languages;
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
    languages = new ArrayList<Language>();
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
    languages = new ArrayList<Language>();
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
  /* Code from template association_GetOne */
  public CV getCV()
  {
    return cV;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfLanguages()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Language addLanguage(String aName, CV aCV)
  {
    return new Language(aName, this, aCV);
  }

  public boolean addLanguage(Language aLanguage)
  {
    boolean wasAdded = false;
    if (languages.contains(aLanguage)) { return false; }
    BasicInformation existingBasicInformation = aLanguage.getBasicInformation();
    boolean isNewBasicInformation = existingBasicInformation != null && !this.equals(existingBasicInformation);
    if (isNewBasicInformation)
    {
      aLanguage.setBasicInformation(this);
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
    //Unable to remove aLanguage, as it must always have a basicInformation
    if (!this.equals(aLanguage.getBasicInformation()))
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

  public void delete()
  {
    for(int i=languages.size(); i > 0; i--)
    {
      Language aLanguage = languages.get(i - 1);
      aLanguage.delete();
    }
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