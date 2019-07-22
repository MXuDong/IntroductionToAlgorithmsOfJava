# Merger 合并算法

# 伪代码
```
/*伪代码
    MERGE(A, p, q, r)
        n1 = q - p + 1
        n2 = r - q
        let L[1..n1 + 1] and R[1..n2 + 1] be new arrays
        for i = 1 to n1
            L[i] = A[p + i - 1]
        for j = 1 to n2
            R[j] = A[q + j]
        L[n1 + 1] = ∞
        R[n2 + 1] = ∞
        i = 1
        j = 1
        for k = p to r
            if L[i] ≤ R[j]
                A[k] = L[i]
                i = i + 1
            else A[k] = R[j]
                j = j + 1
*/
```

# 代码说明
    参数：
        A:被合并的数组
        p:坐标的起始位置（Java中以0开始， 但是伪代码以1开始）
        q:分割坐标
            (
            如果将A看为两个部分
            1 3 5 2 4 6
            则分割坐标为5的坐标（Java中因为以0开始计数，因此分割坐标为2）
            ）
        r:终止坐标
        
        例如要合并1 3 5 2 4 6这个数组，则输入的参数应该是 A,0,2,5
    
    代码中，将 1 3 5 2 4 6分为左右两个数组，因此分别为：
        left  1 3 5 无穷
        right 2 4 6 无穷
    然后再确定循环不变式，上述代码中，最后一位无穷表示哨兵位，如果是降序排列则应改为负无穷