package Plugin.Motor.Model;

import Core.Controller;
import Core.Model;
import Core.Singleton.ServerSingleton;
import com.pi4j.wiringpi.SoftPwm;

/**
 * Created by teddy on 08/07/2016.
 */
@Controller
public class MotorModel extends Model {
    public MotorModel setSpeed(String socket, int pin, int speed) {
        ServerSingleton.getInstance().log(socket, "[MOTOR] -> Speed is set to " + speed + "% in pin " + pin);
        SoftPwm.softPwmWrite(pin, speed);
        return this;
    }
}
