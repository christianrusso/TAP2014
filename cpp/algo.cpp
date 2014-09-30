#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool primera(unsigned int suma, unsigned int primero, unsigned int segundo){
	if(primero*100 >= suma*45)
		return true;
	if((primero*100 >= suma*40) && (primero*100 >= segundo*100 + suma * 10))
		return true;
	return false;
}

int main(int argc, char **argv)
{
	unsigned int n, b, sum = 0;
	cin >> n;
	vector<unsigned int> votos;
	for(unsigned int i = 0; i < n; i++){
		cin >> b;
		votos.push_back(b);
		sum += b;
	}
	
	sort(votos.begin(),votos.end());
	
	unsigned int primero = votos[n-1];
	unsigned int segundo = votos[n-2];
	cout << primero << ' ' << segundo << '\n';
	if ( primera ( sum, primero, segundo )) {
		cout << "1\n";
	} else {
		cout << "2\n";
	}
	return 0;
}

