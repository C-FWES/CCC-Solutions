//
// Created by wesley on 2024-02-15.
//
#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int x; // number of constrains
    cin >> x;

    vector<pair<string, string>> togetherConstrains;

    for (int i = 0; i < x; ++i) {
        string c1, c2; // to hold constrain pair
        cin >> c1 >> c2;
        togetherConstrains.push_back(make_pair(c1, c2));
    }

    int y;
    cin >> y;

    vector<pair<string, string>> separateConstrains;

    for (int i = 0; i < y; ++i) {
        string c1, c2;
        cin >> c1 >> c2;
        separateConstrains.push_back(make_pair(c1, c2));
    }

    unordered_map<string, unordered_set<string>> groups; // we using unordered map for the best efficient lookup

    int g;
    cin >> g;

    for (int i = 0; i < g; ++i) {
        string g1,g2,g3;
        cin >> g1 >> g2 >> g3;
        groups[g1] = {g2, g3};
        groups[g2] = {g1, g3};
        groups[g3] = {g1, g2};
    }

    int count = 0;
    // for each contrain, performed a lookup
    // the people that must be together
    for (int i = 0; i < togetherConstrains.size(); ++i) {
        string n1 = togetherConstrains[i].first;
        string n2 = togetherConstrains[i].second;
        if (groups[n1].find(n2) == groups[n1].end()) {
            ++count;
        }
    }

    for (int i = 0; i < separateConstrains.size(); ++i) {
        string n1 = separateConstrains[i].first;
        string n2 = separateConstrains[i].second;
        if (groups[n1].find(n2) != groups[n1].end()) {
            ++count;
        }
    }

    cout << count;

    return 0;
}
