import java.util.*;
import java.io.*;
public class Encryptor
{
   static Scanner console = new Scanner(System.in);
   public static void main(String[] arg) throws FileNotFoundException
   {
      /* build 1
      Condition aChanger = new Condition();
      
      System.out.println("Input String: ");
      String teststring = console.nextLine();
      
      System.out.println("what letter do you want to swap in?");
      aChanger.setPreferedLetter(console.next().charAt(0));
      System.out.println("what letter do you want to swap out?");
      aChanger.setChangingLetter(console.next().charAt(0));
      
      
      aChanger.changeChar(teststring);
      aChanger.printString();
      aChanger.printChange();
      
      */
      ////////////////////////////////////////////////////////////////////////////////
      //Scanner inFile = new Scanner(new FileReader("Ex20Inpt.txt"));
      //num1 = inFile.nextInt();
      //inFile.close();
      /////////////
      //PrintWriter outFile = new PrintWriter("pay_check.txt");
      //outFile.println("Sum = " + (num1 + num2));
      //outFile.close();
      
      //while(inFile.hasNext())
      
      int choice = 0;
      String sentence, inFileName, outFileName;
      String divider = "/////////////////////////////////////////////////";
      
      System.out.println("///////////////////coder 2.6///////////////////");
      System.out.println("press 1 to make new encryption");
      System.out.println("press 2 to load in an encryption");
      System.out.println(divider);
      
      choice = console.nextInt();
      System.out.println(divider);
      
      while(choice != 1 && choice != 2)
      {
      System.out.println(choice + " is an invalid option");
      System.out.println("press 1 to make new encryption");
      System.out.println("press 2 to load in an encryption");
      System.out.println(divider);
      choice = console.nextInt();
      System.out.println(divider);
      }
      
      if (choice == 1) /////////////////// new
      {
         System.out.println("enter a sentence:");
         sentence = console.next();
         sentence = sentence + console.nextLine();
         System.out.println(divider);
         
         System.out.println("enter the amount of conditons you want (current max = 30)");
         Encryption alpha = new Encryption(sentence, console.nextInt());                           //encryption start
         System.out.println(divider);
         
         System.out.println("your current string: " + alpha.getOriginalString());
         System.out.println(divider);
         System.out.println("///////////////current conditions///////////////"); 
         alpha.viewAllConditions();
         
         while (choice != 15)
         {
            System.out.println(divider);
            alpha.encryptionCreateMenu();
            System.out.println(divider);
            
            choice = console.nextInt(); 
            System.out.println(divider);
            
            switch(choice)
            {
               case 1:
                  /*System.out.println("enter condition set in this format:");
                  System.out.println("condition number");
                  System.out.println("character to swap out");
                  System.out.println("character to swap in");
                  alpha.setConditionChange((console.nextInt() - 1), console.next().charAt(0), console.next().charAt(0));*/
                  alpha.ConditionTEST();
                  break;
               case 2:
                  System.out.println("enter condition change in this format:");
                  System.out.println("condition number");
                  System.out.println("character to swap out");
                  System.out.println("character to swap in");
                  alpha.changeCondition((console.nextInt() - 1), console.next().charAt(0), console.next().charAt(0));
                  break;
               case 3:
                  System.out.println("enable which condition?");
                  /*alpha.enableCondition((console.nextInt() - 1));*/
                  alpha.enableSelectionCondition((console.nextInt() - 1));//
                  break;
               case 4:
                  System.out.println("enabling all conditions");
                  alpha.enableAllConditions();
                  break;
               case 5:
                  System.out.println("reverse which condition?");
                  alpha.reverseCondition((console.nextInt() - 1));
                  break;
               case 6:
                  System.out.println("reversing all conditions");
                  alpha.reverseAllConditions();
                  break;
               case 7:
                  System.out.println("reseting to original string");
                  alpha.resetString();
                  break;
               case 8:
                  System.out.println("view which condition?");
                  alpha.viewCondition((console.nextInt() - 1));
                  break;
               case 9:
                  System.out.println("viewing all conditions");
                  alpha.viewAllConditions();
                  break;
               case 10:
                  System.out.println("your current string: " + alpha.getCurrentString());
                  break;
               case 11:
                  System.out.println("your original string: " + alpha.getOriginalString());
                  break;
               case 12:
                  alpha.showChangeLog();
                  break;
               case 13:
                  System.out.println("enter new string");
                  sentence = console.next();
                  sentence = sentence + console.nextLine();
                  alpha.setEncryptionString(sentence);
                  break;
               case 14:
                  
                  System.out.println("would you like the encryption to enable all conditions when encrypting a string? (yes/no)");
                  
                  if (console.next().equalsIgnoreCase("no"))
                  {
                     System.out.println("which conditions would you like the encryption to enable when encrypting a string? (enter 999 when finished)");
                     choice = console.nextInt();
                     while(choice != 999)
                     {
                        alpha.updateNumberChoice(choice);
                        alpha.updateChoiceCounter();
                        choice = console.nextInt();
                     }
                  }
                  else
                  {
                     for(int i = 0; i < alpha.getNumberOfConditions(); i++)
                     {
                        alpha.updateNumberChoice(i + 1);
                        alpha.updateChoiceCounter();
                     }
                  }
                  
                  System.out.println("enter name of new file (.txt will be added automatically)");
                  outFileName = console.next() + ".txt";
                  PrintWriter outFile = new PrintWriter(outFileName);
                  outFile.println(alpha.rawData());
                  System.out.println("file has been saved");
                  outFile.close();
                  break;
               
            }
            
         }    
         
      }
      
      if (choice == 2) /////////////////// load
      {
         System.out.println("enter name of the file (.txt will be added automatically)");
         inFileName = console.next() + ".txt";
         Scanner inFile = new Scanner(new FileReader(inFileName));
         System.out.println(divider);
         Encryption beta = new Encryption(" ", inFile.nextInt());
         //setting up loaded encryption
         for(int i = 0; i < beta.getNumberOfConditions(); i++)
         {
            beta.setConditionChange(i, inFile.next().charAt(0), inFile.next().charAt(0));
         }
         
         beta.setChoiceCounter(Integer.parseInt(inFile.next()));
         
         for(int i = 0; i < beta.getChoiceCounter(); i++)
         {
            beta.setNumberChoiceNumber(i, Integer.parseInt(inFile.next()));
         }
         
         
         //done setting up loaded encryption
         beta.viewAllConditions();
         
         while (choice != 9)
         {
            System.out.println(divider);
            beta.encryptionloadMenu();
            System.out.println(divider);
            
            choice = console.nextInt(); 
            System.out.println(divider);
            
            switch(choice)
            {
               case 1:
                  System.out.println("enabling selected conditions");
                  for(int i = 0; i < beta.getChoiceCounter(); i++)
                  {
                     beta.enableSelectionCondition((beta.getNumberChoiceNumber(i) - 1));
                  }
                  break;
               case 2:
                  System.out.println("reversing selected conditions");
                  for(int i = 0; i < beta.getChoiceCounter(); i++)
                  {
                     beta.reverseSelectionCondition((beta.getNumberChoiceNumber(i) - 1));
                  }
                  break;
               case 3:
                  System.out.println("reseting to original string");
                  beta.resetString();
                  break;
               case 4:
                  System.out.println("view which condition?");
                  beta.viewCondition((console.nextInt() - 1));
                  break;
               case 5:
                  System.out.println("viewing all conditions");
                  beta.viewAllConditions();
                  break;
               case 6:
                  System.out.println("your current string: " + beta.getCurrentString());
                  break;
               case 7:
                  System.out.println("your original string: " + beta.getOriginalString());
                  break;
               case 8:
                  System.out.println("enter new string");
                  sentence = console.next();
                  sentence = sentence + console.nextLine();
                  beta.setEncryptionString(sentence);
                  break;
            }
            
         }
         

      }
   
      //test.setConditionChange(0, '1', 'a');
      //test.enableCondition(0);
      //System.out.println(test.getCurrentString());
      //test.setConditionChange(1, '2', 'e');
      //test.enableCondition(1);
      //System.out.println(test.getCurrentString());
      //test.setConditionChange(2, '3', 'i');
      //test.enableCondition(2);
      //System.out.println(test.getCurrentString());
      //test.setConditionChange(3, '4', 'o');
      //test.enableCondition(3);
      //System.out.println(test.getCurrentString());
      //test.setConditionChange(4, '5', 'n');
      //test.enableCondition(4);
      //System.out.println(test.getCurrentString());
      //test.viewAllConditions();
      //test.viewCondition(4);
      //test.reverseCondition(4);
      //System.out.println(test.getCurrentString());
      //test.viewCondition(2);
      //test.reverseCondition(2);
      //System.out.println(test.getCurrentString());
      //test.resetString();
      //System.out.println(test.getCurrentString());
      //test.showChangeLog();
      
      //test.setEncryptionString("reach for the stars");
      //System.out.println(test.getCurrentString());
      //test.viewAllConditions();
      //test.changeCondition(0, '6', 'a');
      //test.changeCondition(1, '7', 'e');
      //test.changeCondition(2, '8', 'r');
      //test.enableCondition(0);
      //System.out.println(test.getCurrentString());
      //test.enableCondition(1);
      //System.out.println(test.getCurrentString());
      //test.enableCondition(2);
      //System.out.println(test.getCurrentString());
      //test.showChangeLog();
      
      //test.viewAllConditions();
      //System.out.println(test.rawData());
      
      
      
   }
}