/*
Program Title: StockListApp
Author: D.Lambord
Created: 30/04/2016
Version: 1.0
*/

package assignment;

public class StockListApp {
    

    public static void main(String[] args)
    {
        StockList stockList = new StockArrayList(null);// Create the stock list object

        StockListCLI stockListCLI
            = new StockListCLI(stockList);// Create an interface
        
        stockListCLI.doMenu();// Display the menu
    }
    
}
