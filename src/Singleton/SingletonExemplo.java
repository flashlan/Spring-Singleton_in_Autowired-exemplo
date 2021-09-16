package Singleton;

public class SingletonExemplo {
	  private static SingletonExemplo instance;
	    public String value;

	    private SingletonExemplo(String value) {
	        this.value = value;
	    }

	    public static SingletonExemplo getInstance(String value) {
	        if (instance == null) {
	            instance = new SingletonExemplo(value);
	        }
	        return instance;
	    }

}
