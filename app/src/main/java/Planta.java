
import java.util.ArrayList;

public class Planta{

    private ArrayList<Etapa> etapas;
    private String id="";
    private int etapaActual;


    public Planta(String id)
    {
        etapas = new ArrayList<Etapa>();
        this. id = id;
        etapaActual = 0;
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









        }