# Probabilistic Search
# Kutaisi International University Java Course Assignment
For the probabilistic search we need a sorted array, as well as the minimum and maximum value and the number of elements of the array.

From that, the step width is computed. The start position then is determined by means of the step width and the difference of the desired value and the minimal value according to the formula 

Position=Round( (value - min) / (max - min) / (#elements - 1) ).


Only for the curious: since we assume an equal distribution, the computation is so simple. When data are differently distributed, the computation of the position is more complicated.

Now we check the position and proceed from that position into the appropriate direction in an exponential way: in the first trial, we proceed by 2^0 = 1 value in the second trial by 2^1 = 2 values in the third trial by 2^2 = 4 values and so on.


As soon as the program steps beyond the searching for value, an interval need to be found within which the desired value is located. From that moment on, we rely on ordinary binary search as auxiliary method.

Counting Steps
In the first trial, probabilistic search uses a single step. For every subsequent trial, the step count is increased. Thus, if the first guess is a hit, the step count is 1, while in the second subsequent trial, the step count is incremented to 2 and so on. Binary search then is started with the values min and max in such a way that the range is searched which has not yet been covered by the probabilistic search. The current step count (perhaps increased by one) should be passed as a parameter.
method now accesses the value at index position 9 directly and finds a value that is too large there, so it must be to the left of position keep searching and all values to the right of this position can be excluded.

Your method goes left from the current index 2^0 = 1 step(s) and still finds a value that is too large.

Your method goes left from the current index 2^(0 + 1) = 2  steps and finds a value that is too small, now we have found the range where the value must be. Your program can exclude all values to the left of the current one. We now use binary search in this area.

Your task is to implement a method public static int[] probalisticSearch(int[] arr, int value) that implements the algorithm described above. The passed array is always sorted. The searched value int value is always within the range between the smallest and the largest value of the array.

The return array has the index of the searched value in the array in the first position (index 0) or -1 if the searched number does not appear in the array. In the second place (index 1) your function returns how many calls it took to find the right value or to return that the value does not exist in the array.

 
Now let's compare the performance of the two approaches. For this there is a slightly modified version of public static int[] find (int[] a, int x) in the template, which, just like your method, first returns the index and then the required number of calls are.

Write a method public static void compareApproaches(int[] arr, int min, int max) that returns all values (including min and max and whether the values in between are in the array or not ) between min and max in the array searches with both variants and outputs how many calls the variants needed.

In addition, your program should print what was the largest number of steps and at what value this occurred (if there are several values with the same number of values, print the first with this number).

Please use the data type long for summing up the calls, since we may be testing very large arrays!

The output format can be seen in the following sample output:
![image](https://user-images.githubusercontent.com/77580098/218205872-168325eb-7bcf-47c6-b3ac-924e20a796ef.png)
