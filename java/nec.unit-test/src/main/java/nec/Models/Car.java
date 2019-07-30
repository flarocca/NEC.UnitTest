package nec.Models;

import java.util.List;

public class Car {

    private String _maker;
    private IEngine _engine;
    private List<Seat> _seats;

    // It should be encapsulated into a FuelTank,
    // but for simplicity lets keep it here
    private IFuelState _fuelState;

    // Lights should be encapsulated into a ControlPanel,
    // but again, for simplicity lets keep them here
    private ILightState _seatBeltUnfastenedLightState;
    private ILightState _stopCarLightState;

    public Car(String maker, IEngine engine, List<Seat> seats) {

	if (maker == null || maker.length() == 0) {
	    throw new IllegalArgumentException();
	}

	if (engine == null) {
	    throw new IllegalArgumentException();
	}

	if (seats == null || seats.isEmpty()) {
	    throw new IllegalArgumentException();
	}

	this._maker = maker;
	this._engine = engine;
	this._seats = seats;

	this._fuelState = () -> false;
	this._seatBeltUnfastenedLightState = () -> false;
	this._stopCarLightState = () -> false;
    }

    public String getMaker() {

	return this._maker;
    }

    public void refillFuel() {
	this._fuelState = () -> true;
    }

    public void turnOn() {

	// TEST: No fuel, throws IllegalStateException
	// TEST: _engine.ignite() is called
	// TEST: if _engine.ignite fails, method is called no more than 2 times
	// TEST: after _engine.ignite having failed 3 times, stop car light is turned on
	// TEST: seat belts are checked
	// TEST: if any seat belt is not fastened, seat belt unfastened ligh is turned
	// on

	if (this._fuelState.hasFuel() == false) {
	    throw new IllegalStateException();
	}

	igniteEngineAndCheckSeatBelts();
    }

    public void turnOff() throws Exception {

	// TEST: _engine.stop() is called once and only once

	this._engine.stop();
    }

    public Boolean isSeatBeltUnfastenLightTurnedOn() {

	// TEST: before turning the car on, returns false
	// TEST: after turning the car on, returns true

	return this._seatBeltUnfastenedLightState.isTurnedOn();
    }

    public Boolean isStopCarLightTurnedOn() {

	// TEST: if engine ignites, returns false
	// TEST: if engine does not ignite, returns true

	return this._stopCarLightState.isTurnedOn();
    }

    private void igniteEngineAndCheckSeatBelts() {

	int maxRetries = 3;
	int retryCounter = 0;

	while (retryCounter < maxRetries) {

	    try {

		this._engine.ignite();
		checkSeatBelts();

		break;

	    } catch (Exception e) {
		retryCounter++;
		if (retryCounter >= maxRetries) {

		    this._stopCarLightState = () -> true;
		    break;
		}
	    }
	}
    }

    private void checkSeatBelts() {

	for (Seat seat : this._seats) {

	    if (seat.isSeatBeltFastened() == false) {

		this._seatBeltUnfastenedLightState = () -> true;
	    }
	}
    }
}
