using core_fw.component.io.mq.devCmd;
using core_fw.component.io.mq.devCmd.vo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace test_core_fw.component.io.mq.devCmd
{
    public class DevCmdDemo : DevCmdBase
    {
        #region doSth

        public override List<byte> doSth()
        {
            //invoke UDPUtilsEx.sendMsg
            if (this.Id == 1)
            {
                return new List<byte>() { 0x01, 0xAA, 0xBB, 0xCC, 0x02, 0xDD, 0xEE, 0xFF };
            }
            else
            {
                return new List<byte>();
            }
        }

        #endregion

        #region splitRespMsg

        public override Dictionary<int, List<byte>> splitRespMsg(List<byte> lstRespSet)
        {
            var mapRespSet = new Dictionary<int, List<byte>>();

            //invoke NED split
            if (this.Id == 1)
            {
                mapRespSet.Add(0, new List<byte>() { 0x01, 0xAA, 0xBB, 0xCC });
                mapRespSet.Add(1, new List<byte>() { 0x02, 0xDD, 0xEE, 0xFF });

            }

            return mapRespSet;
        }

        #endregion

        #region doSthFinish

        public override DevCmdOutVo doSthFinish(List<byte> lstResp)
        {
            //invoke NED parse
            return new DevCmdOutVo()
            {
                isOk = true,
                errMsg = "",
                nedRes = "NED parse result:" + lstResp.Count
            };
        }

        #endregion

        #region doSthFinish4DB

        public override void doSthFinish4DB(DevCmdOutVo oDevCmdOutVo)
        {
            //do nothing
        }

        #endregion

        #region doSthFinish4UI

        public override void doSthFinish4UI(DevCmdOutVo oOutVo)
        {
            //update bu-xxx UI
        }

        #endregion

        #region doSthErr4DB

        public override void doSthErr4DB(DevCmdOutVo oOutVo)
        {
            //do nothing
        }

        #endregion

        #region doSthErr4UI

        public override void doSthErr4UI(DevCmdOutVo oOutVo)
        {
            //update bu-xxx UI
        }

        #endregion
    }
}
