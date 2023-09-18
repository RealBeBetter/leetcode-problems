package leetcode75.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1268. 搜索推荐系统
 * <a href="https://leetcode.cn/problems/search-suggestions-system">...</a>
 *
 * @author wei.song
 * @since 2023/6/29 16:36
 */
public class SearchSuggestionsSystem {

    /**
     * 建议产品，搜索得到建议的产品
     *
     * @param products   产品
     * @param searchWord 搜索词
     * @return {@link List}<{@link List}<{@link String}>>
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> sortProducts = Arrays.stream(products).sorted().collect(Collectors.toList());

        List<List<String>> result = new ArrayList<>();
        int length = searchWord.length();
        for (int i = 0; i < length; i++) {
            List<String> temp = new ArrayList<>();
            String start = searchWord.substring(0, i + 1);
            for (String sortProduct : sortProducts) {
                if (sortProduct.startsWith(start) && temp.size() < 3) {
                    temp.add(sortProduct);
                }
            }

            result.add(temp);
        }

        return result;
    }

}
