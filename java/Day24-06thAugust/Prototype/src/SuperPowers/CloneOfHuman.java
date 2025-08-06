package SuperPowers;

import java.util.HashMap;

public class CloneOfHuman {
    private static HashMap<String, HumanBeing> humanMap = new HashMap<>();

    public static void loadCache() {
        SpiderMan spider = new SpiderMan();
        BatMan bat = new BatMan();
        IronMan iron = new IronMan();

        humanMap.put("1", spider);
        humanMap.put("2", bat);
        humanMap.put("3", iron);
    }

    public static HumanBeing getClone(String id) {
        HumanBeing cachedHuman = humanMap.get(id);
        return (HumanBeing) cachedHuman.clone();
    }

    public static int getSize() {
        return humanMap.size();
    }
}

