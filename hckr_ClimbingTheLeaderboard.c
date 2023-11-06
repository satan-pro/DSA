#include <stdio.h>
#include <stdlib.h>

int* climbingLeaderboard(int ranked_count, int* ranked, int player_count, int* player, int* result_count) {

    int* spRank = (int*)malloc(ranked_count*sizeof(int));
    *result_count=player_count;
    int* result = (int*)malloc(player_count*sizeof(int));
    int count=1;
    int j=0;
    for(int i=j; i<ranked_count; i++)
    {
        i=j;
       for(j=i; j<ranked_count;j++)
       {
        if(ranked[i]==ranked[j])
        {
            spRank[j] = count;
        }
        else{
            break;
        }
       }
       count++;
    }
    for(int i=player_count-1; i>=0; i--)
    {
        int currScore = player[i];
        int currSpRank;
        int currLowestRank;
        for(int j=0; j<ranked_count; j++)
        {
            int currRank = ranked[j];
            currSpRank = spRank[j];
           
            if(currScore>=currRank)
            {
                result[i]=currSpRank;
                currLowestRank=currSpRank;
               
                break;
            }
            if(currScore<currRank)
            {
                if(j==ranked_count-1)
                {
                    if(currScore>=player[i+1])
                    {
                        printf("%d %d\n", currScore, player[i+1]);
                        result[i]=currLowestRank;
                    }
                    if(currScore<currRank)
                    {
                        if(currLowestRank<currSpRank)
                        {
                            currLowestRank=currSpRank;
                        }
                        
                        if(currScore<player[i+1])
                        {
                            result[i]=++currLowestRank;
                        }
                    }
                }
            }
        }
    }
    return result;

}

int main()
{
    int ranked[7] = {100,100,50,40,40,20,10};
    int player[4] = {5,6,50,120};
    int result_count;
    int* result = climbingLeaderboard(7,ranked,4,player,&result_count);
    for(int i=0; i<result_count; i++)
    {
        printf("%d\n",result[i]);
    }

}