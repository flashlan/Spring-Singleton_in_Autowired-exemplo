package Singleton;

public class Main {
    public static void main(String[] args) {
    	
        SingletonExemplo singleton = SingletonExemplo.getInstance("VALOR INICIAL");
        SingletonExemplo anotherSingleton = SingletonExemplo.getInstance("VALOR ALTERADO");
        
        System.out.println("Se você ver o mesmo valor, então o  singleton foi reusado" + "\n" +
                "Se você ver valores diferentes, então foram criados 2 singletons" + "\n\n" +
                "RESULTADO:" + "\n");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
        
        
       //System.out.println((SingletonExemplo.class).isInstance(singleton));
    }
}
