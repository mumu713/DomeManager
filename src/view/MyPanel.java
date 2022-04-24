package view;
import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{
    TextArea   text;
    MyPanel()
    {
        String s="在主窗口输入口令，正确时激活子菜单，在子菜单中输入学号或者宿舍号会得到相应的信息;"+"\n"  + "博雅学院代号为1，机械学院代号为2，化生学院代号为3";
        text=new TextArea(40,80);
        add(text);
        text.setBackground(Color.white);
        text.setText(s);
        text.setEditable(false);

    }
}
