package cflat.entity;

import cflat.ast.Location;
import cflat.type.ParamTypeRefs;
import cflat.type.TypeRef;

import java.util.ArrayList;
import java.util.List;

public class Params extends ParamSlots<CBCParameter>
        implements cflat.ast.Dumpable {
    public Params(Location loc, List<CBCParameter> paramDescs) {
        super(loc, paramDescs, false);
    }

    public List<CBCParameter> parameters() {
        return paramDescriptors;
    }

    public ParamTypeRefs parametersTypeRef() {
        List<TypeRef> typerefs = new ArrayList<TypeRef>();
        for (CBCParameter param : paramDescriptors) {
            typerefs.add(param.typeNode().typeRef());
        }
        return new ParamTypeRefs(location, typerefs, vararg);
    }

    public boolean equals(Object other) {
        return (other instanceof Params) && equals((Params)other);
    }

    public boolean equals(Params other) {
        return other.vararg == vararg
                && other.paramDescriptors.equals(paramDescriptors);
    }
    
    public void dump(cflat.ast.Dumper d) {
        d.printNodeList("parameters", parameters());
    }
}
