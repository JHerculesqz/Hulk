using Autofac;
using Autofac.Configuration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw.core
{
    /// <summary>
    /// IOCUtils
    /// </summary>
    public class IOCUtils
    {
        #region Fields

        private static readonly IContainer m_oContainer;

        #endregion

        #region Construction

        static IOCUtils()
        {
            var builder = new ContainerBuilder();
            builder.RegisterModule(new ConfigurationSettingsReader("autofac"));
            m_oContainer = builder.Build();
        }

        #endregion

        #region getBean

        /// <summary>
        /// getBean
        /// </summary>
        /// <typeparam name="T">T</typeparam>
        /// <returns>T</returns>
        public static T getBean<T>()
        {
            T oFac = m_oContainer.Resolve<T>();
            return oFac;
        }

        /// <summary>
        /// getBean
        /// </summary>
        /// <typeparam name="T">T</typeparam>
        /// <param name="strName">bean name</param>
        /// <returns>T</returns>
        public static T getBean<T>(String strName)
        {
            T oFac = m_oContainer.ResolveNamed<T>(strName);
            return oFac;
        }

        #endregion
    }
}
