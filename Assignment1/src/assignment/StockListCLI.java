/*
Program Title: StockListCLI
Author: D.Lambord
Created: 30/04/2016
Version: 1.0
*/

package assignment;

import java.util.Scanner;

public class StockListCLI
{
        Scanner scanner = new Scanner(System.in);
        private StockList stock = null;
        public String input;
        public String ID;
        public String desc;
        public double price;
        public int quantity;
        public int reOrder;
        public String again;

    public StockListCLI(StockList stock)
    {
        this.stock = stock;

    }

    public void doMenu()// Displays main menu and gets valid option from user
    {
        System.out.println("Registry Mian Menu");
        System.out.println("******************");
        System.out.println("1. Add an Item");
        System.out.println("2. Delete an Item");
        System.out.println("3. Update Item Price");
        System.out.println("4. Update Item Quantity");
        System.out.println("5. Update Re-Order Level");
        System.out.println("6. Print Stock List");
        System.out.println("7. Print reOrder List");
        System.out.println("8. Exit");
        System.out.println("Select option [1-8] ;> ");
        input = scanner.next();

        switch(input){//Switch statement so that the correct method is used 
            case "1" :
                doAddItem();
                break;
            case "2" :
                doDeleteItem();
                break;
            case "3" :
                doUpdateItemPrice();
                break;
            case "4" :
                doUpdateItemQuantity();
                break;
            case "5" :
                doUpdateReOrderLevel();
                break;
            case "6" :
                doPrintStockList();
                break;
            case"7" :
                doPrintReOrderList();
                break;
            case "8" :
                System.exit(0);// Exiting of the program if 8 is selected
                break;
            default :
                System.out.println("Incorrect option please enter another value");
                doMenu();//Allowing the user to try again if an invalid option is chosen
        }
        doMenu();//Repeating the menu once the method in the switch statement is complete
    }

    private void doAddItem() 
    {
        System.out.println("Add New Product");
        System.out.println("***************");

        System.out.println("Enter Item ID");
        ID = scanner.next();

        System.out.println("Enter Item Description");
        desc = scanner.next();

        System.out.println("Enter Item Price");
        price = scanner.nextFloat();

        System.out.println("Enter Item Quantity");
        quantity = scanner.nextInt();// Scans the users input

        System.out.println("Enter Item Re-Order Level");
        reOrder = scanner.nextInt();

        StockItem item  = new StockItem(ID,desc, (float) price,quantity,reOrder);// New item created with the details inputted
        stock.addItem(item);//Adding the new item to the Linked list
        System.out.println("Item added");//Informing the user that the item has been added
        System.out.println("Add another item? [Y/N] :>");//Asking if the user wants to add another item
        again = scanner.next();
        if(again.equals("Y"))
        {
            doAddItem();//Repats if the user input is Y
        }
        else
        {
            doMenu();
        }
    }
    
    private void doDeleteItem() 
    {
        System.out.println("Delete Product");
        System.out.println("***************");

        System.out.println("Enter Item ID");
        ID = scanner.next();

        System.out.println("Enter Item Description");
        desc = scanner.next();

        System.out.println("Enter new Price");
        price = scanner.nextFloat();

        System.out.println("Enter Item Quantity");
        quantity = scanner.nextInt();

        System.out.println("Enter Item Re-Order Level");
        reOrder = scanner.nextInt();

        StockItem item  = new StockItem(ID,desc, (float) price,quantity,reOrder);
        stock.deleteItem(item);//Removing the item from the linkes list
        System.out.println("Item Removed");
        System.out.println("Remove another item? [Y/N] :>");
        again = scanner.next();

        if(again.equals("Y"))
        {
            doDeleteItem();
        }
        else
        {
            doMenu();
        }

    }
    
    private void doUpdateItemPrice() 
    {
        System.out.println("Update Price");
        System.out.println("***************");

        System.out.println("Enter Item ID");
        ID = scanner.next();

        System.out.println("Enter Item Description");
        desc = scanner.next();

        System.out.println("Enter new Price");
        price = scanner.nextFloat();

        System.out.println("Enter Item Quantity");
        quantity = scanner.nextInt();

        System.out.println("Enter Item Re-Order Level");
        reOrder = scanner.nextInt();

        StockItem item  = new StockItem(ID,desc, (float) price,quantity,reOrder);
        stock.updateItemPrice(item, (float) price);//Updating of price
        System.out.println("Price Updated");
        System.out.println("Update another item? [Y/N] :>");
        again = scanner.next();

        if(again.equals("Y"))
        {
            doUpdateItemPrice();
        }
        else
        {
            doMenu();
        }

    }
    
    private void doUpdateItemQuantity() 
    {

        System.out.println("Update Quantity");
        System.out.println("***************");

        System.out.println("Enter Item ID");
        ID = scanner.next();

        System.out.println("Enter Item Description");
        desc = scanner.next();

        System.out.println("Enter Item Price");
        price = scanner.nextFloat();

        System.out.println("Enter New Quantity");
        quantity = scanner.nextInt();

        System.out.println("Enter Item Re-Order Level");
        reOrder = scanner.nextInt();

        StockItem item  = new StockItem(ID,desc, (float) price,quantity,reOrder);
        stock.updateItemQuantity(item, quantity);
        System.out.println("Quantity Updated");
        System.out.println("Update another item? [Y/N] :>");
        again = scanner.next();

        if(again.equals("Y"))
        {
            doUpdateItemQuantity();
        }
        else
        {
            doMenu();
        }
    }
    
    private void doUpdateReOrderLevel() 
    {
        System.out.println("Update Re-order Level");
        System.out.println("***************");

        System.out.println("Enter Item ID");
        ID = scanner.next();

        System.out.println("Enter Item Description");
        desc = scanner.next();

        System.out.println("Enter Item Price");
        price = scanner.nextFloat();

        System.out.println("Enter Item Quantity");
        quantity = scanner.nextInt();

        System.out.println("Enter New Re-Order Level");
        reOrder = scanner.nextInt();

        StockItem item  = new StockItem(ID,desc, (float) price,quantity,reOrder);

        stock.updateReOrderLevel(item, reOrder);//Updating re-order level
        System.out.println("Re-order Level Updated");
        System.out.println("Update another item? [Y/N] :>");
        again = scanner.next();

        if(again.equals("Y"))
        {
            doUpdateReOrderLevel();
        }
        else
        {
            doMenu();
        }

    }

    private void doPrintStockList()
    {
        System.out.println(stock.formatStockList());// Display contents of stock list
    }

    private void doPrintReOrderList() 
    {
        System.out.println(stock.formatReOrderList());// Display contents of re-order list

    }
}
