import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Pair> al = new ArrayList<>();
        bioR bio=new bioR();

        String birth = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String c = sc.nextLine();
            al.add(new Pair(c, bio.bioRythm(birth, c)));
        }

        Collections.sort(al);
        System.out.println(al.get(0).getFirst());
    }
}

class bioR{
    public int bioRythm(String b, String c){
        int y,m,d,idx,bn,cn;
        y=m=d=idx=0;
        for(;idx<4;idx++){
            bn=b.charAt(idx)-'0';
            cn=c.charAt(idx)-'0';

            y+=(bn-cn)*(bn-cn);
        }
        for(;idx<6;idx++){
            bn=b.charAt(idx)-'0';
            cn=c.charAt(idx)-'0';

            m+=(bn-cn)*(bn-cn);
        }
        for(;idx<8;idx++){
            bn=b.charAt(idx)-'0';
            cn=c.charAt(idx)-'0';

            d+=(bn-cn)*(bn-cn);
        }
        return y*m*d;
    }
}

class Pair implements Comparable<Pair>{
    private String first;
    private int second;

    public Pair(String first, int second){
        this.first=first;
        this.second=second;
    }

    public String getFirst(){
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.second==o.second)
            return this.first.compareTo(o.first)>0?1:-1;
        return this.second<o.second?1:-1;
    }
}