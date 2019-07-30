using Xunit;

namespace NEC.Models.Tests
{
    public class ConstructorTests
    {

        [Fact]
        public void Car_NullMaker_ThrowsArgumentNullException()
        {
            // new Car(null, engine, seats);

            Assert.True(false);
        }

        [Fact]
        public void Car_EmptyMaker_ThrowsArgumentNullException()
        {
            // new Car("", engine, seats);

            Assert.True(false);
        }

        [Fact]
        public void Car_NullEngine_ThrowsArgumentNullException()
        {
            // new Car("notNullNorEmptyMaker", null, seats);

            Assert.True(false);
        }

        [Fact]
        public void Car_NullListOfSeats_ThrowsArgumentNullException()
        {
            // new Car("notNullNorEmptyMaker", engine, null);

            Assert.True(false);
        }

        [Fact]
        public void Car_EmptyListOfSeats_ThrowsArgumentNullException()
        {
            // new Car("notNullNorEmptyMaker", engine, emptyListOfSeats);

            Assert.True(false);
        }

        [Fact]
        public void Car_NotNullNorEmptyMakerAndNotNullEngineAndNotNullNorEmptyListOfSeats_ReturnsValidCar()
        {
            // new Car("notNullNorEmptyMaker", engine, seats);

            Assert.True(false);
        }
    }
}
