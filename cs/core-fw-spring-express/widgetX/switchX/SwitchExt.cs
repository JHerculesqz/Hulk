using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Drawing.Drawing2D;
using System.Drawing.Text;
using System.ComponentModel.Design;

namespace core_fw_spring_express.widgetX.switchX
{
    /// <summary>
    /// 开关按钮
    /// </summary>
    [ToolboxItem(true)]
    [DefaultProperty("Type")]
    [Description("开关按钮")]
    public partial class SwitchExt : Control
    {
        #region

        private SwitchType type = SwitchType.Flat;
        /// <summary>
        /// 按钮类型
        /// </summary>
        [DefaultValue(SwitchType.Flat)]
        [Description("按钮类型")]
        public SwitchType Type
        {
            get { return this.type; }
            set
            {
                if (this.type == value)
                    return;
                this.type = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private int radius = 5;
        /// <summary>
        /// 按钮圆角大小(限于Flat)
        /// </summary>
        [DefaultValue(5)]
        [Description("按钮圆角大小(限于Flat)")]
        public int Radius
        {
            get { return this.radius; }
            set
            {
                if (this.radius == value)
                    return;
                this.radius = value;
                if (this.Type == SwitchType.Flat)
                {
                    this.InitializeSwitchLayout();
                    this.Invalidate();
                }
            }
        }

        private Color backdropColor = Color.FromArgb(245, 165, 166);
        /// <summary>
        /// 背景颜色
        /// </summary>
        [DefaultValue(typeof(Color), "245, 165, 166")]
        [Description("背景颜色")]
        [Editor(typeof(ColorEditorExt), typeof(System.Drawing.Design.UITypeEditor))]
        public Color BackdropColor
        {
            get { return this.backdropColor; }
            set
            {
                if (this.backdropColor == value)
                    return;
                this.backdropColor = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private Color backdropSelectColor = Color.FromArgb(167, 204, 233);
        /// <summary>
        /// 选中时背景颜色
        /// </summary>
        [DefaultValue(typeof(Color), "167, 204, 233")]
        [Description("选中时背景颜色")]
        [Editor(typeof(ColorEditorExt), typeof(System.Drawing.Design.UITypeEditor))]
        public Color BackdropSelectColor
        {
            get { return this.backdropSelectColor; }
            set
            {
                if (this.backdropSelectColor == value)
                    return;
                this.backdropSelectColor = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private Color backdropBorderColor = Color.FromArgb(245, 165, 166);
        /// <summary>
        /// 背景边框颜色
        /// </summary>
        [DefaultValue(typeof(Color), "245, 165, 166")]
        [Description("背景边框颜色")]
        [Editor(typeof(ColorEditorExt), typeof(System.Drawing.Design.UITypeEditor))]
        public Color BackdropBorderColor
        {
            get { return this.backdropBorderColor; }
            set
            {
                if (this.backdropBorderColor == value)
                    return;
                this.backdropBorderColor = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private int backdropBorderThickness = 0;
        /// <summary>
        /// 背景边框画笔大小
        /// </summary>
        [DefaultValue(0)]
        [Description("背景边框画笔大小")]
        public int BackdropBorderThickness
        {
            get { return this.backdropBorderThickness; }
            set
            {
                if (this.backdropBorderThickness == value || value < 0)
                    return;
                this.backdropBorderThickness = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private Color slideColor = Color.FromArgb(255, 255, 255);
        /// <summary>
        /// 滑块颜色
        /// </summary>
        [DefaultValue(typeof(Color), "255, 255, 255")]
        [Description("滑块颜色")]
        [Editor(typeof(ColorEditorExt), typeof(System.Drawing.Design.UITypeEditor))]
        public Color SlideColor
        {
            get { return this.slideColor; }
            set
            {
                if (this.slideColor == value)
                    return;
                this.slideColor = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private Color slideSelectColor = Color.FromArgb(255, 255, 255);
        /// <summary>
        /// 选中时滑块颜色
        /// </summary>
        [DefaultValue(typeof(Color), "255, 255, 255")]
        [Description("选中时滑块颜色")]
        [Editor(typeof(ColorEditorExt), typeof(System.Drawing.Design.UITypeEditor))]
        public Color SlideSelectColor
        {
            get { return this.slideSelectColor; }
            set
            {
                if (this.slideSelectColor == value)
                    return;
                this.slideSelectColor = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private Color slideBorderColor = Color.FromArgb(255, 255, 255);
        /// <summary>
        /// 滑块边框颜色
        /// </summary>
        [DefaultValue(typeof(Color), "255, 255, 255")]
        [Description("滑块边框颜色")]
        [Editor(typeof(ColorEditorExt), typeof(System.Drawing.Design.UITypeEditor))]
        public Color SlideBorderColor
        {
            get { return this.slideBorderColor; }
            set
            {
                if (this.slideBorderColor == value)
                    return;
                this.slideBorderColor = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private int slideBorderThickness = 0;
        /// <summary>
        /// 滑块边框画笔大小
        /// </summary>
        [DefaultValue(0)]
        [Description("滑块边框画笔大小")]
        public int SlideBorderThickness
        {
            get { return this.slideBorderThickness; }
            set
            {
                if (this.slideBorderThickness == value || value < 0)
                    return;
                this.slideBorderThickness = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private string onText = "开";
        /// <summary>
        /// 开启文本
        /// </summary>
        [DefaultValue("开")]
        [Description("开启文本")]
        public string OnText
        {
            get { return this.onText; }
            set
            {
                if (this.onText == value)
                    return;
                this.onText = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private string offText = "关";
        /// <summary>
        /// 关闭文本
        /// </summary>
        [DefaultValue("关")]
        [Description("关闭文本")]
        public string OffText
        {
            get { return this.offText; }
            set
            {
                if (this.offText == value)
                    return;
                this.offText = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private Font textFont = new Font("宋体", 11, FontStyle.Bold);
        /// <summary>
        /// 开关文本字体
        /// </summary>
        [DefaultValue(typeof(Font), "11pt style=Bold")]
        [Description("开关文本字体")]
        public Font TextFont
        {
            get { return this.textFont; }
            set
            {
                if (this.textFont == value)
                    return;
                this.textFont = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private Color textColor = Color.FromArgb(255, 255, 255);
        /// <summary>
        /// 开关文本颜色
        /// </summary>
        [DefaultValue(typeof(Color), "255, 255, 255")]
        [Description("开关文本颜色")]
        [Editor(typeof(ColorEditorExt), typeof(System.Drawing.Design.UITypeEditor))]
        public Color TextColor
        {
            get { return this.textColor; }
            set
            {
                if (this.textColor == value)
                    return;
                this.textColor = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        private SwitchStatus status = SwitchStatus.OFF;
        /// <summary>
        /// 滑块状态
        /// </summary>
        [DefaultValue(SwitchStatus.OFF)]
        [Description("滑块状态")]
        public SwitchStatus Status
        {
            get { return this.status; }
            set
            {
                if (this.status == value)
                    return;
                this.status = value;
                this.InitializeSwitchLayout();
                this.Invalidate();
            }
        }

        protected override Size DefaultSize
        {
            get
            {
                return new Size(90, 30);
            }
        }

        /// <summary>
        /// 滑块动画组件
        /// </summary>
        private AnimationTimer animationTimer;
        /// <summary>
        /// 滑块信息
        /// </summary>
        private SwitchSlide switchSlide = new SwitchSlide();
        /// <summary>
        /// 动画中
        /// </summary>
        private bool slideing = false;

        #endregion

        public SwitchExt()
        {
            SetStyle(ControlStyles.UserPaint, true);
            SetStyle(ControlStyles.AllPaintingInWmPaint, true);
            SetStyle(ControlStyles.OptimizedDoubleBuffer, true);
            SetStyle(ControlStyles.ResizeRedraw, true);
            SetStyle(ControlStyles.SupportsTransparentBackColor, true);

            InitializeComponent();
            this.InitializeSwitchLayout();

            this.animationTimer = new AnimationTimer(this, new AnimationOptions() { AllTime = 100 });
            this.animationTimer.AnimationIng += new AnimationTimer.AnimationHandel(this.animationTimer_AnimationIng);
            this.animationTimer.AnimationEnding += new AnimationTimer.AnimationHandel(this.animationTimer_AnimationEnding);
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);

            Graphics g = e.Graphics;
            g.SmoothingMode = SmoothingMode.AntiAlias;
            g.TextRenderingHint = TextRenderingHint.AntiAlias;

            Color bc = this.Status == SwitchStatus.ON ? this.BackdropSelectColor : this.BackdropColor;
            Color sc = this.Status == SwitchStatus.ON ? this.SlideSelectColor : this.SlideColor;

            if (this.Type == SwitchType.Flat)
                this.DrawFlat(g, bc, sc);
            else if (this.Type == SwitchType.RoundnessOut)
                this.DrawRoundnessOut(g, bc, sc);
            else if (this.Type == SwitchType.Dot)
                this.DrawDot(g, bc, sc);
            else if (this.Type == SwitchType.Circular)
                this.DrawCircular(g, bc, sc);
            else if (this.Type == SwitchType.RoundnessIn)
                this.DrawRoundnessIn(g, bc, sc);
        }

        protected override void OnClick(EventArgs e)
        {
            base.OnClick(e);
            if (this.slideing)
                this.animationTimer.Stop();
            this.slideing = true;
            this.status = this.Status == SwitchStatus.OFF ? SwitchStatus.ON : SwitchStatus.OFF;
            this.switchSlide.slide_prepare = this.switchSlide.slide_current;
            this.animationTimer.Options.Data = new SwitchData() { slide = this.switchSlide, target_status = this.status };
            this.animationTimer.AT = AnimationType.EaseOut;
            this.animationTimer.Start(true, 0);
        }

        protected override void OnDoubleClick(EventArgs e)
        {
            this.OnClick(e);
        }

        protected override void OnMouseEnter(EventArgs e)
        {
            base.OnMouseEnter(e);
            this.Cursor = Cursors.Hand;
        }

        protected override void OnMouseLeave(EventArgs e)
        {
            base.OnMouseLeave(e);
            this.Cursor = Cursors.Default;
        }

        protected override void OnResize(EventArgs e)
        {
            base.OnResize(e);
            this.InitializeSwitchLayout();
        }

        /// <summary>
        /// 动画进行中
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void animationTimer_AnimationIng(object sender, AnimationEventArgs e)
        {
            SwitchData sd = (SwitchData)e.Data;

            if (sd.target_status == SwitchStatus.ON)
                switchSlide.slide_current.X = (float)(sd.slide.slide_prepare.X + (sd.slide.slide_on.X - sd.slide.slide_prepare.X) * e.progressTime);
            else
                switchSlide.slide_current.X = (float)(sd.slide.slide_prepare.X - (sd.slide.slide_prepare.X - sd.slide.slide_off.X) * e.progressTime);
            if (Type == SwitchType.RoundnessIn)
            {
                if (sd.target_status == SwitchStatus.ON)
                {
                    switchSlide.slide_current.Y = (float)(sd.slide.slide_prepare.Y + (sd.slide.slide_on.Y - sd.slide.slide_prepare.Y) * e.progressTime);
                    switchSlide.slide_current.Width = (float)(switchSlide.slide_prepare.Width + (sd.slide.slide_on.Width - sd.slide.slide_prepare.Width) * e.progressTime);
                    switchSlide.slide_current.Height = switchSlide.slide_current.Width;
                }
                else
                {
                    switchSlide.slide_current.Y = (float)(sd.slide.slide_prepare.Y - (sd.slide.slide_prepare.Y - sd.slide.slide_off.Y) * e.progressTime);
                    switchSlide.slide_current.Width = (float)(switchSlide.slide_prepare.Width - (sd.slide.slide_prepare.Width - sd.slide.slide_off.Width) * e.progressTime);
                    switchSlide.slide_current.Height = switchSlide.slide_current.Width;
                }
            }
            this.Invalidate();
        }

        /// <summary>
        /// 动画结束
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void animationTimer_AnimationEnding(object sender, AnimationEventArgs e)
        {
            this.slideing = false;
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
                if (this.animationTimer != null)
                {
                    this.animationTimer.Dispose();
                }
            }
            base.Dispose(disposing);
        }

        #region

        private void DrawFlat(Graphics g, Color bc, Color sc)
        {
            //背景
            SolidBrush backdrop_sb = new SolidBrush(bc);
            GraphicsPath backdrop_gp = TransformCircular(TransformRectangleF(this.switchSlide.backdrop, this.BackdropBorderThickness), this.Radius);
            g.FillPath(backdrop_sb, backdrop_gp);
            if (this.BackdropBorderThickness > 0)
            {
                Pen backdropBorder_pen = new Pen(this.BackdropBorderColor, this.BackdropBorderThickness);
                g.DrawPath(backdropBorder_pen, backdrop_gp);
                backdropBorder_pen.Dispose();
            }
            backdrop_gp.Dispose();
            backdrop_sb.Dispose();

            TextFormatFlags text_tff = TextFormatFlags.NoPadding | TextFormatFlags.VerticalCenter | TextFormatFlags.HorizontalCenter;
            //开启文本
            if (!String.IsNullOrWhiteSpace(this.OnText))
            {
                Rectangle on_text_rect = new Rectangle((int)this.switchSlide.slide_off.X, (int)this.switchSlide.slide_off.Y, (int)this.switchSlide.slide_off.Width, (int)this.switchSlide.slide_off.Height);
                TextRenderer.DrawText(g, this.OnText, this.TextFont, on_text_rect, this.TextColor, text_tff);
            }
            //关闭文本
            if (!String.IsNullOrWhiteSpace(this.OffText))
            {
                Rectangle off_text_rect = new Rectangle((int)this.switchSlide.slide_on.X, (int)this.switchSlide.slide_on.Y, (int)this.switchSlide.slide_on.Width, (int)this.switchSlide.slide_on.Height);
                TextRenderer.DrawText(g, this.OffText, this.TextFont, off_text_rect, this.TextColor, text_tff);
            }

            //滑块
            SolidBrush slide_sb = new SolidBrush(sc);
            GraphicsPath slide_gp = TransformCircular(TransformRectangleF(this.switchSlide.slide_current, this.SlideBorderThickness), this.Radius);
            g.FillPath(slide_sb, slide_gp);
            if (this.BackdropBorderThickness > 0)
            {
                Pen slideBorder_pen = new Pen(this.SlideBorderColor, this.SlideBorderThickness);
                g.DrawPath(slideBorder_pen, slide_gp);
                slideBorder_pen.Dispose();
            }
            slide_gp.Dispose();
            slide_sb.Dispose();

            //滑块竖线1
            float avg_w = (this.switchSlide.slide_current.Width - this.SlideBorderThickness * 2) / 10;
            float avg_h = (this.switchSlide.slide_current.Height - this.SlideBorderThickness * 2) / 5;
            RectangleF slideline_left_rectf = new RectangleF();
            slideline_left_rectf.Width = avg_w;
            slideline_left_rectf.Height = avg_h * 3;
            slideline_left_rectf.X = this.switchSlide.slide_current.X + this.SlideBorderThickness + avg_w * 3;
            slideline_left_rectf.Y = this.switchSlide.slide_current.Y + this.SlideBorderThickness + avg_h;

            RectangleF slideline_right_rectf = new RectangleF();
            slideline_right_rectf.Width = avg_w;
            slideline_right_rectf.Height = avg_h * 3;
            slideline_right_rectf.X = slideline_left_rectf.Right + avg_w * 2;
            slideline_right_rectf.Y = slideline_left_rectf.Y;

            SolidBrush text_sb = new SolidBrush(bc);
            g.FillRectangle(text_sb, slideline_left_rectf);
            g.FillRectangle(text_sb, slideline_right_rectf);
            text_sb.Dispose();
        }

        private void DrawRoundnessIn(Graphics g, Color bc, Color sc)
        {
            //背景
            SolidBrush backdrop_sb = new SolidBrush(bc);
            RectangleF tmp = new RectangleF(this.switchSlide.backdrop.X, this.switchSlide.backdrop.Y, this.switchSlide.backdrop.Width - 1, this.switchSlide.backdrop.Height - 1);
            GraphicsPath backdrop_gp = TransformCircular(tmp, (int)(tmp.Height / 2));
            g.FillPath(backdrop_sb, backdrop_gp);
            backdrop_gp.Dispose();
            backdrop_sb.Dispose();

            //滑块
            SolidBrush slide_sb = new SolidBrush(sc);
            RectangleF slide_tmp = new RectangleF(this.switchSlide.slide_current.X, this.switchSlide.slide_current.Y, this.switchSlide.slide_current.Width - 1, this.switchSlide.slide_current.Height - 1);
            GraphicsPath slide_gp = TransformCircular(slide_tmp, (int)(slide_tmp.Height / 2));
            g.FillPath(slide_sb, slide_gp);
            slide_gp.Dispose();
            slide_sb.Dispose();
        }

        private void DrawRoundnessOut(Graphics g, Color bc, Color sc)
        {
            //背景
            SolidBrush backdrop_sb = new SolidBrush(bc);
            RectangleF backdrop_rectf = TransformRectangleF(this.switchSlide.backdrop, this.BackdropBorderThickness);
            GraphicsPath backdrop_gp = TransformCircular(backdrop_rectf, (int)(backdrop_rectf.Height / 2));
            g.FillPath(backdrop_sb, backdrop_gp);
            if (this.BackdropBorderThickness > 0)
            {
                Pen backdropBorder_pen = new Pen(this.BackdropBorderColor, this.BackdropBorderThickness);
                g.DrawPath(backdropBorder_pen, backdrop_gp);
                backdropBorder_pen.Dispose();
            }
            backdrop_gp.Dispose();
            backdrop_sb.Dispose();

            TextFormatFlags text_tff = TextFormatFlags.NoPadding | TextFormatFlags.VerticalCenter | TextFormatFlags.HorizontalCenter;
            //开启文本
            if (!String.IsNullOrWhiteSpace(this.OnText))
            {
                Rectangle on_text_rect = new Rectangle((int)this.switchSlide.slide_off.X, (int)this.switchSlide.slide_off.Y, (int)this.switchSlide.slide_off.Width, (int)this.switchSlide.slide_off.Height);
                TextRenderer.DrawText(g, this.OnText, this.TextFont, on_text_rect, this.TextColor, text_tff);
            }
            //关闭文本 
            if (!String.IsNullOrWhiteSpace(this.OffText))
            {
                Rectangle off_text_rect = new Rectangle((int)this.switchSlide.slide_on.X, (int)this.switchSlide.slide_on.Y, (int)this.switchSlide.slide_on.Width, (int)this.switchSlide.slide_on.Height);
                TextRenderer.DrawText(g, this.OffText, this.TextFont, off_text_rect, this.TextColor, text_tff);
            }

            //滑块
            SolidBrush slide_sb = new SolidBrush(sc);
            RectangleF tmp = new RectangleF(this.switchSlide.slide_current.X, this.switchSlide.slide_current.Y, this.switchSlide.slide_current.Width - 1, this.switchSlide.slide_current.Height - 1);
            RectangleF slide_current_rectf = TransformRectangleF(tmp, this.SlideBorderThickness);
            GraphicsPath slide_gp = TransformCircular(slide_current_rectf, (int)(slide_current_rectf.Height / 2));
            g.FillPath(slide_sb, slide_gp);
            if (this.SlideBorderThickness > 0)
            {
                Pen slideBorder_pen = new Pen(this.SlideBorderColor, this.SlideBorderThickness);
                g.DrawPath(slideBorder_pen, slide_gp);
                slideBorder_pen.Dispose();
            }
            slide_gp.Dispose();
            slide_sb.Dispose();
        }

        private void DrawDot(Graphics g, Color bc, Color sc)
        {
            //背景
            SolidBrush backdrop_sb = new SolidBrush(bc);
            RectangleF backdrop_rectf = TransformRectangleF(this.switchSlide.backdrop, this.BackdropBorderThickness);
            GraphicsPath backdrop_gp = TransformCircular(backdrop_rectf, (int)(backdrop_rectf.Height / 2));
            g.FillPath(backdrop_sb, backdrop_gp);
            if (this.BackdropBorderThickness > 0)
            {
                Pen backdropBorder_pen = new Pen(this.BackdropBorderColor, this.BackdropBorderThickness);
                g.DrawPath(backdropBorder_pen, backdrop_gp);
                backdropBorder_pen.Dispose();
            }
            backdrop_gp.Dispose();
            backdrop_sb.Dispose();

            //滑块
            SolidBrush slide_sb = new SolidBrush(sc);
            RectangleF tmp = new RectangleF(this.switchSlide.slide_current.X, this.switchSlide.slide_current.Y, this.switchSlide.slide_current.Width - 1, this.switchSlide.slide_current.Height - 1);
            RectangleF slide_current_rectf = TransformRectangleF(tmp, this.SlideBorderThickness);
            GraphicsPath slide_gp = TransformCircular(slide_current_rectf, (int)(slide_current_rectf.Height / 2));
            g.FillPath(slide_sb, slide_gp);
            if (this.SlideBorderThickness > 0)
            {
                Pen slideBorder_pen = new Pen(this.SlideBorderColor, this.SlideBorderThickness);
                g.DrawPath(slideBorder_pen, slide_gp);
                slideBorder_pen.Dispose();
            }
            slide_gp.Dispose();
            slide_sb.Dispose();
        }

        private void DrawCircular(Graphics g, Color bc, Color sc)
        {
            //背景
            float padding = this.switchSlide.backdrop.Height / 8;
            SolidBrush backdrop_sb = new SolidBrush(bc);
            RectangleF tmp = new RectangleF(this.switchSlide.backdrop.X, this.switchSlide.backdrop.Y, this.switchSlide.backdrop.Width - 1, this.switchSlide.backdrop.Height - 1);
            RectangleF backdrop_rectf = TransformRectangleF(tmp, (int)padding);
            GraphicsPath backdrop_gp = TransformCircular(backdrop_rectf, (int)(backdrop_rectf.Height / 2));
            g.FillPath(backdrop_sb, backdrop_gp);

            Pen backdropBorder_pen = new Pen(this.BackdropBorderColor, padding);
            g.DrawPath(backdropBorder_pen, backdrop_gp);
            backdrop_sb.Dispose();
            backdropBorder_pen.Dispose();
            backdrop_gp.Dispose();

            //滑块
            SolidBrush slide_sb = new SolidBrush(sc);
            RectangleF slide_tmp = new RectangleF(this.switchSlide.slide_current.X, this.switchSlide.slide_current.Y, this.switchSlide.slide_current.Width - 1, this.switchSlide.slide_current.Height - 1);
            g.FillEllipse(slide_sb, slide_tmp);
            slide_sb.Dispose();
        }

        /// <summary>
        /// 初始化开关按钮布局
        /// </summary>
        private void InitializeSwitchLayout()
        {
            RectangleF rectf = this.ClientRectangle;
            #region Flat
            if (this.Type == SwitchType.Flat)
            {
                int padding = 3;

                this.switchSlide.backdrop.Width = rectf.Width;
                this.switchSlide.backdrop.Height = rectf.Height;
                this.switchSlide.backdrop.X = rectf.X;
                this.switchSlide.backdrop.Y = rectf.Y;

                this.switchSlide.slide_off.Width = (this.switchSlide.backdrop.Width - this.BackdropBorderThickness * 2) / 2 - padding * 2;
                this.switchSlide.slide_off.Height = this.switchSlide.backdrop.Height - this.BackdropBorderThickness * 2 - padding * 2;
                this.switchSlide.slide_off.Y = this.switchSlide.backdrop.Y + this.BackdropBorderThickness + padding;
                this.switchSlide.slide_off.X = this.switchSlide.backdrop.X + this.BackdropBorderThickness + padding;

                this.switchSlide.slide_on.Width = this.switchSlide.slide_off.Width;
                this.switchSlide.slide_on.Height = this.switchSlide.slide_off.Height;
                this.switchSlide.slide_on.Y = this.switchSlide.slide_off.Y;
                this.switchSlide.slide_on.X = this.switchSlide.backdrop.Right - this.BackdropBorderThickness - padding - this.switchSlide.slide_on.Width;
            }
            #endregion
            #region RoundnessIn
            else if (this.Type == SwitchType.RoundnessIn)
            {
                float padding = 4;

                this.switchSlide.backdrop.Width = rectf.Width;
                this.switchSlide.backdrop.Height = rectf.Height;
                this.switchSlide.backdrop.X = rectf.X;
                this.switchSlide.backdrop.Y = rectf.Y;

                this.switchSlide.slide_off.Width = rectf.Height;
                this.switchSlide.slide_off.Height = rectf.Height;
                this.switchSlide.slide_off.Y = this.ClientRectangle.Y;
                this.switchSlide.slide_off.X = this.ClientRectangle.X;

                this.switchSlide.slide_on.Width = this.switchSlide.slide_off.Width - padding * 2;
                this.switchSlide.slide_on.Height = this.switchSlide.slide_on.Width;
                this.switchSlide.slide_on.Y = this.ClientRectangle.Y + padding;
                this.switchSlide.slide_on.X = rectf.Right - padding - this.switchSlide.slide_on.Width;
            }
            #endregion
            #region RoundnessOut
            else if (this.Type == SwitchType.RoundnessOut)
            {
                int padding = 5;

                this.switchSlide.backdrop.Width = rectf.Width - padding * 2;
                this.switchSlide.backdrop.Height = rectf.Height - padding * 2;
                this.switchSlide.backdrop.X = rectf.X + padding;
                this.switchSlide.backdrop.Y = rectf.Y + padding;

                this.switchSlide.slide_off.Width = rectf.Height;
                this.switchSlide.slide_off.Height = rectf.Height;
                this.switchSlide.slide_off.Y = rectf.Y;
                this.switchSlide.slide_off.X = rectf.X;

                this.switchSlide.slide_on.Width = this.switchSlide.slide_off.Width;
                this.switchSlide.slide_on.Height = this.switchSlide.slide_off.Height;
                this.switchSlide.slide_on.Y = this.switchSlide.slide_off.Y;
                this.switchSlide.slide_on.X = rectf.Right - this.switchSlide.slide_on.Width;
            }
            #endregion
            #region Dot
            else if (this.Type == SwitchType.Dot)
            {
                float padding = 2;
                this.switchSlide.backdrop.Width = rectf.Width - padding * 2;
                this.switchSlide.backdrop.Height = rectf.Height / 5;
                this.switchSlide.backdrop.X = rectf.X + padding;
                this.switchSlide.backdrop.Y = rectf.Y + (rectf.Height - this.switchSlide.backdrop.Height) / 2;

                this.switchSlide.slide_off.Width = rectf.Height;
                this.switchSlide.slide_off.Height = rectf.Height;
                this.switchSlide.slide_off.Y = this.ClientRectangle.Y;
                this.switchSlide.slide_off.X = this.ClientRectangle.X;

                this.switchSlide.slide_on.Width = this.switchSlide.slide_off.Width;
                this.switchSlide.slide_on.Height = this.switchSlide.slide_on.Width;
                this.switchSlide.slide_on.Y = this.switchSlide.slide_off.Y;
                this.switchSlide.slide_on.X = rectf.Right - this.switchSlide.slide_on.Width;
            }
            #endregion
            #region Circular
            else if (this.Type == SwitchType.Circular)
            {
                float padding = rectf.Height / 8;

                this.switchSlide.backdrop.Width = rectf.Width;
                this.switchSlide.backdrop.Height = rectf.Height;
                this.switchSlide.backdrop.X = rectf.X;
                this.switchSlide.backdrop.Y = rectf.Y;

                this.switchSlide.slide_off.Width = padding * 4;
                this.switchSlide.slide_off.Height = padding * 4;
                this.switchSlide.slide_off.Y = rectf.Y + padding * 2;
                this.switchSlide.slide_off.X = rectf.X + padding * 2;

                this.switchSlide.slide_on.Width = this.switchSlide.slide_off.Width;
                this.switchSlide.slide_on.Height = this.switchSlide.slide_on.Width;
                this.switchSlide.slide_on.Y = this.switchSlide.slide_off.Y;
                this.switchSlide.slide_on.X = rectf.Right - padding * 2 - this.switchSlide.slide_on.Width;
            }
            #endregion
            this.switchSlide.slide_current = this.Status == SwitchStatus.OFF ? this.switchSlide.slide_off : this.switchSlide.slide_on;
        }

        /// <summary>
        /// 根据画笔大小转换rectf
        /// </summary>
        /// <param name="rectf">要转换的rectf</param>
        /// <param name="pen">画笔大小大小</param>
        /// <returns></returns>
        private static RectangleF TransformRectangleF(RectangleF rectf, int pen)
        {
            RectangleF result = new RectangleF();
            result.Width = rectf.Width - (pen < 1 ? 0 : pen);
            result.Height = rectf.Height - (pen < 1 ? 0 : pen);
            result.X = rectf.X + (float)(pen / 2);
            result.Y = rectf.Y + (float)(pen / 2);
            return result;
        }

        /// <summary>
        /// 转换成圆角
        /// </summary>
        /// <param name="rectf">要转换的rectf</param>
        /// <param name="radius">圆角半径的大小</param>
        /// <returns></returns>
        private static GraphicsPath TransformCircular(RectangleF rectf, int radius = 0)
        {
            return TransformCircular(rectf, radius, radius, radius, radius);
        }

        /// <summary>
        /// 转换成圆角
        /// </summary>
        /// <param name="rectf">要转换的rectf</param>
        /// <param name="leftTopRadius">左上角</param>
        /// <param name="rightTopRadius">右上角</param>
        /// <param name="rightBottomRadius">右下角</param>
        /// <param name="leftBottomRadius">左下角</param>
        /// <returns></returns>
        private static GraphicsPath TransformCircular(RectangleF rectf, int leftTopRadius = 0, int rightTopRadius = 0, int rightBottomRadius = 0, int leftBottomRadius = 0)
        {
            GraphicsPath gp = new GraphicsPath();
            if (leftTopRadius > 0)
            {
                RectangleF lefttop_rect = new RectangleF(rectf.X, rectf.Y, leftTopRadius * 2, leftTopRadius * 2);
                gp.AddArc(lefttop_rect, 180, 90);
            }
            else
            {
                gp.AddLine(new PointF(rectf.X, rectf.Y), new PointF(rightTopRadius > 0 ? rectf.Right - rightTopRadius * 2 : rectf.Right, rectf.Y));
            }
            if (rightTopRadius > 0)
            {
                RectangleF righttop_rect = new RectangleF(rectf.Right - rightTopRadius * 2, rectf.Y, rightTopRadius * 2, rightTopRadius * 2);
                gp.AddArc(righttop_rect, 270, 90);
            }
            else
            {
                gp.AddLine(new PointF(rectf.Right, rectf.Y), new PointF(rectf.Right, rightBottomRadius > 0 ? rectf.Bottom - rightTopRadius * 2 : rectf.Bottom));
            }
            if (rightBottomRadius > 0)
            {
                RectangleF rightbottom_rect = new RectangleF(rectf.Right - rightTopRadius * 2, rectf.Bottom - rightTopRadius * 2, rightBottomRadius * 2, rightBottomRadius * 2);
                gp.AddArc(rightbottom_rect, 0, 90);
            }
            else
            {
                gp.AddLine(new PointF(rectf.Right, rectf.Bottom), new PointF(leftBottomRadius > 0 ? leftBottomRadius * 2 : rectf.X, rectf.Bottom));
            }
            if (leftBottomRadius > 0)
            {
                RectangleF rightbottom_rect = new RectangleF(rectf.X, rectf.Bottom - leftBottomRadius * 2, leftBottomRadius * 2, leftBottomRadius * 2);
                gp.AddArc(rightbottom_rect, 90, 90);
            }
            else
            {
                gp.AddLine(new PointF(rectf.X, rectf.Bottom), new PointF(rectf.X, leftTopRadius > 0 ? rectf.X + leftTopRadius * 2 : rectf.X));
            }
            gp.CloseAllFigures();
            return gp;
        }

        #endregion

        /// <summary>
        /// 滑块信息
        /// </summary>
        [Description("开关动画事件参数")]
        public class SwitchSlide
        {
            /// <summary>
            ///滑块背景 
            /// </summary>
            [Description("滑块背景")]
            public RectangleF backdrop;
            /// <summary>
            /// 滑块关闭rect
            /// </summary>
            [Description("滑块关闭rect")]
            public RectangleF slide_off;
            /// <summary>
            /// 滑块开启rect
            /// </summary>
            [Description("滑块开启rect")]
            public RectangleF slide_on;
            /// <summary>
            /// 滑块当前rect
            /// </summary>
            [Description("滑块当前rect")]
            public RectangleF slide_current;
            /// <summary>
            /// 滑块动画前rect
            /// </summary>
            [Description("滑块动画前rect")]
            public RectangleF slide_prepare;
        }

        /// <summary>
        /// 开关动画事件参数
        /// </summary>
        [Description("开关动画事件参数")]
        public class SwitchData
        {
            /// <summary>
            /// 滑块信息
            /// </summary>
            [Description("滑块信息")]
            public SwitchSlide slide;
            /// <summary>
            /// 动画要切换的状态
            /// </summary>
            [Description("动画要切换的状态")]
            public SwitchStatus target_status;
        }

        /// <summary>
        /// 开关类型
        /// </summary>
        [Description("开关类型")]
        public enum SwitchType
        {
            /// <summary>
            /// 四边
            /// </summary>
            Flat,
            /// <summary>
            /// 内圆
            /// </summary>
            RoundnessIn,
            /// <summary>
            /// 外圆
            /// </summary>
            RoundnessOut,
            /// <summary>
            /// 圆点
            /// </summary>
            Dot,
            /// <summary>
            /// 环形
            /// </summary>
            Circular
        }

        /// <summary>
        /// 开关状态
        /// </summary>
        [Description("开关状态")]
        public enum SwitchStatus
        {
            /// <summary>
            /// 已开启
            /// </summary>
            ON,
            /// <summary>
            /// 已关闭
            /// </summary>
            OFF

        }
    }
}
