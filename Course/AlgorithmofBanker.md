## 银行家算法

[toc]

### 实现代码：

```c++
#include <iostream>
#include <cstdio>
using namespace std;
const int N = 1e3 + 10;
int m , n;
int Max[N][N], Allocation[N][N], Need[N][N], Available[N], temp[N];
bool finish[N], notExistSeq = true;
string ans;
/**
 * 银行家算法 ：
 * 声明几个对应的数组含义
 * max表示不同进程 对不同的资源 需要的最大的资源的个数
 * Allocation 表示已经分配的资源
 * need 表示 还需要分配的资源的个数
 * available 表示当前 可用的资源个数
 * m 表示列的个数 列代表对应的资源的种类的数量 资源 A  B  C .....
 * n 表示 行的个数， 对应代表了进程种类的数量 p0 p1 p2 p3  .....
 * ans 表示安全序列中一个答案
 */
void init() {
    cout << "依次 输入进程数量 和资源的数量 " << endl;
    cin >> n >> m;

    cout << "输入当前的可用资源" << endl;
    for (int i = 0; i < m; ++i)
        cin >> Available[i];

    cout << "依次输入最大的分配" << endl;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> Max[i][j];


    cout << "依次输入当前已经分配的资源" << endl;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++ )
            cin >> Allocation[i][j];

    for (int i = 0; i < n; i ++)
        for (int j = 0; j < m; j ++ )
            Need[i][j] = Max[i][j] - Allocation[i][j];
    // 矩阵转置
    for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
              // printf("%d  ", Allocation [j][i]);
               Available[i] -= Allocation [j][i];
        }
        temp[i] = Available[i];
    }
}
void showbaseinfo(){
    printf("\n  Max           Allocation      Need\n");
    for (int i = 0; i < n; i++ ){
        for (int j = 0; j < m; j++)
            printf("%3d", Max[i][j]);
        printf("%*s", 6, "");
        for (int j = 0; j < m; j++)
            printf("%3d",  Allocation[i][j]);
        printf("%*s", 6, "");
        for (int j = 0; j < m; j++)
            printf("%3d", Need[i][j]);
        printf("\n");
    }
    printf("\n初始的当前资源可用值为: \n");
    for (int i = 0; i < m; i++)
        printf("%d ", Available[i]);
    puts("");
}

void release(int row){
    for(int i = 0; i < m; i++)
        Available[i] += Allocation[row][i];
    finish[row] = true;
    ans += row + '0';
}

void rollBack(int row){
    for(int i = 0; i < m; i++)
        Available[i] -= Allocation[row][i];
    finish[row] = false;
    ans = string(ans, 0, ans.size() - 1);
}

bool couldRecheak(){
    for (int i = 0; i < n; i++)
        if (finish[i] == false) return true;
    return false;
}

bool getSafeSequence(){
    notExistSeq = true;
    for (int i = 0; i < n ; i++){
        if (finish[i] == false){
            bool flag = true;
            for (int j = 0; j < m; j++)
                if (Need[i][j] > Available[j])  flag = false;
            if (flag) release(i), notExistSeq = false;
        }
    }
    return !notExistSeq;
}

void recheak(){
    while (couldRecheak() && getSafeSequence());
}

void setdefault(){
    for (int i = 0; i < m; i ++) Available[i] = temp[i];
    for (int i = 0; i < n; i ++) finish[i] = false;
    ans = "";
}
/*
获取安全序列的同时需要检查
每次资源的分配 同时需要判断是否存在安全不能求解的情况
如果本次 两种for 都没有找到的的说明当前没有安全序列 可以求出 那么直接返回
对每次的获取完安全值的是时候需要进行安全序列的判断
确保能够输出安全序列的条件就是 当前的所有的进程全部 =执行完成即 资源在分配的过程中没有出现异常的形况
*/

void dfs(int cur){
     //递归的出口
     if (cur == n){
         printf("安全序列为%s\n", ans.c_str());
         return;
     }
     for (int i = 0 ; i < n; i ++){
        if (!finish[i]){
            bool flag = true;
            for (int j = 0; j < m; j++)
                if (Need[i][j] > Available[j])  flag = false;
            if (flag){
                release(i);
                dfs(cur + 1);
                rollBack(i);
            }
        }
     }
}
int main() {
    init();
    showbaseinfo();
    getSafeSequence();
    recheak();
    if (!notExistSeq){
        printf("当前资源分配的安全序列之一为%s", ans.c_str());
        printf("是否要出输全部的安全序列呢 ？yes(1) or (0)\n");
        int a;
        scanf("%d", &a);
        if (a) setdefault(), dfs(0);
        else printf("欢迎下次使用\n");
    }
    else printf("不存在安全的序列\n");
    return 0;
}
```

###  测试样例

```C++
/*

书中讲解的案例：
5  3
10 5 7

7 5 3
3 2 2
9 0 2
2 2 2
4 3 3

0 1 0
2 0 0
3 0 2
2 1 1
0 0 2
如果分配为 不存在安全序列的值
5  3
0 1 0

7 5 3
3 2 2
9 0 2
2 2 2
4 3 3

0 1 0
2 0 0
3 0 2
2 1 1
0 0 2


书中的课后习题

5 4

3 12 14 14

0 0 4 4
2 7 5 0
3 6 10 10
0 9 8 4
0 6 6 10

0 0 3 2
1 0 0 0
1 3 5 4
0 3 3 2
0 0 1 4

*/
```

