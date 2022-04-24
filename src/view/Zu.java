package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Zu extends Frame implements ActionListener{
    static int i=0;
    static int m=1;
    JLabel  a1,a2;
    JTextField   text1;
    JButton  button1;
    JButton m1;
    JButton m2;
    JButton m3;
    JButton m4;
    JButton m5;Font f;
    JButton m6;
    JButton m7;
    JButton m8;
    public Zu(String s)
    {
        super(s);
        setLayout(null);
        f=new Font("黑体",Font.BOLD,30);
        m1= new JButton("按学号查询");
        m2=new JButton("按宿舍号查询");
        m3=new JButton("按学院统计");
        m4=new JButton("按宿舍号统计");
        m6=new JButton("添加学生");
        m7=new JButton("删除学生");
        m8=new JButton("修改学生信息");
        m5=new JButton("帮助");
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);
        m5.addActionListener(this);
        m6.addActionListener(this);
        m7.addActionListener(this);
        m8.addActionListener(this);
        m1.setBounds(10,30,120,25);
        m2.setBounds(140,30,140,25);
        m3.setBounds(290,30,120,25);
        m4.setBounds(420,30,150,25);
        m5.setBounds(420,60,150,25);
        m6.setBounds(10,60,120,25);
        m7.setBounds(140,60,140,25);
        m8.setBounds(290,60,120,25);
        add(m1);add(m2);add(m3);add(m4);add(m5);add(m6);add(m7);add(m8);
        a1=new  JLabel("宿舍管理系统",JLabel.CENTER);
        a2=new JLabel("输入口令：");
        a1.setBounds(180,100,350,40);
        a1.setBackground(Color.white);a1.setFont(f);
        a2.setBounds(180,200,90,25);
        a2.setBackground(Color.white);
        text1=new JTextField(18);
        text1.setBounds(280,200,200,25);
        button1=new  JButton("确认");
        button1.setBounds(300,250,70,30);
        button1.addActionListener(this);
        add(a1);add(a2);add(text1);add(button1);
        setBackground(Color.white);
        setBounds(200,200,650,500);
        setVisible(true);
        validate();
        addWindowListener(new WindowAdapter()
        {public  void  windowClosing(WindowEvent  e)
        {System.exit(0);}
        });
    }


    public void actionPerformed(ActionEvent e)
    {
        String  s=new String("123456");
        if(e.getSource()==button1)
        {
            while(i==0&&m<=3&&(!(text1.getText().equals(""))))
            {
                if(text1.getText().equals(s))
                {
                    JOptionPane.showMessageDialog(this,"口令正确，欢迎使用","成功登录对话框",JOptionPane.INFORMATION_MESSAGE);
                    i=1;
                }
                else{
                    m++;
                    JOptionPane.showMessageDialog(this, "您输入的密码不正确","警告对话框",JOptionPane.WARNING_MESSAGE);
                    text1.setText(null);
                }

            }

            if(m>=3)
            {
                JOptionPane.showMessageDialog(this,"您已被禁用","错误对话框",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(i==1)
        {
            if(e.getSource()==m1)
            {
                Show s1=new Show("按学号查询信息");
                s1.setVisible(true);
            }
            else if(e.getSource()==m2)
            {
                Form3 f1=new Form3();
                f1.setTitle("按宿舍号查询信息");
                f1.setVisible(true);
            }
            else if(e.getSource()==m3)
            {
                Form4  f2=new  Form4();
                f2.setTitle("按学院统计");
                f2.setVisible(true);
            }
            else if(e.getSource()==m4)
            {
                Form5   f5=new  Form5();
                f5.setTitle("按宿舍号统计");
                f5.setVisible(true);
            }
            else if(e.getSource()==m5)
            {
                Help h1=new  Help("帮助信息");
                h1.setVisible(true);
            }
            else if (e.getSource()==m6)
            {   Form6 f6=new Form6();
                f6.setTitle("添加学生信息");
                f6.setVisible(true);
            }
            else if (e.getSource()==m7)
            {   Form7 f7=new Form7();
                f7.setTitle("删除学生信息");
                f7.setVisible(true);
            }
            else if (e.getSource()==m8)
            {   Form12 f12=new Form12();
                f12.setTitle("修改学生信息");
                f12.setVisible(true);
            }
        }
    }
}
