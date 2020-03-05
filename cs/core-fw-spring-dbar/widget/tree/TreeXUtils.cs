using DevComponents.AdvTree;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_dbar.widget.tree
{
    public class TreeXUtils
    {
        #region genNode

        public static Node genNode(String strText, bool bExpand)
        {
            var oNodeView = new Node();

            oNodeView.Text = strText;
            oNodeView.Expanded = bExpand;

            return oNodeView;
        }

        #endregion

        #region genNodeCell

        public static Cell genNodeCell(Control oCellControl, Node oParentNode)
        {
            var oCell = new Cell();

            if (null != oCellControl)
            {
                oCell.HostedControl = oCellControl;
            }
            oParentNode.Cells.Add(oCell);

            return oCell;
        }

        #endregion

        #region updateNodes

        public static void updateNodes(Node oRootNode, AdvTree oParentTree)
        {
            oParentTree.BeginUpdate();
            oParentTree.ClearAndDisposeAllNodes();
            oParentTree.Nodes.Add(oRootNode);
            oParentTree.EndUpdate(true);
        }

        #endregion
    }
}
