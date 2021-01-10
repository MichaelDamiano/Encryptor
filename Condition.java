public class Condition
{
   private char preferedLetter;
   private char changingLetter;
   private String newString = "";
   private String stringUpdate = "";
   
   public Condition()
   {
      preferedLetter = ' ';
      changingLetter = ' ';
   }
   
   public Condition(char letterChange, char letter)
   {
      setCondition(letterChange, letter);
   }
   // SETTERS
   /////////////////////////////////////////////////////////////////////
   public void setCondition(char letterChange, char letter)
   {
      setChangingLetter(letterChange);
      setPreferedLetter(letter);  
   }
   
   public void setPreferedLetter(char letter)
   {
      preferedLetter = letter;
   }
   
   public void setChangingLetter(char letter)
   {
      changingLetter = letter;
   }
   public void resetNewString()
   {
      newString = "";
   }
   
   public void resetStringUpdate()
   {
      stringUpdate = "";
   }
   // GETTERS
   /////////////////////////////////////////////////////////////////////
   public char getPreferedLetter()
   {
      return preferedLetter;
   }
   
   public char getChangingLetter()
   {
      return changingLetter;
   }
   
   public String getEncryptedString()
   {
      return newString;
   }
   
   public String getChange()
   {
      return changingLetter + " ---> " + preferedLetter;
   }
   /////////////////////////////////////////////////////////////////////
   
   public void changeChar(String encrypt)
   {
      resetNewString();
      for(int i = 0; i < encrypt.length() ; i++)
      {
         if(changingLetter == encrypt.charAt(i))
         {
            newString = newString + preferedLetter;
         }  
         else
         {
            newString = newString + encrypt.charAt(i);
         }
      }
   }
   
   public boolean changeCheck(String encrypt)
   {
      for(int i = 0; i < encrypt.length() ; i++)
      {
         if(preferedLetter == encrypt.charAt(i))
         {
            return false;
         }  
      }
      return true;
           
   }
   
   public void ReversechangeChar(String encrypt)
   {
      resetNewString();
      for(int i = 0; i < encrypt.length() ; i++)
      {
         if(preferedLetter == encrypt.charAt(i))
         {
            newString = newString + changingLetter;
         }  
         else
         {
            newString = newString + encrypt.charAt(i);
         }
      }
   }
   
   public boolean reverseCheck(String encrypt)
   {
      for(int i = 0; i < encrypt.length() ; i++)
      {
         if(changingLetter == encrypt.charAt(i))
         {
            return false;
         }  
      }
      return true;
   }   
   
   public void printString()
   {
      System.out.println(newString);
   }
   
   public void printChange()
   {
      System.out.println(changingLetter + " ---> " + preferedLetter);
   }
   
   
}