package com.zarrouk.anis.mynews.Utils;

/**
 * Created by Anis Zarrouk on 17/07/2019
 */
public class DateUtilities {


        private static final String TAG = DateUtilities.class.getSimpleName();

        /**
         * @since 1.0
         *
         * Return date in format string JJ/MM/AA
         *
         * @param date
         *          String starting with a date in the format SSAAMMJJ
         *
         * @return String Date in format JJ/MM/AA
         */
        public static String dateReformat(String date){

            String JJ = date.substring(8,10);            // Day
            String MM = date.substring(5,7);            // Month
            String AA = date.substring(0,4);            // Year

            return JJ+"/"+MM+"/"+AA;                    // JJ/MM/AA
        }
    /**
     * @since 1.0
     *
     * Return date in format string SSAAMMJJ
     *
     * @param date
     *          String starting with a date in the format begin SSAA-MM-JJ...
     *
     * @return String Date in format SSAAMMJJ
     */
    public static String dateReformatSSAAMMJJ(String date){

        String SSAA = date.substring(0,4);           // Year
        String MM = date.substring(5,7);             // Month
        String JJ = date.substring(8,10);            // Day

        return SSAA+MM+JJ;
    }
}
