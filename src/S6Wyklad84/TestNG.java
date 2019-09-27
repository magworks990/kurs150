package S6Wyklad84;

//import jdk.vm.ci.common.InitTimer;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntSupplier;

public class TestNG{

        @Test
         private void searchHotelTest() throws AWTException, IOException {

            List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4);

            for (Integer number : numbers1) {
                System.out.println(number);
            }


            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
            Consumer<Integer> integerConsumer = n->  System.out.println(n);
            numbers.forEach(integerConsumer);
        }

        }
