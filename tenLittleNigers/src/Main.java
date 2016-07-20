/**
 * @author Jari Van Melckebeke
 * @since 20.07.16
 */
public class Main {
    private static int num = 0;

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        if (num < 10)
            for (int i = 10; i > 0; i--) {
                if (i > 1)
                    System.out.println(i + " kleine negers");
                else
                    System.out.println(i + " kleine neger");
                if (i == 10) {
                    System.out.println("Die stonden in de regen\nééntje werd er doodgeregend\nToen waren er nog maar " + (i - 1));

                } else if (i == 9) {
                    System.out.println("Die stonden eens op wacht\nééntje wer er doodgewacht\nToen waren er nog maar " + (i - 1));

                } else if (i == 8) {
                    System.out.println("Die gingen eens gaan zweven\n" +
                            "Ééntje werd er doodgezweefd\n" +
                            "Toen waren er nog maar " + (i - 1));

                } else if (i == 7) {
                    System.out.println("Die speelden met een mes\nÉéntje werd er doodgemest\nToen waren er nog maar " + (i - 1));

                } else if (i == 6) {
                    System.out.println("Die speelden met een rijf\n" +
                            "Ééntje werd er doodgerijfd\n" +
                            "Toen waren er nog maar " + (i - 1));

                } else if (i == 5) {
                    System.out.println("Die speelden met een pier\n" +
                            "Ééntje werd er doodgepierd\n" +
                            "Toen waren er nog maar " + (i - 1));

                } else if (i == 4) {
                    System.out.println("Die speelden met een bie\n" +
                            "Ééntje werd er doodgebiet\n" +
                            "Toen waren er nog maar " + (i - 1));

                } else if (i == 3) {
                    System.out.println("Die speelden in de zee\n" +
                            "Ééntje werd er doodgezeed\n" +
                            "Toen waren er nog maar " + (i - 1));

                } else if (i == 2) {
                    System.out.println("Die stonden op één been\n" +
                            "Ééntje werd er doodgebeend\n" +
                            "Toen was er nog maar " + (i - 1));

                } else if (i == 1) {
                    System.out.println("Die trouwende met Katrien\n" +
                            "En na vele jaren\n" +
                            "Toen waren ze weer met tien");
                    num++;
                    run();

                }
                System.out.println();

            }
        num++;
    }
}
