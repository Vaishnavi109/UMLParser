
public interface Component {

	String operation();

}


public class ConcreteComponent implements Component {

	public String operation() {
		return "Hello World!";
	}

}

public class Decorator implements Component {

    private Component component;

    public Decorator( Component c )
    {
        component = c ;
    }

    public String operation()
    {
        return component.operation() ;
    }

}

public class ConcreteDecoratorA extends Decorator {

	private String addedState;

    public ConcreteDecoratorA( Component c)
    {
        super( c ) ;
    }

    public String operation()
    {
        addedState = super.operation() ;
        return addedBehavior( addedState ) ;
    }

	private String addedBehavior(String in) {
		return "<em>" + addedState + "</em>" ;
	}

}

public class ConcreteDecoratorB extends Decorator {

    private String addedState;

    public ConcreteDecoratorB( Component c)
    {
        super( c ) ;
    }

    public String operation()
    {
        addedState = super.operation() ;
        return addedBehavior( addedState ) ;
    }

    private String addedBehavior(String in) {
        return "<h1>" + addedState + "</h1>" ;
    }

}

public class Tester {

    public static void main(String[] args)
    {
        Component obj = new ConcreteDecoratorB( new ConcreteDecoratorA( new ConcreteComponent() ) ) ;
        String result = obj.operation() ;
        System.out.println( result );
    }
}
