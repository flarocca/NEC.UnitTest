package nec.unit_test;

import org.junit.Assert;
import org.junit.Test;

public class ConstructorTests {

    @Test
    public void car_nullMaker_throwsIllegalArgumentException() {
	// new Car(null, engine, seats);

	Assert.fail();
    }

    @Test
    public void car_emptyMaker_throwsIllegalArgumentException() {
	// new Car("", engine, seats);

	Assert.fail();
    }

    @Test
    public void car_nullEngine_throwsIllegalArgumentException() {
	// new Car("notNullNorEmptyMaker", null, seats);

	Assert.fail();
    }

    @Test
    public void car_nullListOfSeats_throwsIllegalArgumentException() {
	// new Car("notNullNorEmptyMaker", engine, null);

	Assert.fail();
    }

    @Test
    public void car_emptyListOfSeats_throwsIllegalArgumentException() {
	// new Car("notNullNorEmptyMaker", engine, emptyListOfSeats);

	Assert.fail();
    }

    @Test
    public void car_notNullNorEmptyMakerAndNotNullEngineAndNotNullNorEmptyListOfSeats_returnsValidCar() {
	// new Car("notNullNorEmptyMaker", engine, seats);

	Assert.fail();
    }
}
