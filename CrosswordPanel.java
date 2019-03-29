/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ads_assignment;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class CrosswordPanel extends JPanel{
     JTextField textFields[][];

    public void setCrossword(char array[][])
    {
         
        int w = array.length;
        int h = array[0].length;
        setLayout(new GridLayout(w, h));
        textFields = new JTextField[w][h];
            
        for (int x=0; x<h; x++)
        {
            for (int y=0; y<w; y++)
            {
                char c = array[x][y];
                if (c != 0)
                {
                    textFields[x][y] = new JTextField(String.valueOf(c));
                    textFields[x][y].setFont(textFields[x][y].getFont().deriveFont(40.0f));
                    add(textFields[x][y]);
                }
                else
                {
                    add(new JLabel());
                }
            }
        }
        System.out.println("list "+CrossWord.list);    
        for(int i=0;i<CrossWord.list.size();i++){
            String s = CrossWord.list.get(i);
            String[] s1=s.split(" ");
            int x=Integer.parseInt(s1[0]);
            int y=Integer.parseInt(s1[1]);
            textFields[x][y].setForeground(Color.yellow);
        }
    }
}

