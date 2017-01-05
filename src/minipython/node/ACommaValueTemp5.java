/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class ACommaValueTemp5 extends PTemp5
{
    private PValue _value_;

    public ACommaValueTemp5()
    {
    }

    public ACommaValueTemp5(
        PValue _value_)
    {
        setValue(_value_);

    }
    public Object clone()
    {
        return new ACommaValueTemp5(
            (PValue) cloneNode(_value_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACommaValueTemp5(this);
    }

    public PValue getValue()
    {
        return _value_;
    }

    public void setValue(PValue node)
    {
        if(_value_ != null)
        {
            _value_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _value_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_value_);
    }

    void removeChild(Node child)
    {
        if(_value_ == child)
        {
            _value_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_value_ == oldChild)
        {
            setValue((PValue) newChild);
            return;
        }

    }
}
