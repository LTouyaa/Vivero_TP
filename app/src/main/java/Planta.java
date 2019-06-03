
import java.util.ArrayList;

public  class Planta{

    private ArrayList<Etapa> etapas;
    private String id="";
    private int etapaActual;
    private int tempActual;
    private int humedadActual;
    private int luzActual;
    private int hormonas;
    private int sustratos;



    public Planta(String id)
    {
        etapas = new ArrayList<Etapa>();
        this. id = id;
        etapaActual = 0;
    }

    public void agregarEtapa(Etapa etapa)
    {
        etapas.add(etapa);
    }

    public String getID()
     {
        return id;
     }

     public int getEtapaActual()
    {
        return etapaActual;
    }

    public void setEtapaActual(int etapa)
    {
        etapaActual = etapa;
    }



    public boolean tempCorrecta()
    {
        if ((tempActual>etapas.get(etapaActual).getTempMax())||(tempActual<etapas.get(etapaActual).getTempMin()))
        {
            return false;
        }
        else return true;
    }

    public boolean humCorrecta()
    {
        if ((humedadActual>etapas.get(etapaActual).getHumMax())||(humedadActual<etapas.get(etapaActual).getHumMin()))
        {
            return false;
        }else return true;
    }


    public boolean luzCorrecta()
    {
        if ((luzActual>etapas.get(etapaActual).getLuzMax())||(luzActual<etapas.get(etapaActual).getLuzMin()))
        {
            return false;
        }else return true;
    }




        }