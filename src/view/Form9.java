
package view;
import connector.JavaConnectSQLServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class Form9 extends  Frame  implements ActionListener{
    JLabel  b1,b2;Font  f;
    JTextField   t1;
    JButton   button1,button2;
    Form9(){setLayout(null);
        f=new  Font("黑体",Font.BOLD,20);
        b1=new JLabel("按宿舍号删除信息 ");
        b2=new JLabel("请输入宿舍号：");
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
        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {if(e.getSource()==button1) {
        Connection conn = JavaConnectSQLServer.getConnection();
        Statement stm = null;
        try {
            stm=conn.createStatement();
            String sql="delete from student_info where qnumber='"+t1.getText()+"'";
            int ok=stm.executeUpdate(sql);

            if(ok == 1){
                JOptionPane.showMessageDialog(this,"删除成功","删除成功",JOptionPane.INFORMATION_MESSAGE);
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
