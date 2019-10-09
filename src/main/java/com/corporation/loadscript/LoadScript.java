package com.corporation.loadscript;

import java.util.*;

/**
 * Класс реализует задачу по возвращает списка всех скриптов, которые нужно для загрузки входящего скрипта
 */
public class LoadScript {

    public List<Integer> load(Map<Integer, List<Integer>> ds, Integer scriptId) {

        Set<Integer> cache = new HashSet<Integer>();

        Set<Integer> res = new HashSet<Integer>();

        cache.addAll(ds.get(scriptId));

        /**
         * Работаем до тех пор пока есть новые неподгруженные скрипты, а добавленные скрипты удаляем из списка
         */
        while (!cache.isEmpty()) {

            Integer id = cache.iterator().next();

            res.add(id);

            /**
             * Получили зависимости для очередного скрипта из кэша
             */
            List<Integer> list = ds.get(id);

            /**
             * Оставляем только новые зависимости
             */
            list.removeAll(cache);
            list.removeAll(res);

            cache.addAll(list);
            cache.remove(id);

        }

        return new ArrayList<Integer>(res);

    }

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(2, 3));
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(4));
        List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(4, 5));
        List<Integer> list4 = new ArrayList<Integer>();
        List<Integer> list5 = new ArrayList<Integer>();

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        map.put(1, list1);
        map.put(2, list2);
        map.put(3, list3);
        map.put(4, list4);
        map.put(5, list5);

        LoadScript algo = new LoadScript();

        List<Integer> resList = algo.load(map, 1);

        System.out.println(resList);
    }
}
