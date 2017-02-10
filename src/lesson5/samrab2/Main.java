package lesson5.samrab2;

import lesson5.samrab2.serializator.XMLCreator;

/**
 * Created by yuri on 10.02.17.
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        People people = new People("Ioxan", 26, 200);
        People people2 = new People("AntiIoxan", 264, 2004);

        XMLCreator.createXML(people, "people.xml");
        XMLCreator.createXML(people2, "people2.xml");

    }

}
