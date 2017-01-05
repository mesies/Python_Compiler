/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class ACommaIdTemp2Temp3 extends PTemp3
{
    private PIdentifier _identifier_;
    private PTemp2 _temp2_;

    public ACommaIdTemp2Temp3()
    {
    }

    public ACommaIdTemp2Temp3(
        PIdentifier _identifier_,
        PTemp2 _temp2_)
    {
        setIdentifier(_identifier_);

        setTemp2(_temp2_);

    }
    public Object clone()
    {
        return new ACommaIdTemp2Temp3(
            (PIdentifier) cloneNode(_identifier_),
            (PTemp2) cloneNode(_temp2_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACommaIdTemp2Temp3(this);
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

    public PTemp2 getTemp2()
    {
        return _temp2_;
    }

    public void setTemp2(PTemp2 node)
    {
        if(_temp2_ != null)
        {
            _temp2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _temp2_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_identifier_)
            + toString(_temp2_);
    }

    void removeChild(Node child)
    {
        if(_identifier_ == child)
        {
            _identifier_ = null;
            return;
        }

        if(_temp2_ == child)
        {
            _temp2_ = null;
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

        if(_temp2_ == oldChild)
        {
            setTemp2((PTemp2) newChild);
            return;
        }

    }
}
