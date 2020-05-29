package AISD_HW;


public class Task7_2 {

    public static int balanceVal(Element el) {
        return el.childL.height - el.childR.height;
    }

    private static void changeHeight(Element el) {
        el.setHeight(1 + Math.max(el.childL.height, el.childR.height));
    }
    private static Element mostLeftChild(Element el){
        while(el.childL != null)
            el = mostLeftChild(el.childL);
        return el;
    }

    private static Element rotateR(Element el) {
        Element x = el.childL;
        Element y = el.childR;
        x.setChildR(el);
        el.setChildL(y);
        changeHeight(el);
        changeHeight(x);
        return x;
    }

    private static Element rotateL(Element el) {
        Element x = el.childR;
        Element y = el.childL;
        x.childL = el;
        el.childR = y;
        changeHeight(el);
        changeHeight(x);
        return x;
    }

    public static Element balance(Element el) {
        changeHeight(el);
        int balance = balanceVal(el);
        if (balance > 1) {
            if (el.childR.childR.height > el.childR.childL.height)
                el = rotateL(el);
            else {
                el.childR = rotateR(el.childR);
                el = rotateR(el);
            }
        } else if (balance < -1) {
            if (el.childL.childL.height > el.childL.childR.height)
                el = rotateR(el);
            else {
                el.childL = rotateL(el.childL);
                el = rotateR(el);
            }
        }
        return el;
    }

    public static Element add(Element el, int val) {
        if (el == null)
            return new Element(val, null);
        else if (el.value > val) el.childL = add(el.childL, val);
        else if (el.value <= val) el.childR = add(el.childR, val);
        return balance(el);
    }

    public static Element remove(Element el, int val) {
        if (el == null) return el;
        else if(el.value > val) el.childL = remove(el.childL, val);
        else if(el.value <= val) el.childR = remove(el.childR, val);
        else {
            if(el.childL == null)
                el = el.childR;
            else if(el.childR == null)
                el = el.childL;
            else {
                Element left = mostLeftChild(el);
                el.value = left.value;
                el.childR = remove(el.childR, el.value);
            }
        }
        el = balance(el);
        return el;
    }


    private static class Element {
        private static int value, height;
        private static Element childR, childL, parent;

        public Element(int value, Element parent) {
            this.value = value;
            this.parent = parent;
            this.height = parent.height + 1;
        }

        private static void setChildL(Element el) {
            childL = el;
        }

        private static void setChildR(Element el) {
            childR = el;
        }

        private static void setParent(Element el) {
            parent = el;
        }

        private static void setHeight(int value) {
            height = value;
        }

    }
}
