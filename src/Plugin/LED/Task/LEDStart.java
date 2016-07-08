package Plugin.LED.Task;

import Core.Http.Job;
import Core.Task;
import com.pi4j.wiringpi.SoftPwm;

/**
 * Created by teddy on 08/07/2016.
 */
@Task(value = 1500, repeat = false)
public class LEDStart extends Job {
    @Override
    public void task() {
        SoftPwm.softPwmWrite(21, 100);
    }
}
