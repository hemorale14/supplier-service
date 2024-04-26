package com.gapsi.patterns.interpreter;

@FunctionalInterface
public interface Interpreter<I, O> {

	O interpret(I input);
}
