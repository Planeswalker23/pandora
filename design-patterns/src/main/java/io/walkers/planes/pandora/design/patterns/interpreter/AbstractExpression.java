package io.walkers.planes.pandora.design.patterns.interpreter;

/**
 * 抽象解释器
 *
 * @author planeswalker23
 * @date 2022/2/20
 */
public interface AbstractExpression {
    boolean interpreter(Context info);
}
