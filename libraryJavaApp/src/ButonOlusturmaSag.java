import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButonOlusturmaSag {


    private JButton[] buttons;
    public void butonYap(int value,JFrame jFrame) {
        ButonOlusturmaSol sol=new ButonOlusturmaSol();

        sol.butonYap(value,jFrame);
        buttons=sol.getButtons();

        int a = 0,x=51,y=10;
        for (int i = 104; i <114; i++) {
            if(i<110) {
                for (int j = 104; j < 112; j++) {
                    buttons[i + a] = new JButton(String.valueOf(i+a+1));
                    new ButtonColor(buttons,jFrame,i,a);
                    buttons[i + a].setBounds(1205 + x, y, 55, 55);
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
                x = 51;
                y += 60;
            }
            else if(i>=110) {
                for (int j = 104; j < 108; j++) {
                    buttons[i + a] = new JButton(String.valueOf(i+a+1));
                    new ButtonColor(buttons,jFrame,i,a);
                    buttons[i + a].setBounds(1465 + x, y, 55, 55);
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
                x = 51;
                y += 60;

            }
        }

    }
    public JButton[] getButtons() {
        return buttons;
    }
}