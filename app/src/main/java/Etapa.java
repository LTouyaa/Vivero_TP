




public class Etapa {

   private String nombre= "";
   private int numEtapa ;
   private int tempMax ;
   private int tempMin ;
   private int humMax;
   private int humMin ;
   private int luzMax ;
   private int luzMin ;
   private int hormonaMax ;
   private int hormonaMin ;

    public Etapa(String nombre, int numEtapa, int tempMax, int tempMin, int humMax, int humMin, int hormonaMax, int hormonaMin, int luzMax, int luzMin)
    {

        this.nombre = nombre;
        this.numEtapa = numEtapa;
        this.hormonaMax = hormonaMax;
        this.hormonaMin = hormonaMin;
        this.humMax = humMax;
        this.humMin = humMin;
        this.luzMax = luzMax;
        this.luzMin = luzMin;
        this.tempMax = tempMax;
        this.tempMin = tempMin;

     }



    }


