 import java.util.*;
import java.io.*;

public class Input {
  //Class variables
  public boolean run;
  public String tempval;
  public int size;
  public ArrayList<String> amount;
  public ArrayList<String> reason;
  public ArrayList<Double> tax;
  public ArrayList<String> year;
  public ArrayList<String> month;
  public ArrayList<String> date;

  public boolean yeartrue;
  public boolean monthtrue;
  public boolean datetrue;

  //constructor
  public Input() {
    size = 0;
    run = true;
    amount = new ArrayList<String>();
    reason = new ArrayList<String>();
    tax = new ArrayList<Double>();
    tempval = "";

    year = new ArrayList<String>();
    month = new ArrayList<String>();
    date = new ArrayList<String>();

    yeartrue = true;
    monthtrue = true;
    datetrue = true;
  }

  public void inputLoop() {
    //Rules for user input
    System.out.println("type 'Exit' to exit the program, at any point.");
    System.out.println("For reasons, please type in any of the following. Any other inputs will not be accepted.");
    System.out.println("Rent, Cleaning supplies, Salary, Electricity bill, Water bill.");

    Scanner keyboard = new Scanner(System.in);
    //user input loop
    while (run) {
      System.out.print("Enter an amount(Before tax): $");
      tempval = keyboard.nextLine();
      user_exit(tempval);
      
      //So the "Exit" typing wont trigger the try-catch
      if (run) {
        //Try-catch will make sure it is an integer
        try{
          Double.parseDouble(tempval);
        } catch(Exception e) {
          System.out.println("You entered something other than a number. Try again!");
          continue;
        }
        amount.add(tempval);

        System.out.print("Enter a reason: ");
        tempval = keyboard.nextLine();
        checkValidReason(tempval);
        reason.add(tempval);

        
        System.out.println("Enter the year, month, then date in numbers(Ex. Month:6).");
        enterYear();
        enterMonth();
        enterDate();
      }
    }
    amountToTxt();
    reasonToTxt();
    taxToTxt();
    dateToTxt();
  }
  

  //A function that checks whether the reason given is a good parameter, and classifies which taxes(multipliers the amount will face)
  public void checkValidReason(String tempval) {
    boolean ongoing = true;
    while (ongoing) {
      if (tempval.equals("Rent")) {
        tax.add(1.13);
        ongoing = false;
      } else if (tempval.equals("Cleaning supplies")) {
        tax.add(1.13);
        ongoing = false;
      } else if (tempval.equals("Salary")) {
        tax.add(1.13);
        ongoing = false;
      } else if (tempval.equals("Electricity bill")) {
        tax.add(1.13);
        ongoing = false;
      } else if (tempval.equals("Water bill")) {
        tax.add(1.13);
        ongoing = false;
      } 
      else if (tempval.equals("Sales")) {
        tax.add(1.13);
        ongoing = false;
      }
      else if (tempval.equals("Exit")) {
        run = false;
        ongoing = false;
      } 
      else if (tempval.equals("exit")) {
        run=false;
        ongoing=false;
      } 
      
      else {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Your reason was invalid. Please try again.");
        System.out.print("Enter a reason: ");
        tempval = keyboard.nextLine();
        
      }
    }
  }
  

  //If user wants to exit
  public void user_exit(String tempval) {
    if (tempval.equals("Exit")||tempval.equals("exit")) {
      run = false;
      yeartrue = false;
      monthtrue = false;
      datetrue = false;
    }
  }

  public void enterYear(){
    yeartrue = true;
    while(yeartrue) {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Year: ");
      tempval = keyboard.nextLine();
      user_exit(tempval);
      if (yeartrue) {
        try{
          int date = Integer.parseInt(tempval);
          if (date < 1 ) {
            System.out.println("Not within scope, please try again.");
            continue;
          }
        } catch(Exception e) {
          System.out.println("You entered something other than a number. Try again!");
        }
        year.add(tempval);
        yeartrue = false;
      }
    }
  }

  public void enterMonth(){
    monthtrue = true;
    while(monthtrue) {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Month: ");
      tempval = keyboard.nextLine();
      user_exit(tempval);
      if (monthtrue) {
        try{
          int date = Integer.parseInt(tempval);
          if (date < 1 || date > 12) {
            System.out.println("Not within scope, please try again.");
            continue;
          }
        } catch(Exception e) {
          System.out.println("You entered something other than a number. Try again!");
        }
        month.add(tempval);
        monthtrue = false;
      }
    }
  }

  public void enterDate(){
    datetrue = true;
    while(datetrue) {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Date: ");
      tempval = keyboard.nextLine();
      user_exit(tempval);
      if (datetrue) {
        try{
          int date = Integer.parseInt(tempval);
          if (date < 1 || date > 31) {
            System.out.println("Not within scope, please try again.");
            continue;
          }
        } catch(Exception e) {
          System.out.println("You entered something other than a number. Try again!");
        }
        date.add(tempval);
        datetrue = false;
      }
    }
  }

  //Moves all of the Amount values from a list to a txt file
  public void amountToTxt() {
    size = amount.size();
    FileWriter fw = null; 
    BufferedWriter bw = null; 
    PrintWriter pw = null;
    try {
      File file = new File("Amount.txt");
      fw = new FileWriter(file, true); 
      bw = new BufferedWriter(fw); 
      pw = new PrintWriter(bw);
      for (int i = 0; i < size; i++) {
        pw.println(amount.get(i));
      }
      pw.flush();
      pw.close(); 
      bw.close(); 
      fw.close(); 
    } catch (IOException io) {
    }
  }

  public void reasonToTxt() {
    size = reason.size();
    FileWriter fw = null; 
    BufferedWriter bw = null; 
    PrintWriter pw = null;
    try {
      File file = new File("reason.txt");
      fw = new FileWriter(file, true); 
      bw = new BufferedWriter(fw); 
      pw = new PrintWriter(bw);
      for (int i = 0; i < size; i++) {
        pw.println(reason.get(i));
      }
      pw.flush();
      pw.close(); 
      bw.close(); 
      fw.close(); 
    } catch (IOException io) {
    }
  }

  public void taxToTxt(){
    size = tax.size();
    FileWriter fw = null; 
    BufferedWriter bw = null; 
    PrintWriter pw = null;
    try {
      File file = new File("Tax.txt");
      fw = new FileWriter(file, true); 
      bw = new BufferedWriter(fw); 
      pw = new PrintWriter(bw);
      for (int i = 0; i < size; i++) {
        pw.println(tax.get(i));
      }
      pw.flush();
      pw.close(); 
      bw.close(); 
      fw.close(); 
    } catch (IOException io) {
    }
  }

  public void dateToTxt(){
    String totaldate;
    size = year.size();
    FileWriter fw = null; 
    BufferedWriter bw = null; 
    PrintWriter pw = null;
    try {
      File file = new File("Date.txt");
      fw = new FileWriter(file, true); 
      bw = new BufferedWriter(fw); 
      pw = new PrintWriter(bw);
      for (int i = 0; i < size; i++) {
        totaldate = year.get(i) + "-" + month.get(i) + "-" + date.get(i);
        pw.println(totaldate);
      }
      pw.flush();
      pw.close(); 
      bw.close(); 
      fw.close(); 
    } catch (IOException io) {
    }
  }
}
