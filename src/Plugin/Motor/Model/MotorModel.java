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
    public MotorModel setSpeed(String socket, boolean l, boolean r, int speed) {
        ServerSingleton.getInstance().log(socket, "[MOTOR] -> Speed is set to " + speed + "%");
        if (speed != 0) {
            startRotate(l, r, speed / 3);
            startRotate(l, r, speed / 2);
            startRotate(l, r, speed);
        } else {
            disableMotorPlus();
            disableMotorMinus();
        }
        return this;
    }

    private void startRotate(boolean l, boolean r, int speed) {
        if (speed > 0) {
            disableMotorMinus();
            controlDirection(24, 25, l, r, speed);
        } else if (speed < 0) {
            disableMotorPlus();
            controlDirection(28, 29, l, r, speed * -1);
        }
    }

    private void controlDirection(int pin_m1, int pin_m2, boolean l, boolean r, int speed) {
        if ((!l & !r) || (r & l)) {
            SoftPwm.softPwmWrite(pin_m1, speed);
            SoftPwm.softPwmWrite(pin_m2, speed);
        } else if (!l & r) {
            SoftPwm.softPwmWrite(pin_m1, speed / 10);
            SoftPwm.softPwmWrite(pin_m2, speed);
        } else {
            SoftPwm.softPwmWrite(pin_m1, speed);
            SoftPwm.softPwmWrite(pin_m2, speed / 10);
        }
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
