package ra.business.design;

import java.util.List;
import java.util.Scanner;

public interface IOData<E> {
    Scanner scanner = new Scanner(System.in);
    List<E> inputData();
    void displayData();
}
