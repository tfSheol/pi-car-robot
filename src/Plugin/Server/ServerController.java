package Plugin.Server;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Model;
import Core.Route;
import Plugin.Server.Model.EmailModel;
import Plugin.Server.Model.ServerModel;
import com.pi4j.wiringpi.SoftPwm;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by teddy on 29/05/2016.
 */
@Controller
public class ServerController {
    @Methode("GET")
    @Route("/server")
    public ServerModel getServer(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ServerModel();
    }

    @Methode("GET")
    @Route("/server/mail/{subject}/{corps}")
    public EmailModel postServerMail(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new EmailModel().send(socket, "[PI API Robot] " + args.getString("subject"), args.getString("corps"));
    }

    @Methode("GET")
    @Route("/server/update")
    public Model updateServer(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        try {
            SoftPwm.softPwmWrite(2, 100);
            Runtime r = Runtime.getRuntime();
            Process p = r.exec("../scripts/update.sh");
            p.waitFor();
            BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = b.readLine()) != null) {
                System.out.println(line);
            }
            b.close();
            System.exit(1);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return new Model();
    }

    @Methode("GET")
    @Route("/server/stop")
    public Model stopServer(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        SoftPwm.softPwmWrite(2, 100);
        SoftPwm.softPwmWrite(21, 0);
        System.exit(1);
        return new Model();
    }
}
