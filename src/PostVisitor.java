import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class PostVisitor extends DepthFirstAdapter 
{
	private SymbolTable symtable;	

	PostVisitor(SymbolTable symtable) 
	{
		System.out.println("------------ Previsitor Ends -------\n");
		System.out.println("------------ Postvisitor -------");
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
	
	public void inAAdditionExpression(AAdditionExpression node){
		if(node.getLeft() instanceof AValueExpression){
			AValueExpression node1 = (AValueExpression)node.getLeft();
			if (node1.getValue() instanceof AStrValue){
				log("ERROR : String Value in addition is forbidden", ((AStrValue)node1.getValue()).getString().getLine());
			}		
		}else if(node.getLeft() instanceof AIdentifierExpression){
			AIdentifierExpression node1 = (AIdentifierExpression)node.getLeft();
			AIdIdentifier node2 = (AIdIdentifier)node1.getIdentifier();
			String namVal = node2.getId().getText().trim();
			if(!symtable.containVariable(namVal)){
				log("ERROR : Variable " + namVal + " mentionded on the left side of addition is undefined Line :: " , node2.getId().getLine());
			}
		}
		
		if(node.getRight() instanceof AValueExpression){
			AValueExpression node1 = (AValueExpression)node.getRight();
			if (node1.getValue() instanceof AStrValue){
				log("ERROR : String Value in addition is forbidden", ((AStrValue)node1.getValue()).getString().getLine());
			}		
		}else if(node.getRight() instanceof AIdentifierExpression){
			AIdentifierExpression node1 = (AIdentifierExpression)node.getRight();
			AIdIdentifier node2 = (AIdIdentifier)node1.getIdentifier();
			String namVal = node2.getId().getText().trim();
			if(!symtable.containVariable(namVal)){
				log("ERROR : Variable " + namVal + " mentionded on the right side of addition is undefined Line :: " , node2.getId().getLine());
			}
		}
			
		
		
	}
	
	public void inAMultiplicationExpression(AMultiplicationExpression node){
		if(node.getLeft() instanceof AValueExpression){
			AValueExpression node1 = (AValueExpression)node.getLeft();
			if (node1.getValue() instanceof AStrValue){
				log("ERROR : String in Multiplication is forbidden", ((AStrValue)node1.getValue()).getString().getLine());
			}	
		}else if(node.getLeft() instanceof AIdentifierExpression){
			AIdentifierExpression node1 = (AIdentifierExpression)node.getLeft();
			AIdIdentifier node2 = (AIdIdentifier)node1.getIdentifier();
			String namVal = node2.getId().getText().trim();
			if(!symtable.containVariable(namVal)){
				log("ERROR : Variable " + namVal + " mentionded on the left side of multiplication is undefined Line :: " , node2.getId().getLine());
			}
		}	//check add() + 3 * 5
		
		if(node.getRight() instanceof AValueExpression){
			AValueExpression node1 = (AValueExpression)node.getRight();
			if (node1.getValue() instanceof AStrValue){
				log("ERROR : String in Multiplication is forbidden", ((AStrValue)node1.getValue()).getString().getLine());
			}	
		}else if(node.getRight() instanceof AIdentifierExpression){
			AIdentifierExpression node1 = (AIdentifierExpression)node.getRight();
			AIdIdentifier node2 = (AIdIdentifier)node1.getIdentifier();
			String namVal = node2.getId().getText().trim();
			if(!symtable.containVariable(namVal)){
				log("ERROR : Variable " + namVal + " mentionded on the left side of multiplication is undefined Line :: " , node2.getId().getLine());
			}
		}
	}
	
	public void inAForStatementStatement(AForStatementStatement node){
		AIdIdentifier node1 = (AIdIdentifier)node.getFirstid();
		AIdIdentifier node2 = (AIdIdentifier)node.getSecondid();
		symtable.addVar(node1.getId().getText().trim(), new Variable(node1.getId().getText().trim(), "int"));
		if(symtable.containVariable(node2.getId().getText().trim())){
			if(!symtable.getVar().get(node2.getId().getText().trim()).getType().equalsIgnoreCase("list")){
				log("ERROR : Variable " + node2.getId().getText().trim() + " must be type of list" , node2.getId().getLine());
			}
		}else{
			log("ERROR : Undefined list mention in for Statement", node2.getId().getLine());
		}
	}
	
	public static void log(Object o){
		System.out.println( o.toString());
	}
	public static void log(String ErrMessage,int line){
		System.err.println(ErrMessage+" LINE :: " + String.valueOf(line));
	}
}