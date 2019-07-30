using System;

namespace NEC.Models
{
    public class SeatBelt
    {
        private Func<bool> _state;

        public SeatBelt() => _state = () => false;

        public bool IsFastened() => _state();

        public void Fasten() => _state = () => true;

        public void Unfasten() => _state = () => false;
    }
}
