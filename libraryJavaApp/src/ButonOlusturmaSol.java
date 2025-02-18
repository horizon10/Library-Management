import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButonOlusturmaSol {
    private JButton[] buttons;
    public void butonYap(int value,JFrame jFrame){
            buttons=new JButton[value];
            int a = 0,x,y=10;
                for (int i = 0; i < 8; i++) {
                    buttons[i] = new JButton(String.valueOf(i+1));
                    new ButtonColor(buttons,jFrame,i,a);
                    buttons[i].setBounds(85,  y, 55, 55);
                    int finalI = i;
                    int finalA = a;
                    buttons[i+a].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            // Mevcut arka plan rengini sakla ve tekrar ayarla
                            buttons[finalI+finalA].setBackground(buttons[finalI+finalA].getBackground());
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            // Mevcut arka plan rengini sakla ve tekrar ayarla
                            buttons[finalI+finalA].setBackground(buttons[finalI+finalA].getBackground());
                        }
                    });
                    buttons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ButonDinleme butonDinleme=new ButonDinleme();
                            butonDinleme.masaKayitEkrani(finalI,finalA,buttons,jFrame);
                        }
                    });
                    jFrame.add(buttons[i]);
                    y+=65;
                    if ((i + 1) % 4 == 0) {
                        y += 515;
                    }
                }
            a = 0;x=46;y=10;
            for (int i = 8; i < 24; i++) {
                for (int j = 8; j < 14; j++) {
                    buttons[i + a] = new JButton(String.valueOf(i+a+1));
                    new ButtonColor(buttons,jFrame,i,a);
                    buttons[i + a].setBounds(110 + x, y, 55, 55);
                    int finalI = i;
                    int finalA = a;
                    buttons[i+a].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            // Mevcut arka plan rengini sakla ve tekrar ayarla
                            buttons[finalI+finalA].setBackground(buttons[finalI+finalA].getBackground());
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            // Mevcut arka plan rengini sakla ve tekrar ayarla
                            buttons[finalI+finalA].setBackground(buttons[finalI+finalA].getBackground());
                        }
                    });

                    buttons[i+a].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ButonDinleme butonDinleme=new ButonDinleme();
                            butonDinleme.masaKayitEkrani(finalI,finalA,buttons,jFrame);
                        }
                    });
                    jFrame.add(buttons[i + a]);
                    x += 60;
                    a++;
                    if ((j + 1) % 2 == 0) {
                        x += 10;
                    }
                }
                if ((i + 1) % 2 == 0) {
                    y += 10;
                }

                a -= 1;
                x = 46;
                y += 60;
            }
        }
    public JButton[] getButtons() {
        return buttons;
    }
}

