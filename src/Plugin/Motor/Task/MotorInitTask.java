package Plugin.Motor.Task;

import Core.Http.Job;
import Core.Task;
import com.pi4j.wiringpi.Gpio;

/**
 * Created by teddy on 08/07/2016.
 */
@Task(value = 50, repeat = false)
public class MotorInitTask extends Job {
    @Override
    public void task() {
        Gpio.wiringPiSetup();
    }
}
