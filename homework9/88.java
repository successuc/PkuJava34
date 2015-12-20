public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // for write to A
        int cur = m+n-1;

        // for A
        int i = m-1;
        // for B
        int j =n-1;
   
        for(; i>=0 && j>=0; cur--)
        {
            if(A[i] >= B[j])
            {
                A[cur] = A[i];
                i--;
            }
            else
            {
                A[cur] = B[j];
                j--;
            }
        }
         
        while(j >=0) // don't need to do anything if i>=0
        {
            A[cur] = B[j];
            cur--;
            j--;
        }
    }
}

/**这道题如果从前往后把B归并到A的话，每次插入操作都会导致A中插入的数后面的所有数后移，但是如果是从后往前归并的话，这个低效的行为就巧妙地避免了，而且，归并完毕后，如果A中还有剩余元素，它们天然地躺在最小端，什么额外的事情都不需要做：**/