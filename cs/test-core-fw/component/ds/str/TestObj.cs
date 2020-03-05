using core_fw.component.ds.str;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace test_core_fw.component.ds.str
{
    public class TestObj : LombokBase
    {
        #region Fields

        private String name;

        public string Name { get => name; set => name = value; }

        #endregion
    }
}
