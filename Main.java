import javax.swing.*;
import java.awt.*;
import java.util.Scanner; 
import java.util.ArrayList;
import java.io.*;


class Main {

  public static void main(String[] args) {
    //Output out = new Output();
    //out.total_without_tax();
    Input userin = new Input();
    userin.inputLoop();


//Hari code
        final JFrame frame = new JFrame("Net Income/Loss");
int h=4;
        String[] columns = {"Amount", "Reason", "Tax Amount", "Amount with tax",
                            "Date"};




       
       ArrayList<String> cars= new ArrayList<String>();
         
           try {



      FileReader fr = new FileReader("Amount.txt");

      BufferedReader br = new BufferedReader(fr);

      String line = br.readLine();
      cars.add(line);

      while (line != null) {

        System.out.println(line);

        line = br.readLine();
        cars.add(line);
      }

      br.close();
      fr.close();
    } catch (Exception ex) {

      System.out.println(ex.getMessage());
    }
       
       int g=cars.size();
       Object[][] dataa=new Object[g][5];
int a=0;


for(int i=0;i<g;i++){


    
dataa[i][0]=cars.get(a);
a+=1;

}
       
       
ArrayList<String> Reason= new ArrayList<String>();

try{

      FileReader frr = new FileReader("reason.txt");

      BufferedReader brr = new BufferedReader(frr);

      String lines = brr.readLine();
      Reason.add(lines);

  while (lines != null) {

        System.out.println(lines);

        lines = brr.readLine();
        Reason.add(lines);
      }

      brr.close();
      frr.close();
}
catch(Exception ex){
System.out.println(ex.getMessage());
}

int m=Reason.size();
a=0;

for(int n=0;n<g;n++){

    
dataa[n][1]=Reason.get(a);
a+=1;

}


        JTable table = new JTable(dataa, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
Scanner sc = new Scanner(System.in);
        int ans=0;
        System.out.println("Enter amount:");
        ans=sc.nextInt();

        String net="";
        if (ans>0){
          net="income";
        }
        else{
          net="loss";
        }
        JLabel lblHeading = new JLabel("Net "+net);
        lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,24));

        frame.getContentPane().setLayout(new BorderLayout());

        frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
        frame.getContentPane().add(scrollPane,BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 200);
        frame.setVisible(true);
        
        
    }
    
}