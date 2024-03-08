package ra.business.design;

import java.util.List;

public interface IOData<E> {
    List<E> inputData();
    void displayData();
}
