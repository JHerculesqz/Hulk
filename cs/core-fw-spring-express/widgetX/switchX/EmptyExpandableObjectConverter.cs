using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace core_fw_spring_express.widgetX.switchX
{
  /// <summary>
  /// 展开属性选型去除描述
  /// </summary>
  [Description("展开属性选型去除描述")]
  public class EmptyExpandableObjectConverter : ExpandableObjectConverter
  {
    /// <summary>
    /// 当该属性为展开属性选型时，属性编辑器删除该属性的描述
    /// </summary>
    /// <param name="context"></param>
    /// <param name="culture"></param>
    /// <param name="value"></param>
    /// <param name="destinationType"></param>
    /// <returns></returns>
    public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, System.Type destinationType)
    {
      if (destinationType == typeof(string))
        return (object)"";
      return base.ConvertTo(context, culture, value, destinationType);
    }
  }
}
