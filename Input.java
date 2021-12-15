import java.util.*;

public class Input {
  //Class variables
  public boolean run;
  public String tempval;
  public ArrayList<String> amount;
  public ArrayList<String> reason;

  //constructor
  public Input() {
    run = true;
    amount = new ArrayList<String>();
    reason = new ArrayList<String>();
    tempval = "";
  }

  public void inputLoop() {
    //Rules for user input
    System.out.println("type 'Exit' to exit the program");
    System.out.println("For reasons, please type in any of the following. Any other inputs will not be accepted.");
    System.out.println("Rent, Cleaning supplies, Salary, Electricity bill, Water bill.");

    Scanner keyboard = new Scanner(System.in);
    //user input loop
    while (run == true) {
      System.out.print("Enter an amount(Before tax):");
      tempval = keyboard.nextLine();
      if (tempval == "Exit") {
        break;
        }
      amount.add(tempval);
      //Double.parseDouble(str)
      System.out.print("Enter a reason");
      tempval = keyboard.nextLine();
      if (tempval == "Exit") {
        break;
        }
      reason.add(tempval);
    }
  }
}