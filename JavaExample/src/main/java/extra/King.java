package extra;
import Citizen;

public class King extends Citizen {

    // MAGIC
    // if I do not provide a CTOR, a default CTOR will be inserted
    // public King() {
    //     super();
    // }

    public King(String name, int income) {
        super(name, income);
    }

    @Override
    public int getIncome() {
        return 0;
    }    
    
}
