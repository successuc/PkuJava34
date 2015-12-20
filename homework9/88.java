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

/**����������ǰ�����B�鲢��A�Ļ���ÿ�β���������ᵼ��A�в��������������������ƣ���������ǴӺ���ǰ�鲢�Ļ��������Ч����Ϊ������ر����ˣ����ң��鲢��Ϻ����A�л���ʣ��Ԫ�أ�������Ȼ��������С�ˣ�ʲô��������鶼����Ҫ����**/