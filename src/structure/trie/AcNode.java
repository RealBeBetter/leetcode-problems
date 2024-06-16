package structure.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Real
 * @since 2024/6/1 22:52
 */
public class AcNode {
    /**
     * 数据
     */
    public String data;
    public Map<String, AcNode> children;
    public Boolean isEndingChar;
    public Integer length;
    public AcNode fail;

    public AcNode(String data) {
        this.data = data;
        this.children = new HashMap<>();
        this.isEndingChar = false;
        this.length = 0;
        this.fail = null;
    }

}
