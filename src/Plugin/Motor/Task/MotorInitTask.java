package Plugin.Motor.Task;

import Core.Http.Job;
import Core.Task;
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

/**
 * Created by teddy on 08/07/2016.
 */
@Task(value = 50, repeat = false)
public class MotorInitTask extends Job {
    @Override
    public void task() {
        Gpio.wiringPiSetup();
        SoftPwm.softPwmCreate(1, 0, 100);
        SoftPwm.softPwmCreate(2, 0, 100);
        SoftPwm.softPwmCreate(3, 0, 100);
        SoftPwm.softPwmCreate(4, 0, 100);
        SoftPwm.softPwmCreate(5, 0, 100);
        SoftPwm.softPwmCreate(6, 0, 100);
    }
}
