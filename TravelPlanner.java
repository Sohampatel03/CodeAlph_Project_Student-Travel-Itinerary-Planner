import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TravelPlanner {
    private List<Destination> destinations;
    private Scanner scanner;

    public TravelPlanner() {
        destinations = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addDest() {
        System.out.println("Enter destination name:");
        String name = scanner.nextLine();
        System.out.println("Enter start date (YYYY-MM-DD):");
        Date start = getDateFromUser();
        System.out.println("Enter end date (YYYY-MM-DD):");
        Date end = getDateFromUser();
        System.out.println("Enter budget:");
        double budget = scanner.nextDouble();

        Destination dest = new Destination(name, start, end, budget);
        destinations.add(dest);
        System.out.println("Destination added successfully!");
    }

    private Date getDateFromUser() {
        Date date = null;   
        while (date == null) {
            try {
                String dateString = scanner.nextLine();
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format:");
            }
        }
        return date;
    }

    public void genPlan() {
        System.out.println("Your travel plan:");
        for (Destination dest : destinations) {
            System.out.println("Destination: " + dest.name);
            System.out.println("Start Date: " + dest.startDate);
            System.out.println("End Date: " + dest.endDate);
            System.out.println("Budget: $" + dest.budget);
            System.out.println("Weather: " + getWeather(dest.name)); // Fetch weather info
            System.out.println("----------------------------");
        }
    }

    // Placeholder method to simulate fetching weather data
    private String getWeather(String destName) {
        // In a real application, you would call a weather API to get actual weather
        // information
        // This is just a placeholder to demonstrate the concept
        return "Sunny";
    }

    public static void main(String[] args) {
        TravelPlanner planner = new TravelPlanner();
        planner.addDest();
        planner.genPlan();
    }
}
