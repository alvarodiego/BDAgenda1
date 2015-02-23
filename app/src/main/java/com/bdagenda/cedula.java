package com.bdagenda;

public class cedula {
	
	public static boolean valida(String editable){
	    int suma=0;
	    if(editable.length()==9){
	      
	      return false;
	    }else{
	      int a[]=new int [editable.length()/2];
	      int b[]=new int [(editable.length()/2)];
	      int c=0;
	      int d=1;
	      for (int i = 0; i < editable.length()/2; i++) {
	        a[i]=Integer.parseInt(String.valueOf(editable.charAt(c)));
	        c=c+2;
	        if (i < (editable.length()/2)-1) {
	          b[i]=Integer.parseInt(String.valueOf(editable.charAt(d)));
	          d=d+2;
	        }
	      }
	   
	      for (int i = 0; i < a.length; i++) {
	        a[i]=a[i]*2;
	        if (a[i] >9){
	          a[i]=a[i]-9;
	        }
	        suma=suma+a[i]+b[i];
	      } 
	      int aux=suma/10;
	      int dec=(aux+1)*10;
	      if ((dec - suma) == Integer.parseInt(String.valueOf(editable.charAt(editable.length()-1))))
	        return true;
	      else
	        if(suma%10==0 && editable.charAt(editable.length()-1)=='0'){
	          return true;
	        }else{
	          return false;
	        }
	    
	  }
	}}
	
	




