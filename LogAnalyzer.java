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
 * Question 7
 * 20 string objects
 * 
 * Question 8
 * The 50 is in parantheses its supposed to be in brackets.
 * 
 * Question 9
 * Hours in a day are 0 to 23. The loop using <= tries to access hour 24,
 * which doesn't exist. We should use <.
 * 
 * Question 11
 * Incorrect parameter types it was written double instead of double[])
 * Missing type of index declaration
 * Incorrect loop condititon it was written <= instead of <
 * 
 * Question 14
 * Yes the method works it gives the total.
 * 
 * 
 * 
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    
    //Question 3
    private boolean[] vacant;
    
    //Question 5
    int [] counts;
    boolean [] occupied;
    
    //Question 6
    //6a
    double[] readings;
    //6b
    String[] urls;
    //6c
    //TicketMachine[] machines; 
    
    //Question 8
    // Correct version
    double [] prices;
    
    
    
   

    /**
     * Create an object to analyze hourly web accesses.
     */
    // Question 12
    public LogAnalyzer(String logfileName)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        //Question 12
        reader = new LogfileReader(logfileName);
        
        //Question 5
        occupied = new boolean[5000];
        
        //Question 6
        //6a
        readings = new double[60];
        //6b
        urls = new String[90];
        //6c
        //machines = new TicketMachine[5];
        
        //Question 8
        //Correct version
        prices = new double [50];
        
        
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
        //for(int hour = 0; hour < hourCounts.length; hour++) {
        //System.out.println(hour + ": " + hourCounts[hour]);
        //}
        
        //Question 10
        int hour = 0;
        while(hour < hourCounts.length){
            System.out.println(hour +":"+ hourCounts[hour]);
            hour++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
        //Question 11
        double[] marks = {2.3,3.3,5.8,1.0,0.8};
        printGreater(marks,2.0);
    }
    
    //Question 11
    public void printGreater(double [] marks, double mean){
        for(int index = 0; index < marks.length;index++){
            if(marks[index]>mean){
                System.out.println(marks[index]);
            }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
        }
    }
    
    public int numberOfAccesses(){
        int total = 0;
        for(int count : hourCounts){
            total += count;
        }
        return total;
    }
    
    //Question 15
    public int busiestHour(){
        int busiestHour= 0;
        int maxCount= hourCounts[0];
        for(int hour = 1; hour < hourCounts.length; hour++){
            if(hourCounts[hour] > maxCount){
                maxCount = hourCounts[hour];
                busiestHour = hour;
            }
        }
        return busiestHour;
    }
    
    //Question 16
    public int quietestHour(){
        int quietestHour= 0;
        int minCount= hourCounts[0];
        for(int hour = 1; hour < hourCounts.length; hour++){
            if(hourCounts[hour] < minCount){
                minCount = hourCounts[hour];
                quietestHour = hour;
            }
        }
        return quietestHour;
    }
}
