
import java.util.Random;
import java.util.Scanner;


public class CaptchaUygulaması {
    public static void main(String[] args) {
    Random rnd = new Random();
    boolean deger = false;
    int rastgele, uretilensayi = 0;
    String dizi[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "e", "s", "t", "u", "v", "w", "x", "y", "z"};
    int dizib[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    String buyukHarf = "", kucukHarf = "", rakam = "";
    int buyukHarfAdet, kucukHarfAdet, rakamAdet;
    Scanner input = new Scanner(System.in);
    int anahtaruzunluk = 7; // CAPTHA uzunluk
    String dizi2[] = new String[anahtaruzunluk];
    buyukHarfAdet = rnd.nextInt(4);
    System.out.println("Üretilen büyük harf sayısı :" + buyukHarfAdet);
    kucukHarfAdet = rnd.nextInt(4);
    System.out.println("Üretilen küçük harf sayısı :" + kucukHarfAdet);
    rakamAdet = 7 - (buyukHarfAdet + kucukHarfAdet);
    System.out.println("Üretilen rakam sayısı :" + rakamAdet);
    for (int i = 0; i < buyukHarfAdet; i++) {
        buyukHarf = dizi[rnd.nextInt(26)].toUpperCase();
        dizi2[i] = buyukHarf;

    }
    for (int i = buyukHarfAdet; i < buyukHarfAdet + kucukHarfAdet; i++) { //gelecek harfleri aynı dizi içine kaydettiğim için buyukharf sayısındandan başlatıyorum
        kucukHarf = dizi[rnd.nextInt(26)];
        dizi2[i] = kucukHarf;

    }
    for (int i = buyukHarfAdet + kucukHarfAdet; i < buyukHarfAdet + kucukHarfAdet + rakamAdet; i++) {
        rakam = "" + dizib[rnd.nextInt(10)];
        dizi2[i] = rakam;

    }

    System.out.println("-----------------------------------------");
    System.out.println("Üretilen Harf ve Rakamlar ");
    for (int i = 0; i < anahtaruzunluk; i++) {
        System.out.print(dizi2[i] + " ");
    }
    System.out.println("");
    System.out.println("-----------------------------------------");
    System.out.println("Harf Ve Rakamların Şifrelenmiş Hali");
    //Buradan aşağısı üretilen harf ve rakamların karışık şekilde yazdıran algoritma
    int sayac = 0;
    int dizi3[] = new int[anahtaruzunluk];
    for (int i = 0; i < anahtaruzunluk; i++) {  //burada aşağıda dizi elamanlarını kontrol ederken null çıkmaması için dolduruyorum
        dizi3[i] = anahtaruzunluk + 1;
    }
    for (int i = 0; i < anahtaruzunluk; i++) {
        deger = false;
        while (deger == false) {
            uretilensayi = rnd.nextInt(anahtaruzunluk);
            deger = true;
            for (int j = 0; j <= i; j++) {
                if (uretilensayi == dizi3[j]) // bunun amacı daha önce yazdırılan dizi elamanı birdaha yazdırılmasın
                {
                    deger = false;
                }
            }
        }
        if (deger == true) {
            System.out.print(dizi2[uretilensayi] + " ");
            dizi3[sayac] = uretilensayi;
            sayac++;
        }

    }
    System.out.println("");

}
}
