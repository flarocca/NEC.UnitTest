package nec.utils;

import nec.Models.IEngine;

public class FakeThrowsExceptionEngine implements IEngine {

    private Exception _exceptionToThrow;

    public FakeThrowsExceptionEngine(Exception exceptionToThrow) {
	this._exceptionToThrow = exceptionToThrow;
    }

    public void ignite() throws Exception {

	throw _exceptionToThrow;
    }

    public void stop() throws Exception {

	throw _exceptionToThrow;
    }

}
