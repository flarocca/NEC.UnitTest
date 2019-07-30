package nec.Models;

public class Seat {

    private SeatBelt _seatBelt;

    public Seat(SeatBelt seatBelt) {

	if (seatBelt == null) {
	    throw new IllegalArgumentException();
	}

	this._seatBelt = seatBelt;
    }

    public Boolean isSeatBeltFastened() {

	return this._seatBelt.isFastened();
    }

    public void fastenSeatBelt() {

	this._seatBelt.fasten();
    }
}
