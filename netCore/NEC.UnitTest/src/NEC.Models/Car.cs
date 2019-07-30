using System;
using System.Collections.Generic;
using System.Linq;

namespace NEC.Models
{
    public class Car
    {
        public string Maker { get; private set; }

        public IEngine Engine { get; private set; }

        private readonly List<Seat> _seats;
        public IReadOnlyCollection<Seat> Seats => _seats;

        // It should be encapsulated into a FuelTank,
        // but for simplicity lets keep it here
        private Func<bool> _fuelState;

        // Lights should be encapsulated into a ControlPanel,
        // but again, for simplicity lets keep them here
        private Func<bool> _seatBeltUnfastenedLightState;
        private Func<bool> _stopCarLightState;

        public Car(string maker, IEngine engine, IEnumerable<Seat> seats)
        {
            if (string.IsNullOrWhiteSpace(maker))
            {
                throw new ArgumentNullException();
            }

            if (seats == null || seats.Count() == 0)
            {
                throw new ArgumentNullException();
            }

            Maker = maker;
            Engine = engine ?? throw new ArgumentNullException();
            _seats = seats.ToList();

            _fuelState = () => false;
            _seatBeltUnfastenedLightState = () => false;
            _stopCarLightState = () => false;
        }

        public void RefillFuel() => _fuelState = () => true;

        public void TurnOn()
        {
            // TEST: No fuel, throws IllegalStateException
            // TEST: _engine.ignite() is called
            // TEST: if _engine.ignite fails, method is called no more than 2 times
            // TEST: after _engine.ignite having failed 3 times, stop car light is turned on
            // TEST: seat belts are checked
            // TEST: if any seat belt is not fastened, seat belt unfastened ligh is turned on

            if (_fuelState() == false)
            {
                throw new InvalidOperationException();
            }

            IgniteEngineAndCheckSeatBelts();
        }

        // TEST: _engine.stop() is called once and only once
        public void TurnOff() => Engine.Stop();

        // TEST: before turning the car on, returns false
        // TEST: after turning the car on, returns true
        public bool IsSeatBeltUnfastenLightTurnedOn() => _seatBeltUnfastenedLightState();

        // TEST: if engine ignites, returns false
        // TEST: if engine does not ignite, returns true
        public bool IsStopCarLightTurnedOn() => _stopCarLightState();

        private void IgniteEngineAndCheckSeatBelts()
        {
            int maxRetries = 3;
            int retryCounter = 0;

            while (retryCounter < maxRetries)
            {
                try
                {
                    Engine.Ignite();
                    CheckSeatBelts();

                    break;
                }
                catch (Exception)
                {
                    retryCounter++;
                    if (retryCounter >= maxRetries)
                    {
                        _stopCarLightState = () => true;
                        break;
                    }
                }
            }
        }

        private void CheckSeatBelts() =>
            _seatBeltUnfastenedLightState = () => Seats.Any(seat => seat.IsSeatBeltFastened());
    }
}
