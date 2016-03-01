
public static void main(String[] args){
  Scanner sc = new Scanner(System.in);
  int aantalTestGevallen = sc.nextInt();
  for(int i = 0; i< aantalTestGevallen; i++){
    int width = sc.nextInt();
    int height = sc.nextInt();
    String[] ascii = new String[height];
    for(int j = 0; j< height; j++){
      ascii[j] = sc.nextLine();
    }
    ArrayList<String[]> stukken = new ArrayList<String[]>();
    for(int j = 0;j< aantalStukken;j++){
      int width_stuk = sc.nextInt();
      int height_stuk = sc.nextInt();
      String[] ascii_stuk = new String[height_stuk];
      for(int h = 0; h< height_stuk; h++){
        ascii_stuk[h] = sc.nextLine();
      }
      System.out.println(getAnswer(width, height,width_stuk, height_stuk, ascii, stuk));
    }
    
  }
}

/**
 * deze methode verkrijgt de mogenlijkheid om een ascii_stuk in de ascii afbeelding te steken 
 */
private static String getAnswer(int width, int height,int stuk_height, int stuk_width, String[] ascii, String[] stuk){
  //1: bereken de combo's
  char[][][] stuk_chars = new char[4][stuk_height][stuk_width];
  //1.1: steek oorspronkelijke chars in de stukken
  for(String lijn: stuk){
    
  }
}
