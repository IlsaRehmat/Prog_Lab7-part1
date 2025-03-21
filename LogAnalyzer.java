/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */

/*
 * Lab 7 part 1 answers
 * 
 * Question 1
 * The busiest time of the day is at 18:00
 * 
 * Question 2
 * private Person[] people;
 * 
 * Question 4
 * The hourCounts variable is used in the fields section, in the constructor
 * and in the first two methods. The square brackets is used very often.
 * 
 * Question 5
 * 1. []int counts;
 * The brackets should come after the type not before the type
 * The correct version: int [] counts;
 * 2. boolean[5000] occupied;
 * You cannot specify the size of an array when declaring it
 * The size should be assigned when creating the array using new.
 * Correct version: boolean [] occupied = new boolean[5000];
 * 
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    //Q3
    private boolean[] vacant;
    //Q5
    int [] counts;
    boolean [] occupied = new boolean[5000];
   

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
