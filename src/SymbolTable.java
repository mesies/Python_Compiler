import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InputMismatchException;
/**
 * var -> Name of variable , Variable Object (name,type)
 * func -> Signature of Function(name , numbOfArguments) , Function Object(name , signature ,return type)
 */
public class SymbolTable {
	Hashtable<String,Variable> var;
	//Store Functions
	Hashtable<Signature, Function> func;
	public SymbolTable(){
		this.var = new Hashtable<String,Variable>();
		this.func = new Hashtable<Signature,Function>();
	}
	public void addVar(String name,Variable v) throws InputMismatchException{
//		if (var.containsKey(name)) throw new InputMismatchException("This Variable is already in the Symbol table : " + v.getName());
		var.put(name, v);
	}
	public void addFunc(ArrayList<String> signature,Function function) throws InputMismatchException{
		Signature sign = new Signature(function.getName(),signature.size());
		if (func.containsKey(sign)) throw new InputMismatchException("This Function is already defined in the Symbol table : " + function.getName());
		func.put(sign, function);
	}
	public void addFunc(Signature sign,Function function) throws InputMismatchException{
		if (func.containsKey(sign)) throw new InputMismatchException("This Function is already defined in the Symbol table : " + function.getName());
		func.put(sign, function);
	}
	public Hashtable<String, Variable> getVar() {
		return var;
	}
	public Hashtable<Signature, Function> getFunc() {
		return func;
	}
}
