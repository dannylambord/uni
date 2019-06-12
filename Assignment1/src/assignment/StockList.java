/*
Program Title: StockList
Author: D.Lambord
Created: 30/04/2016
Version: 1.0
*/

package assignment;

public interface StockList  {
        
    public void addItem(StockItem item);// Adds item to stock list
    
    public void deleteItem(StockItem itemID);// Removes item identified by productID from stock list
    
    public void updateItemPrice(StockItem itemID, float price);// Updates price of existing item
    
    public void updateItemQuantity(StockItem item, int quantity);// Updates quantity of existing item
    
    public void updateReOrderLevel(StockItem item, int reOrderLevel);// Updates re-order level of existing item
    
    public String formatStockList();// Returns the stock list
  
    public String formatReOrderList();// Returns the re-order list
                                      // Items are on this list if quantity < reOrderLevel
}

