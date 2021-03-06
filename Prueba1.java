class NodoLista {
  int dato;
  NodoLista siguiente;

  NodoLista() {
    dato = 0;
    siguiente = null;
  }

  NodoLista(int x) {
    dato = x;
    siguiente = null;
  }
}

class Lista {
  NodoLista cabeza;

  Lista() {
    cabeza = new NodoLista();
    cabeza.siguiente = null;
  }

  public static void main(String[] args) {
    Lista L = new Lista();
    L.insertar(10, 0);
    L.insertar(20, 1);
    L.insertar(30, 2);
    L.insertar(40, 3);
    L.mostrar();
    float posicion = L.busqueda_binaria((40), L);
    if (posicion == -1) {
      System.out.println("El elemento no se encuentra en la lista!");
    } else {
      System.out.println("El elemento se encuentra en la posición: " + posicion);
    }
  }

  public void insertar(int x, int p) {
    NodoLista aux = new NodoLista(x);
    NodoLista temp = cabeza;
    int i = 0;
    if (p < 0)
      System.out.println("Posicion inválida!");
    else {
      while ((temp.siguiente != null) && (i != p)) {
        i++;
        temp = temp.siguiente;
      }
      if (i < p)
        System.out.println("La posición indicada no existe!");
      else
        insertar(aux, temp);
    }
  }

  private void insertar(NodoLista x, NodoLista p) {
    x.siguiente = p.siguiente;
    p.siguiente = x;
  }

  private void mostrar() {
    NodoLista temp = cabeza;
    boolean first = true;
    while (temp.siguiente != null) {
      System.out.print((first ? "" : "-") + temp.siguiente.dato);
      temp = temp.siguiente;
      first = false;
    }
    System.out.println();
  }

  public float busqueda_binaria(int datoABuscar, Lista L) {
    NodoLista temp = L.cabeza;
    float counter = 0;
    while (temp != null) {
      if (temp.dato == datoABuscar) {
        return counter - 1;
      }
      temp = temp.siguiente;
      counter++;
    }
    System.out.println();
    return -1;
  }
}