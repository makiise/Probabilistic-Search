
public class ProbabilisticSearch {
    /**
     * Binary search slightly modified from the lecture
     */
    public static int[] find (int[] a, int x) {
        return find0(a, x, 0, a.length-1, 1);
    }

    public static int[] find0 (int[] a, int x, int n1, int n2, int numberOfSteps) {
        int t = (n1+n2)/2;
        if (a[t] == x)
            return new int[]{t, numberOfSteps};
        else if (n1 >= n2)
            return new int[]{-1, numberOfSteps};
        else if (x > a[t])
            return find0 (a,x,t+1,n2, numberOfSteps + 1);
        else if (n1 < t)
            return find0 (a,x,n1,t-1, numberOfSteps + 1);
        else return new int[]{-1, numberOfSteps};
    }

    private static int[] a2(int a, int b) {
        int[] c = {a, b};
        return c;
    }
    
    private static int round(double a) {
    	return (int)(a + 0.5);
    }
    
    public static int[] probalisticSearch(int[] arr, int value) {
        int n = arr.length;
        int min = arr[0];
        int max = arr[n - 1];
        double temp1 = value - min;
        double temp2 = (double)(max - min) / (double)(n - 1);
        int firstIdx = round(temp1 / temp2);
        int calls = 1;
        if(arr[firstIdx] == value) {
            return a2(firstIdx, calls);
        }
        int l = 0;
        int r = 0;
        if(arr[firstIdx] < value) {
            l = firstIdx + 1;
            int idx = firstIdx;
            int step = 1;
            while(true) {
                calls += 1;
                idx += step;
                if(idx > n - 1) idx = n - 1;
                if(arr[idx] > value) {
                    r = idx - 1;
                    break;
                } else if(arr[idx] == value) {
                    return a2(idx, calls);
                }
                l = idx + 1;
                step *= 2;
            }
        } else {
            r = firstIdx - 1;
            int idx = firstIdx;
            int step = -1;
            while(true) {
                calls += 1;
                idx += step;
                if(idx < 0) idx = 0;
                if(arr[idx] < value) {
                    l = idx + 1;
                    break;
                } else if(arr[idx] == value) {
                    return a2(idx, calls);
                }
                r = idx - 1;
                step *= 2;
            }
        }
        return find0(arr, value, l, r, calls);

    }
    
    public static void compareApproaches(int[] arr, int min, int max) {
        int[] maxNumberOfCalls = {0, 0};
        int[] valueAt = {0, 0};
        long[] totalCalls = {0, 0};
        for(int value = min; value <= max; value++) {
            int[] bin = find(arr, value);
            int[] prob = probalisticSearch(arr, value);
            if(bin[1] > maxNumberOfCalls[0]) {
                maxNumberOfCalls[0] = bin[1];
                valueAt[0] = value;
            }
            if(prob[1] > maxNumberOfCalls[1]) {
                maxNumberOfCalls[1] = prob[1];
                valueAt[1] = value;
            }
            totalCalls[0] += bin[1];
            totalCalls[1] += prob[1];
        }
        
        System.out.println("Binary Search:");
        System.out.println("Maximum number of calls:");
        System.out.println(maxNumberOfCalls[0]);
        System.out.println("Value at which the maximum number of calls occurs:");
        System.out.println(valueAt[0]);
        System.out.println("Number of total calls:");
        System.out.println(totalCalls[0]);
        
        System.out.println("Probabilistic Search:");
        System.out.println("Maximum number of calls");
        System.out.println(maxNumberOfCalls[1]);
        System.out.println("Value at which the maximum number of calls occurs:");
        System.out.println(valueAt[1]);
        System.out.println("Number of total calls:");
        System.out.println(totalCalls[1]);
    }

    public static void main(String[] args) {
        // Not part of the exercise but can be helpful for debugging purposes
         int[] exampleArray = new int[]{6, 20, 22, 35, 51, 54, 59, 74, 77, 80, 87, 94, 97};
         compareApproaches(exampleArray, 6, 97);
    }
}
