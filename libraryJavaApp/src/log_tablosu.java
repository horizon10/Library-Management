import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class log_tablosu {
    public log_tablosu(JButton[] button){
        SqlConnect sqlConnect=new SqlConnect();
        String query= "select mesaj from log_tablosu ORDER BY id asc LIMIT 1";
        String result=sqlConnect.executeSelect(query);
        String query2= "SELECT masa_id FROM log_tablosu ORDER BY id asc LIMIT 1";
        String result2=sqlConnect.executeSelect(query2);
        // Eğer sonuçlar null değilse işlem yap
        if (result != null && result2 != null) {
            int masa_id = Integer.parseInt(result2)-1;
            // Sonuca göre renk ayarı yap
            if ("1".equals(result)) {
                if(button[masa_id].getBackground() == Color.RED){
                    button[masa_id].setBackground(Color.WHITE);
                }
            } else if ("2".equals(result)) {
                if(button[masa_id].getBackground() == Color.WHITE){
                    button[masa_id].setBackground(Color.RED);
                }
            }
            String query3= "DELETE FROM log_tablosu WHERE id = (SELECT id FROM (SELECT id FROM log_tablosu ORDER BY id ASC LIMIT 1) AS t)";
            sqlConnect.executeUpdate(query3);
        } else {
            // Hata durumunda uyarı ver

        }

    }
}
