using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring.component.rpc.http.vo
{
    public class RespErrVo
    {
        #region Fields

        private List<RespErrItemVo> items = new List<RespErrItemVo>();

        public List<RespErrItemVo> Items { get => items; set => items = value; }

        #endregion
    }
}
