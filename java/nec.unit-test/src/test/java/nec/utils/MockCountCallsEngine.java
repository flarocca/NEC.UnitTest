package nec.utils;

import nec.Models.IEngine;

public class MockCountCallsEngine implements IEngine {

    private int _igniteCalls;

    private int _stopCalls;

    public void ignite() {

	this._igniteCalls++;
    }

    public void stop() {

	this._stopCalls++;
    }

    public int getIgniteCalls() {

	return this._igniteCalls;
    }

    public int getStopCalls() {

	return this._stopCalls;
    }

}
