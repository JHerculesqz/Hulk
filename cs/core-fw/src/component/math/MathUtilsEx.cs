using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace walle.component.math
{
    public class MathUtilsEx
    {
        #region calcProgress

        public static int calcProgress(int iVal, int iSum)
        {
            double dIndex = Convert.ToDouble(iVal);
            double dSum = Convert.ToDouble(iSum);
            double dProgress = Math.Round(dIndex / dSum * 100);
            int iProgress = Convert.ToInt32(dProgress);
            return iProgress;
        }

        #endregion
    }
}
