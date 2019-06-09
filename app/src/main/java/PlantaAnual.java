public abstract class PlantaAnual extends Planta{

    public PlantaAnual(String id) {
        super(id);
    }

    @Override
    public void actualizarEtapa() {
        if(listaEtapas().get(0).unPaso()){
            listaEtapas().remove(0);
        }
    }
}
