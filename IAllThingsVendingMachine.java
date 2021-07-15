/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhchingoproject22;
import java.util.Queue;

/**
 *
 * @author binhn
 */
public interface IAllThingsVendingMachine<E> {// Accepts the amount of money from the user
void TakeMoney(double userInputValue, double amount, Queue<E> a);

// Returns the amount of money to the user
void ReturnMoney(double change, Queue<E> a);

// Spits out an item based on the vending slot chosen by the user
// Each vending machine should have SlotA, SlotB, and SlotC
// Up to 5 items can be placed in each slot of the vending machine
E VendItem(Queue<E> slotCode);

// Displays what kind of vending machine it is
String GetMachineInfo();

// Shows the item name and price for each Slot of the machine
String DisplayContents(Queue<E> a, Queue<E> b, Queue<E> c);
}