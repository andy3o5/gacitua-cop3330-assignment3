package Exercise44;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Andres Gacitua
 */


 import org.json.simple.JSONArray;
 import org.json.simple.JSONObject;
 import org.json.simple.parser.JSONParser;
 import org.json.simple.parser.ParseException;

 import java.io.FileReader;
 import java.io.IOException;
 import java.util.HashMap;
 import java.util.Iterator;

 public class JsonFileParser
 {

  public static HashMap<String, Product> readFile(String filename) throws IOException, ParseException
  {
     JSONParser parser = new JSONParser();
     FileReader fileReader = new FileReader(filename);
     JSONObject json = (JSONObject)parser.parse(fileReader);

     JSONArray jsonArray = (JSONArray)  json.get("products");
     Iterator iterator = jsonArray.iterator();
     HashMap<String, Product> productList = new HashMap<>();

     while(iterator.hasNext())
     {
         JSONObject productObject = (JSONObject) iterator.next();
         String name = (String) productObject.get("name");
         double price = Math.round((double) productObject.get("price"));
         long quantity = (long) productObject.get("quantity");
         Product product = new Product(name, price, quantity);
         productList.put(name, product);
    }
      return productList;
  }
 }