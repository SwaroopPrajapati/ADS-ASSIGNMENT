package ads_assignment;

import java.util.ArrayList;
import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class CrossWord {

    static int count;
    ArrayList<String> Dictionary = new ArrayList<>();
    static ArrayList<String> list;
    char words[][];
    int row, col, listCounter;
    String input = "word";
    int flag = 0;

    public void init(char[][] word, String input) {
        list = new ArrayList<>();
        this.words = word;
        col = row = word.length;
        this.input = input;
        count = input.length() - 2;
        if (!input.equals("")) {
            findElement(row - 1, col - 1, input.length() - 1);
        }
    }

    void findElement(int rowEle, int colEle, int inputLength) {

        int p = 0, q = 0;
        for (int i = rowEle; i >= 0; i--) {
            for (int j = colEle; j >= 0; j--) {
                if (words[i][j] == input.charAt(inputLength)) {
                    p = i;
                    q = j;
                    inputLength--;
                    list.add(p + " " + q + " " + words[i][j]);
                    listCounter = 0;
                    flag = 1;
                    break;
                }
            }
            colEle = 5;
            if (flag == 1) {
                flag = 0;
                break;
            }
        }
        int isFound = 0;

        if (p > 0 && words[p - 1][q] == input.charAt(inputLength)) {
            isFound = findUp(p - 1, q, inputLength);
        }
        if (q > 0 && words[p][q - 1] == input.charAt(inputLength)) {
            findSide(p, q - 1, inputLength);
        } else if (isFound != -1 && words[p][q] == input.charAt(input.length() - 1)) {
            list.remove(p + " " + q + " " + words[p][q]);
        } else if (p == 0 && q == 0) {
            return;
        } else {
            inputLength = input.length() - 1;
            if (q > 0) {
                findElement(p, q - 1, inputLength);
            } else {
                q = 5;
                findElement(p - 1, q, inputLength);
            }
        }
        if (p > 0) {
            inputLength = input.length() - 1;
            if (q > 0) {
                findElement(p, q - 1, inputLength);
            } else {
                q = 5;
                findElement(p - 1, q, inputLength);
            }
        }
    }

    int findUp(int p, int q, int inputLength) {

        if (inputLength == -1) {
            System.out.println("found");
            return count;
        } else if (words[p][q] == input.charAt(inputLength)) {
            list.add(p + " " + q + " " + words[p][q]);
            listCounter++;
            inputLength--;
            count--;
            findUp(p - 1, q, inputLength);
        } else {
            count = input.length() - 2;
            list.remove(listCounter);
            listCounter--;
        }
        return count;
    }

    void findSide(int p, int q, int inputLength) {

        if (inputLength == -1) {
            System.out.println("found");
        } else if (words[p][q] == input.charAt(inputLength)) {
            list.add(p + " " + q + " " + words[p][q]);
            inputLength--;
            listCounter++;
            findSide(p, q - 1, inputLength);
        } else {
            list.remove(listCounter);
            listCounter--;
        }
        return ;
    }

}

public class Assignment {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char word[][] =    {{'x', 'w', 'd', 'w', 'q', 'p', 's'},
                            {'p', 'o', 'a', 'o', 'd', 'a', 'o'},
                            {'l', 'w', 'o', 'r', 'd', 'c', 'a'},
                            {'c', 's', 'e', 'd', 'c', 'e', 'k'},
                            {'b', 'r', 'r', 'o', 's', 'g', 'm'},
                            {'y', 'z', 'd', 'n', 'e', 'o', 'd'},
                            {'a', 'w', 'r', 's', 'b', 'h', 't'}};
        System.out.println("Enter input here...");
        String input = sc.next();
        CrossWord c = new CrossWord();
        c.init(word, input);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.getContentPane().setLayout(new BorderLayout());

        JPanel container = new JPanel(new FlowLayout());
        CrosswordPanel panel = new CrosswordPanel();
        panel.setCrossword(word);
        container.add(panel);
        f.getContentPane().add(container, BorderLayout.CENTER);
        f.setSize(800, 800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
