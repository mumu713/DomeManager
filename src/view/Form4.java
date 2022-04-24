package view;

import connector.JavaConnectSQLServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Form4 extends Frame implements ActionListener {
    JLabel b1,b2;Font  f;
    JTextField   t1;
    JButton   button1,button2;
    Form4()
    {
        setLayout(null);
        f=new  Font("黑体",Font.BOLD,20);
        b1=new JLabel("按学院统计 ");
        b2=new JLabel("请输入学院代号：");
        b1.setBounds(250,100,250,40);
        b1.setFont(f);
        b1.setBackground(Color.white);
        b2.setBounds(100,200,120,25);
        b2.setBackground(Color.white);
        t1=new  JTextField(15);
        t1.setBounds(250,200,200,25);
        button1=new JButton("确定");button2=new JButton("返回");
        button1.setBounds(200,350,70,25);button2.setBounds(360,350,70,25);
        setBounds(100,100,600,400);
        setBackground(Color.white);
        add(b1);add(b2);add(button1);add(button2);add(t1);
        button1.addActionListener(this);
        button2.addActionListener(this);
        validate();
        addWindowListener(new WindowAdapter()
        {public  void  windowClosing(WindowEvent e)
        {setVisible(false);}
        });
    }


    public  void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button1)
        {
            int x=0;
            t1.requestFocusInWindow();
            Connection conn=JavaConnectSQLServer.getConnection();
            Statement stm=null;
            try {
                stm = conn.createStatement();
                String sql="select * from STUDENT_INFO where scollege="+t1.getText();
                ResultSet rs=stm.executeQuery(sql);
                System.out.print("学号");System.out.print("    ");
                System.out.print("姓名");System.out.print("      ");
                System.out.print("性别");System.out.print("     ");
                System.out.print("年龄");System.out.print("  ");
                System.out.print("所属学院");System.out.print(" ");
                System.out.print("寝室楼号");System.out.print(" ");
                System.out.print("寝室号");System.out.print("    ");
                while(rs.next()){
                    x++;
                    System.out.println();
                    System.out.print(rs.getString("snumber"));System.out.print("     ");
                    System.out.print(rs.getString("sname"));
                    System.out.print(rs.getString("ssex"));
                    System.out.print(rs.getString("sage"));System.out.print("     ");
                    if(t1.getText()=="1")
                    {
                        System.out.print("博雅");
                        System.out.print("     ");}
                    else if(t1.getText()=="2")
                    {
                        System.out.print("化生");
                        System.out.print("     ");}
                    else {System.out.print("机械");System.out.print("     ");}
                    System.out.print(rs.getString("mlou"));System.out.print("       ");
                    System.out.print(rs.getString("qnumber"));
                }
                System.out.println();
                System.out.println("该学院有住宿生"+x+"名");
                System.out.println();System.out.println();
            } catch (SQLException k) {
                k.printStackTrace();
            }
        }

        else  if(e.getSource()==button2)
        {
            setVisible(false);
        }
    }
}
