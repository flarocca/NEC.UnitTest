package nec.Models;

public class SeatBelt {

    private ISeatBeltState _state;

    public SeatBelt() {
	this._state = () -> false;
    }

    public Boolean isFastened() {
	return _state.isFastened();
    }

    public void fasten() {
	this._state = () -> true;
    }

    public void unfasten() {
	this._state = () -> false;
    }
}
