package cflat.entity;
import cflat.ast.TypeNode;

public class CBCParameter extends DefinedVariable {
    public CBCParameter(TypeNode type, String name) {
        super(false, type, name, null);
    }

    public boolean isParameter() {
        return true;
    }

    protected void _dump(cflat.ast.Dumper d) {
        d.printMember("name", name);
        d.printMember("typeNode", typeNode);
    }
}
