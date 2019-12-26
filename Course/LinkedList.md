## 链表的一些基本操作



```c
#include <stdio.h>
#include <stdlib.h>
typedef struct Athlete{
    int  id;
    char name[20];
    char items[20];
    char gender[5];
    int  score ;
    struct Athlete *next;
}Ath, *Athl;
/*
    实现链表的建立通过返头指针，实现链表的一系列操作
    使用尾插法建立
*/
Ath *creat(){
    //头节点
    Ath *head, *r, *s;
    head = (Athl)malloc(sizeof(Ath));
    r = head;
    while(1){
        printf("请依次输入运动员的id ,姓名,参加项目,成绩0退出\n");
        s = (Athl)malloc(sizeof(Ath));
        printf("输入学生的id\n");
        scanf("%d", &s->id);
        if(s->id == 0) break;
        printf("输入学生的姓名\n");
        scanf("%s", &s ->name);
        printf("输入学生的性别\n");
        scanf("%s", &s ->gender);
        printf("输入学生的项目\n");
        scanf("%s", &s ->items);
        printf("输入学生的成绩\n");
        scanf("%d", &s ->score);
        r->next = s;
        r = s;
    }
    return head;
}


void sortByid(Athl head){
    Athl t1, t2;
    for(t1 = head->next; t1 != NULL; t1 = t1->next){
        for(t2 = t1->next; t2 != NULL; t2 = t2->next){
            if(t1->id > t2->id){
                int temp = t1->id;
                t1->id = t2->id;
                t2->id =temp;
            }
        }
    }
}


//查询学生信息
void dispalyinfo(Athl head){
    Athl temp;
    temp = (Athl)malloc(sizeof(Ath));
    temp = head ->next;
    while(temp != NULL){
        printf("%3d %3s %3s %3s %3d\n", temp->id, temp->name, temp->gender, temp->items, temp->score);
        temp = temp->next;
    }
}
//删除学生信息
void deleteinfo(Athl head){
    Athl temp, Todele;
    Todele = (Athl)malloc(sizeof(Ath));
    printf("输入删除的id\n");
    scanf("%d", &Todele->id);
    temp = head;
    while(temp->next != NULL){
        if(temp->next->id != Todele->id) temp = temp->next;
        else break;
    }
    temp ->next = temp->next->next;
}
void insertinfoEnd(Athl head){
    Athl temp, pt;
    temp = (Athl)malloc(sizeof(Ath));
    pt = head;
    printf("输入插入节点的信息(依次为id 姓名 性别  项目 成绩 )\n");
    scanf("%d %s %s %s %d", &temp->id, &temp ->name, &temp->gender, &temp->items, &temp->score);
    while(pt->next != NULL) pt = pt->next;
    pt->next = temp;
    temp->next =NULL;
}
void updateinfo(Athl head){
    Athl temp;
    temp = (Athl)malloc(sizeof(Ath));
    printf("输入插入节点的信息\n");
    scanf("%d %s %s %d", &temp->id, &temp ->name, &temp->items, &temp->score);
    head->next->id = temp->id;
    //head->next->name = temp->name;
    //head->next->items = temp->items;
    head->next->score = temp->score;
}
void insertinfoByid(Athl head){
    Athl t1 , temp;
    temp = (Athl)malloc(sizeof(Ath));
    printf("输入插入节点的信息(依次为id 姓名 性别  项目 成绩 )\n");
    scanf("%d %s %s %s %d", &temp->id, &temp ->name, &temp->gender, &temp->items, &temp->score);
    sortByid(head);
    t1 = head;
    while(t1->next != NULL){
        if(t1->id > temp->id) t1 = t1->next;
        else break;
    }
    temp->next = t1->next;
    t1->next = temp;
}
void search(Athl head){
    Athl t, temp;
    temp = (Athl)malloc(sizeof(Ath));
    printf("输入查询的id\n");
    scanf("%d", &temp->id);
    t = head;
    while(t->next != NULL){
        if(t->id != temp->id) t = t->next;
        else break;
    }
    printf("%3d %3s %3s %3s %3d\n", t->id, t->name, t->gender, t->items, t->score);
}

//冒泡排序的主要思想两两相性比较，每比较一次会把一轮最大或最小的数放在最后
void sortByscore(Athl head){
    Athl t1, t2;
    for(t1 = head ->next; t1 != NULL; t1 = t1->next){
        for(t2 = t1 ->next; t2 != NULL; t2 = t2 ->next){
            if(t1->score > t2 ->score){
                int temp = t1->score;
                t1->score = t2->score;
                t2->score =temp;
            }
        }
    }
}

int main(){
    Ath *Head = NULL;
    Head = creat();
    //insertinfoByid(Head);
    printf("-------\n");
    dispalyinfo(Head);
    return 0;
}


/**

20
zqy
a
s
20


26
sas
a1
fd
96

57
as
sd
cd
36

58
as
df
cd
1

0
 *
 */


```

