package bunchbycycles;

import java.util.*;
public class Main {
  static class CountsByUsage {
    public int lowCount = 0;
    public int mediumCount = 0;
    public int highCount = 0;
  };

  static CountsByUsage countBatteriesByUsage(int[] cycles) {
    CountsByUsage counts = new CountsByUsage();




        // Approach
        // Linearly Iterate all the values one by one
        //  Checking the base condition to classify the Batteries
        //  Time Complexity with respect to this code --> O(N) , where N-size of array , because we are using linear time
        //  Space Complexity is O(1) because No Extra space is used


        // Additional thing is we can group the batteries based on their  life cycle 
        // We can use this data to identify the batteries and also we can store the index as well(Not implemented)
        ArrayList<ArrayList<Integer>> Grouped = new ArrayList<>();
        ArrayList<Integer> lowBattery = new ArrayList<>();
        ArrayList<Integer> mediumBattery = new ArrayList<>();
        ArrayList<Integer> highBattery = new ArrayList<>();


        for(int i=0;i< cycles.length;i++){
            if(cycles[i] < 400)
            {
                counts.lowCount = counts.lowCount+1;
                lowBattery.add(cycles[i]);
            }
            else if(cycles[i]>=400 && cycles[i]<=919)
            {
                counts.mediumCount = counts.mediumCount + 1;
                mediumBattery.add(cycles[i]);
            }
            else if(cycles[i] >= 920){
                counts.highCount = counts.highCount + 1;
                highBattery.add(cycles[i]);
            }

            else //Checking if the value is less than 0 ( Boundary Condition )
                System.out.println("Invalid Cycle");
        }

        Grouped.add(lowBattery);
        Grouped.add(mediumBattery);
        Grouped.add(highBattery);

    //        for(int i=0;i<3;i++)
    //            System.out.println(Grouped.get(i));

        return counts;
  }

  static void testBucketingByNumberOfCycles() {
    System.out.println("Counting batteries by usage cycles...\n");
    CountsByUsage counts = countBatteriesByUsage(new int[] {100, 300, 500, 600, 900, 1000});
    assert (counts.lowCount == 2) : "Low Count is Wrong";
    assert (counts.mediumCount == 3) : "Medium Count is Wrong";
    assert (counts.highCount == 1) : " High Count is wrong";
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByNumberOfCycles();
  }
}
