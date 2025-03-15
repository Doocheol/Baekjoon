// 4
// 1 3 5 7

import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {
 
            
            if (isPrime(arr[i])) count++;
            
        }
        
        System.out.println(count);
        
    }
    
    private static boolean isPrime(int number) {
        
        if (number == 1) return false;
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        
        
        return true;
    }
    
}