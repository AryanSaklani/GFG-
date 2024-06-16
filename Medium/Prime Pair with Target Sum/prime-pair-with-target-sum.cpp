//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

class Array {
  public:
    template <class T>
    static void input(vector<T> &A, int n) {
        for (int i = 0; i < n; i++) {
            scanf("%d ", &A[i]);
        }
    }

    template <class T>
    static void print(vector<T> &A) {
        for (int i = 0; i < A.size(); i++) {
            cout << A[i] << " ";
        }
        cout << endl;
    }
};


// } Driver Code Ends

class Solution {
  public:
    vector<int> getPrimes(int n) {
    vector<int> ans;
        
      if(n<=3)
      return {-1,-1};
   set<int> primes;
    primes.insert(2);
    primes.insert(3);
    primes.insert(5);
    primes.insert(7);

  for (int i = 11; i < n; i += 2) {
        bool isPrime = true;
        for (int j = 3; j * j <= i; j += 2) {
            if (i % j == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime)
            primes.insert(i);
    }
  

    for (int prime : primes) {
        int complement = n - prime;
        if (primes.count(complement)) {

             ans.push_back(prime);
            ans.push_back(complement);
            return ans;
           }

        }

    return {-1, -1};

    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        int n;
        scanf("%d", &n);

        Solution obj;
        vector<int> res = obj.getPrimes(n);

        Array::print(res);
    }
}

// } Driver Code Ends