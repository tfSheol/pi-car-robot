package Plugin.LED;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Plugin.LED.Model.LEDModel;
import org.json.JSONObject;

/**
 * Created by teddy on 08/07/2016.
 */
@Controller
public class LEDController {
    @Methode("GET")
    @Route("/led/set/{id}/{power}")
    public LEDModel setLedPower(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new LEDModel().setPower(socket, args.getInt("id"), args.getInt("power"));
    }
}
