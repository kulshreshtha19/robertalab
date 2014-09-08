package de.fhg.iais.roberta.ast.syntax.action;

import de.fhg.iais.roberta.ast.visitor.AstVisitor;

/**
 * This class represents the <b>robActions_display_clear</b> block from Blockly into the AST (abstract syntax tree).
 */
public final class ClearDisplayAction<V> extends Action<V> {

    private ClearDisplayAction(boolean disabled, String comment) {
        super(Kind.CLEAR_DISPLAY_ACTION, disabled, comment);
        setReadOnly();
    }

    /**
     * Creates instance of {@link ClearDisplayAction}. This instance is read only and can not be modified.
     * 
     * @param disabled state of the block,
     * @param comment added from the user
     * @return read only object of class {@link ClearDisplayAction}.
     */
    public static <V> ClearDisplayAction<V> make(boolean disabled, String comment) {
        return new ClearDisplayAction<V>(disabled, comment);
    }

    @Override
    public String toString() {
        return "ClearDisplayAction []";
    }

    @Override
    protected V accept(AstVisitor<V> visitor) {
        return visitor.visitClearDisplayAction(this);
    }
}