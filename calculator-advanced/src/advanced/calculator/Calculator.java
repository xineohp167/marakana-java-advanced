package advanced.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import advanced.calculator.expression.Expression;
import advanced.calculator.expression.NumberExpression;
import advanced.calculator.expression.OperationExpression;

public class Calculator {

	private static final Map<String, Operator> operators;
	static {
		operators = new HashMap<String, Operator>();
		for (Operator op : Operator.values()) {
			operators.put(op.toString(), op);
		}
	}

	private static boolean handleNumber(String token, Stack<Expression> stack) {
		try {
			stack.push(new NumberExpression(Integer.parseInt(token)));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static boolean handleOperator(String token, Stack<Expression> stack) {
		Operator op = operators.get(token);
		if (op == null) {
			return false;
		}

		Expression rhs = stack.pop(), lhs = stack.pop();
		stack.push(new OperationExpression(lhs, rhs, op));
		return true;
	}

	public static Expression parse(String expression) {
		Stack<Expression> stack = new Stack<Expression>();
		for (String token : expression.split(" ")) {
			if (!handleNumber(token, stack) && !handleOperator(token, stack)) {
				throw new IllegalArgumentException("unrecognized token: "
						+ token);
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: Calculator <expression>");
			return;
		}
		Expression e = parse(args[0]);
		System.out.format("%s = %d\n", e, e.getValue());
	}

}
