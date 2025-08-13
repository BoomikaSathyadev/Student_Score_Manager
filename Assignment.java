// Student Score Manager Assignment
// Operations: sum, average, percentage, highest, lowest, reverse, copy, sorted check, swap, search, count, pass/fail

import java.util.Arrays;
import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] mark = new int[5];
        
        for (int i = 0; i < mark.length; i++) {
            while (true) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                int input = scan.nextInt();
                if (input >= 0 && input <= 100) {
                    mark[i] = input;
                    break;
                } else {
                    System.out.println("Invalid input! Marks must be between 0 and 100. Try again.");
                }
            }
        }

        System.out.println("\n=== Student Score Manager Menu ===");
        System.out.println("1. Sum & Average");
        System.out.println("2. Percentage");
        System.out.println("3. Highest & Lowest marks");
        System.out.println("4. Reverse Marks");
        System.out.println("5. Copy Marks");
        System.out.println("6. Check Sort (Ascending)");
        System.out.println("7. Swap Marks");
        System.out.println("8. Search for Distinction");
        System.out.println("9. Count for Scholarship");
        System.out.println("10. Pass or Fail");
        System.out.println("11. Exit");
    
        while (true) {
            System.out.print("\nChoose an option (1-11): ");
            int choice = scan.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                // 1. ** SUM & AVERAGE **  - Time: O(n), Space: O(1)
                    int sum = 0;                                                         
                    for (int i = 0; i < mark.length; i++) {
                        sum += mark[i];
                    }
                    System.out.println("Sum of marks out of "+ (mark.length * 100) + ": " + sum);
                    double average = (double) sum / mark.length;
                    System.out.println("Average mark: " + average);
                    break;

                case 2:
                // 2. ** PERCENTAGE ** - Time: O(1), Space: O(1)
                    int sumPercentage = 0;
                    for (int m : mark) sumPercentage += m;
                    double percentage = (sumPercentage * 100.0) / (mark.length * 100);
                    System.out.println("Percentage of marks: " + percentage + " %");
                    break;

                case 3:
                // 3. ** HIGHEST & LOWEST MARKS ** - Time: O(n), Space: O(1)
                    int max = mark[0];
                    int min = mark[0];
                    for (int i = 1; i < mark.length; i++) {
                        if (mark[i] > max) max = mark[i];
                        if (mark[i] < min) min = mark[i];
                    }
                    System.out.println("Highest mark is: " + max);
                    System.out.println("Lowest mark is: " + min);
                    break;
                
                case 4:
                // 4. ** REVERSE ** - Time: O(n), Space: O(1)
                    System.out.print("Reverse: ");
                    for (int i = mark.length - 1; i >= 0; i--) {
                        System.out.print(mark[i] + " ");
                    }
                    System.out.println();
                    break;
                
                case 5:
                // 5. ** COPY ** - Time: O(n), Space: O(n)
                    int[] copy = new int[mark.length];
                    for (int i = 0; i < mark.length; i++) {
                        copy[i] = mark[i];
                    }
                    System.out.println("Copied Marks: " + Arrays.toString(copy));
                    break;
                
                case 6:
                // 6. ** CHECK SORT (ascending) ** - Time: O(n), Space: O(1)
                    boolean sort = true;
                    for (int i = 0; i < mark.length - 1; i++) {
                        if (mark[i] > mark[i+1]) {
                            sort = false;
                            break;
                        }
                    }
                    System.out.println("Array sorted? " + sort);
                    break;
                
                case 7:
                // 7. ** SWAP ** - Time: O(1), Space: O(1)
                    int a = 2, b = 4;
                    int temp = mark[a];
                    mark[a] = mark[b];
                    mark[b] = temp;
                    System.out.println("After swap: " + Arrays.toString(mark));
                    break;

                case 8:
                // 8. ** SEARCH ** - Time: O(n), Space: O(1)
                    int target = 99;
                    boolean found = false;
                    boolean below35 = false;
                    for (int m : mark) if (m < 35) below35 = true;
                    if (!below35) {     // only search if no marks below 35
                        for (int m : mark) {
                            if (m == target) {
                                System.out.println("Distinction for getting " + target + " marks.");
                                found = true;
                                break;
                            }
                        }
                    }
                    if (!found) System.out.println("Mark not found (or) Mark below 35. No distinction.");
                    break;

                case 9:
                // 9. ** COUNT ** - Time: O(n), Space: O(1)
                    below35 = false;
                    for (int m : mark) if (m < 35) below35 = true;
                    int count = 0;
                    if (!below35) {  
                        for (int m : mark) {
                            if (m >= 85) {
                                count++;
                            }
                        }
                    }
                    if (count >= 1 && !below35) {
                        System.out.println("Scholarship Available.");
                    } else {
                        System.out.println("Scholarship Not Available.");
                    }
                    break;

                case 10:
                // 10. ** PASS or FAIL ** - Time: O(1), Space: O(1)
                    int total = 0;
                    below35 = false;
                    for (int m : mark) {
                            total += m;          
                            if (m < 35) below35 = true;
                        }                    
                    if (total >= 250 && !below35) {
                        System.out.println("Status: PASS. You passed all subjects.");
                    } else {
                        System.out.println("Status: FAIL. Some subjects have marks below 35.");
                    }
                    break;
                        
                case 11:
                    System.out.println("Exiting...");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}