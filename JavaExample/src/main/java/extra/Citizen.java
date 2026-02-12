package extra;

public abstract class Citizen {
    
    // 1st MANTRA: All Attributes must be private.
    // 2nd MANTRA: Keep almost everything private.
    //             Only use public when it is necessary.

    // Attributes
    private String name; // Missing the visibility modifier
                         // will result in FAILING this module.
    private int income;

    // Methods
    //public Citizen() {} // <- this CTOR doesn't make any sense

    // CTOR (Constructor)
    // - CTOR must have the same name as the class.
    // - CTOR does not have a return type.
    public Citizen(String name, int income) {
        // this is the standard constructor
        // => all attributes will be initialized here.
        // main purpose of CTOR is to initialize its attributes.
        this.name = name;
        this.income = income;
        // this helps to address the hidden attributes
    }

    public int getIncome() {
        return income;
    }

    public int payTax() {
        // call to a polymorphic method
        int incomeForTaxation = getIncome();
        
        int taxToPay = incomeForTaxation * 10 / 100;
        if (taxToPay < 1) taxToPay = 1;
        //return taxToPay < 1 ? 1 : taxToPay; -- alternative way to write the above if statement.
        return taxToPay;
    }

    /*
    public abstract int doTaxDeduction();
     // this is an abstract method
     // it does not have a body (implementation)
     // it must be implemented by all concrete subclasses of Citizen
     */
}
