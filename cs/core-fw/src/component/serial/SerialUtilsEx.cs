using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading.Tasks;

namespace walle.component.serial
{
    public class SerialUtilsEx
    {
        #region serializeObject

        public static byte[] serializeObject(object obj)
        {
            if (obj == null)
                return null;
            //内存实例  
            MemoryStream ms = new MemoryStream();
            //创建序列化的实例  
            BinaryFormatter formatter = new BinaryFormatter();
            formatter.Serialize(ms, obj);//序列化对象，写入ms流中    
            byte[] bytes = ms.GetBuffer();
            return bytes;
        }

        #endregion

        #region deserializeObject

        public static object deserializeObject(byte[] bytes)
        {
            object obj = null;
            if (bytes == null)
                return obj;
            //利用传来的byte[]创建一个内存流  
            MemoryStream ms = new MemoryStream(bytes);
            ms.Position = 0;
            BinaryFormatter formatter = new BinaryFormatter();
            obj = formatter.Deserialize(ms);//把内存流反序列成对象    
            ms.Close();
            return obj;
        }

        #endregion
    }
}
