import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Input {
  //Class variables
  public boolean run;
  public String tempval;
  public String date;
  public int size;
  public ArrayList<String> amount;
  public ArrayList<String> reason;
  public ArrayList<String> tax;

  //constructor
  public Input() {
    size = 0;
    run = true;
    amount = new ArrayList<String>();
    reason = new ArrayList<String>();
    tax = new ArrayList<String>();
    tempval = "";
    date = "";
  }

  public void inputLoop() {
    //Rules for user input
    System.out.println("type 'Exit' to exit the program, at any point.");
    System.out.println("For reasons, please type in any of the following. Any other inputs will not be accepted.");
    System.out.println("Rent, Cleaning supplies, Salary, Electricity bill, Water bill.");

    Scanner keyboard = new Scanner(System.in);
    //user input loop
    while (run == true) {
      System.out.print("Enter an amount(Before tax): $");
      tempval = keyboard.nextLine();
      user_exit(tempval);
      
      //So the "Exit" typing wont trigger the try-catch
      if (run == true) {
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

        try {
          //Saves dates
          System.out.println("Enter the year of transaction(Ex. 2019): ");
          int temp = Integer.parseInt(keyboard.nextLine());
          date += temp + "/";
          System.out.println("Enter the month of transaction(1-12): ");
          temp = Integer.parseInt(keyboard.nextLine());
          if (temp < 1 || temp > 12) {
            System.out.println("Month out of range. Please try again!");
            continue;
          } else {
            date += temp + "/";
            System.out.println("Enter the date of the transaction");
            temp = Integer.parseInt(keyboard.nextLine());
            int maxday = 0;
            if (temp == 1 || temp == 3 || temp == 5 || temp == 7 || temp == 8 || temp == 10 || temp == 12) {
              maxday = 31;
            } else if (temp == 2) {
              maxday = 29;
            } else {
              maxday = 30;
            }
            if (temp <)
          }
        } catch (Exception e){
          System.out.println("Not a number.Please try again.");
        }
      }
    }
    amountToTxt();
    reasonToTxt();
  }
  

  //A function that checks whether the reason given is a good parameter, and classifies which taxes(multipliers the amount will face)
  public void checkValidReason(String tempval) {
    boolean ongoing = true;
    while (ongoing == true) {
      if (tempval.equals("Rent")) {
        tax.add("1");
        ongoing = false;
      } else if (tempval.equals("Cleaning supplies")) {
        tax.add("1");
        ongoing = false;
      } else if (tempval.equals("Salary")) {
        tax.add("1");
        ongoing = false;
      } else if (tempval.equals("Electricity bill")) {
        tax.add("1");
        ongoing = false;
      } else if (tempval.equals("Water bill")) {
        tax.add("1");
        ongoing = false;
      } else if (tempval.equals("Exit")) {
        run = false;
        ongoing = false;
      } else {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Your reason was invalid. Please try again.");
        System.out.print("Enter a reason: ");
        tempval = keyboard.nextLine();
      }
    }
  }
  

  //If user wants to exit
  public void user_exit(String tempval) {
    if (tempval.equals("Exit")) {
      run = false;
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
}
