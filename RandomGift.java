/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhchingoproject22;

/**
 *
 * @author binhn
 */
public class RandomGift extends AllThings {
    
    /**
     * Default Constructor
     */
    public RandomGift(){

    }
    
   /**
    * Constructor with a known name and price
    * @param name and price The Name and price of the Soda
    */
    public RandomGift(String name, double price){
      SetName(name);
      SetPrice(price);
    }
}