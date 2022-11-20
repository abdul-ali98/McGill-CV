package com.mcgill.mcgillcv.model;

// line 36 "model.ump"
// line 108 "model.ump"
public class Club
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Club Attributes
  private String name;
  private String title;
  private String description;

  //Club Associations
  private CV cV;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Club(String aName, String aTitle, String aDescription, CV aCV)
  {
    name = aName;
    title = aTitle;
    description = aDescription;
    boolean didAddCV = setCV(aCV);
    if (!didAddCV)
    {
      throw new RuntimeException("Unable to create club due to cV. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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

  public boolean setTitle(String aTitle)
  {
    boolean wasSet = false;
    title = aTitle;
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

  public String getName()
  {
    return name;
  }

  public String getTitle()
  {
    return title;
  }

  public String getDescription()
  {
    return description;
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
      existingCV.removeClub(this);
    }
    cV.addClub(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    CV placeholderCV = cV;
    this.cV = null;
    if(placeholderCV != null)
    {
      placeholderCV.removeClub(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "title" + ":" + getTitle()+ "," +
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cV = "+(getCV()!=null?Integer.toHexString(System.identityHashCode(getCV())):"null");
  }
}