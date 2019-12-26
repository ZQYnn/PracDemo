```c
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <string>
#include <cstring>
#include <stack>
#include <queue>
#define MAX_SIZE 100
#define INF 65535
/*
课程设计城市建设规划
实现如下功能 main function
1.每个城市介绍（遍历图，按照结点信息输出 或者BFS DFS遍历）
2.添加城市信息
3.删除城市 删除路径
4.更改城市信息
5.查询浏览路线 即求两点之间的最短路径使用Dijkstra算法
6.查询城市之之间的可行路径使用Fyold
7.重新规划城市结构重新输入结点信息
8.找到连通n城市的n-1条边两种算法 Kruskal 算法
9.通矩阵的方式输出当前所有城市信息
基本思路
实现的主要思路通过临邻接矩阵的方式构建图，通过图论算法实现每个
其基本功能
*/
using namespace std;
struct Graph{
    string vexs[MAX_SIZE];              //城市的节点名称
    string baseinfo[MAX_SIZE];          //城市的基本信息
    int arc[MAX_SIZE][MAX_SIZE];        //两城市之间的权值
    int numvex,numarc;                  //表示城市的个数以及城市之间路径的条数
};
struct Edge{
    int beg, des, wei;
};
//初始化成之间的基本信息
void CreateGraph(Graph &G){
    G.numvex = 6;
    G.numarc = 9;
    string vexname[G.numvex] = {"city1", "city2", "city3", "city4", "city5", "City6"};
    string Cityinfo[G.numvex] =
                                { "City1是城市优美________",
                                  "City2是人文气息优雅_________",
                                  "CIty3是历史悠久的古都________",
                                  "City4是科技高速发展________",
                                  "city5是科技创新中心_______",
                                  "city6是的政治、经济、文化中心_______"
                                };
    for(int i = 0; i < G.numvex; i++){
        G.vexs[i] = vexname[i];
        G.baseinfo[i] = Cityinfo[i];
    }
    fill(G.arc[0], G.arc[0] + MAX_SIZE * MAX_SIZE, INF);
    int beg[G.numarc] = {0, 1, 2, 4, 0, 1, 1, 4, 3};
    int des[G.numarc] = {1, 3, 4, 6, 2, 2, 4, 3, 5};
    int wei[G.numarc] = {1, 7, 1, 6, 5, 3, 5, 2, 3};
    for(int i = 0; i < G.numarc; i++){
        G.arc[beg[i]][des[i]] = wei[i] * 10;
        G.arc[des[i]][beg[i]] = wei[i] * 10;
    }
}
//重新建立城市的规划
void ReCreateGraph(Graph &G){
  int vi, vj, w;
    cout << "please enter the number of vertexes and arcs : \n";
    cin >> G.numvex >> G.numarc;
    for(int i = 0; i < G.numvex; i++){
        printf("Please enter the NO.%d name and base info of the vex : ",i+1);
        cin >> G.vexs[i] >>  G.baseinfo[i];
    }
    for(int i = 0; i < G.numvex; i++){
        for(int j = 0; j < G.numvex ;j++){
            G.arc[i][j] = INF;
        }
    }
    cout << endl;
    for(int i = 0; i < G.numarc; i++){
        cout<< "Enter the subscripts and weights from vertex vi to vertex vj : ";
        cin >> vi >> vj >> w;
        G.arc[vi][vj] = w;
        G.arc[vj][vi] = w;
    }
}
//通过临街矩阵的方式显示信息
void DispalyGraphMatrix(Graph G){
    printf("\n邻接矩阵为:\n");
    for(int i = 0; i < G.numvex; i++){
        for(int j = 0; j < G.numvex; j++){
            if(G.arc[i][j] == INF) {
                if(i == j) printf("%6s", "0");
                else
                    printf("%6s", "∞");
            }
            else printf("%6d", G.arc[i][j]);
        }
        cout << endl;
    }
}
void ShowCityinfo(Graph G){
    printf("\n城市的基本信息如下\n");
    for(int i = 0; i < G.numvex; i++)
        cout << G.vexs[i] << " : "<< G.baseinfo[i] << endl;
}
void DeletePath(Graph &G){
    int n;
    string s1, s2;
    cout << "输入删除的路径条数" <<endl;
    cin >> n;
    for(int i = 0; i < n; i++){
        cout << "输入此条路径需要删除的起始和目标城市"<< endl;
        int  L1 = -1, L2 = -1;
        cin >> s1 >> s2;
        for(int i = 0; i < G.numvex; i++){
            if(s1 == G.vexs[i]) L1 = i;
        }
        if(L1 == -1)cout << "起始城市不存在";
        for(int i = 0; i < G.numvex; i++){
            if(s2 == G.vexs[i]) L2 = i;
        }
        if(L2 == -1)cout << "目标城市不存在";
        if(L1 != -1 && L2 != -1) {
            G.arc[L1][L2] = INF;
            G.arc[L2][L1] = INF;
            cout << "删除成功";
        }
    }
}
void DeleteCity(Graph &G, string s){
    int loc = -1;
    //查找要删除的城市名称 由于需要查找的结点较少，直接使用暴力查找的方式就可以啦
    for(int i = 0; i < G.numvex; i++){
        if(s == G.vexs[i]){
            loc = i;
            break;
        }
    }
    if(loc == -1){
        printf("当前城市不含此节点！\n");
        return;
    }
    for(int i = loc; i < G.numvex - 1; i++)
        G.vexs[i] = G.vexs[i + 1];
    for(int i = 0; i < G.numvex; i++){
        for(int j = loc; j < G.numvex; j++){
            G.arc[i][j] = G.arc[i][j + 1];
        }
    }
    for(int i = loc; i < G.numvex; i++){
        for(int j = 0; j < G.numvex; j++){
            G.arc[i][j] = G.arc[i + 1][j];
        }
    }
    G.numvex -= 1;
    printf("删除成功!\n");
}
void AddCity(Graph &G){
    string temp1 ,temp2;
    string city[G.numvex] = {"0"};
    int len = 0, tempwei, loc[G.numvex] = {0}, wei[G.numarc] = {0};
    cout << "请输入加入城市的名称和基本信息\n";
    cin >> temp1 >> temp2;
    for(int i = 0; i < G.numvex; i++){
        if(temp1 == G.vexs[i]){
            cout <<"当前添加的城市信息已经存在，不可以重复添加\n";
            return;
        }
    }
    G.numvex += 1;
    G.vexs[G.numvex - 1] = temp1;
    G.baseinfo[G.numvex - 1] =temp2;
    cout << "请输入其他城市可以到达当前添加城市的名称 以及到达此城市的权值 输入e e结束\n";
    while(cin >> temp1 >> tempwei && temp1 != "e" && len < G.numvex - 1){
        int L = -1;
        for(int i = 0; i < G.numvex - 1; i++){
            if(temp1 == G.vexs[i]){
                L = i;
                wei[len] = tempwei;
                loc[len] = i;
                city[len++] = temp1;
                break;
            }
        }
        if(L == -1){
            cout << temp1 <<"这个城市不存在无法产生联系 添加关联就不会纳入，请输入正确的信息" << endl;
        }
    }
    for(int i = 0; i < len; i++){
        G.arc[G.numvex - 1][loc[i]] = wei[i];
        G.arc[loc[i]][G.numvex - 1] = wei[i];
    }
}
void UpdateCityName(Graph &G){
    string s1 ,s2;
    int L = -1;
    cout << "输入要更新城市名称 , 以及修改后的名称\n";
    cin >> s1 >> s2;
    for(int i = 0; i < G.numvex; i++){
        if(s1 == G.vexs[i]){
            L = i;
            G.vexs[i] = s2;
            break;
        }
    }
    if(L == -1) cout << "需要更新的城市不存在\n";
}
void UpdateCityBaseinfo(Graph &G){
    string s1 ,s2;
    int L = -1;
    cout << "输入要更新城市名称 , 以及修改后的基本介绍信息\n";
    cin >> s1 >> s2;
    for(int i = 0; i < G.numvex; i++){
        if(s1 == G.vexs[i]){
            L = i;
            G.baseinfo[i] = s2;
            break;
        }
    }
    if(L == -1) cout << "需要更新的城市不存在\n";
}
void UpdateCitiesNetwork(Graph &G){
    int n;
    string s1, s2;
    cout << "输入更新的路径条数" <<endl;
    cin >> n;
    for(int i = 0; i < n; i++){
        cout << "输入此条路径需要更新的起始和目标城市"<< endl;
        int  L1 = -1, L2 = -1, wei;
        cin >> s1 >> s2 >> wei;
        for(int i = 0; i < G.numvex; i++){
            if(s1 == G.vexs[i]) L1 = i;
        }
        if(L1 == -1)cout << "起始城市不存在";
        for(int i = 0; i < G.numvex; i++){
            if(s2 == G.vexs[i]) L2 = i;
        }
        if(L2 == -1)cout << "目标城市不存在";
        if(L1 != -1 && L2 != -1) {
            G.arc[L1][L2] = wei;
            G.arc[L2][L1] = wei;
            cout << "更新成功";
        }
    }
}
void ShowP2PShortPath(Graph G,int v){
    cout <<" 依次访问的路线为 :"<< G.vexs[v] << " -> " ;
    int min, k, dist[MAX_SIZE], path[MAX_SIZE], Final[MAX_SIZE];
    for(int i = 0; i < G.numvex; i++){
            dist[i] = G.arc[v][i];
            path[i] = 0;
            Final[i] = 0;
    }
    dist[v] = 0;
    Final[v] = 1;
    for(int i = 0; i < G.numvex; i++){
        min = INF;
        for(int j = 0; j < G.numvex; j++){
            if(!Final[j] && min > dist[j]){
                min = dist[j];
                k = j;
            }
        }
        if(i != G.numvex -1){
            if(i != G.numvex -2) cout << G.vexs[k] << " -> " ;
            else cout << G.vexs[k] << endl;
        }
        Final[k] = 1;
        for(int j = 0; j < G.numvex; j++){
            if(!Final[j] &&(min + G.arc[k][j] < dist[j])){
                dist[j] = min + G.arc[k][j];
                path[j] = k;
            }
        }
    }
    cout << "本次访问的总路径为： "<< dist[G.numvex - 1]<< endl;
}
void ShowAllShortPath(Graph G){

}
int Find(int parent[], int f){
    while(parent[f] > 0) f = parent[f];
    return f;
}
bool cmp (Edge a, Edge b){
    return a.wei < b.wei;
}
void ShowMPT1(Graph G){
    Edge e[MAX_SIZE];
    int parent[MAX_SIZE], k = 0, m, n;
    for(int i = 0; i < G.numvex; i++){
        for(int j = 0; j < G.numvex; j++){
            if(G.arc[i][j] != INF ){
                e[k].beg = i;
                e[k].des = j;
                e[k].wei = G.arc[i][j];
                k++;
            }
        }
    }
    sort(e, e + k, cmp);
    memset(parent, 0 ,sizeof(parent));
    for(int i = 0; i < k; i++){
        m = Find(parent, e[i].beg);
        n = Find(parent, e[i].des);
        if(m != n){
            parent[m] = n;
            cout <<  "起始城市是:" << G.vexs[e[i].beg]<< " ,目标城市是" << G.vexs[e[i].des]<< " 他们之间的路径长度为" << e[i].wei << endl;
        }
    }
}
void ShowMPT2(Graph G){

}
/*图中的顶点存在变化，使用递归方式需要对是否参观过这个参数传递
，反而过于繁琐*/
void DFS(Graph G){
    stack<int> s;
    int j;
    bool vis[G.numvex];
    for(int i = 0; i < G.numvex; i++){
        if(!vis[i]){
            cout << "访问"<<G.vexs[i] << endl;
            s.push(i);
            vis[i] = true;
        }
        while(!s.empty()){
            int temp = s.top();
            for(j = 0; j < G.numvex; j++){
                if(G.arc[temp][j] && !vis[j]){
                    vis[j] = true;
                    cout<< "访问" << G.vexs[j] << endl;
                    s.push(j);
                    break;
                }
            }
            if(j == G.numvex) s.pop();
        }
    }
}
//使用queue的结构遍历当前的图
void BFS(Graph G){
    bool vis[G.numvex];
    queue<int> q;
    for(int i = 0; i < G.numvex; i++){
        if(!vis[i]){
            vis[i] = true;
            cout <<" 访问：" <<G.vexs[i] << endl;
            q.push(i);
            while(!q.empty()){
                int front = q.front();
                q.pop();
                for(int j = 0; j < G.numvex; j++){
                    if(G.arc[front][j] && !vis[j]){
                        vis[j] = true;
                        cout << " 访问 " << G.vexs[j] <<endl;
                        q.push(j);
                    }
                }
            }
        }
    }
}
void Menu(){
    printf("\n");
    printf("************************************************************************************\n");
    printf("*                    欢迎使用城市规划方案                                          *\n");
    printf("* 1-显示当前城市基本信息                      2-添加城市                           *\n");
    printf("* 3-删除城市                                  4-删除城市间路径                     *\n");
    printf("* 5-更新城市间路径                            6-更新城市名称                       *\n");
    printf("* 7-更新城市基本信息                          8-按照深度游览城市                   *\n");
    printf("* 9-按照广度游览城市                          10-获取游览全部城市的最佳方案        *\n");
    printf("* 11-获取连通全部城市的最佳方案               12-通过矩阵的方式显示路径            *\n");
    printf("* 13- 重构城市规划                            0 - 退出当前系统                     *\n");
    printf("************************************************************************************\n");
}
int check(int c){
    while(!(c >= 0 && c <= 13)){
        printf("请输入正确的操作符号\n");
        scanf("%d", &c);
    }
    return c;
}
int main(){
    Graph G;
    CreateGraph(G);
    int c;
    Menu();
    printf("请输入相应的操作\n");
    scanf("%d", &c);
    c = check(c);
    while(1){
        switch(c){
            case 1: {system("cls"); ShowCityinfo(G); break;}
            case 2: { AddCity(G); break;}
            case 3: {
                system("cls");
                string s;
                printf("输入删除的目标城市\n");
                cin >> s;
                DeleteCity(G, s);
                break;
            }
            case 4: {system("cls"); DeletePath(G); break;}
            case 5: {system("cls"); UpdateCitiesNetwork(G); break;}
            case 6: {system("cls"); UpdateCityName(G); break;}
            case 7: {system("cls"); UpdateCityBaseinfo(G); break;}
            case 8: {system("cls"); DFS(G); break;}
            case 9: {system("cls"); BFS(G); break;}
            case 10: {
                system("cls");
                string s;
                int L = -1;
                printf("请输入起始城市名称\n");
                cin >> s;
                for(int i = 0; i < G.numvex; i++){
                    if(s == G.vexs[i]) L = i;
                }
                if(L == -1) break;
                ShowP2PShortPath(G, L);
                break;
             }
            case 11: {system("cls"); ShowMPT1(G); break;}
            case 12: {DispalyGraphMatrix(G); break;}
            case 13: {ReCreateGraph(G); break;}
            case 0:  {exit(0); break;}
            default: break;
        }
        Menu();
        printf("请输入相应的操作\n");
        scanf("%d", &c);
        c = check(c);
    }
    return 0;
}
```

