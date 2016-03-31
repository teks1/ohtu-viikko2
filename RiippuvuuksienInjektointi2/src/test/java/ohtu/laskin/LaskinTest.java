package ohtu.laskin;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;



class IOStub implements IO {

    int[] inputs;
    int mones;
    ArrayList<String> outputs;

    public IOStub(int... inputs) {
        this.inputs = inputs;
        this.outputs = new ArrayList<String>();
    }

    public int nextInt() {
        return inputs[mones++];
    }

    public void print(String m) {
        outputs.add(m);
    }
}
public class LaskinTest {

    @Test
    public void yksiSummaOikein() {
        IOStub io = new IOStub(1, 3, -9999);
        new Laskin(io).suorita();
        
        assertEquals("summa: 4\n",io.outputs.get(2));
    }
}
