package parsing_json;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class ElementCollection extends ArrayList<Element> {


    public Element findByAtomicNumber(int atomic_number) {
//        for (Element element: elements){
//            if (element.getNumber() == atomic_number){
//                return element;
//            }
//        }
        Iterator<Element> iterator = this.iterator();
        while (iterator.hasNext()){
            Element element = iterator.next();
            if (element.getNumber() == atomic_number){
                return element;
            }
        }
        return null;
    }

    public Element findByName(String name) {
//        for (Element element: elements){
//            if (element.getName().equalsIgnoreCase(name)){
//                return element;
//            }
//        }
        Iterator<Element> iterator = this.iterator();
        while (iterator.hasNext()){
            Element element = iterator.next();
            if (element.getName().equalsIgnoreCase(name)){
                return element;
            }
        }
        return null;
    }

    public ElementCollection where(String fieldName, Object value) {
//        ElementCollection emptyCollection = new ElementCollection();
//        for (int i = 0; i < elements.size(); i++){
//            try {
//                Field matchingField = elements.get(i).getClass().getDeclaredField(fieldName);
//                if (matchingField.equals(value)){
//                    elements.add(elements.get(i));
//                }
//            } catch (NoSuchFieldException e) {
//                return emptyCollection;
//            }
//        }
//        return emptyCollection;
        ElementCollection emptyCollection = new ElementCollection();
        Iterator<Element> iterator = this.iterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            try {
                Field matchingField = element.getClass().getDeclaredField(fieldName);
                matchingField.setAccessible(true);
                try {
                    if (matchingField.get(element).equals(value)) {
                        emptyCollection.add(element);
                    }
                } catch (IllegalAccessException ie){
                    return emptyCollection;
                }
            } catch (NoSuchFieldException e) {
                return emptyCollection;
            }
        }
        return emptyCollection;
    }
}
