using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace core_fw_spring_express.widgetX.switchX
{
  [Category("动画")]
  [TypeConverter(typeof(EmptyExpandableObjectConverter))]
  public class AnimationTimer : IDisposable
  {
    public delegate void AnimationHandel(object sender, AnimationEventArgs e);

    private event AnimationHandel animationStart = null;
    /// <summary>
    /// 动画开始前事件
    /// </summary>
    [Description("动画开始前事件")]
    public event AnimationHandel AnimationStart
    {
      add { this.animationStart += value; }
      remove { this.animationStart -= value; }
    }

    private event AnimationHandel animationIng = null;
    /// <summary>
    /// 动画时间间隔发生事件
    /// </summary>
    [Description("动画时间间隔发生事件")]
    public event AnimationHandel AnimationIng
    {
      add { this.animationIng += value; }
      remove { this.animationIng -= value; }
    }

    private event AnimationHandel animationEnding = null;
    /// <summary>
    /// 动画结束时事件
    /// </summary>
    [Description("动画结束时事件")]
    public event AnimationHandel AnimationEnding
    {
      add { this.animationEnding += value; }
      remove { this.animationEnding -= value; }
    }

    private event AnimationHandel animationRepetitioning = null;
    /// <summary>
    /// 动画重复间隔时事件
    /// </summary>
    [Description("动画重复间隔时事件")]
    public event AnimationHandel AnimationRepetitioning
    {
      add { this.animationRepetitioning += value; }
      remove { this.animationRepetitioning -= value; }
    }

    public AnimationType at = AnimationType.EaseIn;
    /// <summary>
    /// 动画类型(默认值EaseIn)
    /// </summary>
    [Description("动画类型")]
    [DefaultValue(AnimationType.EaseIn)]
    public AnimationType AT
    {
      get { return this.at; }
      set { this.at = value; }
    }

    private AnimationOptions options;
    /// <summary>
    /// 动画设置参数
    /// </summary>
    [Description("动画设置参数")]
    public AnimationOptions Options
    {
      get { return this.options; }
      set { this.options = value; }
    }

    private int interval = 20;
    /// <summary>
    /// 动画定时器时间间隔(默认值20毫秒)
    /// </summary>
    [Description("动画定时器时间间隔")]
    [DefaultValue(20)]
    public int Interval
    {
      get { return this.interval; }
      set
      {
        this.interval = value;
        if (this.time != null)
          this.time.Interval = this.interval;
      }
    }

    private double usedTime = 0.0;
    /// <summary>
    /// 已进行动画时间(默认值0.0毫秒)
    /// </summary>
    [Description("已进行动画时间(默认值0.0毫秒)")]
    [Browsable(false)]
    [DefaultValue(0.0)]
    public double UsedTime
    {
      get { return this.usedTime; }
      set { this.usedTime = value; }
    }

    private bool disposed = false;
    private System.Windows.Forms.Control _control = null;
    private System.Windows.Forms.Timer time = null;
    private double runTime = 0.0;

    /// <summary>
    /// 添加还是减少动画时间间隔(决定动画方向)
    /// </summary>
    private bool isadd = true;

    /// <summary>
    /// 
    /// </summary>
    /// <param name="control">要变化动画的控件</param>
    /// <param name="options">动画配置</param>
    public AnimationTimer(System.Windows.Forms.Control control, AnimationOptions options)
    {
      this._control = control;
      this.options = options;
    }

    /// <summary>
    /// 定时更新动画
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    public void time_Tick(object sender, EventArgs e)
    {
      if (this.isadd)
        this.runTime += this.time.Interval;
      else
        this.runTime -= this.time.Interval;

      if ((this.runTime >= 0 && this.runTime < this.options.AllTime) || this.options.AlwaysExercise)
      {
        if (this.animationIng != null)
        {
          this.usedTime = this.runTime;
          this.animationIng.Invoke(this._control, new AnimationEventArgs() { Data = this.options.Data, Transform = this.options.Transform, UsedTime = this.runTime, progressTime = getprogressTime(this.AT, this.options, this.runTime) });
        }
      }
      else
      {
        if (this.animationIng != null)//保证最后一次百分百变化
        {
          this.usedTime = this.runTime < 0 ? 0.0 : this.options.AllTime;
          this.animationIng.Invoke(this._control, new AnimationEventArgs() { Data = this.options.Data, Transform = this.options.Transform, UsedTime = this.runTime, progressTime = getprogressTime(this.AT, this.options, this.runTime) });
        }

        if (this.options.AlwaysRepetitionExercise)
        {
          this.runTime = 0.0;
          if (this.animationRepetitioning != null)
          {
            this.animationRepetitioning.Invoke(this._control, new AnimationEventArgs() { Data = this.options.Data, Transform = this.options.Transform, UsedTime = this.runTime, progressTime = getprogressTime(this.AT, this.options, this.runTime) });
          }
        }
        else
        {
          this.Stop();
          if (this.animationEnding != null)
          {
            this.usedTime = this.runTime < 0 ? 0.0 : this.options.AllTime;
            this.animationEnding.Invoke(this._control, new AnimationEventArgs() { Data = this.options.Data, Transform = this.options.Transform, UsedTime = this.usedTime, progressTime = this.runTime < 0 ? 0.0 : 1.0 });
          }
        }
      }
    }

    /// <summary>
    /// 动画开始
    /// </summary>
    /// <param name="_isadd">添加还是减少动画时间间隔(决定动画方向)</param>
    /// <param name="_usedTime">已进行动画时间</param>
    public void Start(bool _isadd, double _usedTime)
    {
      this.isadd = _isadd;
      this.Stop();
      this.runTime = _usedTime;
      if (this.animationStart != null)
      {
        this.animationStart.Invoke(this._control, new AnimationEventArgs() { Data = this.options.Data, Transform = this.options.Transform, UsedTime = this.runTime, progressTime = getprogressTime(this.AT, this.options, this.runTime) });
      }
      this.time = new System.Windows.Forms.Timer();
      this.time.Tick += new EventHandler(this.time_Tick);
      this.time.Interval = this.interval;
      this.time.Start();
    }

    /// <summary>
    /// 动画停止
    /// </summary>
    public void Stop()
    {
      if (this.time != null)
      {
        this.time.Stop();
        this.time.Dispose();
      }
    }

    /// <summary>
    /// 获取动画变化值的进度（0.0-1.0）
    /// </summary>
    /// <param name="type">动画类型</param>
    /// <param name="options">动画参数</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <returns></returns>
    private double getprogressTime(AnimationType type, AnimationOptions options, double usedTime)
    {
      switch (type)
      {
        case AnimationType.UniformMotion:
          return AnimationCore.UniformMotionCore(usedTime, options.AllTime);
        case AnimationType.EaseIn:
          return AnimationCore.EaseInCore(usedTime / options.AllTime, options.Power);
        case AnimationType.EaseOut:
          return AnimationCore.EaseOutCore(usedTime / options.AllTime, options.Power);
        case AnimationType.EaseBoth:
          return AnimationCore.EaseBothCore(usedTime / options.AllTime, options.Power);
        case AnimationType.BackIn:
          return AnimationCore.BackInCore(usedTime / options.AllTime, options.Power, options.Amplitude);
        case AnimationType.BackOut:
          return AnimationCore.BackOutCore(usedTime / options.AllTime, options.Power, options.Amplitude);
        case AnimationType.BackBoth:
          return AnimationCore.BackBothCore(usedTime / options.AllTime, options.Power, options.Amplitude);
        case AnimationType.BounceIn:
          return AnimationCore.BounceInCore(usedTime / options.AllTime, options.Bounces, options.Bounciness);
        case AnimationType.BounceOut:
          return AnimationCore.BounceOutCore(usedTime / options.AllTime, options.Bounces, options.Bounciness);
        case AnimationType.BounceBoth:
          return AnimationCore.BounceBothCore(usedTime / options.AllTime, options.Bounces, options.Bounciness);
        case AnimationType.ElasticIn:
          return AnimationCore.ElasticInCore(usedTime / options.AllTime, options.Oscillations, options.Springiness);
        case AnimationType.ElasticOut:
          return AnimationCore.ElasticOutCore(usedTime / options.AllTime, options.Oscillations, options.Springiness);
        case AnimationType.ElasticBoth:
          return AnimationCore.ElasticBothCore(usedTime / options.AllTime, options.Oscillations, options.Springiness);
        case AnimationType.QuadraticIn:
          return AnimationCore.QuadraticInCore(usedTime / options.AllTime);
        case AnimationType.QuadraticOut:
          return AnimationCore.QuadraticOutCore(usedTime / options.AllTime);
        default:
          return 0.0;
      }
    }

    ~AnimationTimer()
    {
      this.Dispose(false);
    }

    public void Dispose()
    {
      this.Dispose(true);
      GC.SuppressFinalize((object)this);
    }

    protected virtual void Dispose(bool disposing)
    {
      if (this.disposed)
        return;
      if (disposing)
      {
        if (this.time != null)
        {
          this.time.Dispose();
          this.time = (System.Windows.Forms.Timer)null;
        }
      }
      this.disposed = true;
    }

  }

  /// <summary>
  /// 动画参数设置
  /// </summary>
  [Description("动画参数设置")]
  [TypeConverter(typeof(EmptyExpandableObjectConverter))]
  public class AnimationOptions
  {
    private object data = null;
    /// <summary>
    /// 自定义参数
    /// </summary>
    [Description("自定义参数")]
    [Browsable(false)]
    public object Data
    {
      get { return this.data; }
      set { this.data = value; }
    }

    private double transform = 10.0;
    /// <summary>
    /// 动画对象开始制定属性变化值(默认值10.0)
    /// </summary>
    [Description("动画对象开始制定属性变化值")]
    [DefaultValue(10.0)]
    public double Transform
    {
      get { return this.transform; }
      set { this.transform = value; }
    }

    private double allTime = 300.0;
    /// <summary>
    /// 总动画时间
    /// </summary>
    [Description("总动画时间")]
    [DefaultValue(300.0)]
    public double AllTime
    {
      get { return this.allTime; }
      set { this.allTime = value; }
    }

    private bool alwaysExercise = false;
    /// <summary>
    /// 是否为永久动画
    /// </summary>
    [Description("是否为永久动画")]
    [DefaultValue(false)]
    public bool AlwaysExercise
    {
      get { return this.alwaysExercise; }
      set { this.alwaysExercise = value; }
    }

    private bool alwaysRepetitionExercise = false;
    /// <summary>
    /// 是否为永久重复动画
    /// </summary>
    [Description("是否为永久重复动画")]
    [DefaultValue(false)]
    public bool AlwaysRepetitionExercise
    {
      get { return this.alwaysRepetitionExercise; }
      set { this.alwaysRepetitionExercise = value; }
    }

    private double power = 3.0;
    /// <summary>
    /// 动画曲线幂(默认值3.0)
    /// </summary>
    [Description("动画曲线幂(默认值3)")]
    [DefaultValue(3.0)]
    public double Power
    {
      get { return this.power; }
      set { this.power = value; }
    }

    private double amplitude = 1.0;
    /// <summary>
    /// 收缩与相关联的幅度动画。此值必须大于或等于 0。 默认值为 1.0。
    /// </summary>
    [Description("收缩与相关联的幅度动画。此值必须大于或等于 0。 默认值为 1.0")]
    [DefaultValue(1.0)]
    public double Amplitude
    {
      get { return this.amplitude; }
      set { this.amplitude = value; }
    }

    private int bounces = 3;
    /// <summary>
    /// 反弹次数。值必须大于或等于零(默认值为3)
    /// </summary>
    [Description("反弹次数。值必须大于或等于零(默认值为3)")]
    [DefaultValue(3)]
    public int Bounces
    {
      get { return this.bounces; }
      set { this.bounces = value; }
    }

    private double bounciness = 2.0;
    /// <summary>
    /// 指定反弹动画的弹性大小。虽然较高的值都会导致反弹 （弹性较小），此属性中的结果很少或者反弹低值会丢失反弹 （弹性较大） 之间的高度。此值必须是正数(默认值为 2.0)
    /// </summary>
    [Description("指定反弹动画的弹性大小。虽然较高的值都会导致反弹 （弹性较小），此属性中的结果很少或者反弹低值会丢失反弹 （弹性较大） 之间的高度。此值必须是正数(默认值为 2.0)")]
    [DefaultValue(2.0)]
    public double Bounciness
    {
      get { return this.bounciness; }
      set { this.bounciness = value; }
    }

    private int oscillations = 3;
    /// <summary>
    /// 目标来回滑过动画目标的次数。此值必须大于或等于0 (默认值为3)
    /// </summary>
    [Description("目标来回滑过动画目标的次数。此值必须大于或等于0 (默认值为3)")]
    [DefaultValue(3)]
    public int Oscillations
    {
      get { return this.oscillations; }
      set { this.oscillations = value; }
    }

    private double springiness = 3.0;
    /// <summary>
    /// 弹簧铡度。 越小的 Springiness 值为，严格 spring，通过每个振动的强度减小的速度越快弹性。一个正数(默认值为3.0)
    /// </summary>
    [Description("弹簧铡度。 越小的 Springiness 值为，严格 spring，通过每个振动的强度减小的速度越快弹性。一个正数(默认值为3.0)")]
    [DefaultValue(3.0)]
    public double Springiness
    {
      get { return this.springiness; }
      set { this.springiness = value; }
    }

  }

  /// <summary>
  /// 动画事件数据
  /// </summary>
  [Description("动画事件数据")]
  public class AnimationEventArgs
  {
    /// <summary>
    /// 自定义参数
    /// </summary>
    public object Data { get; set; }
    /// <summary>
    /// 动画对象开始制定属性变化值
    /// </summary>
    public double Transform { get; set; }
    /// <summary>
    /// 已进行动画时间
    /// </summary>
    public double UsedTime { get; set; }
    /// <summary>
    /// 动画变化值的进度（0.0-1.0）
    /// </summary>
    public double progressTime { get; set; }
  }
}
