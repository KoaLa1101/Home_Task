package AISD_HW;

import java.math.BigInteger;

public class Task7_2 {



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
