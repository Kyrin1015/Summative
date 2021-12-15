import java.util.*;

public class Input {
  //Class variables
  public boolean run;
  public String tempval;
  public ArrayList<String> amount;
  public ArrayList<String> reason;
  public ArrayList<String> tax;

  //constructor
  public Input() {
    run = true;
    amount = new ArrayList<String>();
    reason = new ArrayList<String>();
    tax = new ArrayList<String>();
    tempval = "";
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
      }
    }
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
}
