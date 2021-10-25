import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.*;

import static java.lang.Class.forName;

public class Splash {
    JFrame f;
    JLabel l1,l2,l3,l4;
    JProgressBar Pb;
    ImageIcon I;
    Splash(){
        f=new JFrame();
        f.setLayout(null);
        I=new ImageIcon("C:\\Users\\Rohit mittal\\IdeaProjects\\mobile shop\\src\\mmshop.jpg");
        l4 =new JLabel("",JLabel.CENTER);
        l4.setIcon(I);
        l4.setBounds(40,20,700,600);
        f.add(l4);

        l1=new JLabel("Loading");
        l1.setBounds(300,650,200,15);
        f.add(l1);

        l2=new JLabel("Mobileshop.com");
        l2.setBounds(20,630,200,20);
        f.add(l2);

        l3=new JLabel("Sri Ganganagar Branch");
        l3.setBounds(500,630,200,20);
        f.add(l3);

        Pb=new JProgressBar(1,100);
        Pb.setBounds(50,680,600,30);
        f.add(Pb);

        f.setBounds(100,50,800,760);
        f.setVisible(true);
        for (int i=1;i<=100;i=i+10){
            try {
                   Thread.sleep(1000);
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,"error occured ","emulation",0);

            }
            Pb.setValue(i);

        }
        f.setVisible(false);
        try {
            Login A=new Login();
        }
        catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"error occured ","emulation",0);
        }


    }

    public static void main(String[] args) {
        Splash B=new Splash();
    }
}
class Login implements ActionListener {
    JFrame f;
    JLabel l1,l2;
    JTextField t1,t2;
    JButton B1,B2;
    Connection con;
    Statement st;
    ResultSet Rs;
    {
        try {
            forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emulation","root","");
            st = con.createStatement();
        //    JOptionPane.showMessageDialog(null,"connected","emulation",0);
        }
        catch (SQLException se){
            JOptionPane.showMessageDialog(null,"connection failed rebbot system plz","emulation",0);
        }
    }
    Login() throws ClassNotFoundException {
        f=new JFrame();
        f.setLayout(null);
        Color c = new Color(150,120,100);
        f.setBackground(c);

        l1 = new JLabel("username");
        l1.setBackground(Color.white);
        l1.setForeground(Color.black);
        l1.setBounds(150,250,100,20);
        f.add(l1);

        l2=new JLabel("password");
        l2.setBackground(Color.white);
        l2.setForeground(Color.black);
        l2.setBounds(150,310,100,20);
        f.add(l2);

        t1=new JTextField("");
        t1.setBounds(300,250,150,20);
        f.add(t1);

        t2=new JTextField("");
        t2.setBounds(300,310,150,20);
        f.add(t2);

        B1=new JButton("Submit");
        B1.setBounds(390,500,80,20);
        f.add(B1);

        B2=new JButton("Cancel");
        B2.setBounds(500,500,80,20);
        f.add(B2);

        B1.addActionListener(this);
        B2.addActionListener(this);

        f.setBounds(100,50,650,600);
        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        Object ob=ae.getSource();
        if(ob==B2){
           int yy= JOptionPane.showConfirmDialog(null,"do you want to exit","emulation",0);
            if (yy==0){
                System.exit(0);
            }
        }
        if(ob==B1){
           try {
               String s1,s2;
               s1=t1.getText();
               s2=t2.getText();
               Rs= st.executeQuery("select * from users where username ='"+s1+"'");
               boolean chk=false;
               while(Rs.next()){
                  if(Rs.getString("password").equals(s2)){
                      chk=true;
                      f.setVisible(false);
                      JOptionPane.showMessageDialog(null,"login with sucess","emulation",2);
                      Mobile B =new Mobile();

                  }
               }
               if (chk==false)
               {
                   JOptionPane.showMessageDialog(null,"user not found check username and password","emulation",0);
               }
               t1.setText("");
               t2.setText("");

           }
           catch (Exception e){
               JOptionPane.showMessageDialog(null,"network error occured","emulation",0);


           }
        }
    }
}
class Mobile implements ActionListener{
    JFrame f;
    JMenuBar mb;
    JMenu mn,me,mv,ml,mex;
    JMenuItem mnb,mnc,memm,memc,medc,mvmd,mvcd,mvsm,mvsmn,mlcp,mll,mexc;
    JLabel l1,l2,l3;
    ImageIcon Img1,Img2;
    JInternalFrame jf1;
    JDesktopPane dp;

    Mobile(){
        f = new JFrame("Mobile");
        f.setLayout(null);
        mb = new JMenuBar();
        f.setJMenuBar(mb);
        mb.setBounds(1,1,900,15);
        mn = new JMenu("New");
        //mf.setMnemonic(char('F'));
        mb.add(mn);
        mnb = new JMenuItem("Mobile");
        mn.add(mnb);
        mnc = new JMenuItem("Customer");
        mn.add(mnc);

        me = new JMenu("Edit");
        mb.add(me);
        memm=new JMenuItem("Modify Mobile");
        me.add(memm);
        memc=new JMenuItem("Modify Mobile");
        me.add(memc);
        medc=new JMenuItem("Modify Mobile");
        me.add(medc);

        mv = new JMenu("View");
        //mv.setMnemonic(KeyEvent.VK_V);
        mb.add(mv);
        mvmd=new JMenuItem("Mobile Customer Details");
        mv.add(mvmd);
//        mvcd=new JMenuItem("Customer Details");
//        mv.add(mvcd);
        mvsm=new JMenuItem("Sales by Month");
        mv.add(mvsm);
        mvsmn=new JMenuItem("Sales by Model no.");
        mv.add(mvsmn);

        ml = new JMenu("Login");
        //mv.setMnemonic(KeyEvent.VK_V);
        mb.add(ml);
        mlcp=new JMenuItem("Change Password");
        ml.add(mlcp);
        mll=new JMenuItem("Logout");
        ml.add(mll);

        Img1=new ImageIcon("C:\\Users\\Rohit mittal\\IdeaProjects\\mobile shop\\src\\left.jpg");
        l1 =new JLabel("", JLabel.LEFT);
        l1.setIcon(Img1);
        l1.setBounds(10,10,200,600);
        f.add(l1);

        Img2=new ImageIcon("C:\\Users\\Rohit mittal\\IdeaProjects\\mobile shop\\src\\left.jpg");
        l2 =new JLabel("",JLabel.RIGHT);
        l2.setIcon(Img2);
        l2.setBounds(630,10,250,600);
        f.add(l2);

        l3 =new JLabel("",JLabel.CENTER);
        l3.setIcon(Img2);
        l3.setBounds(220,10,400,600);

        dp=new JDesktopPane();
        dp.setBounds(220,10,400,600);
        f.add(dp);

        mnb.addActionListener(this);
        mnc.addActionListener(this);
        mlcp.addActionListener(this);
        mvmd.addActionListener(this);
        //jf1=new JInternalFrame();
        f.setSize(900,700);
        f.setVisible(true);
    }

        public void actionPerformed(ActionEvent e) {
        Object ob=e.getSource();
        if(ob==mnb){
            jf1=new JInternalFrame("Mobile",true,true,true,true);
            try{
                MyPanel p=new MyPanel();
                p.setBounds(212,12,390,500);
                p.setVisible(true);
                jf1.add(p);
            }
            catch(Exception ex){
                  JOptionPane.showMessageDialog(null,ex,"emulation",0);
            }

            jf1.setVisible(true);
            dp.setLayout(null);
            dp.setBackground(Color.blue);
            dp.setVisible(true);
            jf1.setBounds(2,12,390,500);
            dp.add(jf1);

        }
        if(ob==mnc){
            jf1=new JInternalFrame("Customer",true,true,true,true);
            try{
                MyPanel2 p=new MyPanel2();
                p.setBounds(212,12,390,500);
                p.setVisible(true);
                jf1.add(p);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex,"emulation",0);
            }

            jf1.setVisible(true);
            dp.setLayout(null);
            dp.setBackground(Color.BLUE);
            dp.setVisible(true);
            jf1.setBounds(2,12,390,500);
            dp.add(jf1);

        }
        if(ob==mlcp){
            jf1=new JInternalFrame("password settings",true,true,true,true);
            try{
                Pass p1=new Pass();
                p1.setBounds(212,12,390,500);
                p1.setVisible(true);
                jf1.add(p1);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex,"emulation",0);
            }

            jf1.setVisible(true);
            dp.setLayout(null);
            dp.setBackground(Color.BLUE);
            dp.setVisible(true);
            jf1.setBounds(2,12,390,500);
            dp.add(jf1);
        }
       if (ob==mvmd){
           jf1=new JInternalFrame("Details",true,true,true,true);
           try{
               Details p1=new Details();
               p1.setBounds(212,12,390,500);
               p1.setVisible(true);
               jf1.add(p1);
           }
           catch(Exception ex){
               JOptionPane.showMessageDialog(null,ex,"emulation",0);
           }

           jf1.setVisible(true);
           dp.setLayout(null);
           dp.setBackground(Color.BLUE);
           dp.setVisible(true);
           jf1.setBounds(2,12,390,500);
           dp.add(jf1);
       }
    }
}
class MyPanel extends JPanel implements ActionListener, ItemListener
{
    JButton b1,b2;
    JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5;
    Choice c1;
    int s1,s2,s4;
    String s3,s5,s6,s7;
    Connection con;
    Statement st;
    ResultSet Rs;
    {
        try {
            forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emulation","root","");
            st = con.createStatement();
            //    JOptionPane.showMessageDialog(null,"connected","emulation",0);
        }
        catch (Exception se){
            JOptionPane.showMessageDialog(null,"connection failed reboot system plz","emulation",0);
        }
    }
    MyPanel(){
           setLayout(null);
//        f=new JFrame();
//        f.setLayout(null);
        l1=new JLabel("Mobile Id.");
        l1.setBounds(30,30,100,20);
        add(l1);
        t1=new JTextField("");
        t1.setBounds(135,30,100,20);
        add(t1);

        l2=new JLabel("Mobile No.");
        l2.setBounds(30,60,100,20);
        add(l2);
        t2=new JTextField("");
        t2.setBounds(135,60,100,20);
        add(t2);

        l3=new JLabel("IMEI No.");
        l3.setBounds(30,90,100,20);
        add(l3);
        t3=new JTextField("");
        t3.setBounds(135,90,100,20);
        add(t3);

        l4=new JLabel("Amount");
        l4.setBounds(30,120,100,20);
        add(l4);
        t4=new JTextField("");
        t4.setBounds(135,120,100,20);
        add(t4);

        l5=new JLabel("Company Name");
        l5.setBounds(30,150,100,20);
        add(l5);

        c1=new Choice();
        c1.add("Samsung");
        c1.add("Nokia");
        c1.add("Motorola");
        c1.add("redmi/mi/xaomi");
        c1.add("realme");
        c1.add("one plus");
        c1.add("google");
        c1.add("lenovo");
        c1.setBounds(135,150,100,20);
        add(c1);

        l6=new JLabel("Color");
        l6.setBounds(30,180,100,20);
        add(l6);
        t5=new JTextField("");
        t5.setBounds(140,180,100,20);
        add(t5);

        l7=new JLabel("Features");
        l7.setBounds(30,210,100,20);
        add(l7);

        cb1=new JCheckBox("5G");
        cb1.setBounds(140,210,50,20);
        add(cb1);
        cb2=new JCheckBox("4G");
        cb2.setBounds(200,210,50,20);
        add(cb2);
        cb3=new JCheckBox("DUO SIM");
        cb3.setBounds(260,210,90,20);
        add(cb3);
        cb4=new JCheckBox("Finger Print sensor");
        cb4.setBounds(140,240,170,20);
        add(cb4);
        cb5=new JCheckBox("AI Dual Camera");
        cb5.setBounds(140,270,130,20);
        add(cb5);
        cb6=new JCheckBox("Face Reco.");
        cb6.setBounds(140,300,90,20);
        add(cb6);
        cb7=new JCheckBox("Amoled Disp");
        cb7.setBounds(240,300,130,20);
        add(cb7);

        b1=new JButton("Submit");
        b1.setBounds(100,340,80,20);
        add(b1);
        b1.addActionListener(this);

        b2=new JButton("Cancel");
        b2.setBounds(190,340,80,20);
        add(b2);
        b2.addActionListener(this);
//        f.setBounds(212,12,390,590);

    }
    public void actionPerformed(ActionEvent ae){
         Object ob=ae.getSource();
         if(ob==b1){
             try {
                 s1= Integer.parseInt(t1.getText());
                 s2= Integer.parseInt(t2.getText());
                 s3= t3.getText();
                 s4= Integer.parseInt(t4.getText());
                 s6=t5.getText();
                 st.execute("insert into mobile (mid,mno,mimei,mamo,mcomp,mcol,mfea) values ("+s1+","+s2+",'"+s3+"',"+s4+",'"+s5+"','"+s6+"','"+s7+"')");
                 JOptionPane.showMessageDialog(null,"record saved","emulation",2);
                 setVisible(false);
                 }
             catch (Exception e1){
                 JOptionPane.showMessageDialog(null,e1,"emulation",0);
             }
         }
         if (ob==b2){
             //JOptionPane.showMessageDialog(null,"sure wanna exit","emulation",0);
             int yy=JOptionPane.showConfirmDialog(null,"sure wanna exit","emulation",0);
                if(yy==0){
                    System.exit(0);

                }

         }
    }

    public void itemStateChanged(ItemEvent e) {
     Object ob=e.getSource();
     if(ob==c1){

         s5=c1.getSelectedItem();

     }
     if(ob==cb1){

         s7="5g";
     }
     if(ob==cb2){
         s7=s7+" "+"4g";
     }
     if(ob==cb3){
         s7=s7+" "+"Duo Sim";
     }
     if(ob==cb4){
         s7=s7+" "+"Finger Print sensor";
     }
     if(ob==cb5){
         s7=s7+" "+"AI Dual Camera";
     }
     if(ob==cb6){
         s7=s7+" "+"Face Reco.";
     }
     if(ob==cb7){
         s7=s7+" "+"Amoled Disp";
     }
    }
}
class MyPanel2 extends JPanel implements ActionListener, ItemListener
{
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    Choice c1;

    String s1,s2,s4,s3,s5,s6,s7,s8;
    Connection con;
    Statement st;
    ResultSet Rs;
    {
        try {
            forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emulation","root","");
            st = con.createStatement();
            //    JOptionPane.showMessageDialog(null,"connected","emulation",0);
        }
        catch (Exception se){
            JOptionPane.showMessageDialog(null,"connection failed reboot system plz","emulation",0);
        }
    }
    MyPanel2(){
        setLayout(null);
//        f=new JFrame();
//        f.setLayout(null);
        l1=new JLabel("Name");
        l1.setBounds(30,30,100,20);
        add(l1);
        t1=new JTextField("");
        t1.setBounds(135,30,100,20);
        add(t1);

        l2=new JLabel("Email-Id");
        l2.setBounds(30,60,100,20);
        add(l2);
        t2=new JTextField("");
        t2.setBounds(135,60,100,20);
        add(t2);

        l3=new JLabel("Address");
        l3.setBounds(30,90,100,20);
        add(l3);
        t3=new JTextField("");
        t3.setBounds(135,90,100,20);
        add(t3);

        l4=new JLabel("Contact No.");
        l4.setBounds(30,120,100,20);
        add(l4);
        t4=new JTextField("");
        t4.setBounds(135,120,100,20);
        add(t4);

        l5=new JLabel("Gender");
        l5.setBounds(30,150,100,20);
        add(l5);

        c1=new Choice();
        c1.add("Male");
        c1.add("Female");
        c1.add("Others");
        c1.setBounds(135,150,100,20);
        add(c1);

        l6=new JLabel("Purchase Model");
        l6.setBounds(30,180,100,20);
        add(l6);
        t5=new JTextField("");
        t5.setBounds(140,180,100,20);
        add(t5);

        l7=new JLabel("Purchase Date");
        l7.setBounds(30,210,100,20);
        add(l7);
        t6=new JTextField("");
        t6.setBounds(140,210,50,20);
        add(t6);

        l8=new JLabel("Amount");
        l8.setBounds(30,240,100,20);
        add(l8);
        t7=new JTextField("");
        t7.setBounds(140,270,50,20);
        add(t7);

        b1=new JButton("Submit");
        b1.setBounds(100,340,80,20);
        add(b1);
        b1.addActionListener(this);

        b2=new JButton("Cancel");
        b2.setBounds(190,340,80,20);
        add(b2);
        b2.addActionListener(this);
//        f.setBounds(212,12,390,590);

    }
    public void actionPerformed(ActionEvent ae){
        Object ob=ae.getSource();
        if(ob==b1){
            try {
                s1= t1.getText();
                s2= t2.getText();
                s3= t3.getText();
                s4= t4.getText();
                s6= t5.getText();
                s7= t6.getText();
                s8= t7.getText();
                st.execute("insert into customer (cname,cemail,cadd,ccon,cgen,cpurm,cpurd,cpura) values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')");
                JOptionPane.showMessageDialog(null,"record saved","emulation",2);
                setVisible(false);
            }
            catch (Exception e1){
                JOptionPane.showMessageDialog(null,e1,"emulation",0);
            }
        }
        if (ob==b2){

            int yy=JOptionPane.showConfirmDialog(null,"sure wanna exit","emulation",0);
            if(yy==0){
                System.exit(0);

            }

        }
    }

    public void itemStateChanged(ItemEvent e) {
        Object ob=e.getSource();
        if(ob==c1){
            s5=c1.getSelectedItem();
        }
    }
}
class Pass extends JPanel implements ActionListener{

    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JButton B1,B2;
    Connection con;
    Statement st;
    ResultSet Rs;
    {
        try {
            forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emulation","root","");
            st = con.createStatement();
            //    JOptionPane.showMessageDialog(null,"connected","emulation",0);
        }
        catch (SQLException | ClassNotFoundException se){
            JOptionPane.showMessageDialog(null,"connection failed rebbot system plz","emulation",0);
        }
    }
    Pass(){
        setLayout(null);

        l1 = new JLabel("username");
        l1.setBackground(Color.white);
        l1.setForeground(Color.black);
        l1.setBounds(80,170,100,20);
        add(l1);

        l2=new JLabel("old password");
        l2.setBackground(Color.white);
        l2.setForeground(Color.black);
        l2.setBounds(80,240,100,20);
        add(l2);

        l3=new JLabel("new password");
        l3.setBackground(Color.white);
        l3.setForeground(Color.black);
        l3.setBounds(80,300,100,20);
        add(l3);

        t1=new JTextField("");
        t1.setBounds(200,170,150,20);
        add(t1);

        t2=new JTextField("");
        t2.setBounds(200,240,150,20);
        add(t2);

        t3=new JTextField("");
        t3.setBounds(200,300,150,20);
        add(t3);

        B1=new JButton("Update");
        B1.setBounds(150,370,80,20);
        add(B1);

        B2=new JButton("Cancel");
        B2.setBounds(260,370,80,20);
        add(B2);

        B1.addActionListener(this);
        B2.addActionListener(this);



    }
    public void actionPerformed(ActionEvent ae){
        Object ob=ae.getSource();
        if(ob==B2){
            int yy= JOptionPane.showConfirmDialog(null,"do you want to exit","emulation",0);
            if (yy==0){
                System.exit(0);
            }
        }
        if(ob==B1){
            try {
                String s1,s2,s3;
                s1=t1.getText();
                s2=t2.getText();
                s3=t3.getText();
                Rs= st.executeQuery("select * from users where username ='"+s1+"'");
                boolean chk=false;
                while(Rs.next()){
                    if(Rs.getString("password").equals(s2)){
                        chk=true;
                        int yy=JOptionPane.showConfirmDialog(null,"wanna change password","emulation",1);
                        if(yy==0){
                            System.out.print("yogi ji");
                            st.executeUpdate("update users set password ='"+s3+"',where username='"+s1+"'and password='"+s2+"'");
                        }
                        break;
                    }
                }
                if (chk==false)
                {
                    JOptionPane.showMessageDialog(null,"user not found check username and password","emulation",0);
                }
                t1.setText("");
                t2.setText("");
                t3.setText("");

            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,"network error occured","emulation",0);

            }
        }
    }
}
class Details extends JPanel{
    JTable tb1;
    JScrollPane sp;
    Connection con;
    Statement st;
    ResultSet Rs;
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emulation", "root", "");
            st = con.createStatement();
            //    JOptionPane.showMessageDialog(null,"connected","emulation",0);
        }
        catch (Exception se)
        {
            JOptionPane.showMessageDialog(null, "connection failed rebbot system plz", "emulation", 0);
        }
    }
    Details(){
        try{
            String d[][]=new String[20][7];
            String h[]={"Mobile Id","Mobile Number","IMEI no.","Amount","Company","Colour","Features"};
            int R=0;
            Rs=st.executeQuery("select * from mobile where mid="+65434+"");
            while(Rs.next()){
                d[R][0]=Rs.getString("mid");
                d[R][1]=Rs.getString("mno");
                d[R][2]=Rs.getString("mimei");
                d[R][3]=Rs.getString("mamo");
                d[R][4]=Rs.getString("mcomp");
                d[R][5]=Rs.getString("mcol");
                d[R][6]=Rs.getString("mfea");
                R++;
            }
            tb1=new JTable(d,h);
            sp=new JScrollPane(tb1);
            sp.setBounds(70,70,300,250);
            add(sp);

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e,"emulation",0);
        }
    }
}