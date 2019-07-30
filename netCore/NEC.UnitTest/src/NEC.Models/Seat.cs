using System;

namespace NEC.Models
{
    public class Seat
    {
        private readonly SeatBelt _seatBelt;

        public Seat(SeatBelt seatBelt) => 
            _seatBelt = seatBelt ?? throw new ArgumentNullException(nameof(seatBelt));

        public bool IsSeatBeltFastened() => _seatBelt.IsFastened();

        public void FastenSeatBelt() => _seatBelt.Fasten();
    }
}
