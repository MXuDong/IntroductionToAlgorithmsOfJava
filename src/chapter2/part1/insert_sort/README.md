# 2.1 插入排序

## 伪代码表示
```
INSERT-SORT(A)
    for j = 2 to A.length
        key = A[j]
        // Insert A[j] into the sorted sequence A[1..j-1].
        // 翻译 将A[j]插入到已排序序列A[1..j-1]
        i = j - 1
        while i > 0 and A[j] > key
            A[i+1] = A[i]
            i = i - 1
        A[i + 1] = key
```

## 算法分析
插入排序(Insert-Sort)算法是一种简单的排序方法

时间复杂度:O(n^2)    

空间复杂度:O(1)

算法稳定性:稳定

插入排序的基本思想是：每步将一个待排序的记录，按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止。