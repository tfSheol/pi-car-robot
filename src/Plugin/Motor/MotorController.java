package Plugin.Motor;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Plugin.Motor.Model.MotorModel;
import com.pi4j.wiringpi.SoftPwm;
import org.json.JSONObject;

/**
 * Created by teddy on 08/07/2016.
 */
@Controller
public class MotorController {
    @Methode("GET")
    @Route("/motor/set/{pin}/{speed}")
    public MotorModel setMotor(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        SoftPwm.softPwmCreate(args.getInt("pin"), 0, 100);
        return new MotorModel().setSpeed(socket, args.getInt("pin"), args.getInt("speed"));
    }
}
