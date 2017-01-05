import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class PreVisitor extends DepthFirstAdapter 
{
	private Hashtable symtable;	

	public PreVisitor() 
	{
		this.symtable = new Hashtable();
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
    public void inAIdentifierExpression(AIdentifierExpression node)
    {
    	AIdIdentifier node2 = (AIdIdentifier)node.getIdentifier();
		int line = ((TId) node2.getId()).getLine();

    	System.out.println(node.parent()+String.valueOf(line));
    }
    public void inAIdIdentifier(AIdIdentifier node)
    {
    	System.out.println(node.toString());
    	int line = ((TId)node.getId()).getLine();
    }
    public void inAFunctionCommands(AFunctionCommands node){
    	log(node.getIdentifier().toString());
    	log("Arg"+node.getArgument().toString());
    }



public static void log(Object o){
	System.out.println( o.toString());
}
}