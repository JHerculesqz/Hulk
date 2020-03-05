using core_fw.widget.pgrid;
using core_fw.widget.pgrid.plugins;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace test_core_fw.widget.pgrid
{
    public partial class PGridForm : Form
    {
        public PGridForm()
        {
            InitializeComponent();

            var lstPGridAttributeVoEx = new List<PGridAttributeVoEx>();
            for (int i = 0; i < 10; i++)
            {
                var oPGridAttributeVoEx = new PGridAttributeVoEx("name" + i,
                    "category" + i % 2, "displayName" + i, "description" + i, "1", false,
                    new PGridDropDownListConverter(new List<string>() { "1", "2", "3" }.ToArray()));
                lstPGridAttributeVoEx.Add(oPGridAttributeVoEx);
            }
            this.m_propertyGrid.SelectedObject = new PGridCustomTypeDescriptorEx(lstPGridAttributeVoEx);
        }

        private void m_propertyGrid_PropertyValueChanged(object s, 
            PropertyValueChangedEventArgs e)
        {
            var oData = PGridCustomTypeDescriptorEx.getData(e);
            Console.WriteLine(oData);
        }
    }
}
