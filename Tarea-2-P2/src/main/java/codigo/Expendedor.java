package codigo;

public class Expendedor {
    private int n;
    private int cantidadProductos;
    private Monedas pago;
    private Moneda100 moneda100;
    private int vuelto = 0;
    private Deposito<CocaCola> coca = new Deposito<>();
    private Deposito<Sprite> sprite = new Deposito<>();
    private Deposito<Fanta> fanta = new Deposito<>();
    private Deposito<Super8> super8 = new Deposito<>();
    private Deposito<Snikers> sniker = new Deposito<>();
    private Deposito<Monedas> monvu = new Deposito<>();
    //y si la moneda de pago no es la misma que la moneda del cliente??
    public Expendedor(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
        for (int n=0; n<cantidadProductos; n++){
            coca.addProducto(new CocaCola(n));
            sprite.addProducto(new Sprite(n));
            fanta.addProducto(new Fanta(n));
            super8.addProducto(new Super8(n));
            sniker.addProducto(new Snikers(n));
        }
        // hacer excepcion en caso de que la moneda fuera igual a NULL PagoIncorrectoException
    }
    public Productos comprarProducto(int n, Monedas pago) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        this.n=n;
        if (pago == null) {
            throw new PagoIncorrectoException("Por favor ingresa una moneda valida");
        }
        if (n==Eleccion.COCA.getSelec()){
            if(coca.size()!=0&&pago.getValor()>=coca.getProducto().getPrecio()){
                for(int i=pago.getValor()-coca.getProducto().getPrecio(); i>0; i=i-100 ){
                    monvu.addProducto(moneda100);
                    vuelto=vuelto+100;
                }
                return coca.getProducto();
            }
            else if (coca.size() == 0) {
                throw new NoHayProductoException("No se puede comprar, no quedan productos");
            }
            else if (pago.getValor() < coca.getProducto().getPrecio()) {
                throw new PagoInsuficienteException("La moneda NO alcanza");
            }
        }
        if (n==Eleccion.SPRITE.getSelec()){
            if(sprite.size()!=0&&pago.getValor()>=sprite.getProducto().getPrecio()){
                for(int i= pago.getValor()-sprite.getProducto().getPrecio(); i>0; i=i-100 ){
                    monvu.addProducto(moneda100);
                    vuelto=vuelto+100;
                }
                return sprite.getProducto();
            }
            else if (sprite.size() == 0) {
                throw new NoHayProductoException("No se puede comprar, no quedan productos");
            }
            else if (pago.getValor() < sprite.getProducto().getPrecio()) {
                throw new PagoInsuficienteException("La moneda NO alcanza");
            }
        }
        if (n==Eleccion.FANTA.getSelec()){
            if(fanta.size()!=0&&pago.getValor()>=fanta.getProducto().getPrecio()){
                for(int i= pago.getValor()-fanta.getProducto().getPrecio(); i>0; i=i-100 ){
                    monvu.addProducto(moneda100);
                    vuelto=vuelto+100;
                }
                return fanta.getProducto();
            }
            else if (super8.size() == 0) {
                throw new NoHayProductoException("No se puede comprar, no quedan productos");
            }
            else if (pago.getValor() < super8.getProducto().getPrecio()) {
                throw new PagoInsuficienteException("La moneda NO alcanza");
            }

        }
        if (n==Eleccion.SUPER.getSelec()){
            if(super8.size()!=0&&pago.getValor()>=super8.getProducto().getPrecio()){
                for(int i= pago.getValor()-super8.getProducto().getPrecio(); i>0; i=i-100 ){
                    monvu.addProducto(moneda100);
                    vuelto=vuelto+100;
                }
                return super8.getProducto();
            }
            else if (super8.size() == 0) {
                throw new NoHayProductoException("No se puede comprar, no quedan productos");
            }
            else if (pago.getValor() < super8.getProducto().getPrecio()) {
                throw new PagoInsuficienteException("La moneda NO alcanza");
            }

        }
        //en vez de poner sniker.getProducto().getPrecio() podríamos poner Eleccion.SUPER.getPrecio()
        if (n==Eleccion.SNICKERS.getSelec()){
            if(sniker.size()!=0&&pago.getValor()>=sniker.getProducto().getPrecio()){
                for(int i= pago.getValor()-sniker.getProducto().getPrecio(); i>0; i=i-100 ){
                    monvu.addProducto(moneda100);
                    vuelto=vuelto+100;
                }
                return sniker.getProducto();
            }
            else if (sniker.size() == 0) {
                throw new NoHayProductoException("No se puede comprar, no quedan productos");
            }
            else if (pago.getValor() < sniker.getProducto().getPrecio()) {
                throw new PagoInsuficienteException("La moneda NO alcanza");
            }
            else {
                return null;
            }
        }
        return null;
    }
    public Monedas getVuelto() {
        return monvu.getProducto();
    }
    public int getVueltoTotal(){
        return vuelto;
    }
}

