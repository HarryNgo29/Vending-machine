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

public class AllThings implements IITem {
  
    //_____________________________________________________
    // Properties   
    //_____________________________________________________
    protected String name = "";
    public String GetName() { return name; }
    public void SetName(String name) { this.name=name; }
    
    protected double price = 0;
    public double GetPrice() { return price; }
    public void SetPrice(double val) { price = val; }   
        
    //_____________________________________________________
    // Constructors   
    //_____________________________________________________
    
    /**
     * Default Constructor
     */
    public AllThings(){

    }
   /**
    * Constructor with a known name and price
    * @param name and price The Name and price of the AllThings
    */
    public AllThings(String name, double price){
      SetName(name);
      SetPrice(price);
    }
     
}


