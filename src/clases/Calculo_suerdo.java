

package clases;

/**
 * 
 * @author Alex carrera
 */
public class Calculo_suerdo {
    
double sb,cb,a,ayp,an,isrt,ss,afore,sc,sind;

String puesto="";
double horas=0,xhora=0,deducciones=0,percepciones=0,Sneto=0,anios=0;

public void setEmpleado(String puesto,double horas, double anios){
this.puesto = puesto;
this.horas = horas;
this.anios = anios;
  System.out.println(horas);
           System.out.println(puesto);
            System.out.println(anios);
  
}

public void setCuantoXHora(){
if( null != puesto)switch (puesto) {
        case "Administrador":
            xhora=300;
            break;
        case "Supervisor":
            xhora=250;
            break;
        case "Tecnico":
            xhora=200;
            break;
        default:
            break;
    }

}


public double getSuerdo(){
this.sb = horas * xhora;
return sb;
 
}
public double getCanasta(){
this.cb = sb * 0.06;
return cb;
}
public double getApoyo(){
this.a = sb * 0.04;
return a;
}
public double getAsistencia(){
this.ayp = sb * 0.025;
return ayp;
}
public double getAntiguedad(){
this.an = anios * 200;
return an;
}
public double getIsrt(){
this.isrt = sb * 0.1;
return isrt;
}
public double getSalud(){
this.ss = sb * 0.035;
return ss;
}
public double getAfore(){
this.afore = sb * 0.05;
return afore;
}
public double getSistema(){
this.sc = sb * 0.03;
return sc;
}
public double getsindicato(){
this.sind = sb * 0.02;
return sind;
}
public double getPercepciones(){
this.percepciones = sb + cb + a + an + ayp;
return percepciones;
}
public double getDeduciones(){
this.deducciones = isrt+ss+afore+sc+sind;
return deducciones;
}
public double getSalarioNeto(){
this.Sneto = percepciones-deducciones;
return Sneto;
}


}
