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

public class Form5 extends  Frame  implements ActionListener{
    JLabel  b1,b2,b3;Font  f;
    JTextField   t1,t2;
    JButton   button1,button2;
    Form5()
    {
        setLayout(null);
        f=new  Font("黑体",Font.BOLD,20);
        b1=new JLabel("按宿舍号统计 ");
        b2=new JLabel("请输入宿舍楼号：");
        b3=new JLabel("请输入宿舍号：");
        b1.setBounds(180,100,250,40);
        b1.setFont(f);
        b1.setBackground(Color.white);
        b2.setBounds(100,200,120,25);
        b2.setBackground(Color.white);
        b3.setBounds(100,250,120,25);
        b3.setBackground(Color.white);
        t1=new  JTextField(15);
        t1.setBounds(250,200,200,25);
        t2=new  JTextField(15);
        t2.setBounds(250,250,200,25);
        button1=new JButton("确定");button2=new JButton("返回");
        button1.setBounds(200,350,70,25);
        button2.setBounds(360,350,70,25);
        setBounds(100,100,600,400);
        setBackground(Color.white);
        add(b1);add(b2);add(b3);add(t2);add(t1);add(button1);add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
        validate();
        addWindowListener(new WindowAdapter()
        {public  void  windowClosing(WindowEvent  e)
        {setVisible(false);}
        });
    }


    public  void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button1)
        {
            int y=0;
            t1.requestFocusInWindow();
            t2.requestFocusInWindow();
            Connection conn=JavaConnectSQLServer.getConnection();
            Statement stm=null;
            try {
                stm = conn.createStatement();
                String sql="select * from STUDENT_INFO where mlou= '"+t1.getText()+"'and qnumber="+t2.getText();
                ResultSet rs=stm.executeQuery(sql);
                System.out.print("学号");System.out.print("    ");
                System.out.print("姓名");System.out.print("      ");
                System.out.print("性别");System.out.print("     ");
                System.out.print("年龄");System.out.print("  ");
                System.out.print("所属学院");System.out.print(" ");
                System.out.print("寝室楼号");System.out.print(" ");
                System.out.print("寝室号");System.out.print("    ");
                while(rs.next()){
                    y++;
                    System.out.println();
                    System.out.print(rs.getString("snumber"));System.out.print("     ");
                    System.out.print(rs.getString("sname"));
                    System.out.print(rs.getString("ssex"));
                    System.out.print(rs.getString("sage"));System.out.print("     ");
                    System.out.print(rs.getString("scollege"));
                    System.out.print(rs.getString("mlou"));System.out.print("       ");
                    System.out.print(rs.getString("qnumber"));
                }
                System.out.println();
                System.out.print("该宿舍有"+y+"人");
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
