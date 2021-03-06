package leer;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


import java.util.ArrayList;



public class Punto {
      private double latitud;
      private double longitud;
      private double epsilon;
      private double elevacion;
      private String tiempo;
      
      public Punto(){}
      // Constructor
      public Punto(double x, double y,double ele,String time) {
        this.latitud = x;
        this.longitud = y;
        this.elevacion=ele;
        this.tiempo=time;
      }

      // toString: devuelve una cadena con la representacion del objeto
      public String toString() {
        // el signo + para cadenas no significa "suma matematica" sino concatenacion
        return "(" + latitud + ", " + longitud+ ", " +elevacion +", "+ tiempo +")";
      }

     

      // metodos de acceso
      public double getLatitud() {
        return latitud;
      }

      public double getLongitud() {
        return longitud;
      }
      
      
      public double getElevacion() {
		return elevacion;
	}
      
      
	public String getTiempo() {
		return tiempo;
	}
	public Punto calcularMaxima(ArrayList<Punto> otrosPuntos) {
            Punto puntoMaximo = null;

            if (otrosPuntos != null && otrosPuntos.size() > 0) {
              // me guardo el primero como mas cercano
              double distanciaMaxima = calcularDistancia(otrosPuntos.get(0));
              puntoMaximo = otrosPuntos.get(0);

              for (int i = 1; i < otrosPuntos.size(); i++) {
                // si encuentro otro maximo, lo sustituyo
                double distancia = calcularDistancia(otrosPuntos.get(i));
                if (distancia > distanciaMaxima) {
                  distancia = distanciaMaxima;
                  puntoMaximo = otrosPuntos.get(i);
                }
              }
            }
            
            
            
            
            // devuelve el punto encontrado si el array contiene puntos, null en caso
            // contrario
            return puntoMaximo;
          }
      
      
      
     
      public double calcularDistancia(Punto otroPunto) {
            double x1 = latitud - otroPunto.getLatitud();
            double y1 = longitud - otroPunto.getLongitud();
            return Math.sqrt(x1 * x1 + y1 * y1);
            
    }
      
      
      
}
