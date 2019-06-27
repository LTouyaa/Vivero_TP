public class Etapa {

    private String nombre;
    private int tempMax;
    private int tempMin;
    private int humMax;
    private int humMin;
    private int luzMax;
    private int luzMin;
    private int hormona;
    private int sustrato;
    private int duracion;
    private int edad;

    public Etapa(String nombre,int duracion, int tempMax, int tempMin, int humMax, int humMin, int hormona, int luzMax, int luzMin, int sustrato)
    {

        this.nombre = nombre;
        this.duracion= duracion;
        this.humMax = humMax;
        this.humMin = humMin;
        this.luzMax = luzMax;
        this.luzMin = luzMin;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.hormona = hormona;
        this.sustrato = sustrato;
        edad = 0;
    }

    public int getTempMax()
    {return tempMax;}

    public int getHumMax()
    {return humMax;}

    public int getHumMin()
    {return humMin;}

    public int getTempMin()
    {return tempMin;}

    public int getLuzMax()
    {return luzMax;}

    public int getLuzMin()
    {return luzMin;}

    public int getHormona()
    {return hormona;}

    public int getSustrato()
    {return sustrato;}

    public int getDuracion()
    {return duracion;}

    //Revisar si les parece adecuada la implementacion.

    public boolean unPaso(){
        if(edad < duracion){
            edad+=1;
            return false;
        } else{
            return true;
        }
    }

}
