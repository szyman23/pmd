/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;


import net.sourceforge.pmd.annotation.InternalApi;

public class ASTConstructorDeclaration extends AbstractMethodOrConstructorDeclaration {

    private boolean containsComment;

    @InternalApi
    @Deprecated
    public ASTConstructorDeclaration(int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTConstructorDeclaration(JavaParser p, int id) {
        super(p, id);
    }


    @Override
    public MethodLikeKind getKind() {
        return MethodLikeKind.CONSTRUCTOR;
    }

    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    public boolean containsComment() {
        return this.containsComment;
    }

    @InternalApi
    @Deprecated
    public void setContainsComment() {
        this.containsComment = true;
    }

    /**
     * @deprecated to be removed with PMD 7.0.0 - use getFormalParameters() instead
     */
    @Deprecated
    public ASTFormalParameters getParameters() {
        return getFormalParameters();
    }

    public int getParameterCount() {
        return getFormalParameters().getParameterCount();
    }

    //@Override // enable this with PMD 7.0.0 - see interface ASTMethodOrConstructorDeclaration
    public ASTFormalParameters getFormalParameters() {
        return getFirstChildOfType(ASTFormalParameters.class);
    }
}
