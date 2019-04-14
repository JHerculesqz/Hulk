using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Timers;

namespace walle.component.timer
{
    public class TimerUtilsEx
    {
        #region init

        public static Timer init(double iIntervalMs, ElapsedEventHandler oCallback)
        {
            Timer timer = new Timer();

            timer.Enabled = true;
            timer.Interval = iIntervalMs;
            timer.Start();
            timer.Elapsed += oCallback;

            return timer;
        }

        #endregion

        #region stop

        public static void stop(Timer oTimer)
        {
            oTimer.Stop();
        }

        #endregion
    }
}
