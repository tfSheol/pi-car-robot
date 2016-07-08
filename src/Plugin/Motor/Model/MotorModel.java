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
    public MotorModel setSpeed(String socket, int speed) {
        ServerSingleton.getInstance().log(socket, "[MOTOR] -> Speed is set to " + speed + "%");
        if (speed > 0) {
            disableMotorMinus();
            SoftPwm.softPwmWrite(24, speed);
            SoftPwm.softPwmWrite(25, speed);
        } else if (speed < 0) {
            disableMotorPlus();
            SoftPwm.softPwmWrite(28, speed * -1);
            SoftPwm.softPwmWrite(29, speed * -1);
        } else {
            disableMotorPlus();
            disableMotorMinus();
        }
        return this;
    }

    private void disableMotorPlus() {
        SoftPwm.softPwmWrite(24, 0);
        SoftPwm.softPwmWrite(25, 0);
    }

    private void disableMotorMinus() {
        SoftPwm.softPwmWrite(28, 0);
        SoftPwm.softPwmWrite(29, 0);
    }
}
