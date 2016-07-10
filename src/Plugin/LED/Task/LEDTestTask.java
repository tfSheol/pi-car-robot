package Plugin.LED.Task;

import Core.Http.Job;
import Core.Singleton.UserSecuritySingleton;
import Core.Task;
import com.pi4j.wiringpi.SoftPwm;

/**
 * Created by teddy on 08/07/2016.
 */
@Task(value = 100)
public class LEDTestTask extends Job {
    @Override
    public void task() {
        if (UserSecuritySingleton.getInstance().getNbToken() > 0) {
            SoftPwm.softPwmWrite(2, 100);
        } else {
            SoftPwm.softPwmWrite(2, 0);
        }
    }
}
