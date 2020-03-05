using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring.component.rpc.http.vo
{
    public class RespErrItemVo
    {
        #region Fields

        private String code;
        private String desc;
        private String reason;
        private String advice;

        public string Code { get => code; set => code = value; }
        public string Desc { get => desc; set => desc = value; }
        public string Reason { get => reason; set => reason = value; }
        public string Advice { get => advice; set => advice = value; }

        #endregion
    }
}
