/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AListpostPrefixExpression extends PExpression
{
    private PIdentifier _identifier_;
    private PExpression _leftexpr_;
    private PExpression _rightexpr_;

    public AListpostPrefixExpression()
    {
    }

    public AListpostPrefixExpression(
        PIdentifier _identifier_,
        PExpression _leftexpr_,
        PExpression _rightexpr_)
    {
        setIdentifier(_identifier_);

        setLeftexpr(_leftexpr_);

        setRightexpr(_rightexpr_);

    }
    public Object clone()
    {
        return new AListpostPrefixExpression(
            (PIdentifier) cloneNode(_identifier_),
            (PExpression) cloneNode(_leftexpr_),
            (PExpression) cloneNode(_rightexpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListpostPrefixExpression(this);
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

    public PExpression getLeftexpr()
    {
        return _leftexpr_;
    }

    public void setLeftexpr(PExpression node)
    {
        if(_leftexpr_ != null)
        {
            _leftexpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _leftexpr_ = node;
    }

    public PExpression getRightexpr()
    {
        return _rightexpr_;
    }

    public void setRightexpr(PExpression node)
    {
        if(_rightexpr_ != null)
        {
            _rightexpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _rightexpr_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_identifier_)
            + toString(_leftexpr_)
            + toString(_rightexpr_);
    }

    void removeChild(Node child)
    {
        if(_identifier_ == child)
        {
            _identifier_ = null;
            return;
        }

        if(_leftexpr_ == child)
        {
            _leftexpr_ = null;
            return;
        }

        if(_rightexpr_ == child)
        {
            _rightexpr_ = null;
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

        if(_leftexpr_ == oldChild)
        {
            setLeftexpr((PExpression) newChild);
            return;
        }

        if(_rightexpr_ == oldChild)
        {
            setRightexpr((PExpression) newChild);
            return;
        }

    }
}
