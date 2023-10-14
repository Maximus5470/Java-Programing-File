public class RomanToInt {
    public static void main(String[] args) {
        //String c=intToRoman(143);
        int c=romanToInt("XIV");
        System.out.println(c);
    }
    public static String intToRoman(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder rom = new StringBuilder();

        int i = 0;

        while (num > 0) {
            if (num >= values[i]) {

                rom.append(romanNumerals[i]);
                num -= values[i];
            } else {
                i++;
            }
        }

        return rom.toString();
    }
    public static int romanToInt(String s) {
        int ans=0;
        int num=0;
        int prev=0;
        for(int i=s.length()-1;i>=0;i--){
            switch(s.charAt(i)){
                case 'I':num=1; break;
                case 'V':num=5; break;
                case 'X':num=10; break;
                case 'L':num=50; break;
                case 'C':num=100; break;
                case 'D':num=500; break;
                case 'M':num=1000; break;
            }
            if(num<prev) ans-=num;
            else ans+=num;
            prev=num;
        }
        return ans;
    }
}