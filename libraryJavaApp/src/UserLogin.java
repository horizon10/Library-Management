import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class UserLogin {
    public JFrame getFrame() {
        return frame;
    }



    JTextField studentNoText = new JTextField();

    JButton confirmButton=new JButton();
    JFrame frame = new JFrame();
    public void UserLoginEkrani(){

        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);




        JLabel studentNo = new JLabel("Öğrenci numarası:",4);
        studentNo.setBounds(20,50,110,30);

        studentNoText.setBounds(140,55,100,20);

        confirmButton.setText("Onayla");
        confirmButton.setBounds(140,90,100,20);



        frame.add(studentNo);
        frame.add(studentNoText);
        frame.add(confirmButton);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }
    public static boolean CheckStudentNo(String StudentNo){
        boolean b1 = StudentNo.length()==12 ? true : false;
        boolean b2 = StudentNo.matches("\\d+");
        return b1&&b2;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }
    public JTextField getStudentNoText() {
        return studentNoText;
    }


}