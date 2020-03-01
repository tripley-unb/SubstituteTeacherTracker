import java.util.ArrayList;

public class SubList {
    private ArrayList<Substitute> subs;
    
    public SubList() {
    	subs = new ArrayList<Substitute>();
    }

    public void addSub(Substitute sub) {
        subs.add(sub);//change to add only subs not in list
    }
    
    public ArrayList<Substitute> getList() {
    	return subs;
    }
    
	public String toString() {
		return subs.toString();
	}
}