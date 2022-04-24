package view;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Help extends Frame{
    MyPanel  panel1;
    String s=null;
    public  Help(String s)
    {
        super(s);
        panel1=new MyPanel();
        add(panel1);
        setLayout(new FlowLayout());
        setBounds(200,300,600,600);
        validate();
        addWindowListener(new WindowAdapter()
        {     public void windowClosing(WindowEvent  e)
        {
            setVisible(false);
        }
        });
    }
}
