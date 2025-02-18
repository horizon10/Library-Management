import javax.swing.*;
import java.awt.*;

public class ButtonColor {
        public ButtonColor(JButton[] button, JFrame jFrame, int i, int a){
            SqlConnect sqlConnect=new SqlConnect();
            String query= "select durum_no from masa where masa_id="+(i+a+1);
            String result=sqlConnect.executeSelect(query);

            if("1".equals(result)){
                button[i+a].setBackground(Color.white);
            }
            else if("2".equals(result)){
                button[i+a].setBackground(Color.red);
            }
        }



}
