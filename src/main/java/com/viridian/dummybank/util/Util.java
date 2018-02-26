package com.viridian.dummybank.util;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

        public static Timestamp convertStringToTimestamp(String str_date) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                Date parsedDate = dateFormat.parse(str_date);
                Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

                return timestamp;
            } catch (ParseException e) {
                System.out.println("Exception :" + e);
                return null;
            }
        }

}
