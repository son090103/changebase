package controller;

import common.Library;
import menu.Menu;


public class convertcontrolle extends Menu{
    public int result =0;
    Library l;
    static String[] mc  = new String[]{"binary", "hexa", "hex to dec","convertbitodec","Exit"};
    public convertcontrolle()
    {
        super("Menu",mc);
        l = new Library();
       
    }
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                int  x =l.getint("Enter number: ");
                convertbinary(x);
                System.out.println();
                break;
            case 2: 
                int y = l.getint("Enter number: ");
                converthexa(y);
                System.out.println();
                break;
            case 3: 
                String str = l.getString("Enter number: ");
                 System.out.println(convertHexToDecRecursive(str, 0, result));
                break;
            case 4: 
                String a = l.getString("Enter number: ");
                 System.out.println(converbinarytodec(a, 0, result));
                break;
            default:
                System.out.println("chi nhap tu 1 den 3");
        }
    }
   public void convertbinary(int n){
       if(n/2!=0){
            convertbinary(n/2);
        }
         System.out.print(" "+n%2);
       // in ngược chương trình 
       
   }
   public int converbinarytodec(String str , int index, int result){
       int n = str.length();
       if(index == n){
       return result;
       }
       // lấy ra vị trí của các char trong string 
      char h = str.charAt(index);
       // chuyển đổi dữ liệu string sang số
       int a = Character.getNumericValue(h);
       // cách chuyển dữ liệu char sang int
       if(a==-1){
           System.out.println("du lieu dau vao khong hop le");
           return -1;
       }
        int i= n-index-1;
        int partialDecimal = a * (int) Math.pow(2, i);
        return converbinarytodec(str, index+1, result+partialDecimal);
   }
   public void converthexa(int n){
       char mang[]= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        if(n==0){ 
            System.out.println(mang[0]+"");
            return;
        }
        hexa(n, mang);
          
   }
   public void hexa(int n, char mang[]){
       if(n==0) return ;
         int index= n%16;
         hexa(n/16, mang);
        System.out.print(mang[index]+ "");
   }
    
    public  int convertHexToDecRecursive(String str, int index, int result) {
    int n = str.length();
    if (index == n) {
        return result;
    }

    char hexChar = str.charAt(index);
    int hexValue = hexCharToDecimal(hexChar);
    
    if (hexValue == -1) {
        System.out.println("Dữ liệu đầu vào không hợp lệ");
        return -1; // Hoặc có thể trả về giá trị mặc định hoặc thực hiện xử lý khác
    }
    
    int power = n - index - 1;
    int partialDecimal = hexValue * (int) Math.pow(16, power);
    
    return convertHexToDecRecursive(str, index + 1, result + partialDecimal);
}
//    public int   converthextodec(String str){
//        int n= str.length();
//        int i=0;
//        if(i==n) return 0;
//        char x = str.charAt(i);// lấy ra từng ký tự trong String 
//        result+= Math.pow(16, i++);
//        return converthextodec(str);
//        }
   // chuyển đổi dữ liệu 
   private int hexCharToDecimal(char hexChar) {
    if (hexChar >= '0' && hexChar <= '9') {
        return hexChar - '0';
    } else if (hexChar >= 'A' && hexChar <= 'F') {
        return hexChar - 'A' + 10;
    } else if (hexChar >= 'a' && hexChar <= 'f') {
        return hexChar - 'a' + 10;
    } else {
//        throw new IllegalArgumentException("Invalid hex digit: " + hexChar);
        System.out.println("du lieu dau vao khong hop le");
        return 0;
    }
}
}
