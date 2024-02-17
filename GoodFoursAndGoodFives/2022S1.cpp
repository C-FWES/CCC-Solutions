//
// Created by wesle on 2024-02-16.
//
#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    // first subtask: n <= 10
    // this can be handle by simple check
    if (n <= 10) {
        if (n == 8) {
            cout << 1;
            return 0;
        } else if (n == 4) {
            cout << 1;
            return 0;
        }
        else if (n == 5) {
            cout << 1;
            return 0;
        }
        else if (n == 9) {
            cout << 1;
            return 0;
        } else if (n == 10) {
            cout << 1;
            return 0;
        } else {
            cout << 0;
            return 0;
        }
    }
    int totalWays = 0;
    // n = 4*(# of 4s) + 5*(# of 5s)
    // so then we can check if n - a multiple of 4 is divisible by 5, is so, there is a multiple of 5 that adds to n
    for (int i = 0; i <= n/4; ++i) {
        if ((n-(4*i)) % 5 == 0) {
            ++totalWays;
        }
    }
    cout << totalWays;
    return 0;
}
