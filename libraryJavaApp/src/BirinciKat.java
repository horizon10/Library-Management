import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class BirinciKat {
        public BirinciKat(){
            //Ekran boyutunu ayarlama
            JFrame jFrame =new JFrame("Birinci Kat");
            jFrame.setSize(1920,1080);

            //Yazı tipi ayarlama
            Font f1=new Font("Arial",Font.BOLD,15);
            Font f2=new Font("Arial",Font.BOLD,40);

            //Renkleri ve ikon ayarları
            jFrame.getContentPane().setBackground(Color.darkGray);
            jFrame.setResizable(false);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //sol masalar
            ButonOlusturmaSol butonOlusturmaSol=new ButonOlusturmaSol();
            butonOlusturmaSol.butonYap(104,jFrame);

            //sag masalar
            ButonOlusturmaSag butonOlusturmaSag=new ButonOlusturmaSag();
            butonOlusturmaSag.butonYap(168,jFrame);

            //Combobox
            String[] items = {"1.KAT", "2.KAT", "3.KAT"};
            JComboBox<String> comboBox = new JComboBox<>(items);
            comboBox.setBounds(1800, 30, 100, 30);
            jFrame.getContentPane().add(comboBox);

            //giriş
            JLabel jLabel=new JLabel("GİRİŞ");
            jLabel.setBounds(950,940,500,100);
            Font f3=new Font("Arial",Font.BOLD,40);
            jLabel.setForeground(Color.red);
            jLabel.setFont(f3);
            jFrame.getContentPane().add(jLabel);

            //merdiveni gösteren ok
            JLabel jLabel1=new JLabel("1.KAT");
            jLabel1.setBounds(940,0,500,100);
            Font f4=new Font("Arial",Font.BOLD,40);
            jLabel1.setForeground(Color.red);
            jLabel1.setFont(f4);
            jFrame.getContentPane().add(jLabel1);

            //Yeni Kayıt
            JButton button=new JButton("Kayıt Ekle");
            button.setBounds(1800, 80, 100, 30);
            jFrame.getContentPane().add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    KayitEkrani kayitEkrani=new KayitEkrani();
                }
            });

            Timer timer=new Timer();
            JButton[] buttons = butonOlusturmaSag.getButtons();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    new log_tablosu(buttons);
                }
            },0,1000);
            jFrame.setLayout(null);
            jFrame.setVisible(true);
        }


}
