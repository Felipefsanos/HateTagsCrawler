package twittersearch2;

import java.sql.SQLException;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Twitter;

public class Reminder extends Thread {

    private final String tweetWords[] = {"baianagem","baitola","boiola","biba","bicha","bichinha","bichona","boiola","bugre","caboclo","caboco","cafuzo","macaco","viado"};
    private final Twitter tt = Autenticacao.Acesso();
    Timer timer;

    @Override
    public void run() {
        int j = 0;
        while (true) {

            for (int i = 0; i < tweetWords.length; i++) {
                try {
                    Autenticacao.search(tt, tweetWords[i], 100);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println(i + "-------------------------------------------------------------");
            }
            try {
                j++;
                System.out.println("Vezes rodada: "+j);
                Thread.sleep(1000*240);
            } catch (InterruptedException ex) {
                Logger.getLogger(Reminder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
