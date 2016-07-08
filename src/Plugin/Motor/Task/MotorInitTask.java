package Plugin.Motor.Task;

import Core.Http.Job;
import Core.Task;
import com.pi4j.wiringpi.SoftPwm;

/**
 * Created by teddy on 08/07/2016.
 */
@Task(value = 50, repeat = false)
public class MotorInitTask extends Job {
    @Override
    public void task() {
        SoftPwm.softPwmCreate(24, 0, 100);
        SoftPwm.softPwmCreate(25, 0, 100);
        SoftPwm.softPwmCreate(28, 0, 100);
        SoftPwm.softPwmCreate(29, 0, 100);
    }
}
