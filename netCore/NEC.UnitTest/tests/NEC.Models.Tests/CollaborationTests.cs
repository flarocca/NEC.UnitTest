using Xunit;

namespace NEC.Models.Tests
{
    public class CollaborationTests
    {
        [Fact]
        public void Car_TurnOnWithFuel_CallsInginteOnEngine()
        {
            // car.HasFuel() == true;
            // car.TurnOn();
            // engine.Ignite() is called once and only once

            Assert.True(false);
        }

        [Fact]
        public void Car_TurnOnWithNoFuel_EngineIgniteIsNotCalled()
        {
            // car.HasFuel() == false;
            // car.TurnOn();
            // engine.Ignite() is not called

            Assert.True(false);
        }

        [Fact]
        public void Car_TurnOnWithNoFuel_ThrowsIllegalStateException()
        {
            // car.HasFuel() == false;
            // car.TurnOn();
            // throws InvalidOperationException()

            Assert.True(false);
        }

        [Fact]
        public void Car_TurnOff_CallsEngineStop()
        {
            // car.TurnOff();
            // engine.Stop() is called once and only once

            Assert.True(false);
        }

        // - When car is turned on, seat belts must be checked for fastening
        // - When car is turned on and any seat belt is not fastened, 
        //   the Seat Belt Unfastened light must be turned on
        // - When engine throws exceptions, car must retry to Ignite the engine 3 times
        // - When engine throws exceptions, car must turn on Stop car light after having
        //   retried 3 times
    }
}
