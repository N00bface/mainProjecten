package classes;

/**
 * Created by mama & vake on 30/12/2015.
 */
public class VliegtuigBoarden {
    public String run(String[] param) {
        String out = "";
        param = param[0].split("/");
        short wachttijd = 1;
        int[] invoer = new int[param.length];
        int[] stoelen = new int[invoer.length - 1];
        int index = 1;
        for (int i = 0; i < invoer.length; i++) {
            invoer[i] = Integer.parseInt(param[i]);
        }
        //for (int i = 0; i < invoer[0]; i++) {

            //for (int j = 0; j < invoer.length; j++) {
            //}
            for (int k = 0; k < invoer[index]; k++) {
                System.out.println("loop " + index +"     "+k);
                for (int l = 1; l < invoer.length; l++) {
                    stoelen[l - 1] = invoer[l];
                }
                for (int j = 0; j < invoer[index] + 1; j++) {
                    System.out.println(j+ " lus");
                    try {
                        if (stoelen[j] < stoelen[j + 1]) {
                            wachttijd++;
                            System.out.println(wachttijd + "      " + j);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("fout");
                    }
                }
            }
            out += (1 + " " + String.valueOf(wachttijd) + "abc");
            //wachttijd = 1;

        //}
        out.replace("abc", "\n");
        out.replace("abc", "");
        out.replace("abc", "\n");
        out.replace("abc", "");
        return (out);
    }
}
