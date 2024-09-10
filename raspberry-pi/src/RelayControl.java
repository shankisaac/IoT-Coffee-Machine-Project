import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

public class RelayControl {

    private static final int RELAY_PIN = 17; // GPIO pin number

    private final GpioPinDigitalOutput relay;

    public RelayControl() {
        final GpioController gpio = GpioFactory.getInstance();
        this.relay = gpio.provisionDigitalOutputPin(RELAY_PIN, "Relay", PinState.LOW);
    }

    public void start() {
        relay.high(); // Activate the relay
    }

    public void stop() {
        relay.low(); // Deactivate the relay
    }

    public void shutdown() {
        relay.low();
        GpioFactory.getInstance().shutdown(); // Clean up GPIO resources
    }
}
