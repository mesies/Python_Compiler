import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class PostVisitor extends DepthFirstAdapter 
{
	private SymbolTable symtable;	

	PostVisitor(SymbolTable symtable) 
	{
		this.symtable = symtable;
	}
	Signature thisFunc;
	int lineNo;
	public void inAFuncallFuncall(AFuncallFuncall node){
		AIdIdentifier idNode  = (AIdIdentifier) node.getIdentifier();
		String nameOfFunction = idNode.getId().getText().trim(); 
		lineNo = idNode.getId().getLine();
		AFuncalltFuncallt args = (AFuncalltFuncallt) node.getFuncallt();
		AArglistArglist AArgs = (AArglistArglist) args.getArglist();
		if (AArgs == null) thisFunc = new Signature(nameOfFunction,0);
		else{
			thisFunc = new Signature(nameOfFunction,1 + AArgs.getTemp4().size());
		}
		if(!symtable.containsFunction(thisFunc)) log("ERROR : This table does not contain this function",lineNo);
	}
	public static void log(Object o){
		System.out.println( o.toString());
	}
	public static void log(String ErrMessage,int line){
		System.err.println(ErrMessage+" LINE :: " + String.valueOf(line));
	}
}