import javax.swing.*;
import java.awt.*;

public class LoginOut {
    JFrame jFrame=new JFrame();
    JButton exitButton=new JButton();
    JButton timeUpdateButton = new JButton();
    JLabel remainingTime = new JLabel();
    public LoginOut(int ifinal, int a){
        jFrame.setSize(300,500);
        jFrame.setLocationRelativeTo(null);
        SqlConnect sqlConnect=new SqlConnect();

        JLabel name = new JLabel("Ad:",4);
        name.setBounds(20,20,110,30);
        String queryName="select ad from masa m \n" +
                " inner join kullanici k on m.kullanici_id=k.kullanici_id\n "+
                " where m.masa_id= "+(ifinal+a+1);
        JLabel nameText = new JLabel(sqlConnect.executeSelect(queryName));
        nameText.setBounds(140,20,110,30);

        JLabel surname = new JLabel("Soyad:",4);
        surname.setBounds(20,50,110,30);
        String querySurName="select soyad from masa m\n" +
                "inner join kullanici k on m.kullanici_id=k.kullanici_id\n" +
                "where m.masa_id="+(ifinal+a+1);
        JLabel surnameText = new JLabel(sqlConnect.executeSelect(querySurName));
        surnameText.setBounds(140,50,110,30);


        JLabel telNo = new JLabel("Tel No:",4);
        telNo.setBounds(20,80,110,30);
        String queryTelNo="select tel_no from masa m " +
                "inner join kullanici k on m.kullanici_id=k.kullanici_id " +
                "where m.masa_id="+(ifinal+a+1);
        JLabel telNoText = new JLabel(sqlConnect.executeSelect(queryTelNo));
        telNoText.setBounds(140,80,110,30);


        JLabel studentNo = new JLabel("Öğrenci numarası:",4);
        studentNo.setBounds(20,110,110,30);
        String queryStudentNo="select okul_no from masa m\n" +
                "inner join kullanici k on m.kullanici_id=k.kullanici_id " +
                "where m.masa_id="+(ifinal+a+1);
        JLabel studentNoText = new JLabel(sqlConnect.executeSelect(queryStudentNo));
        studentNoText.setBounds(140,110,110,30);

        jFrame.getContentPane().add(name);
        jFrame.getContentPane().add(nameText);
        jFrame.getContentPane().add(surname);
        jFrame.getContentPane().add(surnameText);
        jFrame.getContentPane().add(telNo);
        jFrame.getContentPane().add(telNoText);
        jFrame.getContentPane().add(studentNo);
        jFrame.getContentPane().add(studentNoText);

        exitButton.setText("Çıkış Yap");
        exitButton.setBounds(80,200,100,20);

        remainingTime.setForeground(Color.RED);
        remainingTime.setBounds(80,220,120,20);

        timeUpdateButton.setText("Süre Uzat");
        timeUpdateButton.setBounds(80,250,100,20);

        jFrame.getContentPane().add(exitButton);
        jFrame.getContentPane().add(timeUpdateButton);
        jFrame.getContentPane().add(remainingTime);

        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
    public JButton getExitButton() {
        return exitButton;
    }
    public JButton getTimeUpdateButton(){return timeUpdateButton;}

}
