﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace core_fw_spring_express.widgetX.switchX
{
  /// <summary>
  /// 线性动画函数
  /// </summary>
  [Description("线性动画函数")]
  public static class AnimationCore
  {
    #region UniformMotion

    /// <summary>
    ///  匀速
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <returns></returns>
    public static double UniformMotion(double origin, double transform, double usedTime, double allTime)
    {
      return origin + transform * UniformMotionCore(usedTime, allTime);
    }
    /// <summary>
    /// 匀速
    /// </summary>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <returns></returns>
    public static double UniformMotionCore(double usedTime, double allTime)
    {
      return usedTime / allTime;
    }

    #endregion

    #region Ease

    /// <summary>
    /// 变速
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <param name="power">动画曲线幂(默认值2)</param>
    /// <returns></returns>
    public static double EaseIn(double origin, double transform, double usedTime, double allTime, double power)
    {
      return origin + transform * EaseInCore(usedTime / allTime, power);
    }
    /// <summary>
    /// 变速
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <param name="power">动画曲线幂(默认值2)</param>
    /// <returns></returns>
    public static double EaseInCore(double progressTime, double power)
    {
      power = Math.Max(0.0, power);
      return Math.Pow(progressTime, power);
    }
    /// <summary>
    /// 变速
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <param name="power">动画曲线幂(默认值2)</param>
    /// <returns></returns>
    public static double EaseOut(double origin, double transform, double usedTime, double allTime, double power)
    {
      return origin + transform * (EaseOutCore(usedTime / allTime, power));
    }
    /// <summary>
    /// 变速
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <param name="power">动画曲线幂(默认值2)</param>
    /// <returns></returns>    
    public static double EaseOutCore(double progressTime, double power)
    {
      return 1.0 - EaseInCore(1.0 - progressTime, power);
    }
    /// <summary>
    /// 变速
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <param name="power">动画曲线幂(默认值2)</param>
    /// <returns></returns>
    public static double EaseBoth(double origin, double transform, double usedTime, double allTime, double power)
    {
      return origin + transform * EaseBothCore(usedTime / allTime, power);
    }
    /// <summary>
    /// 变速
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <param name="power">动画曲线幂(默认值2)</param>
    /// <returns></returns>
    public static double EaseBothCore(double progressTime, double power)
    {
      if (progressTime >= 0.5)
        return (1.0 - EaseInCore((1.0 - progressTime) * 2.0, power)) * 0.5 + 0.5;
      return EaseInCore(progressTime * 2.0, power) * 0.5;
    }

    #endregion

    #region Back

    /// <summary>
    /// 收缩
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <param name="power">动画曲线幂(默认值3)</param>
    /// <param name="amplitude">收缩与相关联的幅度动画。此值必须大于或等于 0。 默认值为 1。</param>
    /// <returns></returns>
    public static double BackIn(double origin, double transform, double usedTime, double allTime, double power, double amplitude)
    {
      return origin + transform * BackInCore((usedTime / allTime), power, amplitude);
    }
    /// <summary>
    /// 收缩
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <param name="power">动画曲线幂(默认值3)</param>
    /// <param name="amplitude">收缩与相关联的幅度动画。此值必须大于或等于 0。 默认值为 1。</param>
    /// <returns></returns>
    public static double BackInCore(double progressTime, double power, double amplitude)
    {
      amplitude = Math.Max(0.0, amplitude);
      return Math.Pow(progressTime, power) - progressTime * amplitude * Math.Sin(Math.PI * progressTime);
    }
    /// <summary>
    /// 收缩
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <param name="power">动画曲线幂(默认值3)</param>
    /// <param name="amplitude">收缩与相关联的幅度动画。此值必须大于或等于 0。 默认值为 1。</param>
    /// <returns></returns>
    public static double BackOut(double origin, double transform, double usedTime, double allTime, double power, double amplitude)
    {
      return origin + transform * BackOutCore((usedTime / allTime), power, amplitude);
    }
    /// <summary>
    /// 收缩
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <param name="power">动画曲线幂(默认值3)</param>
    /// <param name="amplitude">收缩与相关联的幅度动画。此值必须大于或等于 0。 默认值为 1。</param>
    /// <returns></returns>
    public static double BackOutCore(double progressTime, double power, double amplitude)
    {
      return 1.0 - BackInCore(1.0 - progressTime, power, amplitude);
    }
    /// <summary>
    /// 收缩
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <param name="power">动画曲线幂(默认值3)</param>
    /// <param name="amplitude">收缩与相关联的幅度动画。此值必须大于或等于 0。 默认值为 1。</param>
    /// <returns></returns>
    public static double BackBoth(double origin, double transform, double usedTime, double allTime, double power, double amplitude)
    {
      return origin + transform * BackBothCore(usedTime / allTime, power, amplitude);
    }
    /// <summary>
    /// 收缩
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <param name="power">动画曲线幂(默认值3)</param>
    /// <param name="amplitude">收缩与相关联的幅度动画。此值必须大于或等于 0。 默认值为 1。</param>
    /// <returns></returns>
    public static double BackBothCore(double progressTime, double power, double amplitude)
    {
      if (progressTime >= 0.5)
        return (1.0 - BackInCore((1.0 - progressTime) * 2.0, power, amplitude)) * 0.5 + 0.5;
      return BackInCore(progressTime * 2.0, power, amplitude) * 0.5;
    }

    #endregion

    #region Bounce

    /// <summary>
    /// 弹球减振 加速
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <param name="bounces">反弹次数。值必须大于或等于零(默认值为3)</param>
    /// <param name="bounciness">指定反弹动画的弹性大小。虽然较高的值都会导致反弹 （弹性较小），此属性中的结果很少或者反弹低值会丢失反弹 （弹性较大） 之间的高度。此值必须是正数(默认值为 2)</param>
    /// <returns></returns>
    public static double BounceIn(double origin, double transform, double usedTime, double allTime, int bounces, double bounciness)
    {
      return origin + transform * BounceInCore((usedTime / allTime), bounces, bounciness);
    }
    /// <summary>
    /// 弹球减振 加速
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <param name="bounces">反弹次数。值必须大于或等于零(默认值为3)</param>
    /// <param name="bounciness">指定反弹动画的弹性大小。虽然较高的值都会导致反弹 （弹性较小），此属性中的结果很少或者反弹低值会丢失反弹 （弹性较大） 之间的高度。此值必须是正数(默认值为 2)</param>
    /// <returns></returns>
    public static double BounceInCore(double progressTime, int bounces, double bounciness)
    {
      double y1 = Math.Max(0.0, (double)bounces);
      double num1 = bounciness;
      if (num1 < 1.0 || Math.Abs(num1 - 1.0) < 2.22044604925031E-15)
        num1 = 1001.0 / 1000.0;
      double num2 = Math.Pow(num1, y1);
      double num3 = 1.0 - num1;
      double num4 = (1.0 - num2) / num3 + num2 * 0.5;
      double y2 = Math.Floor(Math.Log(-(progressTime * num4) * (1.0 - num1) + 1.0, num1));
      double y3 = y2 + 1.0;
      double num5 = (1.0 - Math.Pow(num1, y2)) / (num3 * num4);
      double num6 = (1.0 - Math.Pow(num1, y3)) / (num3 * num4);
      double num7 = (num5 + num6) * 0.5;
      double num8 = progressTime - num7;
      double num9 = num7 - num5;
      return -Math.Pow(1.0 / num1, y1 - y2) / (num9 * num9) * (num8 - num9) * (num8 + num9);
    }
    /// <summary>
    /// 加速 弹球减振
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <param name="bounces">反弹次数。值必须大于或等于零(默认值为3)</param>
    /// <param name="bounciness">指定反弹动画的弹性大小。虽然较高的值都会导致反弹 （弹性较小），此属性中的结果很少或者反弹低值会丢失反弹 （弹性较大） 之间的高度。此值必须是正数(默认值为 2)</param>
    /// <returns></returns>
    public static double BounceOut(double origin, double transform, double usedTime, double allTime, int bounces, double bounciness)
    {
      return origin + transform * BounceOutCore((usedTime / allTime), bounces, bounciness);
    }
    /// <summary>
    /// 加速 弹球减振
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <param name="bounces">反弹次数。值必须大于或等于零(默认值为3)</param>
    /// <param name="bounciness">指定反弹动画的弹性大小。虽然较高的值都会导致反弹 （弹性较小），此属性中的结果很少或者反弹低值会丢失反弹 （弹性较大） 之间的高度。此值必须是正数(默认值为 2)</param>
    /// <returns></returns>
    public static double BounceOutCore(double progressTime, int bounces, double bounciness)
    {
      return 1.0 - BounceInCore(1.0 - progressTime, bounces, bounciness);
    }
    /// <summary>
    /// 弹球减振 加速 弹球减振
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <param name="bounces">反弹次数。值必须大于或等于零(默认值为3)</param>
    /// <param name="bounciness">指定反弹动画的弹性大小。虽然较高的值都会导致反弹 （弹性较小），此属性中的结果很少或者反弹低值会丢失反弹 （弹性较大） 之间的高度。此值必须是正数(默认值为 2)</param>
    /// <returns></returns>
    public static double BounceBoth(double origin, double transform, double usedTime, double allTime, int bounces, double bounciness)
    {
      return origin + transform * BounceBothCore(usedTime / allTime, bounces, bounciness);
    }
    /// <summary>
    /// 弹球减振 加速 弹球减振
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <param name="bounces">反弹次数。值必须大于或等于零(默认值为3)</param>
    /// <param name="bounciness">指定反弹动画的弹性大小。虽然较高的值都会导致反弹 （弹性较小），此属性中的结果很少或者反弹低值会丢失反弹 （弹性较大） 之间的高度。此值必须是正数(默认值为 2)</param>
    /// <returns></returns>
    public static double BounceBothCore(double progressTime, int bounces, double bounciness)
    {
      if (progressTime >= 0.5)
        return (1.0 - BounceInCore((1.0 - progressTime) * 2.0, bounces, bounciness)) * 0.5 + 0.5;
      return BounceInCore(progressTime * 2.0, bounces, bounciness) * 0.5;
    }

    #endregion

    #region Elastic

    /// <summary>
    /// Elastic
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <param name="oscillations">目标来回滑过动画目标的次数。此值必须大于或等于0 (默认值为3)</param>
    /// <param name="springiness">弹簧铡度。 越小的 Springiness 值为，严格 spring，通过每个振动的强度减小的速度越快弹性。一个正数(默认值为3)</param>
    /// <returns></returns>
    public static double ElasticIn(double origin, double transform, double usedTime, double allTime, int oscillations, double springiness)
    {
      return origin + transform * ElasticInCore((usedTime / allTime), oscillations, springiness);
    }
    /// <summary>
    /// Elastic
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <param name="oscillations">目标来回滑过动画目标的次数。此值必须大于或等于0 (默认值为3)</param>
    /// <param name="springiness">弹簧铡度。 越小的 Springiness 值为，严格 spring，通过每个振动的强度减小的速度越快弹性。一个正数(默认值为3)</param>
    /// <returns></returns>
    public static double ElasticInCore(double progressTime, int oscillations, double springiness)
    {
      oscillations = Math.Max(0, oscillations);
      springiness = Math.Max(0.0, springiness);
      return (!(Math.Abs(springiness) < 2.22044604925031E-15) ? (Math.Exp(springiness * progressTime) - 1.0) / (Math.Exp(springiness) - 1.0) : progressTime) * Math.Sin((2.0 * Math.PI * oscillations + Math.PI / 2.0) * progressTime);
    }
    /// <summary>
    /// Elastic
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <param name="oscillations">目标来回滑过动画目标的次数。此值必须大于或等于0 (默认值为3)</param>
    /// <param name="springiness">弹簧铡度。 越小的 Springiness 值为，严格 spring，通过每个振动的强度减小的速度越快弹性。一个正数(默认值为3)</param>
    /// <returns></returns>
    public static double ElasticOut(double origin, double transform, double usedTime, double allTime, int oscillations, double springiness)
    {
      return origin + transform * ElasticOutCore((usedTime / allTime), oscillations, springiness);
    }
    /// <summary>
    /// Elastic
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <param name="oscillations">目标来回滑过动画目标的次数。此值必须大于或等于0 (默认值为3)</param>
    /// <param name="springiness">弹簧铡度。 越小的 Springiness 值为，严格 spring，通过每个振动的强度减小的速度越快弹性。一个正数(默认值为3)</param>
    /// <returns></returns>
    public static double ElasticOutCore(double progressTime, int oscillations, double springiness)
    {
      return 1.0 - ElasticInCore(1.0 - progressTime, oscillations, springiness);
    }
    /// <summary>
    /// Elastic
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <param name="oscillations">目标来回滑过动画目标的次数。此值必须大于或等于0 (默认值为3)</param>
    /// <param name="springiness">弹簧铡度。 越小的 Springiness 值为，严格 spring，通过每个振动的强度减小的速度越快弹性。一个正数(默认值为3)</param>
    /// <returns></returns>
    public static double ElasticBoth(double origin, double transform, double usedTime, double allTime, int oscillations, double springiness)
    {
      return origin + transform * ElasticBothCore(usedTime / allTime, oscillations, springiness);
    }
    /// <summary>
    /// Elastic
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <param name="oscillations">目标来回滑过动画目标的次数。此值必须大于或等于0 (默认值为3)</param>
    /// <param name="springiness">弹簧铡度。 越小的 Springiness 值为，严格 spring，通过每个振动的强度减小的速度越快弹性。一个正数(默认值为3)</param>
    /// <returns></returns>
    public static double ElasticBothCore(double progressTime, int oscillations, double springiness)
    {
      if (progressTime >= 0.5)
        return (1.0 - ElasticInCore((1.0 - progressTime) * 2.0, oscillations, springiness)) * 0.5 + 0.5;
      return ElasticInCore(progressTime * 2.0, oscillations, springiness) * 0.5;
    }

    #endregion

    #region Quadratic

    /// <summary>
    /// 二次
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <returns></returns>
    public static double QuadraticIn(double origin, double transform, double usedTime, double allTime)
    {
      return origin + transform * QuadraticInCore(usedTime / allTime);
    }
    /// <summary>
    /// 二次
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <returns></returns>
    public static double QuadraticInCore(double progressTime)
    {
      return -4 * Math.Pow((progressTime - 0.5), 2.0) + 1.0;
    }
    /// <summary>
    /// 二次
    /// </summary>
    /// <param name="origin">要变换的起始值</param>
    /// <param name="transform">要变换的总值</param>
    /// <param name="usedTime">已进行动画时间</param>
    /// <param name="allTime">总动画时间</param>
    /// <returns></returns>
    public static double QuadraticOut(double origin, double transform, double usedTime, double allTime)
    {
      return origin + transform * QuadraticOutCore(usedTime / allTime);
    }
    /// <summary>
    /// 二次
    /// </summary>
    /// <param name="progressTime">已进行动画时间/总动画时间</param>
    /// <returns></returns>
    public static double QuadraticOutCore(double progressTime)
    {
      if (progressTime >= 0.5)
      {
        return 4 * Math.Pow((progressTime - 0.5 - 0.5), 2.0);
      }
      return 4 * Math.Pow((progressTime), 2.0);
    }

    #endregion

  }

  /// <summary>
  /// 动画类型
  /// </summary>
  [Description("动画类型")]
  public enum AnimationType
  {
    UniformMotion,
    EaseIn,
    EaseOut,
    EaseBoth,
    BackIn,
    BackOut,
    BackBoth,
    BounceIn,
    BounceOut,
    BounceBoth,
    ElasticIn,
    ElasticOut,
    ElasticBoth,
    QuadraticIn,
    QuadraticOut
  }

}
