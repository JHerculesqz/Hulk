using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using System.Windows.Forms;

namespace core_fw_csharp.src.component.http
{
    public class RestUtilsEx
    {
        #region Fields

        private static string BaseUri;

        #endregion

        #region Construction

        public RestUtilsEx(string baseUri)
        {
            BaseUri = baseUri;
        }

        #endregion

        #region 通用请求

        public static string httpRequest(string url, HttpType type, ContentType eContentType, string inputData = "")
        {
            switch (type)
            {
                case HttpType.PUT:
                    return _put(url, eContentType, inputData);
                case HttpType.GET:
                    return _get(url, eContentType);
                case HttpType.POST:
                    return _post(url, eContentType, inputData);
                case HttpType.DELETE:
                    return _delete(url, eContentType, inputData);
                default:
                    break;
            }
            return "";
        }

        #endregion

        #region upload

        public static string upload(string uri, string strFileName)
        {
            string serviceUrl = "";
            if (BaseUri == "" || BaseUri == null)
            {
                serviceUrl = uri;
            }
            else
            {
                serviceUrl = string.Format("{0}/{1}", BaseUri, uri);
            }

            System.Net.WebClient webClient = new System.Net.WebClient();
            try
            {
                webClient.UploadFile(serviceUrl, "Post", strFileName);
                return "ok";
            }
            catch (Exception ex)
            {
                webClient.Dispose();
                return ex.Message;
            }

        }

        public static string upload(string uri, string filePath, object obj, string fileKeyName = "file", int timeOut = 360000)
        {
            string result = "";

            WebRequest request = WebRequest.Create(uri);
            request.Timeout = timeOut;
            FormDataUtilsEx form = new FormDataUtilsEx();
            form.AddFormField(obj);
            FileStream file = new FileStream(filePath, FileMode.Open);
            byte[] bb = new byte[file.Length];
            file.Read(bb, 0, (int)file.Length);
            file.Close();
            string fileName = Path.GetFileName(filePath);
            form.AddStreamFile(fileKeyName, fileName, bb);
            form.PrepareFormData();
            request.ContentType = "multipart/form-data; boundary=" + form.Boundary;
            request.Method = "Post";
            Stream stream = request.GetRequestStream();
            foreach (var b in form.GetFormData())
            {
                stream.WriteByte(b);
            }
            stream.Close();
            WebResponse response = request.GetResponse();

            using (var httpStreamReader = new StreamReader(response.GetResponseStream(), Encoding.GetEncoding("utf-8")))
            {
                result = httpStreamReader.ReadToEnd();
            }
            response.Close();
            request.Abort();
            return result;
        }

        public static string uploadFat(string uri, string filePath, object obj,
                                       string fileKeyName = "file", int timeOut = 3600000)
        {
            string result = "";
            FormDataUtilsEx form = new FormDataUtilsEx();
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(uri);
            request.ContentType = "multipart/form-data; boundary=" + form.Boundary;
            request.Method = "Post";
            //request.AllowWriteStreamBuffering = false;
            request.Timeout = timeOut;

            //form data
            form.AddFormField(obj);
            string fileName = Path.GetFileName(filePath);
            form.AddStreamFile(fileKeyName, fileName);

            FileStream file = new FileStream(filePath, FileMode.Open, FileAccess.Read);
            //二进制对象
            BinaryReader r = new BinaryReader(file);

            try
            {
                Stream stream = request.GetRequestStream();
                foreach (var b in form.GetFormData())
                {
                    stream.WriteByte(b);
                }
                //每次上传4k  
                int bufferLength = 4096;
                byte[] buffer = new byte[bufferLength]; //已上传的字节数   
                long offset = 0;         //开始上传时间   
                int size = r.Read(buffer, 0, bufferLength);
                long length = file.Length;
                while (size > 0)
                {
                    stream.Write(buffer, 0, size);
                    offset += size;
                    Application.DoEvents();
                    size = r.Read(buffer, 0, bufferLength);
                }

                foreach (var b in form.getSuffix())
                {
                    stream.WriteByte(b);
                }
                stream.Close();

                WebResponse response = request.GetResponse();

                using (var httpStreamReader = new StreamReader(response.GetResponseStream(), Encoding.GetEncoding("utf-8")))
                {
                    result = httpStreamReader.ReadToEnd();
                }
                response.Close();
                request.Abort();
                return result;
            }
            catch (Exception ex)
            {
                return "";
            }
            finally
            {
                file.Close();
                r.Close();
            }
        }

        #endregion

        #region private

        #region Delete方式

        private static string _delete(string uri, ContentType eContentType, string data = "")
        {
            string serviceUrl = "";
            if (BaseUri == "" || BaseUri == null)
            {
                serviceUrl = uri;
            }
            else
            {
                serviceUrl = string.Format("{0}/{1}", BaseUri, uri);
            }
            return _commonHttpRequest(serviceUrl, "DELETE", eContentType, data);
        }

        #endregion

        #region Put方式

        private static string _put(string uri, ContentType eContentType, string data)
        {
            string serviceUrl = "";
            if (BaseUri == "" || BaseUri == null)
            {
                serviceUrl = uri;
            }
            else
            {
                serviceUrl = string.Format("{0}/{1}", BaseUri, uri);
            }
            return _commonHttpRequest(serviceUrl, "PUT", eContentType, data);
        }

        #endregion

        #region POST方式实现

        private static string _post(string uri, ContentType eContentType, string data)
        {
            string serviceUrl = "";
            if (BaseUri == "" || BaseUri == null)
            {
                serviceUrl = uri;
            }
            else
            {
                serviceUrl = string.Format("{0}/{1}", BaseUri, uri);
            }
            return _commonHttpRequest(serviceUrl, "Post", eContentType, data);
        }

        #endregion

        #region GET方式实现

        private static string _get(string uri, ContentType eContentType)
        {
            string serviceUrl = "";
            if (BaseUri == "" || BaseUri == null)
            {
                serviceUrl = uri;
            }
            else
            {
                serviceUrl = string.Format("{0}/{1}", BaseUri, uri);
            }


            return _commonHttpRequest(serviceUrl, "GET", eContentType);
        }

        #endregion

        #region  私有方法

        private static string _commonHttpRequest(string url, string type, ContentType eContentType, string data = "")
        {
            HttpWebRequest myRequest = null;
            Stream outstream = null;
            HttpWebResponse myResponse = null;
            StreamReader reader = null;
            try
            {
                //构造http请求的对象
                myRequest = (HttpWebRequest)WebRequest.Create(url);
                //设置
                myRequest.ProtocolVersion = HttpVersion.Version10;
                myRequest.Method = type;

                if (data.Trim() != "")
                {
                    if (eContentType == ContentType.FORM)
                    {
                        myRequest.ContentType = "application/x-www-form-urlencoded";
                    }
                    else if (eContentType == ContentType.JSON)
                    {
                        myRequest.ContentType = "application/json";
                    }
                    else
                    {
                        myRequest.ContentType = "text/xml";
                    }

                    //转成网络流
                    byte[] buf = System.Text.Encoding.GetEncoding("UTF-8").GetBytes(data);

                    myRequest.ContentLength = buf.Length;
                    //myRequest.Headers.Add("data", data);

                    outstream = myRequest.GetRequestStream();
                    outstream.Flush();
                    outstream.Write(buf, 0, buf.Length);
                    outstream.Flush();
                    outstream.Close();
                }
                // 获得接口返回值
                myResponse = (HttpWebResponse)myRequest.GetResponse();
                reader = new StreamReader(myResponse.GetResponseStream(), Encoding.UTF8);
                string ReturnXml = reader.ReadToEnd();
                reader.Close();
                myResponse.Close();
                myRequest.Abort();
                return ReturnXml;
            }
            catch (Exception ex)
            {
                // throw new Exception();
                if (outstream != null) outstream.Close();
                if (reader != null) reader.Close();
                if (myResponse != null) myResponse.Close();
                if (myRequest != null) myRequest.Abort();
                return "";
            }
        }

        #endregion

        #region enum

        public enum HttpType
        {
            PUT = 0,
            GET = 1,
            POST = 2,
            DELETE = 3
        }

        public enum ContentType
        {
            FORM,
            JSON,
            TEXT
        }

        #endregion

        #region FormDataUtilsEx

        private class FormDataUtilsEx
        {
            private List<byte> formData;
            public String Boundary = "---------------" + DateTime.Now.Ticks.ToString("x");
            private String fieldName = "Content-Disposition: form-data; name=\"{0}\"";
            private String fileContentType = "Content-Type: {0}";
            private String fileField = "Content-Disposition: form-data; name=\"{0}\"; filename=\"{1}\"";
            private Encoding encode = Encoding.GetEncoding("UTF-8");
            public FormDataUtilsEx()
            {
                formData = new List<byte>();
            }

            public void AddFormField(object obj)
            {
                if (null != obj)
                {
                    PropertyInfo[] arrPropertyInfo = obj.GetType().GetProperties();
                    foreach (var oPropertyInfo in arrPropertyInfo)
                    {
                        var oValue = oPropertyInfo.GetValue(obj, null);
                        var FieldValue = null == oValue ? "" : HttpUtility.UrlEncode(oValue.ToString());
                        AddFormField(oPropertyInfo.Name, FieldValue);
                    }
                }
            }

            public void AddFormField(String FieldName, String FieldValue)
            {
                String newFieldName = fieldName;
                newFieldName = string.Format(newFieldName, FieldName);
                formData.AddRange(encode.GetBytes("--" + Boundary + "\r\n"));
                formData.AddRange(encode.GetBytes(newFieldName + "\r\n\r\n"));
                formData.AddRange(encode.GetBytes(FieldValue + "\r\n"));
            }

            public void AddFile(String FieldName, String FileName, String ContentType)
            {
                String newFileField = fileField;
                String newFileContentType = fileContentType;
                newFileField = string.Format(newFileField, FieldName, FileName);
                newFileContentType = string.Format(newFileContentType, ContentType);
                formData.AddRange(encode.GetBytes("--" + Boundary + "\r\n"));
                formData.AddRange(encode.GetBytes(newFileField + "\r\n"));
                formData.AddRange(encode.GetBytes(newFileContentType + "\r\n\r\n"));
                formData.AddRange(encode.GetBytes("\r\n"));
            }

            public void AddFile(String FieldName, String FileName, byte[] FileContent, String ContentType)
            {
                String newFileField = fileField;
                String newFileContentType = fileContentType;
                newFileField = string.Format(newFileField, FieldName, FileName);
                newFileContentType = string.Format(newFileContentType, ContentType);
                formData.AddRange(encode.GetBytes("--" + Boundary + "\r\n"));
                formData.AddRange(encode.GetBytes(newFileField + "\r\n"));
                formData.AddRange(encode.GetBytes(newFileContentType + "\r\n\r\n"));
                formData.AddRange(FileContent);
                formData.AddRange(encode.GetBytes("\r\n"));
            }
            public void AddStreamFile(String FieldName, String FileName, byte[] FileContent)
            {
                AddFile(FieldName, FileName, FileContent, "application /octet-stream");
            }
            public void AddStreamFile(String FieldName, String FileName)
            {
                AddFile(FieldName, FileName, "text/plain");
            }
            public List<byte> getSuffix()
            {
                return encode.GetBytes("\r\n--" + Boundary + "--\r\n").ToList();
            }
            public void PrepareFormData()
            {
                formData.AddRange(encode.GetBytes("--" + Boundary + "--"));
            }
            public List<byte> GetFormData()
            {
                return formData;
            }
        }

        #endregion

        #endregion
    }
}
