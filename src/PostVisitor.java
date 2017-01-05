import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class PostVisitor extends DepthFirstAdapter 
{
	private Hashtable symtable;	

	PostVisitor(Hashtable symtable) 
	{
		this.symtable = symtable;
	}

	public void inASfuncStatement(ASfuncStatement node) 
	{
		String fName = node.getId().toString();
		int line = ((TId) node.getId()).getLine();
		if (symtable.containsKey(fName))
		{
			System.out.println("Line " + line + ": " +" Funcation " + fName +" is already defined");
		}
		else
		{
			symtable.put(fName, node);
		}
	}

}