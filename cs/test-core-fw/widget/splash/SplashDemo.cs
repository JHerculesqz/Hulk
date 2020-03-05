using core_fw_spring_express.widget.splash;
using core_fw_spring_express.widget.splash.vo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace test_core_fw.widget.splash
{
    public class SplashDemo : ISplash
    {
        #region getSplashVo

        public SplashVo getSplashVo()
        {
            SplashVo oOutVo = new SplashVo();

            oOutVo.FilePathBg = "data/images/splash1.png";
            oOutVo.ShowName = true;
            oOutVo.Name = "Hulk";
            oOutVo.ShowVer = true;
            oOutVo.Ver = "v1.0.0-a1";
            oOutVo.ShowCopyRight = true;
            oOutVo.CopyRight1 = "@2008-2020 Hulk.All Right Reserved";
            oOutVo.CopyRight2 = "www.firelordtech.com";
            oOutVo.ShowProgress = true;

            return oOutVo;
        }

        #endregion

        #region splashBeforeCallback

        public void splashBeforeCallback()
        {
            
        }

        #endregion

        #region splashRunCallback

        public void splashRunCallback(BackgroundWorker oBGWorker)
        {
            oBGWorker.ReportProgress(0, "模块1加载...");
            Thread.Sleep(500);
            oBGWorker.ReportProgress(0, "模块2加载...");
            Thread.Sleep(500);
        }

        #endregion

        #region splashAfterCalback

        public Form splashAfterCalback()
        {
            return new MainForm();
        }

        #endregion

        #region getMainFormTitle

        public string getMainFormTitle()
        {
            return "Hulk v1.0.0-a1";
        }

        #endregion
    }
}
