package _03;

import _03.util.Util;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dysania on 19/10/2017.
 */

public class Test {

    public static void main(String[] args) {

        Integer[] array = {1, 2, 3};
        List<Integer> list = Arrays.asList(array);
        System.out.println(Util.joinToString(list, "; ", "", ""));

        System.out.println(ExtensionKt.lastChar("Kotlin"));

        View view = new Button();
        view.click();
        ExtensionKt.showOff(view);

        System.out.println(ExtensionKt.getLastChar("Java"));
    }
}
