import java.util.ArrayList;

public class SubList {
    private ArrayList<Substitute> subs;
    
    public SubList() {
    	subs = new ArrayList<Substitute>();
    }

    public void addSub(Substitute sub) {
        subs.add(sub);
    }
}