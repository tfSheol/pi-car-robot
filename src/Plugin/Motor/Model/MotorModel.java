package Plugin.Motor.Model;

import Core.Model;
import Core.Singleton.ServerSingleton;
import com.pi4j.wiringpi.SoftPwm;

/**
 * Created by teddy on 08/07/2016.
 */
public class MotorModel extends Model {
    public MotorModel setSpeed(String socket, int speed) {
        try {
            ServerSingleton.getInstance().log(socket, "[MOTOR] -> Speed is set to " + speed + "%");
            SoftPwm.softPwmWrite(1, speed);
            SoftPwm.softPwmWrite(2, speed);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
