package Plugin.Motor;

import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Plugin.Motor.Model.MotorModel;
import org.json.JSONObject;

/**
 * Created by teddy on 08/07/2016.
 */
public class MotorController {
    @Methode("GET")
    @Route("/motor/set/{speed}")
    public MotorModel setMotor(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new MotorModel().setSpeed(socket, args.getInt("speed"));
    }
}
