package Plugin.LED.Task;

import Core.Http.Job;
import Core.Task;
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

/**
 * Created by teddy on 08/07/2016.
 */
@Task(value = 40, repeat = false)
public class LEDTask extends Job {
    @Override
    public void task() {
        Gpio.wiringPiSetup();
        SoftPwm.softPwmCreate(2, 0, 100);
        SoftPwm.softPwmCreate(7, 0, 100);
        SoftPwm.softPwmCreate(21, 0, 100);
        SoftPwm.softPwmCreate(0, 0, 100);
    }
}
