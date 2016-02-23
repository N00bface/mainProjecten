import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author Jari Van Melckebeke
 */
public class Action {
    /**
     * deze methode zorgt voor de aanmaak van bepaalde Actions na een command
     */
    private Action() {

    }

    /**
     * deze methode zorgt voor de uitvoer van commands
     *
     * @param command het commando zonder 'teresa'
     */
    public static String doAction(String command) {
        HashMap<String, String> questionDatabase = new Resources().getDatabase();
        String returnType = "";
        try {
            Method actionMethod = Class.forName("Action").getMethod(questionDatabase.get(command));
            actionMethod.invoke(returnType);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return returnType;
    }

    private static String getNotifications() {
        Properties props = new Properties();
        //props.setProperty("mail.store.protocol", "imap");
        props.setProperty("mail.protocol", "pop3");
        props.setProperty("mail.host", "pop3.live.com");
        props.put("mail.pop3.starttls.enable", "true");
        props.put("mail.pop3.auth", "true");
        try {
            Session session = Session.getInstance(props, null);
            session.setDebug(true);
            Store store = session.getStore();
            System.out.println("store gotten");
            store.connect("pop3.live.com", "jarivm@outlook.com", "Tanzania1");
            System.out.println("connected");
            Folder inbox = store.getFolder("INBOX");
            System.out.println(inbox.getNewMessageCount());
            return "you have " + inbox.getNewMessageCount() + "new mails";
        } catch (Exception e) {
            e.printStackTrace();
            return "wrong";
        }
    }

    private static String getTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(calendar.getTime());
    }
}
