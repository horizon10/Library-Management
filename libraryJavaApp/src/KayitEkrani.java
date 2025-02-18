import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KayitEkrani {
    JFrame frame=new JFrame();
    JTextField nameText=new JTextField() ;
    JTextField surnameText=new JTextField();
    JTextField telNoText=new JTextField();
    JTextField studentNoText=new JTextField();
    JButton confirmButton=new JButton();
    public KayitEkrani() {
        frame.setSize(300,250);
        frame.setLocationRelativeTo(null);


        JLabel name = new JLabel("Ad:",4);
        name.setBounds(20,20,110,30);

        nameText.setBounds(140,25,100,20);

        JLabel surname = new JLabel("Soyad:",4);
        surname.setBounds(20,50,110,30);

        surnameText.setBounds(140,55,100,20);

        JLabel telNo = new JLabel("Tel No:",4);
        telNo.setBounds(20,80,110,30);

        telNoText.setBounds(140,85,100,20);

        JLabel studentNo = new JLabel("Öğrenci numarası:",4);
        studentNo.setBounds(20,110,110,30);

        studentNoText.setBounds(140,115,100,20);

        confirmButton.setText("Onayla");
        confirmButton.setBounds(140,150,100,20);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isConfirmed = CheckNums(studentNoText.getText());
                boolean isNull = CheckNull(nameText.getText(),surnameText.getText(),telNoText.getText(),studentNoText.getText());
                SqlConnect sqlConnect=new SqlConnect();
                String baskaKayitVarMi="select count(*) from kullanici\n" +
                        "where okul_no="+studentNoText.getText();
                if(isConfirmed==true && isNull==false && "0".equals(sqlConnect.executeSelect(baskaKayitVarMi))){
                    String query = "INSERT INTO kullanici (okul_no, ad, soyad, tel_no) VALUES ('" + studentNoText.getText() + "','" + nameText.getText() + "','" + surnameText.getText() + "','" + telNoText.getText() + "')";
                    sqlConnect.executeUpdate(query);
                    JOptionPane.showMessageDialog(frame,"Başarılı Giriş");
                    frame.dispose();
                } else if ("1".equals(sqlConnect.executeSelect(baskaKayitVarMi))) {
                    JOptionPane.showMessageDialog(frame,"Bu kullanıcı zaten mevcut");
                } else{
                    JOptionPane.showMessageDialog(frame,"Hatalı giriş");
                }

            }
        });
        frame.add(name);
        frame.add(nameText);
        frame.add(surname);
        frame.add(surnameText);
        frame.add(telNo);
        frame.add(telNoText);
        frame.add(studentNo);
        frame.add(studentNoText);
        frame.add(confirmButton);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    private static boolean CheckNums(String StudentNo){
        boolean b1 = StudentNo.length()==12 ? true : false;
        boolean b2 = StudentNo.matches("\\d+");
        return b1&&b2;
    }
    private static boolean CheckNull(String Ad,String Soyad,String TelNo,String StudentNo){
        return Ad.isBlank()||Soyad.isBlank()||TelNo.isBlank()||StudentNo.isBlank();
    }
}
