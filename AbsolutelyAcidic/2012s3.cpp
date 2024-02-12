//
// Created by Wesley Ou on 2024-02-12.
//
#include <iostream>
#include <map>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> sensorReadings(n);
    for (int i = 0; i < n; ++i) {
        cin >> sensorReadings[i];
    }
    map<int, int> sensorFrequencies;
    //read frequences to map
    for (auto& reading: sensorReadings) {
        if (sensorFrequencies[reading]) {sensorFrequencies[reading] += 1;}
        else {sensorFrequencies[reading] = 1;}
    }
    pair<int, int> mostFrequent = make_pair(-1,-1);
    pair<int, int> secondFrequent = make_pair(-1, -1);

    for (auto& freq : sensorFrequencies) {
        if (freq.second > mostFrequent.second) {
            secondFrequent = mostFrequent;
            mostFrequent = freq;
        } else if (freq.second > secondFrequent.second) {
            secondFrequent = freq;
        }
    }

    int maxDiff;
    maxDiff = abs(mostFrequent.first - secondFrequent.first);

    for (auto& freq: sensorFrequencies) {
        if (freq.second == secondFrequent.second) {
            maxDiff = max(maxDiff, abs(mostFrequent.first - freq.first));
        }
    }

    cout << maxDiff;

    return 0;
}