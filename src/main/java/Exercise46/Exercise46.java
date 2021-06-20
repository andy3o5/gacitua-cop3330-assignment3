 package Exercise46;
 
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Andres Gacitua
 */

 public class Word implements Comparable<Word>
 {
     private String name;
     private int count;

     public Word(String name, int count)
     {
         this.name = name;
         this.count = count;
     }

     public int getCount()
     {
         return count;
     }

     public void setCount(int count)
     {
         this.count = count;
     }

     public String getName()
     {
         return name;
     }

     public void setName(String name)
     {
         this.name = name;
     }

     @Override
     public String toString()
     {
         return  name + ", " + count;
     }

     public int compareTo(Word w)
     {
         return this.getName().compareTo(w.getName());
     }
 }