public interface Hello {
    public default void hello(){
        System.out.print("Привет. ");
    }
}
