/*
Program Title: StockArrayList
Author: D.Lambord
Created: 30/04/2016
Version: 1.0
*/

package assignment;

import java.util.*;//Importing Linked List library
public class StockArrayList implements StockList //Implementation of the StockList interface
{


    LinkedList<StockItem> stockList 
                = new LinkedList <StockItem>();//Creation of linked list of type StockItem

    LinkedList<StockItem> reOrder 
                = new LinkedList <StockItem>();

    public StockArrayList(StockItem item) 
    {
           stockList = new LinkedList();//Creating the stock list
           stockList.add(item);//Adding the 1st item to the list
           reOrder = new LinkedList();//Creating the re-order list
    }    

    public void addItem(StockItem item)
    {
        stockList.add(item);
    }


    public void deleteItem(StockItem item)// Removes item from stock list
    {
        for(StockItem thisitem : stockList)
            {
                if(thisitem.getItemID() == item.getItemID())
                {
                    stockList.remove(thisitem);//If item matches then remove it from the list
              }
            }

    }
    
    public void updateItemPrice(StockItem item, float price)// Updates price of existing item
    {
        item.setPrice((float) price);//Using the setPrice method to update item price
    }

    public void updateItemQuantity(StockItem item, int quantity)// Updates quantity of existing item
    {

       item.setQuantity(quantity);//Using the setQuantity method to update item price

       if(item.getQuantity() < item.getReOrderLevel())
       {
           reOrder.add(item);//Adding the item to the re-order list if quantity is less than re-order level
       }

    }
    
    public void updateReOrderLevel(StockItem item, int reOrderLevel)// Updates re-order level of existing item
    {
         item.setReOrderLevel(reOrderLevel);
    }
    
    public String formatStockList()
    {
        return "[" + stockList + "]";// Returns the stock list
    }
    
    public String formatReOrderList() 
    {
        return  "[" + reOrder + "}";// Returns the re-order list
    }

}        
    
        
    
    
    

