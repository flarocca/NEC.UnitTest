using System;

namespace NEC.Models.Tests.Utils
{
    public class FakeThrowsExceptionEngine : IEngine
    {
        private readonly Exception _exceptionToThrow;

        public FakeThrowsExceptionEngine(Exception exceptionToThrow) =>
            _exceptionToThrow = exceptionToThrow;

        public void Ignite() => throw _exceptionToThrow;

        public void Stop() => throw _exceptionToThrow;
    }
}
