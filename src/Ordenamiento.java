/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aaron
 */
public class Ordenamiento {
    public int[] A= new int[25];
   
    
    public void arreglo(){
          for(int n=0; n<25; n++){
          double v = Math.random()*100;
        int d = (int)v;
        A[n]=d;
        }
    }
    
    public  void shell() {
            
        int salto, aux, i;
        boolean cambios;
      
        
        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento                                         
                cambios = false;
                for (i = salto; i < 25; i++)   // se da una pasada
                {
                    if (A[i - salto] > A[i]) {       // y si están desordenados
                        aux = A[i];                  // se reordenan
                        A[i] = A[i - salto];
                        A[i - salto] = aux;
                        cambios = true;              // y se marca como cambio.                                   
                    }
                }
            }
        }
}
    
    public void radix(){
         if(A.length == 0)


           return;


         int[][] np = new int[A.length][2];


        int[] q = new int[0x100];


       int i,j,k,l,f = 0;


        for(k=0;k<4;k++){


           for(i=0;i<(np.length-1);i++)
               np[i][1] = i+1;
           np[i][1] = -1;
           
           for(i=0;i<q.length;i++)
               q[i] = -1;

           for(f=i=0;i<A.length;i++){
                  j = ((0xFF<<(k<<3))&A[i])>>(k<<3);
               if(q[j] == -1)
                  l = q[j] = f;

               else{

                   l = q[j];

                   while(np[l][1] != -1)


                       l = np[l][1];
                       np[l][1] = f;
                       l = np[l][1];
               }
                        f = np[f][1];
                        np[l][0] = A[i];
                        np[l][1] = -1;
           }
                         for(l=q[i=j=0];i<0x100;i++)
                         for(l=q[i];l!=-1;l=np[l][1])
                         A[j++] = np[l][0];


       }

        
    }
    
    
    public void burbuja(){
        int Aux=0;
        for(int i=0;i<25;i++){
            for(int j=i+1;j<25;j++){
                if(A[j]<A[i]){
                    Aux=A[i];
                    A[i]=A[j];
                    A[j]=Aux;
                }
            }
        }
    }
    
    public void Quicksort(){
        Quicksort(A, 0, A.length -1);
    }
    
    private void Quicksort(int numeros[], int primero, int ultimo){
        int pivote = numeros[primero];
        int i = primero; 
        int j = ultimo; 
        int aux;

        while(i<j){
           while (numeros[i] <= pivote && i < j) i++;

           while (numeros[j] > pivote) j--;   

           if (i<j){                                     
               aux = numeros[i];                  
               numeros[i]= numeros[j];
               numeros[j]=aux;
           }
        }
         numeros[primero] = numeros[j]; 
         numeros[j] = pivote;

         if (primero < j-1)
            Quicksort(numeros,primero,j-1);

         if (j+1 < ultimo)
            Quicksort(numeros,j+1,ultimo);
    }
    
  public String  Impresion (){
      String cad="";
      for (int i = 0; i < 25; i++) {
  cad+= (i+":["+A[i]+"]  ");
 }
      cad+="\n";
   return cad;
 }
}
