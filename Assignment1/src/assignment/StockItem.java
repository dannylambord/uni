/*
Program Title: StockItem
Author: D.Lambord
Created: 30/04/2016
Version: 1.0
*/

package assignment;

import java.io.PrintStream;

public class StockItem 
{

        public String itemID; // Five alpha-numeric characters
        public String itemDesc; // Item description
        public float price; // Item price in pounds sterling
        public int quantity; // Quantity in stock
        public int reOrderLevel; // Level at which to re-order

    public StockItem(String aID, String aDesc, float aPrice, int aQuantity, int aReOrd)//StockItem constructor
    {
        itemID = aID;
        itemDesc = aDesc;
        price = aPrice;
        quantity = aQuantity;
        reOrderLevel = aReOrd;
    }

    public String toString() 
    {
        return " [Item ID = " + getItemID() + " Description = " + getItemDesc() + " Price = £" +
                getPrice() + " Quantity = " + getQuantity() + " Re-Order level = " + getReOrderLevel() + "]";
    }

    public PrintStream format()
    {
        return System.out.printf("\n \n%-10s%-15s%-10s%-10s%-15s\n%-10s%-7s%12.2f%7d%10d\n", 
                "Item ID", "Description","Price","Quantity","Re-Order Level",
                getItemID(), getItemDesc() , getPrice() , getQuantity() , getReOrderLevel());//Formatting of items in linked list
    }

    public String getItemID()
    {
        return itemID;
    }

    public String getItemDesc()
    {
        return itemDesc;
    }

    public double getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getReOrderLevel()
    {
        return reOrderLevel;
    }

    public double setPrice(float p)//Setting the price of the item
    { 
        price = p;
        return price;
    }

    public int setQuantity(int q)//Setting the quantity of the item
    {
        quantity = q;
        return quantity;
    }

    public int setReOrderLevel(int r)//Setting the re-order level of the item
    {
        reOrderLevel = r;
        return reOrderLevel;
    }
}