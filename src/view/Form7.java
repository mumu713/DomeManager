package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Form7 extends  Frame  implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,button1;
    public Form7() {setLayout(null);
        b1 = new JButton("按学号删除");
        b2 = new JButton("按宿舍删除");
        b3 = new JButton("按楼号删除");
        b4 = new JButton("按系删除");
        b1.setBounds(10, 40, 120, 25);
        b2.setBounds(10, 70, 120, 25);
        b3.setBounds(10, 100, 120, 25);
        b4.setBounds(10, 130, 120, 25);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b1.setBounds(200,60,200,40);
        b2.setBounds(200,120,200,40);
        b3.setBounds(200,180,200,40);
        b4.setBounds(200,240,200,40);
        setBounds(100,100,600,400);
        button1=new JButton("返回");
        button1.setBounds(260,350,70,25);
        add(button1);
        button1.addActionListener(this);
        setBackground(Color.white);
        validate();
        addWindowListener(new WindowAdapter()
        {public  void  windowClosing(WindowEvent  e)
        {setVisible(false);}
        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            Form8  f8=new  Form8();
            f8.setTitle("按学号删除信息");
            f8.setVisible(true);
        }
        else if(e.getSource()==b2)
        {
            Form9 f9=new  Form9();
            f9.setTitle("按宿舍号删除信息");
            f9.setVisible(true);
        }
        else if(e.getSource()==b3)
        {
            Form10  f10=new  Form10();
            f10.setTitle("宿舍楼号删除信息");
            f10.setVisible(true);
        }
        else if(e.getSource()==b4)
        {
            Form11   f11=new  Form11();
            f11.setTitle("按学院删除信息");
            f11.setVisible(true);
        }
        else  if(e.getSource()==button1)
        {
            setVisible(false);
        }
    }
}
