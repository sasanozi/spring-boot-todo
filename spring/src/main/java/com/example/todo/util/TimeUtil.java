package com.example.todo.util;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class TimeUtil {
  public static String ymd = "yyyy-MM-dd";
  public static String ymdhm = "yyyy-MM-dd HH:mm";
  public static String ymdhms = "yyyy-MM-dd HH:mm:ss";
  public static String ym = "yyyy-MM";
  public static String ymdI = "yyyyMMdd";
  public static String ymI = "yyyyMM";

  public class Format{

    public static String toYmd(TemporalAccessor time) {
      return format(time, ymd);
    }

    public static String toYmdHm(TemporalAccessor time) {
      return format(time, ymdhm);
    }

    public static String toYmdHms(TemporalAccessor time) {
      return format(time, ymdhms);
    }

    public static String toYm(TemporalAccessor time) {
      return format(time, ym);
    }

    public static Integer toYmdI(TemporalAccessor time) {
      return Integer.parseInt(format(time, ymdI));
    }

    public static Integer toYmI(TemporalAccessor time) {
      return Integer.parseInt(format(time, ymI));
    }

    private static String format(TemporalAccessor time, String format) {
      return DateTimeFormatter.ofPattern(format).format(time);
    }

  }
}

