/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AIdentifierExpression extends PExpression
{
    private PIdentifier _identifier_;

    public AIdentifierExpression()
    {
    }

    public AIdentifierExpression(
        PIdentifier _identifier_)
    {
        setIdentifier(_identifier_);

    }
    public Object clone()
    {
        return new AIdentifierExpression(
            (PIdentifier) cloneNode(_identifier_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIdentifierExpression(this);
    }

    public PIdentifier getIdentifier()
    {
        return _identifier_;
    }

    public void setIdentifier(PIdentifier node)
    {
        if(_identifier_ != null)
        {
            _identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _identifier_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_identifier_);
    }

    void removeChild(Node child)
    {
        if(_identifier_ == child)
        {
            _identifier_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_identifier_ == oldChild)
        {
            setIdentifier((PIdentifier) newChild);
            return;
        }

    }
}
