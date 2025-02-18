import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.sql.Time;

public class ButonDinleme {

    public void masaKayitEkrani(int ifinal, int a, JButton[] buttons,JFrame jFrame){


        SqlConnect sqlConnect=new SqlConnect();
        String query = "select durum_no from masa where masa_id = " + (ifinal + a + 1);
        String result=sqlConnect.executeSelect(query);
        if("1".equals(result)){
            UserLogin userLogin=new UserLogin();
            userLogin.UserLoginEkrani();
            userLogin.getFrame().setTitle("MASA-"+(ifinal+ a +1));
                    userLogin.getConfirmButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //başka masaya oturmuş mu kontrol etme
                    String querySame = "select m.kullanici_id from masa m " +
                            "inner join kullanici k on m.kullanici_id = k.kullanici_id " +
                            "where k.okul_no = " + userLogin.getStudentNoText().getText();

                    //okul numarası database de var mı
                    String query2 = "select count(*) from kullanici where okul_no = " + userLogin.getStudentNoText().getText();
                    String result2=sqlConnect.executeSelect(query2);
                    if("1".equals(result2) && sqlConnect.executeSelect(querySame)==null) {
                        //masa kullanici_id güncelleme
                        String relationQuery1="select kullanici_id from kullanici where okul_no="+userLogin.getStudentNoText().getText();
                        String resultRelation1  =sqlConnect.executeSelect(relationQuery1);
                        String relationQuery2 = "update masa set kullanici_id = " + Integer.parseInt(resultRelation1) +
                                " where masa_id = " + (ifinal + a + 1);
                        sqlConnect.executeUpdate(relationQuery2);

                        //masa durum no güncelleme
                        String updateQuery = "update masa set durum_no = 2 where masa_id = " + (ifinal + a + 1);
                        sqlConnect.executeUpdate(updateQuery);

                        //masa saat güncelleme
                        LocalTime time = LocalTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        Time sqlTime = Time.valueOf(time.format(formatter).toString());
                        String updateQuery1 = "update masa set oturum_saati = '" + time.format(formatter) +
                                "' where masa_id = " + (ifinal + a + 1);
                        sqlConnect.executeUpdate(updateQuery1);

                        //masa renk belirleme
                        ButtonColor buttonColor=new ButtonColor(buttons,jFrame,ifinal,a);
                        //buttons[ifinal + a].setBackground(Color.red);
                        userLogin.frame.dispose();

                    }
                    //kullanıcı yanlış girerse kontrol
                    else if (sqlConnect.executeSelect(querySame)!=null) {
                        JOptionPane.showMessageDialog(jFrame,"Başka masada kaydı bulunuyor");

                    } else{
                        if (userLogin.CheckStudentNo(userLogin.studentNoText.getText()))
                        {
                            JOptionPane.showMessageDialog(jFrame,"Kayıt Bulunamadı");
                        }
                        else {
                            JOptionPane.showMessageDialog(jFrame,"Hatalı Giriş");
                        }
                    }

                }
            });

        }
        else if("2".equals(result)){
            String query1= "select oturum_saati from masa where masa_id="+(ifinal+a+1);
            String result1=sqlConnect.executeSelect(query1);
            LocalTime oturum_saati = LocalTime.parse(result1);
            Duration remainingMin = Duration.between(LocalTime.now(),oturum_saati.plusHours(1));
            LoginOut loginOut=new LoginOut(ifinal, a);
            loginOut.remainingTime.setText("Kalan Süre: "+String.valueOf(remainingMin.toMinutes())+" DK");
            loginOut.getExitButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String updateQuery= "update masa set durum_no=1 , oturum_saati=NULL where masa_id="+(ifinal+a+1);
                    sqlConnect.executeUpdate(updateQuery);
                    String relationQuery2="UPDATE masa set kullanici_id = NULL where masa_id="+(ifinal+a+1);
                    sqlConnect.executeUpdate(relationQuery2);
                    buttons[ifinal+a].setBackground(Color.white);
                    loginOut.jFrame.dispose();
                }
            });
            loginOut.getTimeUpdateButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LocalTime time = LocalTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    Time sqlTime = Time.valueOf(time.format(formatter).toString());
                    String updateQuery = "update masa set oturum_saati = '" + sqlTime + "' where masa_id = " + (ifinal + a + 1);
                    sqlConnect.executeUpdate(updateQuery);
                    loginOut.jFrame.dispose();
                }
            });
            new ButtonColor(buttons,jFrame,ifinal,a);
        }
    }
}
