package PatronBuilder;

public class Casa {

    private final boolean chimenea; //opcionales
    private final int ventanas; //opcionales
    private final boolean arbustos; //opcionales

    private final int puertas; //obligatorios
    private final String color; //obligatorios

    public Casa(boolean chimenea, int ventanas, boolean arbustos, int puertas, String color) {
        this.chimenea = chimenea;
        this.ventanas = ventanas;
        this.arbustos = arbustos;
        this.puertas = puertas;
        this.color = color;
    }

    //getters

    public boolean isChimenea() {
        return chimenea;
    }

    public int getVentanas() {
        return ventanas;
    }

    public boolean isArbustos() {
        return arbustos;
    }

    public int getPuertas() {
        return puertas;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "chimenea=" + chimenea +
                ", ventanas=" + ventanas +
                ", arbustos=" + arbustos +
                ", puertas=" + puertas +
                ", color='" + color + '\'' +
                '}';
    }

    public static class CasaBuilder{
        private  boolean chimenea; //opcionales
        private  int ventanas; //opcionales
        private  boolean arbustos; //opcionales

        private final int puertas; //obligatorios
        private final String color; //obligatorios

        public CasaBuilder(int puertas, String color) {
            this.puertas = puertas;
            this.color = color;
        }

        public CasaBuilder conChimenea(){
            this.chimenea = true;
            return this;
        }

        public CasaBuilder conVentanas(int ventanas){
            this.ventanas = ventanas;
            return this;
        }

        public CasaBuilder conArbustos(){
            this.arbustos = true;
            return this;
        }

        public Casa build() throws Exception {
            validarCasa();
            return new Casa(this.chimenea, this.ventanas, this.arbustos, this.puertas, this.color);
        }

        private void validarCasa() throws Exception {


                    if(this.puertas <= 0){
                        throw new Exception("La casa debe tener al menos una puerta");
                    }




        }
    }
}

class Contexto{
    public static void main(String[] args) throws Exception {
        Casa casa = new Casa(true, 0 ,false, 1, "azul" );
        Casa casa2 = new Casa(false, 3 ,false, 1, "blanco");

        System.out.println(casa);
        System.out.println(casa2);

        Casa casa3 = new Casa.CasaBuilder(1, "verde")
                .conArbustos()
                .build();
        System.out.println(casa3);

        Casa casa4 = new Casa.CasaBuilder(0, "Blanco")
                .conChimenea()
                .conVentanas(5)
                .build();
        System.out.println(casa4);
    }
}
