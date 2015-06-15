package tools;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


/**
 * @author francoise.perrin - 
 * Inspiration : http://www.jmdoudoux.fr/java/dej/chap-introspection.htm
 * 
 */
public class Introspection {

	/**
	 * private pour empcher de crer des instances de la classe
	 */
	private Introspection() {

	}
		
	/**
	 * Invocation d'une mthode connaissant son nom sur un objet o
	 * en lui passant les bons paramtres
	 * 
	 * @param o - l'objet sur lequel agit la mthode
	 * @param args - la liste des paramtres de la mthode
	 * @param nomMethode - le nom de la mthode
	 * @return la mthode invoque
	 * @throws Exception
	 */
	public static Object invoke(Object o, Object[] args, String nomMethode ) throws Exception	{
		Class<? extends Object>[] paramTypes = null;
		if(args != null){
			paramTypes = new Class<?>[args.length];
			for(int i=0;i<args.length;++i)	{
				paramTypes[i] = args[i].getClass();
			}
		}
		Method m = o.getClass().getMethod(nomMethode,paramTypes);
		return m.invoke(o,args);
	}
	

	/**
	 * cration d'un objet connaissant le nom de la classe
	 * utilise un constructeur sans paramtre
	 * 
	 * @param className
	 * @return le nouvel objet cre
	 */
	public static Object newInstance(String className) {
		Object o = null;
		try	    {
			o = Class.forName (className).newInstance ();
		}
		catch (ClassNotFoundException e)	    {
			// La classe n'existe pas
			e.printStackTrace();
		}
		catch (InstantiationException e)	    {
			// La classe est abstract ou est une interface ou n'a pas de constructeur accessible sans paramtre
			e.printStackTrace();
		}
		catch (IllegalAccessException e)	    {
			// La classe n'est pas accessible
			e.printStackTrace();
		}
		return o;
	}


	/**
	 * construction  partir du nom de la classe et des paramtres du constructeur
	 * 
	 * @param className
	 * @param args - la liste des arguments du constructeur
	 * @return le nouvel objet cre
	 */
	public static Object newInstance(String className, Object[] args)	 {
		Object o = null;

		try {
			//On cre un objet Class
			Class<?> classe = Class.forName(className);
			// on rcupre le constructeur qui a les paramtres args
			Class<?>[] paramTypes = null;
			if(args != null){
				paramTypes = new Class[args.length];
				for(int i=0;i<args.length;++i)	{
					paramTypes[i] = args[i].getClass();
				}
			}
			Constructor<?> ct = classe.getConstructor(paramTypes);
			// on instantie un nouvel objet avec ce constructeur et le bon paramtre
			o =  ct.newInstance (args);		
		}
		catch (ClassNotFoundException e)		{
			// La classe n'existe pas
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)		{
			// La classe n'a pas le constructeur recherch
			e.printStackTrace();
		}
		catch (InstantiationException e)		{
			// La classe est abstract ou est une interface
			e.printStackTrace();
		}
		catch (IllegalAccessException e)		{
			// La classe n'est pas accessible
			e.printStackTrace();
		}
		catch (java.lang.reflect.InvocationTargetException e)		{
			// Exception dclenche si le constructeur invoqu
			// a lui-mme dclench une exception
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)		{
			// Mauvais type de paramtre			
			e.printStackTrace();
		}
		return o;
	}



}
