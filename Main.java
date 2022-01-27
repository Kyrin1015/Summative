import javax.swing.*;
import java.awt.*;
import java.util.Scanner; 
import java.util.ArrayList;
import java.io.*;
import java.lang.*;
import java.lang.Math;

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




      //Creating ArrayList that will store value from txt file 
      ArrayList<String> amount= new ArrayList<String>();
      ArrayList<String> taxed= new ArrayList<String>();
      ArrayList<String> date= new ArrayList<String>();
      ArrayList<String> Reason= new ArrayList<String>();
      ArrayList<String> tamount= new ArrayList<String>();
      ArrayList<Integer> w= new ArrayList<Integer>();
      ArrayList<Integer> p=new ArrayList<Integer>();
           try {


      //Creating files 
      FileReader fr = new FileReader("Amount.txt");
      FileReader fre = new FileReader("Tax.txt");
      FileReader frs = new FileReader("TaxAmount.txt");
      FileReader free = new FileReader("Date.txt");
      FileReader frr = new FileReader("reason.txt");

      BufferedReader br = new BufferedReader(fr);
      BufferedReader bre = new BufferedReader(fre);
      BufferedReader bree = new BufferedReader(free);
      BufferedReader brr = new BufferedReader(frr);
      BufferedReader brs = new BufferedReader(frs);

      String line = br.readLine();
      String liner = bre.readLine();
      String liners = bree.readLine();
      String lines = brr.readLine();
      String liness = brs.readLine();

      amount.add(line);
      taxed.add(liner);
      date.add(liners);
      Reason.add(lines);
      tamount.add(liness);

      //while loop that iterates through txt files and adds element into the appropriate arraylists
      while (line != null) {

        System.out.println(line);

        line = br.readLine();
        amount.add(line);
        liner= bre.readLine();
        taxed.add(liner);
        liners= bree.readLine();
        date.add(liners);
        lines = brr.readLine();
        Reason.add(lines);
        liness = brs.readLine();
        tamount.add(liness);


      }

      br.close();
      fr.close();
      bre.close();
      fre.close();
      bree.close();
      free.close();
      brr.close();
      frr.close();
      brs.close();
      frs.close();
    } catch (Exception ex) {

      System.out.println(ex.getMessage());
    }
       
       int g=amount.size();
       Object[][] dataa=new Object[g-1][5];
int a=0;

String o=Reason.get(a);
//for loop that checks whether values are sources of net income or net loss by comparing the values and their corresponding reasons
//for loop also adds elements to the appropriate collumns
for(int i=0;i<g-1;i++){
o=Reason.get(a);
if(o.equals("Sales")){
  w.add(a);
}
else{
p.add(a);
}

dataa[i][0]=amount.get(a);
dataa[i][1]=Reason.get(a);
dataa[i][2]=tamount.get(a);
dataa[i][3]=taxed.get(a);
dataa[i][4]=date.get(a);
a+=1;

}
       

int m=Reason.size();

int ok=w.size();
double u;
double hey=0;
String q;
int pos;
//for loop that adds all values for revenue
for(int y=0;y<ok;y++){
  pos=w.get(y);
  q=taxed.get(pos);
  u=Double.parseDouble(q);
  hey+=u;
}

int or=p.size();
double hello;
double right=0;
String c;
int posi;
//for loop that adds values for costs or expenses
for(int yy=0;yy<or;yy++){
  posi=p.get(yy);
  c=taxed.get(posi);
  hello=Double.parseDouble(c);
  right+=hello;
}


        JTable table = new JTable(dataa, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
Scanner sc = new Scanner(System.in);
        double ans=0;
        ans=hey-right;

        String net="";
        if (ans>0){
          net="income:$";
        }
        else{
          net="loss:$";
        }
        ans=Math.round(ans * 100.0) / 100.0;
        ans=Math.abs(ans);
        JLabel lblHeading = new JLabel("Net "+net+ans);
        lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,24));

        frame.getContentPane().setLayout(new BorderLayout());

        frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
        frame.getContentPane().add(scrollPane,BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 200);
        frame.setVisible(true);
        
        
    }
    
}