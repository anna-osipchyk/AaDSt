#include<fstream>
#include<queue>
#include<algorithm>
#include<sstream>
#include <string>
#include<iostream>
#include<vector>
using namespace std;

void black_box() {
    auto compare1 = [](int a, int b) { return a < b; };
    auto compare2 = [](int a, int b) { return a > b; };

    ifstream file_in("input.txt");
    ofstream file_out("output.txt");
    int n;
    int m;
    file_in >> m; file_in >> n;
    vector<int> elements(m);


    for (int i = 0; i < m; ++i) {
        file_in >> elements[i];
    }
    int qu;
    file_in >> qu;

    int i = 1;
    int q_pred = -1;
    int quPred = -1;
    priority_queue<int, vector<int>, decltype(compare2)> min_heap(compare2);
    priority_queue<int, vector<int>, decltype(compare1)> max_heap(compare1);
    min_heap.push(elements[0]);
    int j = 1;
    while (true)
    {
        while (max_heap.size() != j - 1) {
             quPred = qu;

            if (elements[i] > min_heap.top()) {
               
                max_heap.push(min_heap.top());
                min_heap.pop();
                min_heap.push(elements[i]);
            }
            else max_heap.push(elements[i]);
            i++;

        }
        while (min_heap.size() + max_heap.size() < qu) {
             quPred = qu;

            if (elements[i] > min_heap.top()) min_heap.push(elements[i]);
            else {
                if (!max_heap.empty() && max_heap.top() > elements[i])
                {
                    min_heap.push(max_heap.top());
                    max_heap.pop();
                    max_heap.push(elements[i]);
                }
                else min_heap.push(elements[i]);
            }
            i++;
        }
    one_more_time:
        if (file_in >> qu)
        {
            file_out << min_heap.top() << " ";
            j++;
            if (qu == quPred) {
                int el = min_heap.top();
                max_heap.push(el);
                min_heap.pop();
                goto one_more_time;

            }
      
        }
        else {
            file_out << min_heap.top() << " ";
            break;
        }

    }
    file_out.close();
}
int main() {
    black_box();
    return 0;
}
