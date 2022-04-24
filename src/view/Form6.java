package view;
import connector.JavaConnectSQLServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class Form6 extends  Frame  implements ActionListener{
    JLabel  b1,b2,b3,b4,b5,b6,b7,b8;
    JTextField   t1,t2,t3,t4,t5,t6,t7;
    JButton   button1,button2;
    public Form6()
    {
        setLayout(null);
        b1=new JLabel("请输入学号： ");
        b2=new JLabel("请输入姓名：");
        b3=new JLabel("请输入性别：");
        b4=new JLabel("请输入年龄：");
        b5=new JLabel("请输入学院号：");
        b6=new JLabel("请输入宿舍楼号：");
        b7=new JLabel("请输入宿舍号:");
        b1.setBounds(10,40,120,25);
        b2.setBounds(10,70,120,25);
        b3.setBounds(10,100,120,25);
        b4.setBounds(10,130,120,25);
        b5.setBounds(10,160,120,25);
        b6.setBounds(10,190,120,25);
        b7.setBounds(10,220,120,25);
        t1=new  JTextField(15);
        t2=new  JTextField(15);
        t3=new  JTextField(15);
        t4=new  JTextField(15);
        t5=new  JTextField(15);
        t6=new  JTextField(15);
        t7=new  JTextField(15);
        t1.setBounds(200,40,200,25);
        t2.setBounds(200,70,200,25);
        t3.setBounds(200,100,200,25);
        t4.setBounds(200,130,200,25);
        t5.setBounds(200,160,200,25);
        t6.setBounds(200,190,200,25);
        t7.setBounds(200,220,200,25);
        button1=new JButton("确定");button2=new JButton("返回");
        button1.setBounds(200,350,70,25);
        button2.setBounds(360,350,70,25);
        add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);
        add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);add(t7);
        add(button1);add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
        setBounds(100,100,600,400);
        setBackground(Color.white);
        validate();
        addWindowListener(new WindowAdapter()
        {public  void  windowClosing(WindowEvent  e)
        {setVisible(false);}
        });}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1) {
            Connection conn = JavaConnectSQLServer.getConnection();
            Statement stm = null;
            try {
                stm=conn.createStatement();
                String sql="insert into student_info values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"
                        +t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"')";
                int ok=stm.executeUpdate(sql);

                if(ok == 1){
                    JOptionPane.showMessageDialog(this,"添加成功","添加成功",JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);}
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
