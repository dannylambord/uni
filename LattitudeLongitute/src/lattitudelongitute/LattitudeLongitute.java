/*
* Code latitude and longitude to miles and km.
* Code from Rob Howorth, and line 34 onwards from Guto Williams
*/
package lattitudelongitute;

import static java.lang.Math.*;

public class LattitudeLongitute 
{
    /**
    * This code 
    * @param args 
    */
    public static void main(String[] args)
    {
        int R = 6371; // radius
        double DLat = (float) 54.994832;
        double DLon = (float) -1.7880551;
        double DLat2 = (float) 52.972922;
        double DLon2 = (float) 1.3121505;
        double Lon;
        double Lat;
        double a;
        double c;
        double d;
        double f;

        Lon = DLon2 - DLon; // position point 1
        Lat = DLat2 - DLat; // position point 2
        a = (Math.pow(sin(Lat/2),2)) + (cos(DLat)) * (cos(DLat2)) * (Math.pow(sin(Lon/2),2));
        c = 2 * atan2( sqrt(a), sqrt(1-a) );
        d = R * c; // times radius of earth
        d = d / 51.927 ; // convert to miles
        f = d * 8 / 5; // convert to km
        
        System.out.print("miles: ");
        System.out.println(d);
        System.out.print("km: ");
        System.out.println(f);
    } 
}