//
// Created by Wesley  Ou on 2023-02-15.
//
#include <iostream>
#include <vector>
using namespace std;

int main () {
    int C = 0;
    string line;
    int columnCount = 0;
    int count = 2;
    vector<vector<string>> triangles;
    bool gotColumNum  = false;
        while (count > 0 and getline(cin, line)) {
            if (not gotColumNum) {
                C = stoi(line);
                gotColumNum = true;
                columnCount = C;
                continue;
            }
            vector<string> currentLine;
            for (int x  = 0; x < line.size(); x+=2) {
                char current = line[x];
                string curr;
                curr += current;
                currentLine.push_back(curr);
            }
            triangles.push_back(currentLine);
            currentLine.clear();
            --count;
        }

    int tapeLengthCount = 0;

    for (int i = 0; i < triangles.size(); ++i) {
        for (int j = 0; j < triangles[i].size(); ++j) {
            if (triangles[i][j] == "1") {
                int adjacentCount = 0;
                int forward = j+1;
                int backward = j-1;
                int up = i-1;
                int down = i+1;
                if (j + 1 < C and triangles[i][forward] == "1") {
                    ++adjacentCount;
                }
                if (j - 1 >= 0 and triangles[i][backward] == "1") {
                    ++adjacentCount;
                }
                if (i + 1 < 2 and triangles[down][j] == "1") {
                    if (j % 2 == 0) {
                        ++adjacentCount;
                    }
                }
                if (i - 1 >= 0 and triangles[up][j] == "1") {
                    if (j % 2 == 0) {
                        ++adjacentCount;
                    }
                }
                tapeLengthCount += 1*3 - adjacentCount; /* single triangles not adjacent */
            }
        }
    }

    cout << tapeLengthCount;

    return 0;
}