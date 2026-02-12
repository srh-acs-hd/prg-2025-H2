package extra;

import extra.Citizen;
import extra.King;
import extra.Pawn;

public class Kingdom {
    public static void main(String[] args) {
        Pawn pawn = new Pawn("Pegan", 123);
        King theKing = new King("Robert", 5688);

        System.out.println( pawn.payTax() );
        System.out.println( theKing.payTax() );
    }
}
