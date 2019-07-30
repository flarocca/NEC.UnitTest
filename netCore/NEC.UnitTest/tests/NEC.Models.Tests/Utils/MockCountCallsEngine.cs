namespace NEC.Models.Tests.Utils
{
    public class MockCountCallsEngine : IEngine
    {
        public int IgniteCalls { get; private set; } = 0;

        public int StopCalls { get; private set; } = 0;

        public void Ignite() => IgniteCalls++;

        public void Stop() => StopCalls++;
    }
}
