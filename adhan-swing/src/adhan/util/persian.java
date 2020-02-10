/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adhan.util;

import com.ghasemkiani.util.icu.PersianCalendar;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.ULocale;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author mohammadghasemy
 */
public class persian {
    public String persiandate(Date d){
        if(d == null)
            return "";
        calendar.setTime( d);
        SimpleDateFormat sds =(SimpleDateFormat)calendar.getDateTimeFormat(DateFormat.LONG,DateFormat.MEDIUM,uLocale);
        return sds.format(calendar.getTime());
    }
	ULocale  uLocale = new ULocale("fa_IR");
    TimeZone timeZone = TimeZone.getTimeZone(TimeZone.getDefault().getID());
    PersianCalendar calendar = new PersianCalendar( uLocale);
}
