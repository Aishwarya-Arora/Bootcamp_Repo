package Java8;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Ques10 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Taking the input of local date
        System.out.print("Enter first date (yyyy-MM-dd): ");
        LocalDate date1 = LocalDate.parse(sc.next()); //parsing the input into local date

        System.out.print("Enter second date (yyyy-MM-dd): ");
        LocalDate date2 = LocalDate.parse(sc.next());

        //checking the date comes before by using isBefore method
        if (date1.isBefore(date2)) {
            System.out.println("First date occurs BEFORE second date");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date occurs AFTER second date");      //isAfter is used to check the date is after the date in bracket
        } else {
            System.out.println("Both dates are EQUAL");
        }

        //ZonedDateTime is used to get time and date for different zones
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime usaTime   = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime ukTime    = ZonedDateTime.now(ZoneId.of("Europe/London"));

        System.out.println("India Time (Asia/Kolkata): " + indiaTime);
        System.out.println("USA Time (New York)     : " + usaTime);
        System.out.println("UK Time (London)       : " + ukTime);
        sc.close();
    }
}
