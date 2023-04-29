import java.time.LocalDateTime;
import java.util.*;
import java.text.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.text.SimpleDateFormat;
    
    public class timez {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            // Get the user's input for the country zone
            System.out.print("Enter a country zone (eg. America/NewYork): ");
              String countryZone = scanner.nextLine();

              ZonedDateTime.now( ZoneId.of( "America/New_York" )).withZoneSameInstant(ZoneId.of( "America/New_York" ) ) .toString();                             
           
    
            // Get the current time in the local time zone
            String format="dd-M-yyyy hh:mm:ss a";
        SimpleDateFormat dateFormat=new SimpleDateFormat(format);

        Date dt=new Date();

        String defaultTZ=TimeZone.getDefault().getID();
        System.out.println(defaultTZ);

        Calendar cal=new GregorianCalendar();
        cal.setTime(dt);
        System.out.println("Date  "+dateFormat.format(cal.getTime()));
    System.out.println("TimeZone:  "+cal.getTimeZone().getID());
System.out.println("Timezone Name:  "+cal.getTimeZone().getDisplayName()); 
            LocalDateTime localDateTime = LocalDateTime.now();
    
            // Convert the local time to the country zone time
            ZoneId localZoneId = ZoneId.systemDefault();
            ZoneId countryZoneId = ZoneId.of(countryZone);
            ZonedDateTime localZonedDateTime = ZonedDateTime.of(localDateTime, localZoneId);
            ZonedDateTime countryZonedDateTime = localZonedDateTime.withZoneSameInstant(countryZoneId);
    
            // Format the country zone time and display it to the user
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedCountryZoneTime = countryZonedDateTime.format(formatter);
            System.out.println("The current time in " + countryZone + " is " + formattedCountryZoneTime);
    
            scanner.close();
        }
    }
    
    

