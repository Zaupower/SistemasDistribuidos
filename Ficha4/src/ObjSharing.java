import java.util.ArrayList;

public class ObjSharing {
    public static void main(String[] args) {
        int NThreads = 1;
        SynchronizedArrayList asFrases = new SynchronizedArrayList();

        for (int i = 0; i< NThreads;i++){
            new Worker(asFrases, i).run();
        }
        for (int j= 0; j<1; j++){
            for (int k=0;k<asFrases.size();k++){
                System.out.println(asFrases.get());
            }
        }
    }
}
