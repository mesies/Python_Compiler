import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class PreVisitor extends DepthFirstAdapter 
{
	private SymbolTable symtable;	

	public PreVisitor() 
	{
		this.symtable = new SymbolTable();
	}

//	public void inASfuncStatement(ASfuncStatement node) 
//	{
//		String fName = node.getId().toString();
//		int line = ((TId) node.getId()).getLine();
//		if (symtable.containsKey(fName))
//		{
//			System.out.println("Line " + line + ": " +" Funcation " + fName +" is already defined");
//		}
//		else
//		{
//			symtable.put(fName, node);
//		}
//	}
	public void inAAssigneqStatement(AAssigneqStatement node){
		
	}
    
    Signature thisFunc;
    int lineNo;
    public void inAFunctionCommands(AFunctionCommands node){
    	
    	AIdIdentifier idNode  = (AIdIdentifier) node.getIdentifier();
    	String nameOfFunction = idNode.getId().getText().trim(); 
    	lineNo = idNode.getId().getLine();
    	LinkedList args = node.getArgument();
    	int noOfArgs = args.size();
    	thisFunc = new Signature(nameOfFunction,noOfArgs);
    	
    	//
    	//
    	
    }
    public void inAReturnStatement(AReturnStatement node){
    	String returnType = "void";
    	if (thisFunc.equals(null)) throw new InputMismatchException("This shouldnt happen , return node was visited first");
    	AIdentifierExpression idNode  = ((AIdentifierExpression) node.getExpression());
    	AIdIdentifier idNode2  = (AIdIdentifier) idNode.getIdentifier();
    	String returnThing = idNode2.getId().getText();
    	if (returnThing.contains("'")) returnType = "str";
    	else if (returnThing.matches("[0-9]*")) returnThing = "int";
    	//Add the function in SymbolTable
    	try {
    	symtable.addFunc(thisFunc, new Function(thisFunc.getName(), returnType, thisFunc));
    	}
    	catch (InputMismatchException e) {
    		log("ERROR : This Function has already been declared" ,(lineNo));
    	}
    }



public static void log(Object o){
	System.out.println( o.toString());
}
public static void log(String ErrMessage,int line){
	System.err.println(ErrMessage+" LINE :: " + String.valueOf(line));
}

}