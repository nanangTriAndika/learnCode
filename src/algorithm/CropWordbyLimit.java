/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author nanang
 */
public class CropWordbyLimit {
 
     static String solution(String message, int K) {
        if(K < 1 ){
            return "";
        }else{
            if(message.length() <= K ){
                return message.replaceAll("\\s+$", "");
            }else{
               String[] kata = message.split(" ");
               String hasil = kata[0];
               int checker = kata[0].length() + 1;

               for(int i=0;i<(kata.length-1);i++){
                   int cekKata = checker + kata[i+1].length();
                   if(cekKata <= K){
                        hasil = hasil + " " + kata[i+1];
                        checker = checker + kata[i+1].length() + 1;
                   }
               }
               return hasil;
            }
        }
    }

    public static void runningModule() {
        System.out.println(solution("Codility We test coders",14));
        System.out.println(solution("To crop or not to crop",21));
         
    }
}
