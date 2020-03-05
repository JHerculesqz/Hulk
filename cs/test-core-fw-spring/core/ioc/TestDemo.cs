using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace test_core_fw_spring.core.ioc
{
    public class TestDemo : ITest
    {
        public void test()
        {
            Console.WriteLine("test...");
        }
    }
}
