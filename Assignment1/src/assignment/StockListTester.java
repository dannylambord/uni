
package assignment;

public class StockListTester 
{
    
    public static void main(String[] args)
    {
        StockItem product1 = new StockItem("HD248", "1TB Hard Drive" , (float) 59.99, 25, 10);// Creating a new product
        StockArrayList stock = new StockArrayList(product1);//Creation of a new stock list

        System.out.println("Testing formatStockList, expecting to see"
                + "     '[Item ID = HD248 Description = 1TB Hard Drive Price = £59.99 Quantity = 25 Re-Order level = 10]'");
        System.out.println(stock.formatStockList());

        System.out.println("Testing updateItemPrice, expecting to see '£9.99'");
        stock.updateItemPrice(product1, (float) 9.99);
        System.out.println(stock.formatStockList());

        System.out.println("Testing updateItemQuantity, expecting to see '58'");
        stock.updateItemQuantity(product1, 58);
        System.out.println(stock.formatStockList());

        System.out.println("Testing updateReOrderLevel, expecting to see '21'");
        stock.updateReOrderLevel(product1, 21);
        System.out.println(stock.formatStockList());

        System.out.println("Testing deleteItem, expecting to see product1 removed");
        stock.deleteItem(product1);
        System.out.println(stock.formatStockList());

        System.out.println("Testing addItem, expecting to see product1 added to the list");
        stock.addItem(product1);
        System.out.println(stock.formatStockList());
    }
    
}
