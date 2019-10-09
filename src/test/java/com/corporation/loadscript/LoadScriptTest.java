package com.corporation.loadscript;

import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@Ignore
public class LoadScriptTest {

    @Test
    public void whenNoScripts() {

        List<Integer> list1 = new ArrayList<Integer>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        map.put(1, list1);

        List<Integer> expect = new ArrayList<Integer>();

        LoadScript algo = new LoadScript();

        List<Integer> result = algo.load(map, 1);

        assertThat(result, is(expect));
    }

    @Test
    public void when1LevelHierarchy() {

        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(2, 3));
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        map.put(1, list1);
        map.put(2, list2);
        map.put(3, list3);

        List<Integer> expect = new ArrayList<Integer>(Arrays.asList(2, 3));

        LoadScript algo = new LoadScript();

        List<Integer> result = algo.load(map, 1);

        assertThat(result, is(expect));
    }
}