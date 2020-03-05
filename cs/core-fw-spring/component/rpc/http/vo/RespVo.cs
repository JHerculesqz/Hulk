using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring.component.rpc.http.vo
{
    public class RespVo
    {
        #region Fields

        private bool ok = true;
        private Object resultObj;
        private RespErrVo errorObj;

        public bool Ok { get => ok; set => ok = value; }
        public object ResultObj { get => resultObj; set => resultObj = value; }
        public RespErrVo ErrorObj { get => errorObj; set => errorObj = value; }

        #endregion
    }
}
