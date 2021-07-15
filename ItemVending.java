/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhchingoproject22;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author binhn
 */
public class ItemVending {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
     AllThingsVendingMachine machine = new AllThingsVendingMachine();
     CandyVendingMachine machineCandy = new CandyVendingMachine();
     SodaVendingMachine machineSoda = new SodaVendingMachine();
     RandomGiftVendingMachine machineRandomGift = new RandomGiftVendingMachine();


     
     //Initialize a bunch of candy for queue A
     Queue<AllThings> CandyA = new LinkedList();
     CandyA.add(new Candy("Skittles", 4.2));
     CandyA.add(new Candy("Skittles", 4.2));
     CandyA.add(new Candy("Skittles", 4.2));
     CandyA.add(new Candy("Skittles", 4.2));
     CandyA.add(new Candy("Skittles", 4.2));
     
     //Initialize a bunch of candy for queue B
     Queue<AllThings> CandyB = new LinkedList();
     CandyB.add(new Candy("Snicker", 1.42));
     CandyB.add(new Candy("Snicker", 1.42));
     CandyB.add(new Candy("Snicker", 1.42));
     CandyB.add(new Candy("Snicker", 1.42));
     CandyB.add(new Candy("Snicker", 1.42));
     
     //Initialize a bunch of candy for queue C
     Queue<AllThings> CandyC = new LinkedList();
     CandyC.add(new Candy("M&M's", 42.42));
     CandyC.add(new Candy("M&M's", 42.42));
     CandyC.add(new Candy("M&M's", 42.42));
     CandyC.add(new Candy("M&M's", 42.42));
     CandyC.add(new Candy("M&M's", 42.42));
     
     //Initialize a bunch of soda for queue A
     Queue<AllThings> SodaA = new LinkedList();
     SodaA.add(new Soda("Coca", 1.99));
     SodaA.add(new Soda("Coca", 1.99));
     SodaA.add(new Soda("Coca", 1.99));
     SodaA.add(new Soda("Coca", 1.99));
     SodaA.add(new Soda("Coca", 1.99));
     
     //Initialize a bunch of soda for queue B
     Queue<AllThings> SodaB = new LinkedList();
     SodaB.add(new Soda("Pepsi", 1.19));
     SodaB.add(new Soda("Pepsi", 1.19));
     SodaB.add(new Soda("Pepsi", 1.19));
     SodaB.add(new Soda("Pepsi", 1.19));
     SodaB.add(new Soda("Pepsi", 1.19));
     
     //Initialize a bunch of soda for queue C
     Queue<AllThings> SodaC = new LinkedList();
     SodaC.add(new Soda("Sprite", 1.99));
     SodaC.add(new Soda("Sprite", 1.99));
     SodaC.add(new Soda("Sprite", 1.99));
     SodaC.add(new Soda("Sprite", 1.99));
     SodaC.add(new Soda("Sprite", 1.99));
     
     //Initialize a bunch of random gift for queue A
     Queue<AllThings> RandomGiftA = new LinkedList();
     RandomGiftA.add(new RandomGift("Sprite", 10));
     RandomGiftA.add(new RandomGift("Lanyard", 10));
     RandomGiftA.add(new RandomGift("Lays", 10));
     RandomGiftA.add(new RandomGift("Alarm Clock", 10));
     RandomGiftA.add(new RandomGift("Belt", 10));
     
     //Initialize a bunch of random gift for queue B
     Queue<AllThings> RandomGiftB = new LinkedList();
     RandomGiftB.add(new RandomGift("Coca", 10));
     RandomGiftB.add(new RandomGift("M&M", 10));
     RandomGiftB.add(new RandomGift("Quest nutrition cake", 10));
     RandomGiftB.add(new RandomGift("Samsung case", 10));
     RandomGiftB.add(new RandomGift("AirPods", 10));
     
     //Initialize a bunch of random gift for queue C
     Queue<AllThings> RandomGiftC = new LinkedList();
     RandomGiftC.add(new RandomGift("Iphone case", 10));
     RandomGiftC.add(new RandomGift("Pepsi", 10));
     RandomGiftC.add(new RandomGift("Cheeto", 10));
     RandomGiftC.add(new RandomGift("Iron water bottle", 10));
     RandomGiftC.add(new RandomGift("Snicker", 10));
     
     //Initialize user choice
     String userChoice = "";
     String userInputValueInString;
     Scanner inputChoice = new Scanner(System.in);
     Scanner inputValue = new Scanner(System.in);
     
     //Initialize user money  
     double userInputValueInDouble = 0;
     
     //User decision to use the machine
     while (!userChoice.equals("Q")){
         
       //User choice to operate machine input
       System.out.println("Here are your vending machine options:");
       machineCandy.GetMachineInfo();
       machineSoda.GetMachineInfo();
       machineRandomGift.GetMachineInfo();
       System.out.println("Q: Quit");
       
       userChoice = inputChoice.nextLine().toUpperCase().trim();
     
       //User decision to choose candy
       switch (userChoice) {
         case "C":        
             
         // Keep going until the user quits
         while (!userChoice.equals("Q")) {
     
           //Main Menu
           System.out.println("Welcome to this candy vending machine!");
           machine.DisplayContents( CandyA, CandyB, CandyC);
         
           // Get user candy choice input
           System.out.println("Enter your option");
           userChoice = inputChoice.nextLine().toUpperCase().trim();
    
           // Get user'money
           try{
            if((userChoice.equals("A") && CandyA.size()>0) || 
               (userChoice.equals("B") && CandyB.size()>0) || 
               (userChoice.equals("C") && CandyC.size()>0)){
             System.out.println("Enter your money: ");
             userInputValueInString = inputValue.nextLine().trim();
             userInputValueInDouble = Double.parseDouble(userInputValueInString);        
            } 
           }
           catch(NumberFormatException ES ){
               System.out.println("Enter number please.");
           }
                   
           // Perform user-defined action for candy choice
           switch (userChoice) {
              case "A":
                      TakeMoneyVer2(userInputValueInDouble, CandyA,  machine);
                     break;
              case "B":
                      TakeMoneyVer2(userInputValueInDouble, CandyB,  machine);
                     break;
              case "C":
                      TakeMoneyVer2(userInputValueInDouble, CandyC,  machine);
                     break;
              case "Q":
                     break;
              default:
                     System.out.println("Enter a choice or 'Q' to quit.");
                     break;
             }           
           }        
        case "S":
            
         // Keep going until the user quits
         while (!userChoice.equals("Q")) {
     
           //Main Menu
           System.out.println("Welcome to this soda vending machine!");
           machine.DisplayContents( SodaA, SodaB, SodaC);
         
           // Get user candy choice input
           System.out.println("Enter your option");
           userChoice = inputChoice.nextLine().toUpperCase().trim();
    
           // Get user'money
           try{
            if((userChoice.equals("A") && SodaA.size()>0) || 
               (userChoice.equals("B") && SodaB.size()>0) || 
               (userChoice.equals("C") && SodaC.size()>0)){
             System.out.println("Enter your money: ");
             userInputValueInString = inputValue.nextLine().trim();
             userInputValueInDouble = Double.parseDouble(userInputValueInString);        
            } 
           }
           catch(NumberFormatException ES ){
               System.out.println("Enter number please.");
           }
                   
           // Perform user-defined action for candy choice
           switch (userChoice) {
              case "A":
                      TakeMoneyVer2(userInputValueInDouble, SodaA,  machine);
                     break;
              case "B":
                      TakeMoneyVer2(userInputValueInDouble, SodaB,  machine);
                     break;
              case "C":
                      TakeMoneyVer2(userInputValueInDouble, SodaC,  machine);
                     break;
              case "Q":
                     break;
              default:
                     System.out.println("Enter a choice or 'Q' to quit.");
                     break;
             }
           }  
         case "R":
         
         // Keep going until the user quits
         while (!userChoice.equals("Q")) {
     
           //Main Menu
           System.out.println("Welcome to this random gift vending machine!");
           machine.DisplayContents( RandomGiftA, RandomGiftB, RandomGiftC);
         
           // Get user candy choice input
           System.out.println("Enter your option");
           userChoice = inputChoice.nextLine().toUpperCase().trim();
    
           // Get user'money
           try{
            if((userChoice.equals("A") && RandomGiftA.size()>0) || 
               (userChoice.equals("B") && RandomGiftB.size()>0) || 
               (userChoice.equals("C") && RandomGiftC.size()>0)){
             System.out.println("Enter your money: ");
             userInputValueInString = inputValue.nextLine().trim();
             userInputValueInDouble = Double.parseDouble(userInputValueInString);        
            } 
           }
           catch(NumberFormatException ES ){
               System.out.println("Enter number please.");
           }
                   
           // Perform user-defined action for candy choice
           switch (userChoice) {
              case "A":
                      TakeMoneyVer2(userInputValueInDouble, RandomGiftA,  machine);
                     break;
              case "B":
                      TakeMoneyVer2(userInputValueInDouble, RandomGiftB,  machine);
                     break;
              case "C":
                      TakeMoneyVer2(userInputValueInDouble, RandomGiftC,  machine);
                     break;
              case "Q":
                     break;
              default:
                     System.out.println("Enter a choice or 'Q' to quit.");
                     break;
             }
           }       
         case "Q":
              System.out.println("Thanks for choosing us, see you next time");             
              break;
         default:
              System.out.println("Enter a choice or 'Q' to quit.");
              break;         
      }
    }
  }
    
   private static void TakeMoneyVer2(double userInputValue, Queue<AllThings> A, AllThingsVendingMachine machine){
       if(A.size()>0){
          machine.TakeMoney(userInputValue, A.element().GetPrice(), A);
       }else{
          System.out.println("This option have no candy left, so please choose another option");
       }
   }
 
}
