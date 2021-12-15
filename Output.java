import java.io.*;

public class Output {
  public int totalval;
  public int addition;
  
  //Constructor
  public Output() {
    totalval = 0;
    addition = 0;
  }

  //class function to read the total
  public void total_without_tax() {
    try {
      FileReader fr = new FileReader("ValueFile.txt");
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) {
        addition = Integer.parseInt(line);
        totalval = totalval + addition;
        line = br.readLine();
      }
      br.close();
      fr.close();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  System.out.print("Net Gain: $" + totalval);
  }
}

