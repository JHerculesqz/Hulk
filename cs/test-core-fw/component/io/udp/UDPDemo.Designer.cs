namespace test_core_fw.component.io.udp
{
    partial class UDPDemo
    {
        /// <summary> 
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region 组件设计器生成的代码

        /// <summary> 
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.m_groupBoxUDPClient = new System.Windows.Forms.GroupBox();
            this.m_groupBoxUDPRetryMQ = new System.Windows.Forms.GroupBox();
            this.m_textBoxRetryMQTest = new System.Windows.Forms.TextBox();
            this.m_buttonRetryMQTest = new System.Windows.Forms.Button();
            this.m_buttonRetryMQInit = new System.Windows.Forms.Button();
            this.m_buttonDestroy4Client = new System.Windows.Forms.Button();
            this.m_buttonSendAsync4Client = new System.Windows.Forms.Button();
            this.m_textBoxPortRemote4Send = new System.Windows.Forms.TextBox();
            this.m_textBoxPort4Send = new System.Windows.Forms.TextBox();
            this.m_textBoxSendAsync4Client = new System.Windows.Forms.TextBox();
            this.m_textBoxIPRemote4Send = new System.Windows.Forms.TextBox();
            this.m_textBoxParallelTest4Client = new System.Windows.Forms.TextBox();
            this.m_textBoxIP4Send = new System.Windows.Forms.TextBox();
            this.m_buttonParallelTest4Client = new System.Windows.Forms.Button();
            this.m_buttonInit4Client = new System.Windows.Forms.Button();
            this.m_groupBoxUDPServer = new System.Windows.Forms.GroupBox();
            this.m_buttonKill4Server = new System.Windows.Forms.Button();
            this.m_textBoxPort4Server = new System.Windows.Forms.TextBox();
            this.m_textBoxIP4Server = new System.Windows.Forms.TextBox();
            this.m_buttonInit4Server = new System.Windows.Forms.Button();
            this.m_buttonRetryMQTestDebug = new System.Windows.Forms.Button();
            this.m_groupBoxUDPClient.SuspendLayout();
            this.m_groupBoxUDPRetryMQ.SuspendLayout();
            this.m_groupBoxUDPServer.SuspendLayout();
            this.SuspendLayout();
            // 
            // m_groupBoxUDPClient
            // 
            this.m_groupBoxUDPClient.Controls.Add(this.m_groupBoxUDPRetryMQ);
            this.m_groupBoxUDPClient.Controls.Add(this.m_buttonDestroy4Client);
            this.m_groupBoxUDPClient.Controls.Add(this.m_buttonSendAsync4Client);
            this.m_groupBoxUDPClient.Controls.Add(this.m_textBoxPortRemote4Send);
            this.m_groupBoxUDPClient.Controls.Add(this.m_textBoxPort4Send);
            this.m_groupBoxUDPClient.Controls.Add(this.m_textBoxSendAsync4Client);
            this.m_groupBoxUDPClient.Controls.Add(this.m_textBoxIPRemote4Send);
            this.m_groupBoxUDPClient.Controls.Add(this.m_textBoxParallelTest4Client);
            this.m_groupBoxUDPClient.Controls.Add(this.m_textBoxIP4Send);
            this.m_groupBoxUDPClient.Controls.Add(this.m_buttonParallelTest4Client);
            this.m_groupBoxUDPClient.Controls.Add(this.m_buttonInit4Client);
            this.m_groupBoxUDPClient.Location = new System.Drawing.Point(3, 2);
            this.m_groupBoxUDPClient.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_groupBoxUDPClient.Name = "m_groupBoxUDPClient";
            this.m_groupBoxUDPClient.Padding = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_groupBoxUDPClient.Size = new System.Drawing.Size(424, 256);
            this.m_groupBoxUDPClient.TabIndex = 9;
            this.m_groupBoxUDPClient.TabStop = false;
            this.m_groupBoxUDPClient.Text = "UDPClient";
            // 
            // m_groupBoxUDPRetryMQ
            // 
            this.m_groupBoxUDPRetryMQ.Controls.Add(this.m_textBoxRetryMQTest);
            this.m_groupBoxUDPRetryMQ.Controls.Add(this.m_buttonRetryMQTestDebug);
            this.m_groupBoxUDPRetryMQ.Controls.Add(this.m_buttonRetryMQTest);
            this.m_groupBoxUDPRetryMQ.Controls.Add(this.m_buttonRetryMQInit);
            this.m_groupBoxUDPRetryMQ.Location = new System.Drawing.Point(7, 154);
            this.m_groupBoxUDPRetryMQ.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_groupBoxUDPRetryMQ.Name = "m_groupBoxUDPRetryMQ";
            this.m_groupBoxUDPRetryMQ.Padding = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_groupBoxUDPRetryMQ.Size = new System.Drawing.Size(400, 92);
            this.m_groupBoxUDPRetryMQ.TabIndex = 9;
            this.m_groupBoxUDPRetryMQ.TabStop = false;
            this.m_groupBoxUDPRetryMQ.Text = "UDPRetryMQ";
            // 
            // m_textBoxRetryMQTest
            // 
            this.m_textBoxRetryMQTest.Location = new System.Drawing.Point(7, 24);
            this.m_textBoxRetryMQTest.Margin = new System.Windows.Forms.Padding(4);
            this.m_textBoxRetryMQTest.Name = "m_textBoxRetryMQTest";
            this.m_textBoxRetryMQTest.Size = new System.Drawing.Size(208, 25);
            this.m_textBoxRetryMQTest.TabIndex = 10;
            this.m_textBoxRetryMQTest.Text = "10000";
            // 
            // m_buttonRetryMQTest
            // 
            this.m_buttonRetryMQTest.Location = new System.Drawing.Point(281, 24);
            this.m_buttonRetryMQTest.Margin = new System.Windows.Forms.Padding(4);
            this.m_buttonRetryMQTest.Name = "m_buttonRetryMQTest";
            this.m_buttonRetryMQTest.Size = new System.Drawing.Size(112, 25);
            this.m_buttonRetryMQTest.TabIndex = 5;
            this.m_buttonRetryMQTest.Text = "RetryMQTest";
            this.m_buttonRetryMQTest.UseVisualStyleBackColor = true;
            this.m_buttonRetryMQTest.Click += new System.EventHandler(this.m_buttonRetryMQTest_Click);
            // 
            // m_buttonRetryMQInit
            // 
            this.m_buttonRetryMQInit.Location = new System.Drawing.Point(222, 23);
            this.m_buttonRetryMQInit.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_buttonRetryMQInit.Name = "m_buttonRetryMQInit";
            this.m_buttonRetryMQInit.Size = new System.Drawing.Size(52, 26);
            this.m_buttonRetryMQInit.TabIndex = 2;
            this.m_buttonRetryMQInit.Text = "Init";
            this.m_buttonRetryMQInit.UseVisualStyleBackColor = true;
            this.m_buttonRetryMQInit.Click += new System.EventHandler(this.m_buttonRetryMQInit_Click);
            // 
            // m_buttonDestroy4Client
            // 
            this.m_buttonDestroy4Client.Location = new System.Drawing.Point(346, 24);
            this.m_buttonDestroy4Client.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_buttonDestroy4Client.Name = "m_buttonDestroy4Client";
            this.m_buttonDestroy4Client.Size = new System.Drawing.Size(61, 26);
            this.m_buttonDestroy4Client.TabIndex = 8;
            this.m_buttonDestroy4Client.Text = "Kill";
            this.m_buttonDestroy4Client.UseVisualStyleBackColor = true;
            this.m_buttonDestroy4Client.Click += new System.EventHandler(this.m_buttonDestroy4Client_Click);
            // 
            // m_buttonSendAsync4Client
            // 
            this.m_buttonSendAsync4Client.Location = new System.Drawing.Point(288, 57);
            this.m_buttonSendAsync4Client.Name = "m_buttonSendAsync4Client";
            this.m_buttonSendAsync4Client.Size = new System.Drawing.Size(119, 58);
            this.m_buttonSendAsync4Client.TabIndex = 7;
            this.m_buttonSendAsync4Client.Text = "SendAsync";
            this.m_buttonSendAsync4Client.UseVisualStyleBackColor = true;
            this.m_buttonSendAsync4Client.Click += new System.EventHandler(this.m_buttonSendAsync4Client_Click);
            // 
            // m_textBoxPortRemote4Send
            // 
            this.m_textBoxPortRemote4Send.Location = new System.Drawing.Point(195, 57);
            this.m_textBoxPortRemote4Send.Margin = new System.Windows.Forms.Padding(4);
            this.m_textBoxPortRemote4Send.Name = "m_textBoxPortRemote4Send";
            this.m_textBoxPortRemote4Send.Size = new System.Drawing.Size(85, 25);
            this.m_textBoxPortRemote4Send.TabIndex = 6;
            this.m_textBoxPortRemote4Send.Text = "502";
            // 
            // m_textBoxPort4Send
            // 
            this.m_textBoxPort4Send.Location = new System.Drawing.Point(195, 24);
            this.m_textBoxPort4Send.Margin = new System.Windows.Forms.Padding(4);
            this.m_textBoxPort4Send.Name = "m_textBoxPort4Send";
            this.m_textBoxPort4Send.Size = new System.Drawing.Size(85, 25);
            this.m_textBoxPort4Send.TabIndex = 6;
            this.m_textBoxPort4Send.Text = "503";
            // 
            // m_textBoxSendAsync4Client
            // 
            this.m_textBoxSendAsync4Client.Location = new System.Drawing.Point(7, 90);
            this.m_textBoxSendAsync4Client.Margin = new System.Windows.Forms.Padding(4);
            this.m_textBoxSendAsync4Client.Name = "m_textBoxSendAsync4Client";
            this.m_textBoxSendAsync4Client.Size = new System.Drawing.Size(273, 25);
            this.m_textBoxSendAsync4Client.TabIndex = 6;
            this.m_textBoxSendAsync4Client.Text = "123";
            // 
            // m_textBoxIPRemote4Send
            // 
            this.m_textBoxIPRemote4Send.Location = new System.Drawing.Point(7, 57);
            this.m_textBoxIPRemote4Send.Margin = new System.Windows.Forms.Padding(4);
            this.m_textBoxIPRemote4Send.Name = "m_textBoxIPRemote4Send";
            this.m_textBoxIPRemote4Send.Size = new System.Drawing.Size(179, 25);
            this.m_textBoxIPRemote4Send.TabIndex = 6;
            this.m_textBoxIPRemote4Send.Text = "127.0.0.1";
            // 
            // m_textBoxParallelTest4Client
            // 
            this.m_textBoxParallelTest4Client.Location = new System.Drawing.Point(7, 123);
            this.m_textBoxParallelTest4Client.Margin = new System.Windows.Forms.Padding(4);
            this.m_textBoxParallelTest4Client.Name = "m_textBoxParallelTest4Client";
            this.m_textBoxParallelTest4Client.Size = new System.Drawing.Size(273, 25);
            this.m_textBoxParallelTest4Client.TabIndex = 6;
            this.m_textBoxParallelTest4Client.Text = "10000";
            // 
            // m_textBoxIP4Send
            // 
            this.m_textBoxIP4Send.Location = new System.Drawing.Point(7, 24);
            this.m_textBoxIP4Send.Margin = new System.Windows.Forms.Padding(4);
            this.m_textBoxIP4Send.Name = "m_textBoxIP4Send";
            this.m_textBoxIP4Send.Size = new System.Drawing.Size(179, 25);
            this.m_textBoxIP4Send.TabIndex = 6;
            this.m_textBoxIP4Send.Text = "127.0.0.1";
            // 
            // m_buttonParallelTest4Client
            // 
            this.m_buttonParallelTest4Client.Location = new System.Drawing.Point(288, 123);
            this.m_buttonParallelTest4Client.Margin = new System.Windows.Forms.Padding(4);
            this.m_buttonParallelTest4Client.Name = "m_buttonParallelTest4Client";
            this.m_buttonParallelTest4Client.Size = new System.Drawing.Size(119, 25);
            this.m_buttonParallelTest4Client.TabIndex = 5;
            this.m_buttonParallelTest4Client.Text = "ParallelTest";
            this.m_buttonParallelTest4Client.UseVisualStyleBackColor = true;
            this.m_buttonParallelTest4Client.Click += new System.EventHandler(this.m_buttonParallelTest4Client_Click);
            // 
            // m_buttonInit4Client
            // 
            this.m_buttonInit4Client.Location = new System.Drawing.Point(288, 24);
            this.m_buttonInit4Client.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_buttonInit4Client.Name = "m_buttonInit4Client";
            this.m_buttonInit4Client.Size = new System.Drawing.Size(52, 26);
            this.m_buttonInit4Client.TabIndex = 2;
            this.m_buttonInit4Client.Text = "Init";
            this.m_buttonInit4Client.UseVisualStyleBackColor = true;
            this.m_buttonInit4Client.Click += new System.EventHandler(this.m_buttonInit4Client_Click);
            // 
            // m_groupBoxUDPServer
            // 
            this.m_groupBoxUDPServer.Controls.Add(this.m_buttonKill4Server);
            this.m_groupBoxUDPServer.Controls.Add(this.m_textBoxPort4Server);
            this.m_groupBoxUDPServer.Controls.Add(this.m_textBoxIP4Server);
            this.m_groupBoxUDPServer.Controls.Add(this.m_buttonInit4Server);
            this.m_groupBoxUDPServer.Location = new System.Drawing.Point(3, 262);
            this.m_groupBoxUDPServer.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_groupBoxUDPServer.Name = "m_groupBoxUDPServer";
            this.m_groupBoxUDPServer.Padding = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_groupBoxUDPServer.Size = new System.Drawing.Size(424, 66);
            this.m_groupBoxUDPServer.TabIndex = 9;
            this.m_groupBoxUDPServer.TabStop = false;
            this.m_groupBoxUDPServer.Text = "UDPServer";
            // 
            // m_buttonKill4Server
            // 
            this.m_buttonKill4Server.Location = new System.Drawing.Point(346, 24);
            this.m_buttonKill4Server.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_buttonKill4Server.Name = "m_buttonKill4Server";
            this.m_buttonKill4Server.Size = new System.Drawing.Size(61, 26);
            this.m_buttonKill4Server.TabIndex = 8;
            this.m_buttonKill4Server.Text = "Kill";
            this.m_buttonKill4Server.UseVisualStyleBackColor = true;
            this.m_buttonKill4Server.Click += new System.EventHandler(this.m_buttonKill4Server_Click);
            // 
            // m_textBoxPort4Server
            // 
            this.m_textBoxPort4Server.Location = new System.Drawing.Point(195, 24);
            this.m_textBoxPort4Server.Margin = new System.Windows.Forms.Padding(4);
            this.m_textBoxPort4Server.Name = "m_textBoxPort4Server";
            this.m_textBoxPort4Server.Size = new System.Drawing.Size(85, 25);
            this.m_textBoxPort4Server.TabIndex = 6;
            this.m_textBoxPort4Server.Text = "502";
            // 
            // m_textBoxIP4Server
            // 
            this.m_textBoxIP4Server.Location = new System.Drawing.Point(7, 24);
            this.m_textBoxIP4Server.Margin = new System.Windows.Forms.Padding(4);
            this.m_textBoxIP4Server.Name = "m_textBoxIP4Server";
            this.m_textBoxIP4Server.Size = new System.Drawing.Size(179, 25);
            this.m_textBoxIP4Server.TabIndex = 6;
            this.m_textBoxIP4Server.Text = "127.0.0.1";
            // 
            // m_buttonInit4Server
            // 
            this.m_buttonInit4Server.Location = new System.Drawing.Point(288, 24);
            this.m_buttonInit4Server.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_buttonInit4Server.Name = "m_buttonInit4Server";
            this.m_buttonInit4Server.Size = new System.Drawing.Size(52, 26);
            this.m_buttonInit4Server.TabIndex = 2;
            this.m_buttonInit4Server.Text = "Init";
            this.m_buttonInit4Server.UseVisualStyleBackColor = true;
            this.m_buttonInit4Server.Click += new System.EventHandler(this.m_buttonInit4Server_Click);
            // 
            // m_buttonRetryMQTestDebug
            // 
            this.m_buttonRetryMQTestDebug.Location = new System.Drawing.Point(7, 57);
            this.m_buttonRetryMQTestDebug.Margin = new System.Windows.Forms.Padding(4);
            this.m_buttonRetryMQTestDebug.Name = "m_buttonRetryMQTestDebug";
            this.m_buttonRetryMQTestDebug.Size = new System.Drawing.Size(83, 25);
            this.m_buttonRetryMQTestDebug.TabIndex = 5;
            this.m_buttonRetryMQTestDebug.Text = "Debug";
            this.m_buttonRetryMQTestDebug.UseVisualStyleBackColor = true;
            this.m_buttonRetryMQTestDebug.Click += new System.EventHandler(this.m_buttonRetryMQTestDebug_Click);
            // 
            // UDPDemo
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.m_groupBoxUDPServer);
            this.Controls.Add(this.m_groupBoxUDPClient);
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "UDPDemo";
            this.Size = new System.Drawing.Size(437, 340);
            this.m_groupBoxUDPClient.ResumeLayout(false);
            this.m_groupBoxUDPClient.PerformLayout();
            this.m_groupBoxUDPRetryMQ.ResumeLayout(false);
            this.m_groupBoxUDPRetryMQ.PerformLayout();
            this.m_groupBoxUDPServer.ResumeLayout(false);
            this.m_groupBoxUDPServer.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox m_groupBoxUDPClient;
        private System.Windows.Forms.Button m_buttonInit4Client;
        private System.Windows.Forms.Button m_buttonParallelTest4Client;
        private System.Windows.Forms.TextBox m_textBoxPort4Send;
        private System.Windows.Forms.TextBox m_textBoxIP4Send;
        private System.Windows.Forms.TextBox m_textBoxParallelTest4Client;
        private System.Windows.Forms.TextBox m_textBoxSendAsync4Client;
        private System.Windows.Forms.Button m_buttonSendAsync4Client;
        private System.Windows.Forms.TextBox m_textBoxPortRemote4Send;
        private System.Windows.Forms.TextBox m_textBoxIPRemote4Send;
        private System.Windows.Forms.Button m_buttonDestroy4Client;
        private System.Windows.Forms.GroupBox m_groupBoxUDPServer;
        private System.Windows.Forms.Button m_buttonKill4Server;
        private System.Windows.Forms.TextBox m_textBoxPort4Server;
        private System.Windows.Forms.TextBox m_textBoxIP4Server;
        private System.Windows.Forms.Button m_buttonInit4Server;
        private System.Windows.Forms.GroupBox m_groupBoxUDPRetryMQ;
        private System.Windows.Forms.TextBox m_textBoxRetryMQTest;
        private System.Windows.Forms.Button m_buttonRetryMQTest;
        private System.Windows.Forms.Button m_buttonRetryMQInit;
        private System.Windows.Forms.Button m_buttonRetryMQTestDebug;
    }
}
