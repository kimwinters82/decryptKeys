import java.util.*;
import java.math.BigInteger;

class Main {
  public static BigInteger increment = new BigInteger("1");

  public static void main(String[] args) {
    //take in user input
  Scanner sc = new Scanner (System.in);
  String alice = sc.nextLine();
  String [] aliceS = alice.split(" ");
  String bob = sc.nextLine();
  String [] bobS = bob.split(" ");
  sc.close();

  //create & store in bigInteger variables
  BigInteger x = new BigInteger("1");
  BigInteger p = new BigInteger(aliceS[0]);//prime modulus
  BigInteger g = new BigInteger(aliceS[1]);//generator
  BigInteger gxmodp = new BigInteger (aliceS[2]);//g^xmodp
  BigInteger c1 = new BigInteger(bobS[0]); //g^ymodp
  BigInteger c2 = new BigInteger(bobS[1]);//m.g^xymodp

  //get private key x
  x = modpow(g, x, p, gxmodp);

  //decrypt
  BigInteger one = new BigInteger("1");
  BigInteger d = p.subtract(one).subtract(x);
  BigInteger ans = c1.modPow(d, p);
  BigInteger m = ans.multiply(c2).mod(p);

  //print m
  System.out.println(m.intValue());
  }//main

  /*public static BigInteger modpow(BigInteger g, BigInteger x, BigInteger p, BigInteger gxmodp){
  if (g.modPow(x, p).compareTo(gxmodp) == 0){
    //System.out.println("x = "+x);
    return x;
  }
  else {
    x =x.add(increment);
    return modpow(g, x, p, gxmodp);
    }
  }//modpow*/
  public static BigInteger modpow(BigInteger g, BigInteger x, BigInteger p, BigInteger gxmodp){
  while (true)
  if (g.modPow(x, p).compareTo(gxmodp) == 0){
    return x;
  }else{
    x = x.add(increment); 
  }
  }//modpow*/
  
}//class