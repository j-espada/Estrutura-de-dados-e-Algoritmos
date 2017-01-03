/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

/**
 *
 * @author J.Espada
 */
public class QuickSort {

    public QuickSort(List<Aresta> A) {
        final int p = 0;
        int r = A.size() - 1;
        run(A, p, r);

    }

    private void exchange(List<Aresta> A, int i, int j) {
        Aresta temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
       
    }

    public void run(List<Aresta> A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            run(A, p, q - 1);
            run(A, q + 1, r);
        }
    }

    private int partition(List<Aresta> A, int p, int r) {

        Aresta x = A.get(r);
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A.get(j).getPeso() <= x.getPeso()) {
                i=i+1;
                exchange(A, i, j);
            }
        }
        exchange(A, i + 1, r);
        return i + 1;
    }
}
