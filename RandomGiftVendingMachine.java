/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhchingoproject22;

import java.text.DecimalFormat;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author binhn
 */
public class RandomGiftVendingMachine implements IAllThingsVendingMachine<RandomGift> {
    
    //Convert infinite decimal number to two decimal number
    DecimalFormat df = new DecimalFormat("###.###");
    
    //Initialize extraMoney
    double extraMoneyCalculated = 0;  


    //_____________________________________________________
    // Methods
    //_____________________________________________________
    @Override
    public void TakeMoney(double userInputValue, double amount, Queue<RandomGift> a) {
         
        if(a.size()>=1){       
          Queue<RandomGift> A = a;
          amount = A.element().GetPrice();
          //userInput
          if(userInputValue>amount ){
            VendItem(A);
            ReturnMoney(userInputValue-amount, A); 
          }
          else if(userInputValue==amount){
            VendItem(A);
          }
          else if(userInputValue<amount && userInputValue>0){
                              
            //Initialize user extra money
            String userInputForExtraMoney = "";
            Scanner inputValueForExtraMoney = new Scanner(System.in);
                  
            String userChoice = "";
            Scanner inputChoice = new Scanner(System.in);
            
            boolean ContinueLoop = true;
            
               while(ContinueLoop == true){
                extraMoneyCalculated = amount - userInputValue;
                System.out.println("We need this extra money " + df.format(extraMoneyCalculated) + ".");
                System.out.println("Do you want to continue adding more money:");
                System.out.println("Y: Yes");
                System.out.println("Q: Quit");
                
                userChoice = inputChoice.nextLine().toUpperCase().trim();
                           
                switch (userChoice) {
                  case "Y":             
                    try{ 
                      System.out.println("Please enter some more money.");
                      userInputForExtraMoney = inputValueForExtraMoney.nextLine().trim();
                      double extraMoneyFromUser = Double.parseDouble(userInputForExtraMoney);
                      if(extraMoneyFromUser>0){
                        userInputValue += extraMoneyFromUser;
                        System.out.println("This is your new total money " + df.format(userInputValue) + ".");
                      }
                      else {
                        System.out.println("Enter a number more than 0.");
                      } 
                    }
                    catch(Exception ES ){
                     System.out.println("Enter number please.");
                    }       
                   break;
                  case "Q":
                    System.out.println("Here is your money: " + userInputValue);
                    System.out.println("We will get you back to our random gift menu");
                    System.out.println("This is our menu");
                    ContinueLoop = false;
                   break;
                  default:
                    System.out.println("Enter a choice or 'Q' to quit adding money.");
                   break;  
                }
                
                if(userInputValue<amount && !userChoice.equals("Q")) {
                 ContinueLoop = true;
                } 
                else {
                  ContinueLoop = false;
                  if(userInputValue>=amount){
                    TakeMoney(userInputValue, amount, a);
                   }
                }
               }
          }
          else if(userInputValue<=0) {
            System.out.println("Money value has to be more than 0.");
            System.out.println("Please choose again.");
          }
          else {
            System.out.println();        
          }
        }
    }
    
    //Just get money and print
    @Override
    public void ReturnMoney(double change, Queue<RandomGift> a) {
         System.out.println("Here is your change: &" + df.format(change));
         System.out.println("");
    }
    
    //Vend out candy, minus slot by compare queue'size
    @Override
    public RandomGift VendItem(Queue<RandomGift> slot) {
        
        RandomGift A = new RandomGift();
           
        if(slot.size()>0){
            A = slot.poll();
            System.out.println("This is your " + A.GetName() +" , enjoy it!");
            return A;
        }

        return null;
    }

    //Print machine'name
    @Override
    public String GetMachineInfo() {
        
     String output = "R: Random gift vending machine.";

     System.out.println(output);
     
     return output;
    }

    //Print machine options
    @Override
    public String DisplayContents(Queue<RandomGift> a, Queue<RandomGift> b, Queue<RandomGift> c) {
     
     RandomGift A = a.peek();
     RandomGift B = b.peek();
     RandomGift C = c.peek();
    
     String output = "Welcome to random gift vending machine \r\n" ;
     

     output +="Here are your options:\r\n";     
     if(a.size()>0){
      output +="A: Random gift (" + a.size() + ") - $" + A.GetPrice() + ".\r\n";
     }else{
      System.out.println("\r\n");
     }
     if(b.size()>0){
      output +="B: Random gift (" + b.size() + ") - &" + B.GetPrice() + ".\r\n";
     }else{
      System.out.println("\r\n");
     }
     if(c.size()>0){
      output +="C: Random gift (" + c.size() + ") - &" + C.GetPrice() + ".\r\n";
     }else{
      System.out.println("\r\n");
     }
     output +="Q: Quit" + ".\r\n"; 
    
     System.out.println(output);
     
     return output;
    }
}
