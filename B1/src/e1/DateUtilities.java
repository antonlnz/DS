package e1;

public class DateUtilities {

    /**
     * Indicates whether a year is a leap year . A leap year is divisible by 4,
     * unless it is divisible by 100 , in which case it must be divisible by 400
     * in order to be considered a leap year (e.g., 1900 is not a leap year ,
     * but 2000 is) => See the JUnit seminar for an example .
     *
     * @param year the given year
     * @return True if the given year is a leap year , false otherwise .
     */

    public static boolean isLeap(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    /**
     * Indicates the number of days of a given month . As the number of days in
     * the month of February depends on the year , it is also necessary to pass
     * the year as an argument .
     *
     * @param month The given month
     * @param year  The given year
     * @return The number of days of that month in that year .
     * @throws IllegalArgumentException if the month is not valid .
     */

    public static int numberOfDays(int month, int year) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 2: {
                if (isLeap(year)) return 29;
                else return 28;
            }
            case 4, 6, 9, 11:
                return 30;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* FUNCION AUXILIAR monthToNumber str -> str . Cambia el nombre del mes al numero que lo representa*/
    private static String monthToNumber(String month) {
        return switch (month) {
            case "January" -> "01";
            case "February" -> "02";
            case "March" -> "03";
            case "April" -> "04";
            case "May" -> "05";
            case "June" -> "06";
            case "July" -> "07";
            case "August" -> "08";
            case "September" -> "09";
            case "October" -> "10";
            case "November" -> "11";
            case "December" -> "12";
            default -> throw new IllegalArgumentException();
        };
    }

    /**
     * The ISO date format is a standard format that displays the dates
     * starting with the year , followed by the month and the day , i.e. ,
     * "YYYY -MM -DD ". For example , in that format the text " July 28 , 2006"
     * would be represented as "2006 -07 -28".
     * The " convertToISO " method converts a date in the " Month DD , AAAA "
     * format to its ISO representation . For simplicity , let us assume that
     * the values are correctly formatted even if the date is invalid
     * (e.g., " February 31 , 2006" is correctly formatted, but it is not a valid date )
     *
     * @param dateText Date in textual format ( USA style ).
     * @return A string with the given date in ISO format .
     */
    public static String convertToISODate(String dateText) {
        String[] parts = dateText.split(" ");
        String month = parts[0]; // "July"
        String day = parts[1]; // "28,"
        day = day.substring(0, day.length() - 1); //"28"
        String year = parts[2]; // "2006"

        return (year.concat("-").concat(monthToNumber(month)).concat("-").concat(day));
    }

    /* FUNCION AUXILIAR checkNumber str -> bool: comprueba que no haya caracteres no validos  */
    private static boolean checkNumber(String str) {
        int max = str.length() - 1;
        for (int i = 0; i < max; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * Given a String representing an ISO - formatted date , the methods checks
     * its validity . This includes checking for non - valid characters , erroneous
     * string lengths , and the validity of the date itself (i.e. , checking the
     * number of days of the month ).
     *
     * @param ISODate A date in ISO format
     * @return True if the ISO - formatted date is a valid date , False otherwise .
     */
    public static boolean checkISODate(String ISODate) {
        int year, month, day;
        String[] parts = ISODate.split("-");
        if(parts[0].length() == 4 && parts[1].length() == 2 && parts[2].length() == 2) {
            if (checkNumber(parts[0]) && checkNumber(parts[1]) && checkNumber(parts[2])) {
                year = Integer.parseInt(parts[0]); //2020
                month = Integer.parseInt(parts[1]); //02
                day = Integer.parseInt(parts[2]); //29
                return ((1 <= month && month <= 12) && 1 <= day && day <= numberOfDays(month, year));
            }
            else
                return false;
        } else
            return false;

    }

}