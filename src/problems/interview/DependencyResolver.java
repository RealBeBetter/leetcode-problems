package problems.interview;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 输入若干类似A=B+C的加法表达式，或者类似X=n的表达式
 * 例如输入：
 * [
 * "a=b+c",
 * "b=d+e",
 * "d=1",
 * "c=e+f",
 * "e=2",
 * "f=3"
 * ]
 *
 * <p>
 * 表达式之间存在依赖关系，比如a依赖b和c
 * 题目目标是分析依赖关系，整理他们之间的顺序，然后输出
 * 按照你输出的顺序，依次计算每个表达式应该可以得到所有变量的值
 * <p>
 * 例如输出：
 * [
 * "d=1",
 * "e=2",
 * "f=3",
 * "c=e+f",
 * "b=d+e",
 * "a=b+c",
 * ]
 * <p>
 * 按照这个顺序依次计算就可以知道a,b,c,d,e,f的值。
 *
 * @author Real
 * @since 2023/3/13 20:28
 */
public class DependencyResolver {

    public static void main(String[] args) {
        DependencyResolver test = new DependencyResolver();
        List<String> list = Arrays.asList("a=b+c", "b=d+e", "d=1", "c=e+f", "e=2", "f=3");
        System.out.println(test.resolveDependencies(list));
    }

    public List<String> resolveDependencies(List<String> expressionsList) {
        // 构建依赖顺序关系
        if (expressionsList == null || expressionsList.size() == 0) {
            return Collections.emptyList();
        }

        // 将所有的 X=n 放前面
        List<String> targetExpressions = new ArrayList<>();
        Map<Boolean, List<String>> containsPlusMap = expressionsList.stream().filter(expression -> expression != null && expression.length() != 0)
                .collect(Collectors.groupingBy(this::containsPlus));
        List<String> equalsNumberExpressions = containsPlusMap.get(Boolean.FALSE);
        List<String> knownElements = new ArrayList<>();
        if (equalsNumberExpressions != null && !expressionsList.isEmpty()) {
            knownElements = equalsNumberExpressions.stream().map(equalsNumberExpression -> equalsNumberExpression.split("=")[0])
                    .collect(Collectors.toList());
            targetExpressions.addAll(equalsNumberExpressions);
        }

        // 计算后面的加法表达式
        calcExpressions(targetExpressions, knownElements, containsPlusMap.get(Boolean.TRUE));

        return targetExpressions;
    }


    private void calcExpressions(List<String> targetExpressions, List<String> knownElements, List<String> restExpressions) {
        if (restExpressions == null || knownElements == null || knownElements.isEmpty() || restExpressions.isEmpty()) {
            return;
        }

        // 随机找一个元素，满足条件
        String tempExpression = null;
        int index = 0;

        for (String restExpression : restExpressions) {
            List<String> needSourceElements = parseElementsByExpression(restExpression);
            if (knownElements.containsAll(needSourceElements)) {
                // 重复值暂时不考虑
                int equalsIndex = restExpression.indexOf("=");
                if (equalsIndex > 0) {
                    tempExpression = restExpression;
                    index = equalsIndex;
                    break;
                } else {
                    return;
                }
            }
        }

        if (tempExpression != null) {
            knownElements.add(tempExpression.substring(0, index));
            restExpressions.remove(tempExpression);
            targetExpressions.add(tempExpression);
            calcExpressions(targetExpressions, knownElements, restExpressions);
        }
    }

    private List<String> parseElementsByExpression(String expression) {
        if (expression == null || expression.length() == 0) {
            return Collections.emptyList();
        }

        String[] leftAndRight = expression.split("=");
        int expressionSplitLength = 2;
        if (leftAndRight.length != expressionSplitLength) {
            throw new IllegalArgumentException("argument error, error = " + Arrays.toString(leftAndRight));
        }

        // 右边的为 m + n
        String[] sourceElements = leftAndRight[1].split("\\+");
        return Arrays.asList(sourceElements);
    }


    private boolean containsPlus(String expression) {
        if (expression == null || expression.length() == 0) {
            return false;
        }

        return expression.contains("+");
    }

}
