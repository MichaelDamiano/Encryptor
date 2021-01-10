public class Encryption
{
   final int MAX = 30;
   
   
   private String encryptedString;
   private String saveString;
   private String rawData;
   private String numberChoice = " ";
   private Condition[] EncryptionConditions = new Condition[MAX];
   private int[] numberChoiceNumbers = new int[MAX];
   private String changeLog = "CHANGE LOG:\n";
   private int numofcond;
   private int choiceCounter = 0;
   
   
   public Encryption()
   {
      encryptedString = "";
      saveString = "";
      for (int i = 0; i< 10; i++)
      {
		   EncryptionConditions[i] = new Condition();
      }
      for (int i = 0; i < 10; i++)
      {
		   numberChoiceNumbers[i] = 0;
      }
   }
   
   public Encryption(String a, int num)
   {
      setEncryption(a, num);
   }
   // SETTERS
   /////////////////////////////////////////////////////////////////////
   public void setEncryption(String a, int num)
   {
      encryptedString = a;
      saveString = encryptedString;
      numofcond = num;
      for (int i = 0; i < num; i++)
      {
		   EncryptionConditions[i] = new Condition();
      }
      for (int i = 0; i < num; i++)
      {
		   numberChoiceNumbers[i] = 0;
      }
         
   }
   
   public void setEncryptionString(String a)
   {
      encryptedString = a;
      saveString = encryptedString;
      changeLog = changeLog + "NEW STRING: " + a + "\n";
      resetNumberChoice();
   }
   
   public void setChoiceCounter(int a)
   {
      choiceCounter = a;
   }
   
   public void setNumberChoiceNumber(int a, int b)
   {    
      numberChoiceNumbers[a] = b;
   }
      
   // GETTERS
   /////////////////////////////////////////////////////////////////////
   public String getOriginalString()
   {
      return saveString;
   }
   
   public String getCurrentString()
   {
      return encryptedString;
   }
   public int getNumberOfConditions()
   {
      return numofcond;
   }
   
   public int getChoiceCounter()
   {
      return choiceCounter;
   }
   
   public String getNumberChoice()
   {
      return numberChoice;
   }
   
   public int getNumberChoiceNumber(int a)
   {    
      return numberChoiceNumbers[a];
   }
   
   //menus
   
   public void encryptionCreateMenu()
   {
      System.out.println("What would you like to do?");
      System.out.println("1: set a condition");     
      System.out.println("2: change a condition");   
      System.out.println("3: enable a condition");
      System.out.println("4: enable all conditions");    
      System.out.println("5: reverse a condition");
      System.out.println("6: reverse all conditions");   
      System.out.println("7: reset to original string");   
      System.out.println("8: view a conditon"); 
      System.out.println("9: view all conditions"); 
      System.out.println("10: show current string"); 
      System.out.println("11: show original string"); 
      System.out.println("12: show changelog"); 
      System.out.println("13: enter a new string"); 
      System.out.println("14: export encryption"); 
      System.out.println("15: exit"); 
   }

   public void encryptionloadMenu()
   {
      System.out.println("What would you like to do?");
      System.out.println("1: enable selected conditions");   
      System.out.println("2: reverse selected conditions");   
      System.out.println("3: reset to original string");   
      System.out.println("4: view a conditon"); 
      System.out.println("5: view all conditions"); 
      System.out.println("6: show current string"); 
      System.out.println("7: show original string"); 
      System.out.println("8: enter a new string"); 
      System.out.println("9: exit");
   }

   
   //menu options
   /////////////////////////////////////////////////////////////////////
   
   public void setConditionChange(int num, char letterChange, char letter)
   {
      if(EncryptionConditions[num].getPreferedLetter() == ' ' && EncryptionConditions[num].getChangingLetter() == ' ')
      {
         EncryptionConditions[num].setCondition(letterChange, letter);
         changeLog = changeLog + "CONDITION #" + (num + 1) + ": " + EncryptionConditions[num].getChange() + "\n";
      }
      else
      {
         System.out.println("CONDITION ALREADY INITIALLY SET: REJECTED INPUT");
      }
   }
   
   public void changeCondition(int num, char letterChange, char letter)
   {
      if(EncryptionConditions[num].getPreferedLetter() == ' ' && EncryptionConditions[num].getChangingLetter() == ' ')
      {
         System.out.println("CONDITION NOT INITIALLY SET: REJECTED INPUT");
      }
      else
      {
         changeLog = changeLog + "CONDITION #" + (num + 1) + " (" + EncryptionConditions[num].getChange() + ") ---> ";
         EncryptionConditions[num].setCondition(letterChange, letter);
         changeLog = changeLog + "(" + EncryptionConditions[num].getChange() + ")\n";
      }
   }

   
   public void enableCondition(int num)
   {
      EncryptionConditions[num].changeChar(encryptedString);
      changeLog = changeLog + EncryptionConditions[num].getChange() + "\n";
      encryptedString = EncryptionConditions[num].getEncryptedString();
   }
   
   public void enableSelectionCondition(int num)
   {
      if(EncryptionConditions[num].changeCheck(encryptedString) != false)
      {
         System.out.println("true");
         EncryptionConditions[num].changeChar(encryptedString);
         changeLog = changeLog + EncryptionConditions[num].getChange() + "\n";
         encryptedString = EncryptionConditions[num].getEncryptedString();
      }
      else
      {
         System.out.println("FALSE");
         EncryptionConditions[num].ReversechangeChar(encryptedString);
         changeLog = changeLog + "RETRACTED: " + EncryptionConditions[num].getChange() + "\n";
         encryptedString = EncryptionConditions[num].getEncryptedString();
      }
   }
   
   
   public void enableAllConditions()
   {
      for(int i = 0; i < numofcond; i++)
      {
         if(EncryptionConditions[i].changeCheck(encryptedString) != false)
         {
            EncryptionConditions[i].changeChar(encryptedString);
            changeLog = changeLog + EncryptionConditions[i].getChange() + "\n";
            encryptedString = EncryptionConditions[i].getEncryptedString();
         }
         else
         {
            EncryptionConditions[i].ReversechangeChar(encryptedString);
            changeLog = changeLog + "RETRACTED: " + EncryptionConditions[i].getChange() + "\n";
            encryptedString = EncryptionConditions[i].getEncryptedString();
         }
      }
   }
   
   public void reverseCondition(int num)
   {
      EncryptionConditions[num].ReversechangeChar(encryptedString);
      changeLog = changeLog + "RETRACTED: " + EncryptionConditions[num].getChange() + "\n";
      encryptedString = EncryptionConditions[num].getEncryptedString();
   }
   
   public void reverseSelectionCondition(int num)
   {
      if(EncryptionConditions[num].reverseCheck(encryptedString) != false)
      {
         EncryptionConditions[num].ReversechangeChar(encryptedString);
         changeLog = changeLog + "RETRACTED: " + EncryptionConditions[num].getChange() + "\n";
         encryptedString = EncryptionConditions[num].getEncryptedString();
         }
         else
         {
            EncryptionConditions[num].changeChar(encryptedString);
            changeLog = changeLog + EncryptionConditions[num].getChange() + "\n";
            encryptedString = EncryptionConditions[num].getEncryptedString();
         }
         
   }
   
   public void reverseAllConditions()
   {
      for(int i = 0; i < numofcond; i++)
      {
         if(EncryptionConditions[i].reverseCheck(encryptedString) != false)
         {
            EncryptionConditions[i].ReversechangeChar(encryptedString);
            changeLog = changeLog + "RETRACTED: " + EncryptionConditions[i].getChange() + "\n";
            encryptedString = EncryptionConditions[i].getEncryptedString();
         }
         else
         {
            EncryptionConditions[i].changeChar(encryptedString);
            changeLog = changeLog + EncryptionConditions[i].getChange() + "\n";
            encryptedString = EncryptionConditions[i].getEncryptedString();
         }

      }
      
   }
   
   public void resetString()
   {
         encryptedString = saveString;
         changeLog = changeLog + "STRING RESET\n";
         resetNumberChoice();
   }
   
   
   public void viewAllConditions()
   {
      for(int i = 0; i < numofcond; i++)
      {
         System.out.println("condition #" + (i + 1) + ": ");
         EncryptionConditions[i].printChange();
      }
   }
   
   public void viewCondition(int num)
   {
      System.out.println("condition #" + (num + 1) + ": ");
      EncryptionConditions[num].printChange();
   }
   
   public void showChangeLog()
   {
      System.out.println(changeLog);
   }
   
   //misc.
   ////////////////////////////////////////////////
   
   public void resetNumberChoice()
   {
      numberChoice = " ";
   }
   
   public void updateNumberChoice(int a)
   {
      numberChoice = numberChoice + a + " ";
   }
   
   public void updateChoiceCounter()
   {
      choiceCounter++;
   }
   
   public String rawData()
   {
      rawData = numofcond + " ";
      
      for(int i = 0; i < numofcond; i++)
      {
         rawData = rawData + EncryptionConditions[i].getChangingLetter() + " " + 
         EncryptionConditions[i].getPreferedLetter() + " ";
      }
      rawData = rawData + getChoiceCounter();
      rawData = rawData + numberChoice;
      
      return rawData;
   }
   
   public void ConditionTEST() //for debug
   {
      char lettertest = 'a';
      char lettertest2 = '0';
      for (int i = 0; i < 26; i++)
      {
         EncryptionConditions[i].setCondition(lettertest, lettertest2);
         changeLog = changeLog + "CONDITION #" + (i + 1) + ": " + EncryptionConditions[i].getChange() + "\n";
         lettertest++;
         lettertest2++;
      }
   }
}