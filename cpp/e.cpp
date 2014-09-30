#include <iostream>
#include <vector>
#include <set>

using namespace std;

void printset(set<unsigned int> &m){
	for(set<unsigned int>::iterator i = m.begin(); i != m.end(); i++)
		cout << *i << " ";
}

void printgraph(vector<set<unsigned int > > &m ){
	for(unsigned int i = 0; i < m.size(); i++){ 
		printset(m[i]);
		cout << "\n";
	}
	cout << "terminaaaa\n";
}

int main(){
	unsigned int a, n, i, j, k, autores, buff;
	cout.sync_with_stdio(false);
	cin.sync_with_stdio(false);
	cin >> a;
	cin >> n;
	
	vector<set<unsigned int> > g(n,set<unsigned int>());
		
	vector<unsigned int> aut;
	for(i = 0; i < a; i++){
		cin >> autores;
		aut.clear();
		for(j = 0; j < autores; j++){
			cin >> buff;
			aut.push_back(buff);
		}
		int auta, autb;
		for(j = 0; j < autores; j++){
			for(k = 0; k < autores; k++){
				auta = aut[k]-1;
				autb = aut[j]-1;
				g[auta].insert(autb);
				g[autb].insert(auta);
			}
		}
	}
	
	vector<int> erdos(n,-1);
	erdos[0] = 0;
	int grado = 0;
	bool entra = true;
	while(entra){
		entra = false;
		for(unsigned int i = 0; i < n; i++){
			if(erdos[i] == grado){
				for(unsigned int j = 0; j < n; j++){
					if (*(g[i].find(j))){
							if(erdos[j] == -1){
							erdos[j] = grado + 1;
							entra = true;
						}
					}
				}
			}
		}
		grado++;
	}
	printgraph(g);
	int cant = 0, suma = 0, max_erdos = 0;
	for(i = 0; i < erdos.size(); i++){
		if(erdos[i] != -1){
			cant++;
			suma += erdos[i];
			max_erdos = max(max_erdos, erdos[i]);
		}
	}
	//cout << cant<< " "<< max_erdos << " " << suma << '\n';
	return 0;
	
}
