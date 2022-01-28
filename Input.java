import java.util.*;
import java.io.*;
import java.math.*;

public class Input {
  //Class variables
  public boolean run;
  public String tempval;
  public int size;

  //ArrayList for the different input values
  public ArrayList<String> amount;
  public ArrayList<String> reason;
  public ArrayList<Double> tax;
  public ArrayList<String> year;
  public ArrayList<String> month;
  public ArrayList<String> date;

  //Boolean values for the date, month, and year
  public boolean yeartrue;
  public boolean monthtrue;
  public boolean datetrue;

  //Input
  public Scanner keyboard;

  //For java io
  public FileWriter fw = null; 
  public BufferedWriter bw = null; 
  public PrintWriter pw = null;

  //constructor
  public Input() {
    //Initializing variables
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

    Scanner keyboard = new Scanner(System.in);

    fw = null;
    bw = null;
    pw = null;
  }

  public void inputLoop() {
    //Rules for user input
    System.out.println("type 'Exit' to exit the program when the program asks for an amount.");
    System.out.println("For reasons, please type in any of the following. Any other inputs will not be accepted.");
    System.out.println("Sales, Rent, Cleaning supplies, Salary, Electricity bill, Water bill.");

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
        //Adds to amount arraylist
        amount.add(tempval);

        //Input for reason
        System.out.print("Enter a reason: ");
        tempval = keyboard.nextLine();
        checkValidReason(tempval);
        reason.add(tempval);

        //Input for date
        System.out.println("Enter the year, month, then date in numbers(Ex. Month:6).");
        enterYear();
      }
    }
    amountToTxt();
    reasonToTxt();
    taxToTxt();
    dateToTxt();
  }
  

  //A function that checks whether the reason given is a good parameter, and classifies which taxes(multipliers the amount will face)
  //Since the tax multiplier is the same for every single reason, I can put them all into a single if statement
  public void checkValidReason(String tempval) {
    boolean ongoing = true;
    while (ongoing) {
      if (tempval.equals("Rent") || tempval.equals("Cleaning supplies") || tempval.equals("Salary") || tempval.equals("Electricity bill") || tempval.equals("Water bill") || tempval.equals("Sales")) {
        tax.add(1.13);
        ongoing = false;
      } else if (tempval.equals("Exit") || tempval.equals("exit")) {
        run = false;
        ongoing = false;
      } else {
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

  //Asks user for the year he wants to put
  public void enterYear(){
    yeartrue = true;
    //While loop to sue the continue if the user input is less than 1
    while(yeartrue) {
      System.out.print("Year: ");
      tempval = keyboard.nextLine();
      user_exit(tempval);
      if (yeartrue) {
        try{
          //If if year < 1, continue is triggered and loops in the while loop
          int date = Integer.parseInt(tempval);
          if (date < 1 ) {
            System.out.println("Not within scope, please try again.");
            continue;
          }
        } catch(Exception e) {
          //When the date get's parsed into an int, if it is not possible, this is triggered
          System.out.println("You entered something other than a number. Try again!");
        }
        //Adds the input into an arraylist, exits the loop and activates the next function
        year.add(tempval);
        yeartrue = false;
        enterMonth();
      }
    }
  }

  //Asks user for the month he wants to put
  public void enterMonth(){
    monthtrue = true;
    while(monthtrue) {
      System.out.print("Month: ");
      tempval = keyboard.nextLine();
      user_exit(tempval);
      if (monthtrue) {
        try{
          //If if month < 1 or month > 12, continue is triggered and loops in the while loop
          int date = Integer.parseInt(tempval);
          if (date < 1 || date > 12) {
            System.out.println("Not within scope, please try again.");
            continue;
          }
        } catch(Exception e) {
          //When the date get's parsed into an int, if it is not possible, this is triggered
          System.out.println("You entered something other than a number. Try again!");
        }
        //Adds the input into an arraylist, exits the loop and activates the next function
        month.add(tempval);
        monthtrue = false;
        enterDate();
      }
    }
  }

  //Asks user for the date he wants to put
  public void enterDate(){
    datetrue = true;
    while(datetrue) {
      System.out.print("Date: ");
      tempval = keyboard.nextLine();
      user_exit(tempval);
      if (datetrue) {
        try{
          //If if month < 1 or month > 12, continue is triggered and loops in the while loop
          int date = Integer.parseInt(tempval);
          if (date < 1 || date > 31) {
            System.out.println("Not within scope, please try again.");
            continue;
          }
        } catch(Exception e) {
          //When the date get's parsed into an int, if it is not possible, this is triggered
          System.out.println("You entered something other than a number. Try again!");
        }
        //Adds the input into an arraylist, exits the loop and resumes input loop's loop
        date.add(tempval);
        datetrue = false;
      }
    }
  }

  //Moves all of the Amount values from a list to a txt file
  public void amountToTxt() {
    size = amount.size();
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

  //Moves all of the Reason values from an arraylist to a txt file
  public void reasonToTxt() {
    size = reason.size();
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

  //Multiplies and calculates the values for the amonut of tax and the amount with tax
  public void taxToTxt(){
    size = tax.size();
    //Calculates for the amount with tax
    try {
      File file = new File("Tax.txt");
      fw = new FileWriter(file, true); 
      bw = new BufferedWriter(fw); 
      pw = new PrintWriter(bw);
      //Prints to Tax.txt the amount with tax
      for (int i = 0; i < size; i++) {
        double val = tax.get(i)*Double.parseDouble(amount.get(i));
        pw.println(round(val, 2));
      }
      pw.flush();
      pw.close(); 
      bw.close(); 
      fw.close(); 
    } catch (IOException io) {
    }
    //Calculates for the amount of tax
    try {
      File file = new File("TaxAmount.txt");
      fw = new FileWriter(file, true); 
      bw = new BufferedWriter(fw); 
      pw = new PrintWriter(bw);
      //Prints to TaxAmount.txt the amount of tax
      for (int i = 0; i < size; i++) {
        double val = (tax.get(i)-1)*Double.parseDouble(amount.get(i));
        pw.println(round(val, 2));
      }
      pw.flush();
      pw.close(); 
      bw.close(); 
      fw.close(); 
    } catch (IOException io) {
    }
  }

  //Compiles all of the date values together and outputs it to Date.txt
  public void dateToTxt(){
    String totaldate;
    size = year.size();
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

  //Round up funtion that takes in a value and the amount of decimal places you need
  public static double round(double value, int places) {
    if (places < 0) {
      throw new IllegalArgumentException();
      }
    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
}
