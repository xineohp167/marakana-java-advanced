package advanced.calculator.expression;

public interface Expression {
	
	<A> A accept(ExpressionVisitor<A> visitor);

}
