package leetcode75.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 841. 钥匙和房间
 * https://leetcode.cn/problems/keys-and-rooms
 *
 * @author wei.song
 * @since 2023/6/14 23:25
 */
public class KeysAndRooms {


    /**
     * 是否能访问所有房间
     *
     * @param rooms 房间
     * @return boolean
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // 使用 Set 存储已经访问过的房间
        if (rooms == null || rooms.isEmpty()) {
            return false;
        }

        Set<Integer> knownRooms = new HashSet<>();
        knownRooms.add(0);

        LinkedList<Integer> needVisitRooms = new LinkedList<>();

        if (rooms.get(0) != null && !rooms.get(0).isEmpty()) {
            knownRooms.addAll(rooms.get(0));
            needVisitRooms.addAll(rooms.get(0));
        }

        while (!needVisitRooms.isEmpty()) {
            Integer roomKey = needVisitRooms.removeFirst();
            knownRooms.add(roomKey);
            List<Integer> nextRooms = rooms.get(roomKey);
            if (nextRooms != null && !nextRooms.isEmpty()) {
                for (Integer nextRoom : nextRooms) {
                    if (!knownRooms.contains(nextRoom)) {
                        needVisitRooms.add(nextRoom);
                    }
                }
            }
        }

        for (int i = 1; i < rooms.size(); i++) {
            if (!knownRooms.contains(i)) {
                return false;
            }
        }

        return true;
    }

}
