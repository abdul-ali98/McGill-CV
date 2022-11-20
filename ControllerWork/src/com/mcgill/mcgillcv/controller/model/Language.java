/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package model;


// line 18 "model.ump"
// line 102 "model.ump"
public class Language
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Language Attributes
  private String name;

  //Language Associations
  private CV cV;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Language(String aName, CV aCV)
  {
    name = aName;
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
      existingCV.removeLanguage(this);
    }
    cV.addLanguage(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
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
            "  " + "cV = "+(getCV()!=null?Integer.toHexString(System.identityHashCode(getCV())):"null");
  }
}