package view;
import connector.JavaConnectSQLServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class Form12<Form13> extends  Frame  implements ActionListener {
    JLabel  b1,b2;Font  f;
    static JTextField   t1;
    JButton   button1,button2;
    public Form12(){setLayout(null);
        f=new  Font("黑体",Font.BOLD,20);
        b1=new JLabel("根据学号修改学生信息 ");
        b2=new JLabel("请输入学生学号：");
        t1=new JTextField(18);
        t1.setBounds(280,200,200,25);
        b1.setBounds(180,100,250,40);
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
        {public  void  windowClosing(WindowEvent  e)
        {setVisible(false);}
        });}


    @Override
    public void actionPerformed(ActionEvent e) {



        if(e.getSource()==button1){
            class Form13 extends JFrame implements ActionListener {JLabel b1,b2,b3,b4,b5,b6,b7,b8;
                static JTextField   t2;
                JTextField t3;
                JTextField t4;
                JTextField t5;
                JTextField t6;
                JTextField t7;
                JButton   button1,button2;
                Form13(){
                    setLayout(null);

                    b2=new JLabel("请输入姓名：");
                    b3=new JLabel("请输入性别：");
                    b4=new JLabel("请输入年龄：");
                    b5=new JLabel("请输入学院号：");
                    b6=new JLabel("请输入宿舍楼号：");
                    b7=new JLabel("请输入宿舍号:");
                    b2.setBounds(10,70,120,25);
                    b3.setBounds(10,100,120,25);
                    b4.setBounds(10,130,120,25);
                    b5.setBounds(10,160,120,25);
                    b6.setBounds(10,190,120,25);
                    b7.setBounds(10,220,120,25);
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
                    add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);
                    add(t2);add(t3);add(t4);add(t5);add(t6);add(t7);
                    add(button1);add(button2);
                    button1.addActionListener(this);
                    button2.addActionListener(this);
                    setBounds(100,100,600,500);
                    setBackground(Color.white);
                    validate();
                    addWindowListener(new WindowAdapter()
                    {public  void  windowClosing(WindowEvent  e)
                    {setVisible(false);}
                    });}
                public void actionPerformed(ActionEvent e){
                    if(e.getSource()==button1){
                        Connection conn = JavaConnectSQLServer.getConnection();
                        Statement stm = null;
                        if (Form13.t2.getText()!=null){
                            try {
                                stm=conn.createStatement();
                                String sql="update student_info set sname='"+t2.getText()+"'where snumber='"+Form12.t1.getText()+"'";
                                int ok=stm.executeUpdate(sql);

                            } catch (SQLException k) {
                                k.printStackTrace();
                            }
                        }
                        if (t3.getText()!=null){
                            try {
                                stm=conn.createStatement();
                                String sql="update student_info set ssex='"+t3.getText()+"'where snumber='"+Form12.t1.getText()+"'";
                                int ok=stm.executeUpdate(sql);

                            } catch (SQLException k) {
                                k.printStackTrace();
                            }
                        }
                        if (t4.getText()!=null){
                            try {
                                stm=conn.createStatement();
                                String sql="update student_info set sage ='"+t4.getText()+"'where snumber='"+Form12.t1.getText()+"'";
                                int ok=stm.executeUpdate(sql);

                            } catch (SQLException k) {
                                k.printStackTrace();
                            }
                        }
                        if (t5.getText()!=null){
                            try {
                                stm=conn.createStatement();
                                String sql="update student_info set scollege ='"+t5.getText()+"'where snumber='"+Form12.t1.getText()+"'";
                                int ok=stm.executeUpdate(sql);

                            } catch (SQLException k) {
                                k.printStackTrace();
                            }
                        }
                        if (t6.getText()!=null){
                            try {
                                stm=conn.createStatement();
                                String sql="update student_info set mlou='"+t6.getText()+"'where snumber='"+Form12.t1.getText()+"'";
                                int ok=stm.executeUpdate(sql);

                            } catch (SQLException k) {
                                k.printStackTrace();
                            }
                        }
                        if (t7.getText()!=null){
                            try {
                                stm=conn.createStatement();
                                String sql="update student_info set qnumber ='"+t7.getText()+"'where snumber='"+Form12.t1.getText()+"'";
                                int ok=stm.executeUpdate(sql);

                            } catch (SQLException k) {
                                k.printStackTrace();
                            }
                        }



                        JOptionPane.showMessageDialog(this,"修改成功","修改成功",JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);}
                    else  if(e.getSource()==button2)
                    {
                        setVisible(false);
                    }
                }}


            Form13 f13=new Form13();
            f13.setTitle("修改学生信息");
            f13.setVisible(true);}


        else  if(e.getSource()==button2)
        {
            setVisible(false);
        }
    }
}
