import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class PreVisitor extends DepthFirstAdapter 
{
	private SymbolTable symtable;	

	public PreVisitor() 
	{
		System.out.println("------------ Previsitor -------");
		this.symtable = new SymbolTable();
	}
	
	public SymbolTable getSymTable(){
		return symtable;
	}

	public void inAAssigneqStatement(AAssigneqStatement node){

		String nameToAdd = ((AIdIdentifier)node.getIdentifier()).getId().getText().trim();
		if (node.getExpression() instanceof AIdentifierExpression){
			AIdentifierExpression nodeR = (AIdentifierExpression)node.getExpression();
			AIdIdentifier node2 = (AIdIdentifier)nodeR.getIdentifier();

			String nameOfVar = node2.getId().getText().trim();
			int line = node2.getId().getLine();
			if (!symtable.containVariable(nameOfVar)){
				log("ERROR : Variable "+nameOfVar+" mentioned on the right side of the equation is undefined ",line);
			}
			else{
				symtable.addVar(nameToAdd,new Variable(nameOfVar, symtable.getVar().get(nameOfVar).getType() ));
			}
		}
		else if(node.getExpression() instanceof AValueExpression){
			AValueExpression valNode = (AValueExpression)node.getExpression();
			if (valNode.getValue() instanceof ANumbValue){
				symtable.addVar(nameToAdd,new Variable(nameToAdd,"int"));
			}
			else if (valNode.getValue() instanceof AStrValue){
				symtable.addVar(nameToAdd,new Variable(nameToAdd, "str"));
			}
		}
		else if(node.getExpression() instanceof AListExpression){
			symtable.addVar(nameToAdd,new Variable(nameToAdd,"list"));
			
			
		}
	}


	public void inAComparisonexMorecomparison(AComparisonexMorecomparison node){
		//ids must exist
		if (node.getExp1() instanceof AIdentifierExpression){
			AIdentifierExpression node2 = (AIdentifierExpression)node.getExp1();
			AIdIdentifier node4 =(AIdIdentifier) node2.getIdentifier();
			String nameOfVal = node4.getId().getText().trim();
			int line = node4.getId().getLine();
			if(!symtable.containVariable(nameOfVal)){
				log("ERROR : Variable " + nameOfVal + " mentioned on if statement id undefined", line);
			}
		}
		
		if (node.getExp2() instanceof AIdentifierExpression){
			AIdentifierExpression node2 = (AIdentifierExpression)node.getExp2();
			AIdIdentifier node4 =(AIdIdentifier) node2.getIdentifier();
			String nameOfVal = node4.getId().getText().trim();
			int line = node4.getId().getLine();
			if(!symtable.containVariable(nameOfVal)){
				log("ERROR : Variable " + nameOfVal + " mentioned on if statement id undefined", line);
			}
		}	
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
		//mallon thes na to kaneis add sto symbol table

	}
	
	
	public void inAReturnStatement(AReturnStatement node){
		String returnType = "void";
		if (thisFunc.equals(null)) throw new InputMismatchException("This shouldnt happen , return node was visited first");
		AIdentifierExpression idNode  = ((AIdentifierExpression) node.getExpression());
		AIdIdentifier idNode2  = (AIdIdentifier) idNode.getIdentifier();
		String returnThing = idNode2.getId().getText();		//to onoma tou id pou epistrefei
		if (returnThing.contains("'")) returnType = "str";
		else if (returnThing.matches("[0-9]*")) returnThing = "int";
		else if (returnThing.matches("\\[")) returnThing = "list";
		else if(symtable.containVariable(returnThing)){
			returnThing = symtable.getVar().get(returnThing).getType();
		}
		

		//Add the function in SymbolTable
		try {
			symtable.addFunc(thisFunc, new Function(thisFunc.getName(), returnType, thisFunc));
		}
		catch (InputMismatchException e) {
			log("ERROR : This Function has already been declared" ,(lineNo));
		}
	}

	//TODO
	public void inAAssigmpeqStatement(AAssigmpeqStatement node){

		String nameToAdd = ((AIdIdentifier)node.getIdentifier()).getId().getText().trim();
		if (node.getExpression() instanceof AIdentifierExpression){
			AIdentifierExpression nodeR = (AIdentifierExpression)node.getExpression();
			AIdIdentifier node2 = (AIdIdentifier)nodeR.getIdentifier();

			String nameOfVar = node2.getId().getText().trim();
			int line = node2.getId().getLine();
			if (!symtable.containVariable(nameOfVar)){
				log("ERROR : Variable "+nameOfVar+" mentioned on the right side of the equation is undefined ",line);
			}
			else{
				symtable.addVar(nameToAdd,new Variable(nameOfVar, symtable.getVar().get(nameOfVar).getType() ));
			}
		}
		else if(node.getExpression() instanceof AValueExpression){
			AValueExpression valNode = (AValueExpression)node.getExpression();
			if (valNode.getValue() instanceof ANumbValue){
				symtable.addVar(nameToAdd,new Variable(nameToAdd,"int"));
			}
			else if (valNode.getValue() instanceof AStrValue){
				symtable.addVar(nameToAdd,new Variable(nameToAdd, "str"));
			}
		}
		else if(node.getExpression() instanceof AListExpression){
			symtable.addVar(nameToAdd,new Variable(nameToAdd,"list"));
			
			
		}
	}
	
	public void inAPrintStatement(APrintStatement node){
		if(node.getExpression() instanceof AIdentifierExpression){
			AIdentifierExpression node1 = (AIdentifierExpression)node.getExpression();
			AIdIdentifier node2 = (AIdIdentifier)node1.getIdentifier();
			if(!symtable.containVariable(node2.getId().getText().trim())) log("ERROR : Variable " + node2.getId().getText().trim() + " is undefined", node2.getId().getLine());
		}
	}

	public void inAPpxExpression(APpxExpression node){
		AIdIdentifier node1 = (AIdIdentifier)node.getIdentifier();
		if(!symtable.containVariable(node1.getId().getText().trim())) log("ERROR : Variable " + node1.getId().getText().trim() + " is undefined", node1.getId().getLine());
	}
	

	public void inAXppExpression(AXppExpression node){
		AIdIdentifier node1 = (AIdIdentifier)node.getIdentifier();
		if(!symtable.containVariable(node1.getId().getText().trim())) log("ERROR : Variable " + node1.getId().getText().trim() + " is undefined", node1.getId().getLine());
	}
	public static void log(Object o){
		System.out.println( o.toString());
	}
	public static void log(String ErrMessage,int line){
		System.err.println(ErrMessage+" LINE :: " + String.valueOf(line));
	}

}