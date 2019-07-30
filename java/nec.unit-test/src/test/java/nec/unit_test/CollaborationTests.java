package nec.unit_test;

import org.junit.Assert;
import org.junit.Test;

public class CollaborationTests {

    @Test
    public void car_turnOnWithFuel_callsInginteOnEngine() {
	// car.hasFuel() == true;
	// car.turnOn();
	// engine.ignite() is called once and only once

	Assert.fail();
    }

    @Test
    public void car_turnOnWithNoFuel_engineIgniteIsNotCalled() {
	// car.hasFuel() == false;
	// car.turnOn();
	// engine.ignite() is not called

	Assert.fail();
    }

    @Test
    public void car_turnOnWithNoFuel_throwsIllegalStateException() {
	// car.hasFuel() == false;
	// car.turnOn();
	// throws IllegalStateException

	Assert.fail();
    }

    @Test
    public void car_turnOff_callsEngineStop() {
	// car.turnOff();
	// engine.stop() is called once and only once

	Assert.fail();
    }

    // - When car is turned on, seat belts must be checked for fastening
    // - When car is turned on and any seat belt is not fastened, the Seat Belt
    // Unfastened light must be turned on
    // - When engine throws exceptions, car must retry to ignite the engine 3 times
    // - When engine throws exceptions, car must turn on stop car light after having
    // retried 3 times
}
