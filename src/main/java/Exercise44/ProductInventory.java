package Exercise44;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Andres Gacitua
 */

 import java.util.HashMap;

 public class ProductInventory
 {
     private HashMap<String, Product> products;

     public ProductInventory(String filename) throws Exception
     {
          products = JsonFileParser.readFile(filename);
     }

     public String findProduct(String name)
     {
         Product product = products.get(name);
         if (product == null)
         {
             return "Product was not found. Please try again.";
         }
         else
         {
             return String.format("Name: %s\nPrice: $%.2f\nQuantity On Hand: %d\n", product.getName(), product.getPrice(),
                 product.getQuantity());
         }
     }
 }