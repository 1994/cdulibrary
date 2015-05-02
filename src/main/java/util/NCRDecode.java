package util;

/**
 * Created by reeco_000 on 2015/4/18.
 */
public class NCRDecode {

    public static String decode(String str) {
        StringBuffer sb = new StringBuffer();
        int i1=0;
        int i2=0;

        while(i2<str.length()) {
            i1 = str.indexOf("&#",i2);
            if (i1 == -1 ) {
                sb.append(str.substring(i2));
                break ;
            }
            sb.append(str.substring(i2, i1));
            i2 = str.indexOf(";", i1);
            if (i2 == -1 ) {
                sb.append(str.substring(i1));
                break ;
            }

            String tok = str.substring(i1+2, i2);
            try {
                int radix = 10 ;
                if (tok.charAt(0) == 'x' || tok.charAt(0) == 'X') {
                    radix = 16 ;
                    tok = tok.substring(1);
                }
                sb.append((char) Integer.parseInt(tok, radix));
            } catch (NumberFormatException exp) {
                exp.printStackTrace();
            }
            i2++ ;
        }
        return sb.toString();
    }

}
