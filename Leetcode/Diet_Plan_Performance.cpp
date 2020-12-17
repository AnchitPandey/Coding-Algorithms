class Solution {
public:
    int dietPlanPerformance(vector<int>& calories, int k, int lower, int upper) {

        int total =0;
        int runner = 0;
        for (int i =0 ; i< k;i+=1)
            runner += calories[i];
        if (runner > upper)
            total += 1;
        else if (runner < lower)
            total -=1;
        for (int i =k; i < calories.size();i+=1)
        {
            runner -= calories[i-k];
            runner+= calories[i];
            if (runner > upper)
            total += 1;
        else if (runner < lower)
            total -=1;
        }
        return total;
    }
};
