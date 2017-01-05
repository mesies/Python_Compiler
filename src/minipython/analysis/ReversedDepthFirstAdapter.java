/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.analysis;

import minipython.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(Node node)
    {
    }

    public void defaultOut(Node node)
    {
    }

    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPProgramme().apply(this);
        outStart(node);
    }

    public void inACommandsProgramme(ACommandsProgramme node)
    {
        defaultIn(node);
    }

    public void outACommandsProgramme(ACommandsProgramme node)
    {
        defaultOut(node);
    }

    public void caseACommandsProgramme(ACommandsProgramme node)
    {
        inACommandsProgramme(node);
        {
            Object temp[] = node.getCommands().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((PCommands) temp[i]).apply(this);
            }
        }
        outACommandsProgramme(node);
    }

    public void inAFunctionCommands(AFunctionCommands node)
    {
        defaultIn(node);
    }

    public void outAFunctionCommands(AFunctionCommands node)
    {
        defaultOut(node);
    }

    public void caseAFunctionCommands(AFunctionCommands node)
    {
        inAFunctionCommands(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        {
            Object temp[] = node.getArgument().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((PArgument) temp[i]).apply(this);
            }
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAFunctionCommands(node);
    }

    public void inAStatementCommands(AStatementCommands node)
    {
        defaultIn(node);
    }

    public void outAStatementCommands(AStatementCommands node)
    {
        defaultOut(node);
    }

    public void caseAStatementCommands(AStatementCommands node)
    {
        inAStatementCommands(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        outAStatementCommands(node);
    }

    public void inAArgArgument(AArgArgument node)
    {
        defaultIn(node);
    }

    public void outAArgArgument(AArgArgument node)
    {
        defaultOut(node);
    }

    public void caseAArgArgument(AArgArgument node)
    {
        inAArgArgument(node);
        {
            Object temp[] = node.getTemp3().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((PTemp3) temp[i]).apply(this);
            }
        }
        if(node.getTemp2() != null)
        {
            node.getTemp2().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAArgArgument(node);
    }

    public void inAEqValueTemp2(AEqValueTemp2 node)
    {
        defaultIn(node);
    }

    public void outAEqValueTemp2(AEqValueTemp2 node)
    {
        defaultOut(node);
    }

    public void caseAEqValueTemp2(AEqValueTemp2 node)
    {
        inAEqValueTemp2(node);
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
        outAEqValueTemp2(node);
    }

    public void inACommaIdTemp2Temp3(ACommaIdTemp2Temp3 node)
    {
        defaultIn(node);
    }

    public void outACommaIdTemp2Temp3(ACommaIdTemp2Temp3 node)
    {
        defaultOut(node);
    }

    public void caseACommaIdTemp2Temp3(ACommaIdTemp2Temp3 node)
    {
        inACommaIdTemp2Temp3(node);
        if(node.getTemp2() != null)
        {
            node.getTemp2().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outACommaIdTemp2Temp3(node);
    }

    public void inAIfStatement(AIfStatement node)
    {
        defaultIn(node);
    }

    public void outAIfStatement(AIfStatement node)
    {
        defaultOut(node);
    }

    public void caseAIfStatement(AIfStatement node)
    {
        inAIfStatement(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        if(node.getMorecomparison() != null)
        {
            node.getMorecomparison().apply(this);
        }
        outAIfStatement(node);
    }

    public void inAAssigneqStatement(AAssigneqStatement node)
    {
        defaultIn(node);
    }

    public void outAAssigneqStatement(AAssigneqStatement node)
    {
        defaultOut(node);
    }

    public void caseAAssigneqStatement(AAssigneqStatement node)
    {
        inAAssigneqStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAAssigneqStatement(node);
    }

    public void inAAssigmpeqStatement(AAssigmpeqStatement node)
    {
        defaultIn(node);
    }

    public void outAAssigmpeqStatement(AAssigmpeqStatement node)
    {
        defaultOut(node);
    }

    public void caseAAssigmpeqStatement(AAssigmpeqStatement node)
    {
        inAAssigmpeqStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAAssigmpeqStatement(node);
    }

    public void inAPrintStatement(APrintStatement node)
    {
        defaultIn(node);
    }

    public void outAPrintStatement(APrintStatement node)
    {
        defaultOut(node);
    }

    public void caseAPrintStatement(APrintStatement node)
    {
        inAPrintStatement(node);
        {
            Object temp[] = node.getTemp4().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((PTemp4) temp[i]).apply(this);
            }
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAPrintStatement(node);
    }

    public void inAWhileStatement(AWhileStatement node)
    {
        defaultIn(node);
    }

    public void outAWhileStatement(AWhileStatement node)
    {
        defaultOut(node);
    }

    public void caseAWhileStatement(AWhileStatement node)
    {
        inAWhileStatement(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        if(node.getMorecomparison() != null)
        {
            node.getMorecomparison().apply(this);
        }
        outAWhileStatement(node);
    }

    public void inAForStatementStatement(AForStatementStatement node)
    {
        defaultIn(node);
    }

    public void outAForStatementStatement(AForStatementStatement node)
    {
        defaultOut(node);
    }

    public void caseAForStatementStatement(AForStatementStatement node)
    {
        inAForStatementStatement(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        if(node.getSecondid() != null)
        {
            node.getSecondid().apply(this);
        }
        if(node.getFirstid() != null)
        {
            node.getFirstid().apply(this);
        }
        outAForStatementStatement(node);
    }

    public void inAReturnStatement(AReturnStatement node)
    {
        defaultIn(node);
    }

    public void outAReturnStatement(AReturnStatement node)
    {
        defaultOut(node);
    }

    public void caseAReturnStatement(AReturnStatement node)
    {
        inAReturnStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAReturnStatement(node);
    }

    public void inAFuncallStatementStatement(AFuncallStatementStatement node)
    {
        defaultIn(node);
    }

    public void outAFuncallStatementStatement(AFuncallStatementStatement node)
    {
        defaultOut(node);
    }

    public void caseAFuncallStatementStatement(AFuncallStatementStatement node)
    {
        inAFuncallStatementStatement(node);
        if(node.getCallfuncall() != null)
        {
            node.getCallfuncall().apply(this);
        }
        outAFuncallStatementStatement(node);
    }

    public void inAListStatement(AListStatement node)
    {
        defaultIn(node);
    }

    public void outAListStatement(AListStatement node)
    {
        defaultOut(node);
    }

    public void caseAListStatement(AListStatement node)
    {
        inAListStatement(node);
        if(node.getRightexpr() != null)
        {
            node.getRightexpr().apply(this);
        }
        if(node.getLeftexpr() != null)
        {
            node.getLeftexpr().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAListStatement(node);
    }

    public void inAFuncallFuncall(AFuncallFuncall node)
    {
        defaultIn(node);
    }

    public void outAFuncallFuncall(AFuncallFuncall node)
    {
        defaultOut(node);
    }

    public void caseAFuncallFuncall(AFuncallFuncall node)
    {
        inAFuncallFuncall(node);
        if(node.getFuncallt() != null)
        {
            node.getFuncallt().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAFuncallFuncall(node);
    }

    public void inACallfuncalltagCallfuncall(ACallfuncalltagCallfuncall node)
    {
        defaultIn(node);
    }

    public void outACallfuncalltagCallfuncall(ACallfuncalltagCallfuncall node)
    {
        defaultOut(node);
    }

    public void caseACallfuncalltagCallfuncall(ACallfuncalltagCallfuncall node)
    {
        inACallfuncalltagCallfuncall(node);
        if(node.getFuncall() != null)
        {
            node.getFuncall().apply(this);
        }
        outACallfuncalltagCallfuncall(node);
    }

    public void inAArglistArglist(AArglistArglist node)
    {
        defaultIn(node);
    }

    public void outAArglistArglist(AArglistArglist node)
    {
        defaultOut(node);
    }

    public void caseAArglistArglist(AArglistArglist node)
    {
        inAArglistArglist(node);
        {
            Object temp[] = node.getTemp4().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((PTemp4) temp[i]).apply(this);
            }
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAArglistArglist(node);
    }

    public void inAFuncalltFuncallt(AFuncalltFuncallt node)
    {
        defaultIn(node);
    }

    public void outAFuncalltFuncallt(AFuncalltFuncallt node)
    {
        defaultOut(node);
    }

    public void caseAFuncalltFuncallt(AFuncalltFuncallt node)
    {
        inAFuncalltFuncallt(node);
        if(node.getArglist() != null)
        {
            node.getArglist().apply(this);
        }
        outAFuncalltFuncallt(node);
    }

    public void inACommaExpressionTemp4(ACommaExpressionTemp4 node)
    {
        defaultIn(node);
    }

    public void outACommaExpressionTemp4(ACommaExpressionTemp4 node)
    {
        defaultOut(node);
    }

    public void caseACommaExpressionTemp4(ACommaExpressionTemp4 node)
    {
        inACommaExpressionTemp4(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outACommaExpressionTemp4(node);
    }

    public void inATrueMorecomparison(ATrueMorecomparison node)
    {
        defaultIn(node);
    }

    public void outATrueMorecomparison(ATrueMorecomparison node)
    {
        defaultOut(node);
    }

    public void caseATrueMorecomparison(ATrueMorecomparison node)
    {
        inATrueMorecomparison(node);
        if(node.getTrue() != null)
        {
            node.getTrue().apply(this);
        }
        outATrueMorecomparison(node);
    }

    public void inAFalseMorecomparison(AFalseMorecomparison node)
    {
        defaultIn(node);
    }

    public void outAFalseMorecomparison(AFalseMorecomparison node)
    {
        defaultOut(node);
    }

    public void caseAFalseMorecomparison(AFalseMorecomparison node)
    {
        inAFalseMorecomparison(node);
        if(node.getFalse() != null)
        {
            node.getFalse().apply(this);
        }
        outAFalseMorecomparison(node);
    }

    public void inAEqqormeqMorecomparison(AEqqormeqMorecomparison node)
    {
        defaultIn(node);
    }

    public void outAEqqormeqMorecomparison(AEqqormeqMorecomparison node)
    {
        defaultOut(node);
    }

    public void caseAEqqormeqMorecomparison(AEqqormeqMorecomparison node)
    {
        inAEqqormeqMorecomparison(node);
        if(node.getComp2() != null)
        {
            node.getComp2().apply(this);
        }
        if(node.getComp1() != null)
        {
            node.getComp1().apply(this);
        }
        outAEqqormeqMorecomparison(node);
    }

    public void inAComparisonexMorecomparison(AComparisonexMorecomparison node)
    {
        defaultIn(node);
    }

    public void outAComparisonexMorecomparison(AComparisonexMorecomparison node)
    {
        defaultOut(node);
    }

    public void caseAComparisonexMorecomparison(AComparisonexMorecomparison node)
    {
        inAComparisonexMorecomparison(node);
        if(node.getExp2() != null)
        {
            node.getExp2().apply(this);
        }
        if(node.getExp1() != null)
        {
            node.getExp1().apply(this);
        }
        outAComparisonexMorecomparison(node);
    }

    public void inAIdcompMorecomparison(AIdcompMorecomparison node)
    {
        defaultIn(node);
    }

    public void outAIdcompMorecomparison(AIdcompMorecomparison node)
    {
        defaultOut(node);
    }

    public void caseAIdcompMorecomparison(AIdcompMorecomparison node)
    {
        inAIdcompMorecomparison(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAIdcompMorecomparison(node);
    }

    public void inAListExpression(AListExpression node)
    {
        defaultIn(node);
    }

    public void outAListExpression(AListExpression node)
    {
        defaultOut(node);
    }

    public void caseAListExpression(AListExpression node)
    {
        inAListExpression(node);
        {
            Object temp[] = node.getTemp5().toArray();
            for(int i = temp.length - 1; i >= 0; i--)
            {
                ((PTemp5) temp[i]).apply(this);
            }
        }
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
        outAListExpression(node);
    }

    public void inAArrayExpression(AArrayExpression node)
    {
        defaultIn(node);
    }

    public void outAArrayExpression(AArrayExpression node)
    {
        defaultOut(node);
    }

    public void caseAArrayExpression(AArrayExpression node)
    {
        inAArrayExpression(node);
        if(node.getLeftexpr() != null)
        {
            node.getLeftexpr().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAArrayExpression(node);
    }

    public void inAAdditionExpression(AAdditionExpression node)
    {
        defaultIn(node);
    }

    public void outAAdditionExpression(AAdditionExpression node)
    {
        defaultOut(node);
    }

    public void caseAAdditionExpression(AAdditionExpression node)
    {
        inAAdditionExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAAdditionExpression(node);
    }

    public void inASubstractionExpression(ASubstractionExpression node)
    {
        defaultIn(node);
    }

    public void outASubstractionExpression(ASubstractionExpression node)
    {
        defaultOut(node);
    }

    public void caseASubstractionExpression(ASubstractionExpression node)
    {
        inASubstractionExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outASubstractionExpression(node);
    }

    public void inAMultiplicationExpression(AMultiplicationExpression node)
    {
        defaultIn(node);
    }

    public void outAMultiplicationExpression(AMultiplicationExpression node)
    {
        defaultOut(node);
    }

    public void caseAMultiplicationExpression(AMultiplicationExpression node)
    {
        inAMultiplicationExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAMultiplicationExpression(node);
    }

    public void inADivisionExpression(ADivisionExpression node)
    {
        defaultIn(node);
    }

    public void outADivisionExpression(ADivisionExpression node)
    {
        defaultOut(node);
    }

    public void caseADivisionExpression(ADivisionExpression node)
    {
        inADivisionExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outADivisionExpression(node);
    }

    public void inAValueExpression(AValueExpression node)
    {
        defaultIn(node);
    }

    public void outAValueExpression(AValueExpression node)
    {
        defaultOut(node);
    }

    public void caseAValueExpression(AValueExpression node)
    {
        inAValueExpression(node);
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
        outAValueExpression(node);
    }

    public void inAXppExpression(AXppExpression node)
    {
        defaultIn(node);
    }

    public void outAXppExpression(AXppExpression node)
    {
        defaultOut(node);
    }

    public void caseAXppExpression(AXppExpression node)
    {
        inAXppExpression(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAXppExpression(node);
    }

    public void inAPpxExpression(APpxExpression node)
    {
        defaultIn(node);
    }

    public void outAPpxExpression(APpxExpression node)
    {
        defaultOut(node);
    }

    public void caseAPpxExpression(APpxExpression node)
    {
        inAPpxExpression(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAPpxExpression(node);
    }

    public void inAListpostPrefixExpression(AListpostPrefixExpression node)
    {
        defaultIn(node);
    }

    public void outAListpostPrefixExpression(AListpostPrefixExpression node)
    {
        defaultOut(node);
    }

    public void caseAListpostPrefixExpression(AListpostPrefixExpression node)
    {
        inAListpostPrefixExpression(node);
        if(node.getRightexpr() != null)
        {
            node.getRightexpr().apply(this);
        }
        if(node.getLeftexpr() != null)
        {
            node.getLeftexpr().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAListpostPrefixExpression(node);
    }

    public void inAIdentifierExpression(AIdentifierExpression node)
    {
        defaultIn(node);
    }

    public void outAIdentifierExpression(AIdentifierExpression node)
    {
        defaultOut(node);
    }

    public void caseAIdentifierExpression(AIdentifierExpression node)
    {
        inAIdentifierExpression(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAIdentifierExpression(node);
    }

    public void inACallfuncallExpression(ACallfuncallExpression node)
    {
        defaultIn(node);
    }

    public void outACallfuncallExpression(ACallfuncallExpression node)
    {
        defaultOut(node);
    }

    public void caseACallfuncallExpression(ACallfuncallExpression node)
    {
        inACallfuncallExpression(node);
        if(node.getFuncall() != null)
        {
            node.getFuncall().apply(this);
        }
        outACallfuncallExpression(node);
    }

    public void inAFuncallExpExpression(AFuncallExpExpression node)
    {
        defaultIn(node);
    }

    public void outAFuncallExpExpression(AFuncallExpExpression node)
    {
        defaultOut(node);
    }

    public void caseAFuncallExpExpression(AFuncallExpExpression node)
    {
        inAFuncallExpExpression(node);
        if(node.getCallfuncall() != null)
        {
            node.getCallfuncall().apply(this);
        }
        outAFuncallExpExpression(node);
    }

    public void inAStrValue(AStrValue node)
    {
        defaultIn(node);
    }

    public void outAStrValue(AStrValue node)
    {
        defaultOut(node);
    }

    public void caseAStrValue(AStrValue node)
    {
        inAStrValue(node);
        if(node.getString() != null)
        {
            node.getString().apply(this);
        }
        outAStrValue(node);
    }

    public void inANumbValue(ANumbValue node)
    {
        defaultIn(node);
    }

    public void outANumbValue(ANumbValue node)
    {
        defaultOut(node);
    }

    public void caseANumbValue(ANumbValue node)
    {
        inANumbValue(node);
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        outANumbValue(node);
    }

    public void inACommaValueTemp5(ACommaValueTemp5 node)
    {
        defaultIn(node);
    }

    public void outACommaValueTemp5(ACommaValueTemp5 node)
    {
        defaultOut(node);
    }

    public void caseACommaValueTemp5(ACommaValueTemp5 node)
    {
        inACommaValueTemp5(node);
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
        outACommaValueTemp5(node);
    }

    public void inAIdIdentifier(AIdIdentifier node)
    {
        defaultIn(node);
    }

    public void outAIdIdentifier(AIdIdentifier node)
    {
        defaultOut(node);
    }

    public void caseAIdIdentifier(AIdIdentifier node)
    {
        inAIdIdentifier(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdIdentifier(node);
    }
}
