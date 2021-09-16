# Spring-singleton-autowired-exemplo
### Como  o padrão Singleton é usado pelo @Autowired  do Spring Framework .


​	O Singleton é um padrão de Projeto (design Pattern) do tipo criacional que fornece apenas apenas um ponto de acesso para qualquer outro código, garantindo que somente um objeto desse tipo exista, basicamente ele consegue  isso criando uma instancia dentro da própria classe de forma estática.

​	O objetivo desse pequeno tutorial não é se aprofundar nas várias implementações de Singleton.

​	Não usarei  Spring nesse tutorial, mas sim código puro escrito em java para prover um exemplo do que acontece, por detrás dos  panos, ou seja: de como a anotação @Autowired do Spring usa o padrão Singleton  para criar instancias estáticas dos objetos.

SingletonExemplo.java:

```
package Singleton;
    
public class SingletonExemplo{

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
```


Main.java:
```
package Singleton;

public class Main {
    public static void main(String[] args)   	
        SingletonExemplo singleton = SingletonExemplo.getInstance("VALOR INICIAL");
        SingletonExemplo anotherSingleton = SingletonExemplo.getInstance("VALOR ALTERADO");
        
        System.out.println("Se você ver o mesmo valor, então o  singleton foi reusado" + "\n" +
                "Se você ver valores diferentes, então foram criados 2 singletons" + "\n\n" +
                "RESULTADO:" + "\n");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);

       //System.out.println((SingletonExemplo.class).isInstance(anotherSingleton));
    }
}
```

​	Note que a classe SingletonExemplo contém em seu interior uma instancia dela mesma, sendo que tanto a variável quanto o método estão declarados de modo estático (static), e uma variável de nome "value" do tipo string (note que a variável "value" é public), a qual usaremos  para demonstrar que,  após ser instanciada uma vez através do padrão singleton, ela não sofrerá mais alterações:

​	O construtor é opcional de acordo com o a implementação que faremos do padrão singleton, mas neste tutorial não vamos nos aprofundar nisso:

```
private static SingletonExemplo instance;
public String value;

private SingletonExemplo(String value) {
        this.value = value;
    }
```
​	Agora na função main vamos tentar criar duas instancias da classe SingletonExemplo e verificar através de um sysout se podemos alterar seus valores. Se tudo der certo isso não ocorrerá e o valor impresso na chamada da segunda instancia será o mesmo do primeira, ou seja, Singleton garante que apenas um tipo de objeto da classe é criado e ele permanece inalterado:
```
public static void main(String[] args) {
        SingletonExemplo singleton = SingletonExemplo.getInstance("VALOR INICIAL");
        SingletonExemplo anotherSingleton = SingletonExemplo.getInstance("VALOR ALTERADO"); 
```
​	Saída esperada: 
```
Se você ver o mesmo valor, então o  singleton foi reusado
Se você ver valores diferentes, então foram criados 2 singletons

RESULTADO:

VALOR INICIAL
VALOR INICIAL
```
​	Para aprender um pouco mais sobre  a anotação @Autowired, utilização de padrões de projetos  pelo Spring, bem inversão de controle e injeção de dependências recomendo esse [tutorial do professor João Carlos Vale](https://www.youtube.com/watch?v=KIoMhHiap88&l). 
