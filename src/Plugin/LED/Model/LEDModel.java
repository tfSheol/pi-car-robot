package Plugin.LED.Model;

import Core.Model;
import Core.Singleton.ServerSingleton;
import com.pi4j.wiringpi.SoftPwm;

/**
 * Created by teddy on 08/07/2016.
 */
public class LEDModel extends Model {
    public LEDModel setPower(String socket, int id, int power) {
        ServerSingleton.getInstance().log(socket, "[LED_" + id + "] -> set to " + power + "%");
        if (id == 1) {
            SoftPwm.softPwmWrite(7, power);
        } else if (id == 2) {
            SoftPwm.softPwmWrite(0, power);
        } else if (id == 3) {
            SoftPwm.softPwmWrite(2, power);
        } else if (id == 4) {
            SoftPwm.softPwmWrite(21, power);
        } else if (id == 0) {
            disableAllLED();
        }
        return this;
    }

    public void disableAllLED() {
        SoftPwm.softPwmWrite(2, 0);
        SoftPwm.softPwmWrite(21, 0);
        SoftPwm.softPwmWrite(7, 0);
        SoftPwm.softPwmWrite(0, 0);
    }
}
