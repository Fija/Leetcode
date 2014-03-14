#include <stdio.h>
//#include <conio.h>
#include <stdlib.h>
#include <string.h>
typedef struct
{
    int m,c;
}MATCH;
typedef MATCH Elemtype;
typedef struct
{
    Elemtype *Elem;
    int Size,Top;
}SQSTACK;
int InitSqstack(SQSTACK *S, int n)
{
    S->Elem=(Elemtype *)malloc(n*sizeof(Elemtype));
    if(S->Elem==NULL) exit(EXIT_FAILURE);
    S->Size=n;
    S->Top=-1;
    return 1;
}
void DestroySqstack(SQSTACK *S)
{
    free(S->Elem);
    S->Elem=NULL;
    S->Top=-1;
    S->Size=0;
}
int IsSqstackEmpty(SQSTACK S)
{
    return S.Top==-1;
}
int IsSqstackFull(SQSTACK S)
{
    return S.Top==S.Size-1;
}
int Push(SQSTACK *S,Elemtype e)
{
    if(IsSqstackFull(*S))return 0;
    S->Top++;
    S->Elem[S->Top]=e;
    return 1;
}
int Pop(SQSTACK *S,Elemtype *e)
{
    if(IsSqstackEmpty(*S)) return 0;
    *e=S->Elem[S->Top];
    S->Top--;
    return 1;
}
void NextVal(char *C,int *Next,int Head,int End)
{
    int j,k;
    Next[Head]=Head-1;
    j=Head;
    while(j<End)
    {
        k=Next[j];
        while(k>=Head&&(!(C[j]==C[k]||C[j]=='?'||C[k]=='?')))
            k=Next[k];
        Next[j+1]=k+1;
        j++;
    }
}
int StrIndexKMP(char *M,char *C,int *Next,int StartM,int Head,int End)
{
    int i=StartM,j=Head;
    if(M[StartM]==0) return -1;
    if(C[Head]=='*'||C[Head]==0) return StartM;
    while(M[i]!=0&&j<=End)
    {
        if(M[i]==C[j])
        {
            i++;
            j++;
        }
        else if(C[j]=='?'&&(j==Head||((j>Head&&M[i-1]==C[j-1])||C[j-1]=='?')))
        {
            i++;
            j++;
        }
        else
        {
            j=Next[j];
            if(j==Head-1)
            {
                i++;
                j=Head;
            }
        }
    }
    if(j==End+1)
        return i-(End-Head+1);
    else
        return -1;
}
void ShowResult(char *M,SQSTACK S,int *Head,int *End)
{
    int i,j=0;
    MATCH Match;
    Match=S.Elem[j];
    for(i=0;M[i]!=0;i++)
    {
        if(i<S.Elem[0].m)
        {
            //textcolor(LIGHTGRAY);
        }
        else if(i<Match.m)
        {
            //textcolor(YELLOW);
        }
        else if(i<Match.m+(End[j]-Head[j]))
        {
            //textcolor(RED);
        }
        else if(i>Match.m+(End[j]-Head[j]))
        {
            //textcolor(LIGHTGRAY);
        }
        else if(i==Match.m+(End[j]-Head[j]))
        {
            //textcolor(RED);
            if(j<S.Size-1)
            {
                j++;
                if(S.Elem[j].m==S.Elem[j-1].m&&Head[S.Elem[j].c]==End[S.Elem[j].c]&&j<S.Size-1) j++;
                Match=S.Elem[j];
            }
        }
        printf("%c",M[i]);
    }
    printf("\n");
}
void main()
{
    /*
    char M[]="abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbaba";
    char C[]="**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
    */
    char M[]="abcdebcdde";
    char C[]="*abcd?e*";
    int AreaNum=1,*AreaHead=NULL,*AreaEnd=NULL;
    int *Next=NULL;
    int i,k,j=0,Pos=0;
    SQSTACK S;
    MATCH Match;
    //clrscr();
    printf("Mother String: %s\n",M);
    printf(" Child String: %s\n",C);
    for(i=0;C[i]!=0;i++)
    {
        if(C[i]=='*'&&C[i+1]=='*')
        {
            for(k=i;C[k]!=0;k++)
            {
                C[k]=C[k+1];
            }
        }
    }
    for(i=0;C[i]!=0;i++)
    {
        if(C[i]=='*') AreaNum++;
    }
    AreaHead=(int*)malloc(AreaNum*sizeof(int));
    AreaEnd=(int*)malloc(AreaNum*sizeof(int));
    Next=(int*)malloc(strlen(C)*sizeof(int));
    InitSqstack(&S,AreaNum);
    if(AreaHead==NULL||AreaEnd==NULL||Next==NULL)
    {
        printf("Not Enough Momery!");
        exit(EXIT_FAILURE);
    }
    for(i=0;i<AreaNum;i++)
    {
        AreaHead[i]=0;AreaEnd[i]=0;
    }
    for(i=0;C[i]!=0;i++)
    {
        Next[i]=0;
    }
    AreaHead[j]=0;
    for(i=0;C[i]!=0;i++)
    {
        if(C[i]!='*')
        {
            AreaEnd[j]=i;
        }
        else
        {
            j++;
            AreaHead[j]=i+1;
            AreaEnd[j]=i+1;
        }
    }
    for(i=0;i<AreaNum;i++)
    {
        NextVal(C,Next,AreaHead[i],AreaEnd[i]);
    }
    for(i=0;i<AreaNum;i++)
    {
        if(C[AreaHead[i]]=='*')
        {
            Pos=StrIndexKMP(M,C,Next,0,AreaHead[i],AreaEnd[i]);
        }
        else if(C[AreaHead[i]]==0)
        {
            Pos=StrIndexKMP(M,C,Next,Pos+AreaEnd[i-1]-AreaHead[i-1],AreaHead[i],AreaEnd[i]);
        }
        else
        {
            if(i==0||C[AreaHead[i-1]]=='*')
            {
                Pos=StrIndexKMP(M,C,Next,Pos,AreaHead[i],AreaEnd[i]);
            }
            else
            {
                Pos=StrIndexKMP(M,C,Next,Pos+AreaEnd[i-1]-AreaHead[i-1]+1,AreaHead[i],AreaEnd[i]);
            }
        }
        if(Pos!=-1)
        {
            Match.m=Pos;Match.c=i;
            Push(&S,Match);
        }
        else
        {
            break;
        }
    }
    if(!IsSqstackFull(S))
    {
        printf("No Matching Result...");
    }
    else
    {
        while(!IsSqstackEmpty(S))
        {
            if(IsSqstackFull(S))
            {
                ShowResult(M,S,AreaHead,AreaEnd);
                Pop(&S,&Match);
                Match.m++;
            }
            else
            {
                if(Pos!=-1)
                {
                    Match=S.Elem[S.Top];
                    Match.c++;
                    if(C[AreaHead[Match.c-1]]!='*')
                    {
                        if(C[AreaHead[Match.c]]==0)
                        {
                            Match.m=Match.m+AreaEnd[Match.c-1]-AreaHead[Match.c-1];
                        }
                        else
                        {
                            Match.m=Match.m+AreaEnd[Match.c-1]-AreaHead[Match.c-1]+1;
                        }
                    }
                }
                else
                {
                    Pop(&S,&Match);
                    Match.m++;
                }
            }
            Pos=StrIndexKMP(M,C,Next,Match.m,AreaHead[Match.c],AreaEnd[Match.c]);
            if(Pos!=-1)
            {
                Match.m=Pos;
                Push(&S,Match);
            }
        }
    }
}
