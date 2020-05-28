package AISD_HW;

import javax.sound.midi.Soundbank;
import java.util.ArrayDeque;
import java.util.Queue;

public class Task7_1 {
    public static void main(String[] args) {
        Element elRL = new Element(6,null,null);
        Element elRR = new Element(2, null, null);
        Element elLL = new Element(4, null, null);
        Element elLR = new Element(3,null,null);
        Element elR = new Element(5, elRL, elRR);
        Element elL = new Element(1, elLL, elLR);
        Element el = new Element(0, elL, elR);
        dfs(el);
        bfs(el);
    }

    public static void dfs(Element el){
        if(el == null) return;
        dfs(el.childL);
        dfs(el.childR);
    }

    public static void bfs(Element el){
        if(el == null) return;
        Queue<Element> q = new ArrayDeque<>();
        q.add(el);
        while (!q.isEmpty()){
            el = q.remove();
            System.out.print(el.value + " ");
            if(el.childL!=null) q.add(el.childL);
            if(el.childR!=null) q.add(el.childR);
        }

    }

    private static class Element{
        private int value;
        private Element childR, childL;

        public Element(int value, Element childL, Element childR){
            this.value = value;
            this.childL = childL;
            this.childR = childR;
        }

    }
}
