#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <iostream>
#include <algorithm>
#include <vector>
#include <set>

using namespace std;

int main(int argc, char **argv)
{
	set<string> t;
	string s, ss;
	cin >> s;
	unsigned int i, l = 1, z = s.size();
	while (l <= z) {
		t.clear();
		for (i=0; i<z-l+1; i++) {
			ss = s.substr(i,l);
			t.insert(ss);
		}
		if (t.size() < pow(2, l)) {
			cout << l << '\n';
			return 0;
		}
		l++;
	}
	
	return 0;
}

