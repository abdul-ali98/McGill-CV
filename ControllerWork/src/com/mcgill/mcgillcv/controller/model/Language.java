package model;



// line 19 "model.ump"
// line 103 "model.ump"
public class Language
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Language Attributes
  private String name;

  //Language Associations
  private BasicInformation basicInformation;
  private CV cV;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Language(String aName, BasicInformation aBasicInformation, CV aCV)
  {
    name = aName;
    boolean didAddBasicInformation = setBasicInformation(aBasicInformation);
    if (!didAddBasicInformation)
    {
      throw new RuntimeException("Unable to create language due to basicInformation. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddCV = setCV(aCV);
    if (!didAddCV)
    {
      throw new RuntimeException("Unable to create language due to cV. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetOne */
  public BasicInformation getBasicInformation()
  {
    return basicInformation;
  }
  /* Code from template association_GetOne */
  public CV getCV()
  {
    return cV;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBasicInformation(BasicInformation aBasicInformation)
  {
    boolean wasSet = false;
    if (aBasicInformation == null)
    {
      return wasSet;
    }

    BasicInformation existingBasicInformation = basicInformation;
    basicInformation = aBasicInformation;
    if (existingBasicInformation != null && !existingBasicInformation.equals(aBasicInformation))
    {
      existingBasicInformation.removeLanguage(this);
    }
    basicInformation.addLanguage(this);
    wasSet = true;
    return wasSet;
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
      existingCV.removeLanguage(this);
    }
    cV.addLanguage(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    BasicInformation placeholderBasicInformation = basicInformation;
    this.basicInformation = null;
    if(placeholderBasicInformation != null)
    {
      placeholderBasicInformation.removeLanguage(this);
    }
    CV placeholderCV = cV;
    this.cV = null;
    if(placeholderCV != null)
    {
      placeholderCV.removeLanguage(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "basicInformation = "+(getBasicInformation()!=null?Integer.toHexString(System.identityHashCode(getBasicInformation())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "cV = "+(getCV()!=null?Integer.toHexString(System.identityHashCode(getCV())):"null");
  }
}