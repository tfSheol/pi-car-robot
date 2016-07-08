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
import org.json.JSONObject;

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
    @Route("/server/stop")
    public Model stopServer(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        System.exit(1);
        return new Model();
    }
}
